package com.logicq.logicq.dao.map.impl;

import java.net.URL;

import com.logicq.logicq.dao.map.ILocationMapDAO;
import com.logicq.logicq.model.map.LocationMap;


public class LocationMapDAO  implements ILocationMapDAO {

	public LocationMap getLocation(String ipAddress) throws Exception {
		String dataFile = "location/GeoLiteCity.dat";
		return getLocation(ipAddress, dataFile) ;
	}

	
	private LocationMap getLocation(String ipAddress, String locationDataFile) throws Exception {

		LocationMap serverLocation = null;

		  URL url = getClass().getClassLoader().getResource(locationDataFile);

		  if (url == null) {
			System.err.println("location  is not found - "
				+ locationDataFile);
		  } else {
			serverLocation = new LocationMap();

//			LookupService lookup = new LookupService(url.getPath(),
//					LookupService.GEOIP_MEMORY_CACHE);
//			Location locationServices = lookup.getLocation(ipAddress);

//			serverLocation.setCountryCode(locationServices.countryCode);
//			serverLocation.setCountryName(locationServices.countryName);
//			serverLocation.setRegion(locationServices.region);
//			serverLocation.setRegionName(regionName.regionNameByCode(
//				locationServices.countryCode, locationServices.region));
//			serverLocation.setCity(locationServices.city);
//			serverLocation.setPostalCode(locationServices.postalCode);
//			serverLocation.setLatitude(
//	                                String.valueOf(locationServices.latitude));
//			serverLocation.setLongitude(
//	                                String.valueOf(locationServices.longitude));

		 }

		 return serverLocation;

		}	
}
