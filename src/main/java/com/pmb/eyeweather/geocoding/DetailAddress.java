package com.pmb.eyeweather.geocoding;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailAddress {
	private String fullAddress;
	
	@JsonCreator
	public DetailAddress(@JsonProperty("formatted_address") String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getFullAddress() {
		return fullAddress;
	}	
	
}
