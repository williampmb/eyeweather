package com.pmb.eyeweather.geocoding;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	@Autowired
	private LocationDao locDao;

	private static int MAX_NUM_LOCATIONS = 3;

	public List<Location> getListByUserId(String userid) {

		List<Location> fullList = locDao.getListByUserId(userid);
		
		
		return pickNFirsts(fullList);
	}

	public List<Location> addLocation(Location location, String userid) {

		List<Location> fullList = locDao.addLocation(location, userid);
		return pickNFirsts(fullList);
	}

	public List<Location> delete(String userid, String lid) {
		System.out.println("Service.Delete.__ini__");
		List<Location> fullList =  locDao.delete(userid, lid);
		return pickNFirsts(fullList);

	}

	public List<Location> pickNFirsts(List<Location> fullList) {
		if (fullList.size() > MAX_NUM_LOCATIONS) {
			List<Location> result = new ArrayList<Location>();
			for (int i = 0; i < MAX_NUM_LOCATIONS; i++) {
				result.add(i,fullList.get(i));
			}
			return result;
		}else{
			return fullList;
		}	
	}

}
