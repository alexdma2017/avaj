import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Helicopter extends Aircraft implements Flyable{
	
	private WeatherTower weatherTower;
	private String text;

	public Helicopter( String name, Coordinates coordinates) {
		super( name, coordinates);	
	}

	public void updateConditions() {
		String newWeather = weatherTower.getWeather(coordinates);
		
		switch(newWeather) {
		
		case WeatherType.FOG:
			coordinates.setLongitude(coordinates.getLongitude()+1);
			text ="Helicopter #" + this.getName() + "(" + this.getId() + "): silly fog, I can just fly over you";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		break;
		
		case WeatherType.RAIN:
			coordinates.setLongitude(coordinates.getLongitude()+5);
			text ="Helicopter #" + this.getName() + "(" + this.getId() + "): helicopters are not afraid to get wet";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		break;
		
		case WeatherType.SUN:
			coordinates.setHeight(coordinates.getHeight()+2);
			coordinates.setLongitude(coordinates.getLongitude()+10);
			text ="Helicopter #" + this.getName() + "(" + this.getId() + "): the sun is blinding me";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		break;
		
		
		case WeatherType.SNOW:
			coordinates.setHeight(coordinates.getHeight()-12);
			text ="Helicopter #" + this.getName() + "(" + this.getId() + "): it's snowing, move to intercept Santa Claus";
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
			weatherTower.unregister(this); //de vazut
			text ="Tower says: Helicopter #" + this.getName() + "(" + this.getId() + "): has been unrergistered";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
				
	

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		text ="Tower says: Helicopter #" + this.getName() + "(" + this.getId() + "): has been rergistered";
		try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
			out.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
