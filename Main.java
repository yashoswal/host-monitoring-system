import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("final_alert_file.csv"));
		String line = br.readLine(); // Read header
		while ((line = br.readLine()) != null) {
			Alert alert = new Alert(line, "\\|");
			
		}
		br.close();
	}
}
