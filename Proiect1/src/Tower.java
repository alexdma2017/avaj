import java.util.ArrayList;

public abstract class Tower{
	private Flyable observers;
	
	private ArrayList<Flyable> observerList;
	
	public Tower() {
		observerList = new ArrayList<Flyable>();
	}
	
	public void register(Flyable flyable){
		
		observerList.add(flyable);
	}
	
	public void unregister(Flyable flyable){
		
		int i= observerList.indexOf(flyable);
		if (i>=0) {
			observerList.remove(i);
		}
		
	}
	
	/*public void notifyAircraft() {
		for(int i=0; i<=observerList.size(); i++) {
			observers=observerList.get(i);
			observers.updateConditions();
		}
	}*/
	
	protected void conditionsChanged(){
		
		for(int i=0; i<observerList.size(); i++) {
			observers=observerList.get(i);
			observers.updateConditions();
		}
	}
}
