
public class Baloon extends Aircraft  implements Flyable {
	
	private WeatherTower weatherTower;

	public Baloon( String name, Coordinates coordinates) {
		super( name, coordinates);
	}
	
	public void updateConditions() {
		String newWeather = weatherTower.getWeather(coordinates);
		if (newWeather.equals(WeatherType.FOG)) {
			coordinates.setHeight(coordinates.getHeight()-3);
		}
		else if(newWeather.equals(WeatherType.RAIN)){
			coordinates.setHeight(coordinates.getHeight()-5);
		}
		else if(newWeather.equals(WeatherType.SUN)){
			coordinates.setHeight(coordinates.getHeight()+4);
			coordinates.setLongitude(coordinates.getLongitude()+2);
		}
		else if(newWeather.equals(WeatherType.SNOW)){
			coordinates.setHeight(coordinates.getHeight()-15);
		}
		
		if(coordinates.getHeight()<0) {
			coordinates.setHeight(0);
		}
		if(coordinates.getHeight()>100) {
			coordinates.setHeight(100);
		}
		if (coordinates.getHeight()==0) {
			weatherTower.unregister(this); //de vazut
			System.out.println("Baloon #" + this.getName() + "(" + this.getId() + "): has been unrergistered");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		System.out.println("Baloon #" + this.getName() + "(" + this.getId() + "): registered to weather tower");
		
	}
	
	
	

}
