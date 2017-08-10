import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
	
public class FileReader {
	
	public static List<String[]> fileList = new ArrayList<String[]>();
	Boolean first;
	
	public void fileReader(String argument) throws TypeException, HeightException {
		Path path = Paths.get(argument);
		try {
			List<String> lines = Files.readAllLines(path,Charset.defaultCharset());
		for(String line : lines) {
			String[] pair = line.split(" ");
			fileList.add(pair);
			}
		for (String[] elements : fileList) {
			Integer.parseInt(fileList.get(0)[0]);
			for (int i = 1; i < fileList.size(); i++) {
				if (fileList.get(i)[0].equals("JetPlane") || fileList.get(i)[0].equals("Helicopter")|| fileList.get(i)[0].equals("Baloon")) {
					first = true;
					} 
				else
					first = false;
				if (first.equals(false))
					throw new TypeException("Wrong type of Aircraft");
				if (Integer.parseInt(fileList.get(i)[4]) < 0 || Integer.parseInt(fileList.get(i)[4]) > 100) {
					throw new HeightException("Height must be between 0 and 100");
					}
				for (int j = 2; j < 5; j++) {
					Integer.parseInt(fileList.get(i)[j]);
					}
				}
			}
		
		
		} 
		catch (IOException e) {
			System.out.println("Please specify the input file");
			System.exit(1);
		}
		
		catch (NumberFormatException n) {
			System.out.println("Error! Coordinates must be numbers");
			n.printStackTrace();
			} 
		catch (TypeException t) {
				t.printStackTrace();
				} 
		catch (HeightException h) {
			h.printStackTrace();
			}
	}
}

