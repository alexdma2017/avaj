import java.awt.List;
import java.util.ArrayList;

public abstract class Tower{
	private Flyable observers;
	
	ArrayList mylist = new ArrayList();
	
	public void register(Flyable flyable){
	}
	
	public void unregister(Flyable flyable){
		
	}
	
	protected void conditionsChanged(){
		
	}
}
