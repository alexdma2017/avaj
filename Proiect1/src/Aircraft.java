import java.util.ArrayList;
import java.util.Collections;

public class Aircraft {
	
	protected long  Id; 
	protected String name;
	protected Coordinates coordinates;
	private long idCounter;
	ArrayList<Integer> list = new ArrayList<Integer>();
	
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
	
	private void genIdList() {
        for (int i=1; i<10; i++) {
            list.add(new Integer(i));
        }
        
	}
	
	private long NextId() {
        Collections.shuffle(list);
        int i=0;
        for (int element : list) {
            Id = list.get(i);
            i++;
        }
		
		return Id;
		
		
	}
	
	
	

}
