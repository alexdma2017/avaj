import java.util.ArrayList;

public class Program {

	public static void main(String[] args) throws TypeException, HeightException {

		FileReader input = new FileReader();
		FileWriter output = new FileWriter();
		
		input.fileReader(args[0]);
		output.fileWriter();
		
		ConcreteAircraftFactory factory = new ConcreteAircraftFactory();
		WeatherTower wthrTower = new WeatherTower();
		
		ArrayList<Flyable> ar = new ArrayList<Flyable>();
		
		for (int i = 1; i <FileReader.fileList.size(); i++) {
			 ar.add(factory.newAircraft(FileReader.fileList.get(i)[0], FileReader.fileList.get(i)[1], Integer.parseInt(FileReader.fileList.get(i)[2]), 
					Integer.parseInt(FileReader.fileList.get(i)[3]), Integer.parseInt(FileReader.fileList.get(i)[4])));
		}
		
		for (int j = 0; j < ar.size(); j++) {
			ar.get(j).registerTower(wthrTower);
		}
		
		for(int count = 0; count<Integer.parseInt(FileReader.fileList.get(0)[0]); count++) {
			int i=0;
			for(Flyable elements: ar) {
			wthrTower.conditionsChanged();				
				i++;
			}
		}
	}

}
