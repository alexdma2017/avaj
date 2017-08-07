
public class JetPlane extends Aircraft  implements Flyable{
	
	private WeatherTower weatherTower;

	public JetPlane( String name, Coordinates coordinates) {
		super( name, coordinates);
		
	}
	

	public void updateConditions() {
		String newWeather = weatherTower.getWeather(coordinates);
		if (newWeather.equals(WeatherType.FOG)) {
			coordinates.setLatitude(coordinates.getLatitude()+1);
		}
		else if(newWeather.equals(WeatherType.RAIN)){
			coordinates.setLatitude(coordinates.getLatitude()+5);
		}
		else if(newWeather.equals(WeatherType.SUN)){
			coordinates.setHeight(coordinates.getHeight()+2);
			coordinates.setLatitude(coordinates.getLatitude()+10);
		}
		else if(newWeather.equals(WeatherType.SNOW)){
			coordinates.setHeight(coordinates.getHeight()-7);
		}
		
		if(coordinates.getHeight()<0) {
			coordinates.setHeight(0);
		}
		if(coordinates.getHeight()>100) {
			coordinates.setHeight(100);
		}
		if (coordinates.getHeight()==0) {
			weatherTower.unregister(this); //de vazut
			System.out.println("JetPlane #" + this.getName() + "(" + this.getId() + "): has been unrergistered");
		}
		
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
		System.out.println("JetPlane #" + this.getName() + "(" + this.getId() + "): registered to weather tower");	
		}
	

}
