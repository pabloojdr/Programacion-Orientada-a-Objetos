package rank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

public class Web {
	private Set<Link> links;
	protected Set<Site> sites;
	private static final double THRESHOLD = 1E-5;
	private static Random alea = new Random(1); // Semilla 1 para pruebas/testing

	public Web() {
		links = new HashSet();
		sites = new HashSet(); // sin orden
	}

	protected void addSite(Site site) {
		sites.add(site);
	}

	protected void addSiteWithName(String name) {
		sites.add(new Site(name));
	}

	public void addLink(String dataLink) {
		try {
			String[] s = dataLink.split("->");
			addSiteWithName(s[0]);
			addSiteWithName(s[1]);
			links.add(new Link(s[0], s[1]));
		} catch (IndexOutOfBoundsException e) {
			throw new IllegalArgumentException("Bad line " + dataLink);
		}
	}

	public Set<String> getNames() {
		Set<String> s = new HashSet<>();
		for (Site si : sites) {
			s.add(si.getName());
		}
		return s;
	}

	public Site getSite(String name) {
		for (Site si : sites) {
			if (si.getName().equalsIgnoreCase(name)) {
				return si;
			}
		}
		throw new NoSuchElementException("No such site " + name);
	}

	/*
	 * public Site getSite(String name){ Iterator<Site> it = sites.iterator(); while
	 * (it.hasNext()) { Site site = it.next(); if
	 * (site.getName().equalsIgnoreCase(name)) return site; } throw new
	 * NoSuchElementException("No such site " + name); }
	 */

	private Set<Site> getSitesLinkedFrom(Site pagina) {
		Set<Site> result = new HashSet<>();

		for (Link link : links) {
			String origin = link.getOrigin();

			if (this.getSite(origin).equals(pagina)) {
				String linked = link.getLinked();
				result.add(this.getSite(linked));
			}
		}
		return result;
	}

	protected void distribute(Site site, double prize) {
		if (prize >= THRESHOLD) {
			site.addRank(prize / 2);

			Set<Site> s = getSitesLinkedFrom(site);
			if (!s.isEmpty()) {
				for (Site si : s) {
					distribute(si, prize / (2 * s.size())); // recursividad
				}
			}
		}
	}

	public void click(String name) {
		try {
			Site site = getSite(name);
			distribute(site, 1);
		} catch (NoSuchElementException e) {
			// Ignorar
		}
	}

	public void simulateClick(int clicks) {
		List<String> names = new ArrayList<>(this.getNames());
		if (names.size() > 0) {
			int pos = alea.nextInt(names.size());
			this.click(names.get(pos));
		}
	}
	
	public SortedSet<Site> getSitesByName(){
		return new TreeSet<Site>(sites);
	}
	
	

	@Override
	public String toString() {
		return String.format("Web (%s, %s)", sites, links);
		// return "Web" + sites.toString() + ", " + links.toString();
	}
}
