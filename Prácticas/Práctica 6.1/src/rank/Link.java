package rank;

import java.util.Objects;

public class Link {
	private String origin;
	private String linked;
	
	public Link(String org, String lnk) {
		this.origin = org;
		this.linked = lnk;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public String getLinked() {
		return this.linked;
	}
	
	@Override
	public boolean equals(Object o) {
		return ((o instanceof Link) && (((Link) o).origin.equalsIgnoreCase(origin)) && ((Link) o).linked.equalsIgnoreCase(linked));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(linked.toLowerCase(), origin.toLowerCase());
	}
	
	@Override
	public String toString() {
		return this.origin + "->" + this.linked;
	}
}
