public class WeatherProvider {
	
	private static WeatherProvider weatherProvider = null;
	private static String[] weather = {WeatherType.FOG, WeatherType.RAIN, WeatherType.SUN, WeatherType.SNOW};
	
	private WeatherProvider(){
		
	}
	
	public static WeatherProvider getProvider(){
		if(weatherProvider == null)
			weatherProvider = new WeatherProvider();
		
		return weatherProvider;
	}

	
	public String getCurrentWeather(Coordinates coordinates){
		
		int x= (coordinates.getLatitude()*2 + coordinates.getLongitude()*3)%4;
		
		return weather[x];
	}
}
