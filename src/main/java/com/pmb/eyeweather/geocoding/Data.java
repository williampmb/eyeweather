package com.pmb.eyeweather.geocoding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	private List<String> forecast;
	private String todayForecast;

	@JsonCreator
	public Data(
			@JsonProperty("text") List<String> forecast
			) {
		this.forecast = forecast;
		todayForecast = forecast.get(0);
	}


	public List<String> getForecast() {
		return forecast;
	}


	public void setForecast(List<String> forecast) {
		this.forecast = forecast;
	}


	public String getTodayForecast() {
		return todayForecast;
	}


	public void setTodayForecast(String todayForecast) {
		this.todayForecast = todayForecast;
	}


}