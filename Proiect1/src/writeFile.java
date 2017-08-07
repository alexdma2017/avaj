import java.io.File;
import java.io.PrintWriter;

public class writeFile {	
	public void fileWriter(){
		try {
			File file = new File("Simulation.txt");
			if(file.exists()) {
				file.createNewFile();
			}
			/*PrintWriter pw = new PrintWriter(file);
			pw.println("Some files");
			pw.println(1000);
			pw.close();
			System.out.println("Done!");*/
		}
		catch(Exception e) {e.printStackTrace();
		}
	}
}

