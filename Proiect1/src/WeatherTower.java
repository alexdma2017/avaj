public class WeatherTower extends Tower {
	
	boolean checkForChange = false;
	
	public String getWeather(Coordinates coordinates){
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);	
	}
	
	private void changeWeather(){
		notifyAircraft();
	}

}
