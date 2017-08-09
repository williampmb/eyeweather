package com.pmb.eyeweather.geocoding;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentObservation {

	private String wind;
	private String humidity;
	private String barometric;
	private String temperature;
	private String currentWeather;
	
	@JsonCreator
	public CurrentObservation(
			@JsonProperty("Winds") String wind,
			@JsonProperty("SLP") String barometric,
			@JsonProperty("Relh") String humidity,
			@JsonProperty("Temp") String temperature,
			@JsonProperty("Weather") String currentWeather
			) {
		System.out.println( "cuob: "+ wind + " " + barometric+ " " + humidity);
		this.wind = wind;
		this.barometric = barometric;
		this.humidity = humidity;
		this.temperature = temperature;
		this.currentWeather = currentWeather;
	}

	public String getWind() {
		return wind;
	}

	public String getHumidity() {
		return humidity;
	}

	public String getBarometric() {
		return barometric;
	}

	public String getTemperature() {
		return temperature;
	}

	public String getCurrentWeather() {
		return currentWeather;
	}
	
}