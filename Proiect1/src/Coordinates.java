
public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	private Coordinates(int latitude, int longitude, int height){
		   this.latitude = latitude;
		   this.longitude= longitude;
		   this.height= height;
	}
	
	public static Coordinates makeCoordinate(int longitude, int latitude, int height) {
		return new Coordinates(longitude, latitude, height);
	}
}
