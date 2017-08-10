import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) throws TypeException, HeightException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		FileReader input = new FileReader();
		FileWriter output = new FileWriter();
		
		input.fileReader(args[0]);
		output.fileWriter();
		
		ConcreteAircraftFactory factory = new ConcreteAircraftFactory();
		WeatherTower weatherTower = new WeatherTower();
		
		Method m = WeatherTower.class.getDeclaredMethod("changeWeather");
		m.setAccessible(true);
		
		ArrayList<Flyable> ar = new ArrayList<Flyable>();
		
		for (int i = 1; i <FileReader.fileList.size(); i++) {
			 ar.add(factory.newAircraft(FileReader.fileList.get(i)[0], FileReader.fileList.get(i)[1], Integer.parseInt(FileReader.fileList.get(i)[2]), 
					Integer.parseInt(FileReader.fileList.get(i)[3]), Integer.parseInt(FileReader.fileList.get(i)[4])));
		}
		
		try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
			for (int j = 0; j < ar.size(); j++) {
				ar.get(j).registerTower(weatherTower);
			}
			out.println("");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(int count = 0; count<Integer.parseInt(FileReader.fileList.get(0)[0]); count++) { 
			m.invoke(weatherTower);	
		}	
	}
}
