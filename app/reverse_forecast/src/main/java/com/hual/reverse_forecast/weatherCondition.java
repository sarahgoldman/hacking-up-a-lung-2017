package com.hual.reverse_forecast;

public enum weatherCondition {
	THUNDER(0,"Thunderstorm"),
	DRIZZLE(1,"Drizzle"),
	RAIN(2,"Rain"),
	SNOW(3,"Snow"),
	HAZY(4,"Hazy"),
	CLEAR(5,"Clear"),
	CLOUDY(6,"Partly Cloudy"),
	OVERCAST(7,"Overcast"),
	TORNDADO(8,"Tornado"),
	STORM(9,"Severe Storm"),
	WINDY(10,"Windy");
	
	final private int id;
	final private String name;
	
	private weatherCondition (final int id, final String name){
		this.id=id;
		this.name=name;
	}
	
	
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	
	
}