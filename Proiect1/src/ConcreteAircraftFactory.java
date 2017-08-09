
public class ConcreteAircraftFactory extends AircraftFactory {

	public Flyable newAircraft (String type, String name, int longitude, int latitude, int height){
		
		Coordinates coord = Coordinates.makeCoordinate(longitude, latitude, height);
		
		
		if (type.equals("Baloon") || type.equals("baloon")) {
		return new Baloon(name, coord);
		}
		
		else if(type.equals("JetPlane") || type.equals("jetplane") || type.equals("Jetplane")) {
			return new JetPlane(name, coord);
		}
		
		else if(type.equals("Helicopter") || type.equals("helicopter")) {
			return new Helicopter(name, coord);
		}
		
		else return Error();
	}

	private Flyable Error() {
		System.out.println("Unidentified Flying Object");
		return null;
	}
}
