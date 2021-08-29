package com.weather.info;

public class WeatherComparator {
	
	public int compare(Double apiWeather, Double uiWeather) {
		
		if(apiWeather == uiWeather)
			
			return 1;
		else 
			
			return 0;
	}
	
	public int variance(Double apiWeather, Double uiWeather) throws OutOfRangeException {
		
		Double tempDiff = apiWeather - uiWeather;
		
		if(tempDiff > 0 && tempDiff < 10) 
			return 1;
		
		else 
			throw new OutOfRangeException("Temperature Range is not valid");
	}

}
