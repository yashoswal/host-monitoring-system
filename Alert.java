
public class Alert {
	
	private int severity, count;
	private String node, property, time, summary;
	
	private int in; // for demo
	
	public Alert(String info, String sep, int in) {
		String[] str = info.split(sep);
		severity = Integer.parseInt(str[0]);
		count = Integer.parseInt(str[1]);
		node = str[2];
		property = str[3];
		time = str[4];
		summary = str[5];
		this.in = in;
	}
	
	public int getSeverity() {
		return severity;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getNode() {
		return node;
	}
	
	public String getProperty() {
		return property;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getSummary() {
		return summary;
	}
	
	
	public int getIn() {
		return in;
	}
	
	@Override
	public boolean equals(Object o) {
		Alert a = (Alert) o;
		return this.severity == a.severity &&
				this.node.equals(a.node) && this.property.equals(a.property)
				&& this.summary.equals(a.summary);
	}
	
	@Override
	public String toString() {
		return String.valueOf(severity) + "|" + count + 
				"|" + node + "|" + property + 
				"|" + time + "|" + summary;
	}
}
