package com.hual.reverse_forecast;
public class RefData {

	private int id;
	private String name;

	public RefData(){
		super();
	}
	public RefData(int id, String name){
		this.id=id;
		this.name=name;
	}
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name=name;
	}
}