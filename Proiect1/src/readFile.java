import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
	
public class readFile {
	
	public static List<String[]> fileList = new ArrayList<String[]>();
	
	public void fileReader() {
		Path path = Paths.get("in.txt");
		try {
			List<String> lines = Files.readAllLines(path,Charset.defaultCharset());
		for(String line : lines) {
			String[] pair = line.split(" ");
			fileList.add(pair);
			}
		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

