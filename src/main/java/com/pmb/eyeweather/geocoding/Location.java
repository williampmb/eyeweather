package com.pmb.eyeweather.geocoding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	private String time;
	private String id;
	private Double latitude;
	private Double longitude;
	private Climate climate;
	private Address address;
	
	public Location(Climate climate, Address address, Double lat, Double lon){
		this. id = UUID.randomUUID().toString();
		this.climate = climate;
		this.address = address;
		this.latitude = lat;
		this.longitude = lon;
		Date timeNow = new Date();
		
		SimpleDateFormat df =  new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		time = df.format(timeNow);	
	}

	public String getTime() {
		return time;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Climate getClimate() {
		return climate;
	}

	public void setClimate(Climate climate) {
		this.climate = climate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
