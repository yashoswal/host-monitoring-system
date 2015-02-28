import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static final int COUNT = 10; // DELAY ROT
	public static final int COUNTMAX = 7; // if count is > this it's noticeable
	public static final int SEVERITYMAX = 2;
	public static Queue<Alert> severe = new LinkedList<Alert>();
	public static Queue<Alert> hits = new LinkedList<Alert>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("final_alert_file.csv"));
		String line = br.readLine(); // Read header
		int count = 1;
		Alert alert = null, drop = null;
		while ((line = br.readLine()) != null) {
			alert = new Alert(line, "\\|", count);
			if (alert.getSeverity() <= SEVERITYMAX) {
				for (Alert s : severe) { // check is this has happened before
					if (alert.equals(s)) { // if it has, it's important
						drop = s;
						// TODO call summary
						System.out.println(alert.toString()); // TODO remove
					}
				}
				if (drop == null) {
					severe.add(alert);
				} else {
					severe.remove(drop);
					drop = null;
				}
			} else if (alert.getCount() >= COUNTMAX) {
				for (Alert h : hits) { // check if this has happened before
					if (alert.equals(h)) { // if it has, it's important
						drop = h;
						// TODO call summary
						System.out.println(alert.toString()); // TODO remove
					}
				}
				if (drop == null) { // alert has happened before, remove previous alert
					hits.add(alert);
				} else { // alert hasn't happened before, add it
					hits.remove(drop);
					drop = null;
				}
			}
			// Remove alerts older than ...
			while (severe.size() > 0 && count - severe.peek().getIn() >= COUNT) {
				severe.remove();
			}
			while (hits.size() > 0 && count - hits.peek().getIn() >= COUNT) {
				hits.remove();
			}
			// more code here
			count++;
		}
		br.close();
	}
}
