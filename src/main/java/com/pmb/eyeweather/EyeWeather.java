package com.pmb.eyeweather;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.pmb.eyeweather.geocoding.Address;
import com.pmb.eyeweather.geocoding.Climate;
import com.pmb.eyeweather.geocoding.GeocondingService;
import com.pmb.eyeweather.geocoding.Location;
import com.pmb.eyeweather.geocoding.LocationService;
import com.pmb.eyeweather.users.User;
import com.pmb.eyeweather.users.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/latlon")
@SessionAttributes(value = "user", types = User.class)
public class EyeWeather {
	@Autowired
	private UserService uService;
	@Autowired
	private LocationService lService;
	@Autowired
	private GeocondingService gService;
	
	public static Integer count =0;
	
	
	@RequestMapping(value = "/users/{userid}/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Location> loadLocations(
			@PathVariable String userid
			) {
		System.out.println(userid);
		return lService.getListByUserId(userid);
		
	}

	@RequestMapping(value = "/users/{userid}/locations", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Location> addLocation(			
			@RequestParam(required=true, defaultValue= "43.81") Double lat,
			@RequestParam(required=true, defaultValue="-91.23") Double lon,
			@PathVariable String userid,
			User user
			) {
		if(user.getId() == null){
			
		}
		if(lat == null){
			lat = 43.81;
			
		}
		if(lon == null){
			lon = -91.23;
		}
		System.out.println("METHOD POST");
		System.out.println(" lat: " + lat + " lon " + lon);
		System.out.println("userid:" + userid);
		
		Address address = gService.getAddressOfLocation(lat, lon);
		
		System.out.println("Address: " + address.toString());
		
		Climate c = gService.getWeatherOfLocation(lat,lon);
		
		System.out.println("Climate: " + c.toString());
		
		Location location = new Location(c, address, lat, lon);
		
		System.out.println("Location:" + location.toString());
		
		List<Location> locs = lService.addLocation(location, userid);
		
		System.out.println(" adicionado location: " + location);
		System.out.println("Size list: " + lService.getListByUserId(userid).size());

		return locs;
	}
	
	@RequestMapping(value = "/users/{userid}/locations/{lid}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Location> delLocation(
			@PathVariable String userid,
			@PathVariable String lid
			) {
		System.out.println("Eyeweather.method = Delete.__ini__");
		List<Location> locs  = lService.delete(userid,lid);
		System.out.println("Eyeweather.method = Delete.__end__");
		
		return locs;
	}
	
	
}
