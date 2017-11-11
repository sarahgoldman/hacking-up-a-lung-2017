package com.hual.reverse_forecast;
public class Place{
	String name;
	String id;
	String country;
	Location coord;
	String temp;
	String condition;
	String humidity;
	String wind;
	
	public Place(){
		super();
	}
	public Place(String name, String id, String country, Location coord, String temp, String condition, String humidity, String wind){
		this.name=name;
		this.id=id;
		this.country=country;
		this.coord=coord;
		this.temp = temp;
		this.condition=condition;
		this.humidity = humidity;
		this.wind=wind;
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
	public String getTemp(){
		return temp;
	}
	public String getCondition(){
		return condition;
	}
	public String getHumidity(){
		return humidity;
	}
	public String getWind(){
		return wind;
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
	public void setTemp(String temp){
		this.temp = temp;
	}
	public void setCondition(String condition){
		this.condition = condition;
	}
	public void setHumidity(String humidity){
		this.humidity = humidity;
	}
	public void setWind(String wind){
		this.wind = wind;
	}
}