package com.pmb.eyeweather.geocoding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Address {
	private List<DetailAddress> results;
	private String fullAddress;
	private String status;
	
	@JsonCreator
	public Address(
			@JsonProperty("results") List<DetailAddress> results,
			@JsonProperty("status") String status
			){
		this.results = results;
		this.status = status;
		System.out.println("Status: " + status);
		this.fullAddress = results.get(0).getFullAddress();
	}

	public List<DetailAddress> getResults() {
		return results;
	}

	public String getStatus() {
		return status;
	}
	
	public String getFullAddress(){
		return fullAddress;
	}
	
}


