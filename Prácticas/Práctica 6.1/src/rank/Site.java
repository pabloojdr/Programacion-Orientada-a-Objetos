package rank;

import java.util.Locale;
import java.util.Objects;

public class Site implements Comparable<Site> {
	private String name;
	private double rank;

	public Site(String name) {
		this.name = name;
		this.rank = 0;
	}

	public String getName() {
		return name;
	}

	public double getRank() {
		return rank;
	}

	public void addRank(double r) {
		rank += r;
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof Site) && (((Site) o).name.equalsIgnoreCase(name)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase());
	}

	@Override
	public int compareTo(Site s) {
		return name.compareToIgnoreCase(s.name);
	}

	@Override
	public String toString() {
		//String s = String.format(Locale.ENGLISH, "%.5f", rank);
		//return this.getName() + "(" + s + ")";
		return String.format(Locale.UK, "%s(%.5f)", name, rank);
	}
}
