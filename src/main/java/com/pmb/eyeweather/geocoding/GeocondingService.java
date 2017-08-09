package com.pmb.eyeweather.geocoding;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GeocondingService {
	public static final String GEOCODING_SCHEME_CLIMATE = "http";
	public static final String GEOCODING_HOST_CLIMATE = "forecast.weather.gov/MapClick.php?";
	public static final String SUFFIX_CLIMATE = "&FcstType=json";

	public static final String GEOCODING_SCHEME_ADDRESS = "https";
	public static final String GEOCODING_HOST_ADDRESS = "maps.googleapis.com/maps/api/geocode/json?";
	public static final String SUFFIX_ADDRESS = "&sensor=false";

	public Address getAddressOfLocation(Double lat, Double lon) {
		System.out.println("Geocoding.getWeatherOfLocation.__ini__");

		URI uri;
		Address address = null;
		try {
			uri = new URIBuilder().setScheme(GEOCODING_SCHEME_ADDRESS)
					.setHost(GEOCODING_HOST_ADDRESS)
					.setPath("latlng=" + lat + "," + lon + SUFFIX_ADDRESS)
					.build();
		} catch (URISyntaxException e) {
			return null;
		}

		HttpGet httpget = new HttpGet(uri);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(1000).setConnectTimeout(1000).build();

		httpget.setConfig(requestConfig);
		CloseableHttpResponse resp1;
		try {
			resp1 = httpclient.execute(httpget);

			HttpEntity result = resp1.getEntity();
			InputStream stream = result.getContent();
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("Geocoding.getAddressOfLocation before mapper");

			address = mapper.readValue(stream, new TypeReference<Address>() {
			});
			stream.close();
			httpclient.close();
		} catch (ClientProtocolException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
		return address;

	}

	public Climate getWeatherOfLocation(Double lat, double lon) {
		URI uri;
		try {
			uri = new URIBuilder().setScheme(GEOCODING_SCHEME_CLIMATE)
					.setHost(GEOCODING_HOST_CLIMATE)
					.setPath("lat=" + lat + "&lon=" + lon + SUFFIX_CLIMATE)
					.build();
		} catch (URISyntaxException e1) {
			return null;
		}
		Climate c = null;

		HttpGet httpget = new HttpGet(uri);
		CloseableHttpClient httpclient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(2000).setConnectTimeout(2000).build();

		httpget.setConfig(requestConfig);
		CloseableHttpResponse resp1;
		try {
			resp1 = httpclient.execute(httpget);

			HttpEntity result = resp1.getEntity();
			InputStream stream = result.getContent();
			ObjectMapper mapper = new ObjectMapper();
			c = mapper.readValue(stream, new TypeReference<Climate>() {
			});
			stream.close();
			httpclient.close();
		} catch (ClientProtocolException e) {			
			return null;
		} catch (IOException e) {			
			return null;
		}

		return c;
	}
}
