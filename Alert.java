
public class Alert {
	
	private int severity, count;
	private String node, property, time, summary;
	
	public Alert(String info, String sep) {
		String[] str = info.split(sep);
		severity = Integer.parseInt(str[0]);
		count = Integer.parseInt(str[1]);
		node = str[2];
		property = str[3];
		time = str[4];
		summary = str[5];
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
	
	@Override
	public String toString() {
		return "Severity: " + String.valueOf(severity) + " Count: " + count + 
				" Node: " + node + " Property: " + property + 
				" Time: " + time + " Summary: " + summary;
	}
}
