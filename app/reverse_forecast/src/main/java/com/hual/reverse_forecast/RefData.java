package com.hual.reverse_forecast;
public class RefData {

	private int id;
	private String name;
	private String code;

	public RefData(){
		super();
	}
	public RefData(int id, String name, String code){
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
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setCode(String code){
		this.code=code;
	}
}