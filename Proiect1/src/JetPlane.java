import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class JetPlane extends Aircraft  implements Flyable{
	
	private WeatherTower weatherTower;
	private String text;

	public JetPlane( String name, Coordinates coordinates) {
		super( name, coordinates);
		
	}
	

	public void updateConditions() {
		weatherTower= new WeatherTower();
		String newWeather = weatherTower.getWeather(coordinates);
		
		switch(newWeather) {
		
		case WeatherType.FOG:
			coordinates.setLatitude(coordinates.getLatitude()+1);
			text ="JetPlane #" + this.getName() + "(" + this.getId() + "): it's really foggy down there";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		break;
		
		case WeatherType.RAIN:
			coordinates.setLatitude(coordinates.getLatitude()+5);
			text ="JetPlane #" + this.getName() + "(" + this.getId() + "): it's raining hard here";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		break;
		
		case WeatherType.SUN:
			coordinates.setHeight(coordinates.getHeight()+2);
			coordinates.setLatitude(coordinates.getLatitude()+10);
			text ="JetPlane #" + this.getName() + "(" + this.getId() + "): flying in the sun is so much fun";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		break;
		
		case WeatherType.SNOW:
			coordinates.setHeight(coordinates.getHeight()-7);
			text ="JetPlane #" + this.getName() + "(" + this.getId() + "): that thing about winter that guy from that tv show once said";
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
			text ="Tower says: JetPlane #" + this.getName() + "(" + this.getId() + "): has been unrergistered";
			try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
				out.println(text);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		text ="Tower says: JetPlane #" + this.getName() + "(" + this.getId() + "): has been rergistered";
		try(PrintWriter out = new PrintWriter(new FileOutputStream("Simulation.txt", true))){
			out.println(text);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
	

}
