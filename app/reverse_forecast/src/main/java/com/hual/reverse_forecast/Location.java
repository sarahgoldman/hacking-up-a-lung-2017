package com.hual.reverse_forecast;
public class Location {
	double lat;
	double lon;
	
	public Location(double lat,double lon){
		this.lat=lat;
		this.lon=lon;
	}
	public Location(){
		super();
	}
	
	public double getLat(){
		return lat;
	}
	public double getLon(){
		return lon;
	}
	
	public void setLat(){
		this.lat=lat;
	}
	public void setLon(){
		this.lon=lon;
	}

}