import java.io.PrintWriter;

public class Aircraft {
	
	protected long  Id; 
	protected String name;
	protected Coordinates coordinates;
	private long idCounter;
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
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
	}
	
	private long nextId() {
        Id = getIdCounter() +1;
        idCounter++;
        return Id;
    }

}
