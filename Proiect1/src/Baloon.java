import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Baloon extends Aircraft  implements Flyable {
	
	private WeatherTower weatherTower;
	private String text;

	public Baloon( String name, Coordinates coordinates) {
		super( name, coordinates);
	}
	
	public void updateConditions() {
		String newWeather = weatherTower.getWeather(coordinates);
		
		
		switch(newWeather) {
		
		case WeatherType.FOG: 
			coordinates.setHeight(coordinates.getHeight()-3);
			text ="Baloon #" + this.getName() + "(" + this.getId() + "): get us lower, we are flying through pea soup";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		
		case WeatherType.RAIN:
			coordinates.setHeight(coordinates.getHeight()-5);
			text ="Baloon #" + this.getName() + "(" + this.getId() + "): descending will not make us any less wet";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
			
		case WeatherType.SUN:
			coordinates.setHeight(coordinates.getHeight()+4);
			coordinates.setLongitude(coordinates.getLongitude()+2);
			text ="Baloon #" + this.getName() + "(" + this.getId() + "): make twoards the rising sun";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
			
			
		case WeatherType.SNOW:
			coordinates.setHeight(coordinates.getHeight()-15);
			text ="Baloon #" + this.getName() + "(" + this.getId() + "): this thing does not run a cold air";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			break;
		}
		if(coordinates.getHeight()<0) {
			coordinates.setHeight(0);
		}
		if(coordinates.getHeight()>100) {
			coordinates.setHeight(100);
		}
		if (coordinates.getHeight()==0) {
			weatherTower.unregister(this);
			String text ="Tower Says: Baloon #" + this.getName() + "(" + this.getId() + "): has been unrergistered";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		text ="Tower Says: Baloon #" + this.getName() + "(" + this.getId() + "): registered to weather tower";
		try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
			out.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
