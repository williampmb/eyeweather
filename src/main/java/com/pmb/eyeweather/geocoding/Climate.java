package com.pmb.eyeweather.geocoding;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Climate {
	private Data data;
	private CurrentObservation currentObv;

	@JsonCreator
	public Climate(@JsonProperty("data") Data data,
			@JsonProperty("currentobservation") CurrentObservation currentObv
			) {
		this.data = data;
		this.currentObv = currentObv;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}	
	
	public CurrentObservation getCurrentObv() {
		return currentObv;
	}

	public void setCurrentObv(CurrentObservation currentObv) {
		this.currentObv = currentObv;
	}
}
