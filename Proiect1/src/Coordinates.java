
public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;
	
	public int getLongitude() {
		return longitude;
	}
	/*private void setLongitude(int longitude) {
		this.longitude = longitude;
	}*/
	public int getLatitude() {
		return latitude;
	}
	/*private void setLatitude(int latitude) {
		this.latitude = latitude;
	}*/
	public int getHeight() {
		return height;
	}
	/*private void setHeight(int height) {
		this.height = height;
	}*/
	
	private Coordinates(int latitude, int longitude, int height){
		this.latitude=latitude;
		this.longitude=longitude;
		this.height=height;
	}
}
