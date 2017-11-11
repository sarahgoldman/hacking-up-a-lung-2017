package com.hual.reverse_forecast;
public class Place{
	String name;
	String id;
	String country;
	Location coord;
	
	public Place(){
		super();
	}
	public Place(String name, String id, String country, Location coord){
		this.name=name;
		this.id=id;
		this.country=country;
		this.coord=coord;
	}
	
	public String getName(){
		return name;
	}
	public String getId(){
		return id;
	}
	public String getCountry(){
		return country;
	}
	public Location getCoord(){
		return coord;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setCountry(String country){
		this.country=country;
	}
	public void setCoord(Location coord){
		this.coord=coord;
	}
}