package com.hual.reverse_forecast;

public enum weatherCondition {
	THUNDER(0,"Thunderstorm","11"),
	DRIZZLE(1,"Drizzle","09"),
	RAIN(2,"Rain","10"),
	SNOW(3,"Snow","13"),
	HAZY(4,"Hazy","03"),
	CLEAR(5,"Clear","01"),
	CLOUDY(6,"Partly Cloudy","02"),
	OVERCAST(7,"Overcast","04"),
	TORNDADO(8,"Tornado","50"),
	STORM(9,"Severe Storm","11"),
	WINDY(10,"Windy","50");
	
	final private int id;
	final private String name;
	final private String code;
	
	private weatherCondition (final int id, final String name, final String code){
		this.id=id;
		this.name=name;
		this.code=code;
	}
	
	
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getCode(){
		return this.code;
	}
	
	
}