public class Aircraft {
	
	protected long  Id; 
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;
	
	public long getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public long getIdCounter() {
		return idCounter;
	}
	public void setIdCounter(long idCounter) {
		this.idCounter = idCounter;
	}
	public Aircraft( String name, Coordinates coordinates) {
		
		this.name = name;
		this.coordinates = coordinates;
		this.Id = ++idCounter;
	}

}
