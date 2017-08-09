package com.pmb.eyeweather.geocoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class LocationDao {
	Map<String, List<Location>> listLocations = new HashMap<String, List<Location>>(); //@repository

	public Map<String, List<Location>> getListLocations() {
		return listLocations;
	}

	public void setListLocations(Map<String, List<Location>> listLocations) {
		this.listLocations = listLocations;
	}

	public List<Location> getListByUserId(String userid) {		
		List<Location> listOfUser = null;
		if(listLocations.get(userid) == null){
			listOfUser = new ArrayList<Location>();
			listLocations.put(userid, listOfUser);
		}else{
			listOfUser = listLocations.get(userid);
		}
		
		return listOfUser;
	}

	public List<Location> addLocation(Location location, String userid) {
		List<Location> listByUserId = getListByUserId(userid);
		listByUserId.add(0, location);
		return listByUserId;
	}

	public List<Location> delete(String userid, String lid) {
		System.out.println("Dao.Delete.__ini__");
		List<Location> listByUserId = getListByUserId(userid);
		for(Location l : listByUserId){
			if(l.getId().equals(lid)){
				System.out.println("Dao.Delete. if(id=id) => delete");
				listByUserId.remove(l);
				System.out.println("Dao.Delete. delete success");
				break;
			}
		}
		System.out.println("daoDelete: " + listByUserId.size());
		return listByUserId;
		
	}	
	
}
