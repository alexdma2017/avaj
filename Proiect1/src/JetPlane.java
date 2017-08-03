
public class JetPlane extends Aircraft  implements Flyable{
	
	private WeatherTower weatherTower;

	public JetPlane( String name, Coordinates coordinates) {
		super( name, coordinates);
		
	}
	

	public void updateConditions() {
		// TODO Auto-generated method stub
		
	}

	public void registerTower(WeatherTower weatherTower) {
		
		System.out.println("Jet plane has been registered");	
		}
	

}
