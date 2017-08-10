import java.io.File;
import java.io.PrintWriter;

public class FileWriter {	
	
	public void fileWriter(){
		try {
			File file = new File("Simulation.txt");
			if(!file.exists()) {
				file.createNewFile();
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

