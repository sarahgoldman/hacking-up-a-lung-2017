package com.hual.reverse_forecast;

import java.util.stream.*;
import java.util.regex.Pattern;

import org.json.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.springframework.http.*;

import com.hual.reverse_forecast.*;
import java.util.*;


//rest imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

@RestController
public class forecastController {
	
	final String API_KEY="0489bc17961e9fcdbf47739f13ffe10e";
	final int[][] OPTION_CODES={{200,201,202,210,211,212,221,230,231,232},									//THUNDER
								{300,301,302,310,500},														//DRIZZLE
								{311,312,313,314,321,501,502,503,504,511,520,521,522,531,611,612,615,616},	//RAIN
								{511,600,601,602,611,612,615,616,620,621,622},								//SNOW
								{701,711,721,731,741,751,761,762,771},										//HAZY
								{800},																		//CLEAR
								{801,802},																	//CLOUDY
								{803,804},																	//OVERCAST
								{900},																		//TORNADO
								{901,902,960,961,962},														//STORM
								{905,956,957,958,959}};														//WINDY
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }
	
	private BufferedReader getRest(String url){
		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url+"&APPID="+API_KEY);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			return rd;
		}
		catch(Exception e){
			return null;
		}
	}
	
	@CrossOrigin
	@RequestMapping(path="/conditions", method = RequestMethod.GET)
    public ResponseEntity<List<RefData>> getWeatherOptions() {
		List<RefData> a = new ArrayList<RefData>();
		for(weatherCondition c: weatherCondition.values()){
			a.add(new RefData(c.getId(), c.getName()));
		}
		
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
	/*
	@CrossOrigin
	@RequestMapping(path="/search/city", method = RequestMethod.GET)
    public ResponseEntity<List<RefData>> getWeatherOptions(@RequestParam(value="option",required=true) final int id, @RequestParam(value="city",required=true) final int id ) {
		String url = "http://api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10";
		String json = "";
		BufferedReader rd = getRest(url);
		try{
			json = rd.lines().collect(Collectors.joining());
		}
		catch(Exception e){
		}
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
	
	@CrossOrigin
	@RequestMapping(path="/search/box", method = RequestMethod.GET)
    public ResponseEntity<List<RefData>> getWeatherOptions(@RequestParam(value="lat",required=true) final int lat, @RequestParam(value="lon",required=true) final int lon ) {
		String url = "http://api.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10";
		String json = "";
		BufferedReader rd = getRest(url);
		try{
			json = rd.lines().collect(Collectors.joining());
		}
		catch(Exception e){
		}
        return new ResponseEntity<>(a,HttpStatus.OK);
    }*/
	
	@CrossOrigin
	@RequestMapping(path="/places", method = RequestMethod.GET)
    public ResponseEntity<List<Place>> searchCircle(@RequestParam(value="option",required=true) final int option, @RequestParam(value="lat",required=true) final double lat, @RequestParam(value="lon",required=true) final double lon ) {
		String url = "http://api.openweathermap.org/data/2.5/find?lat="+lat+"&lon="+lon+"&cnt=50";
		String json = "";
		BufferedReader rd = getRest(url);
		List<Place> places = new ArrayList<Place>();
		try{
			String line = "";
			while((line = rd.readLine()) != null){
				json+=line+"\n";
			} 
			String[] names = json.split("\"name\":\"");
			for(String s: names){
				System.out.println("aa "+s);
				int codeId =-1;
				String code="";
				try{
					System.out.println(s.split(Pattern.quote("weather\":{[\"id\":"))[0]);
					code = s.split(Pattern.quote("weather\":[{\"id\":"))[1].substring(0,3);
					codeId = Integer.parseInt(code);
				}
				catch (Exception e){
					System.out.println("==================================================================");
					e.printStackTrace();
					continue;
				}
				System.out.println(s.substring(0,10)+"--"+code);
				for(int n = 0; n < OPTION_CODES[option].length; n++){
					if(OPTION_CODES[option][n] == codeId){//matches
						//find name
						int name_end = s.indexOf('\"');
						String name = s.substring(0,name_end);
						
						//find country
						//null
						
						//find id
						//null
						
						//find location
						//find lat
						String coordA = s.split("lat\":")[1];
						int lat_end = coordA.indexOf(',');
						double latt = Double.parseDouble(coordA.substring(0,lat_end));
						
						//find lon
						String coordB = s.split("lon\":")[1];
					int lon_end = coordB.indexOf('}');
						double lonn = Double.parseDouble(coordB.substring(0,lon_end));
						Location loc = new Location(latt,lonn);
						Place place = new Place(name, null, null, loc);
						places.add(place);
						
					}
				}
				
			}
			
			//json = rd.lines().collect(Collectors.joining());
		}
		catch(Exception e){
			System.out.println("ERROR==============================================================");
			e.printStackTrace();
		}
		
        return new ResponseEntity<>(places,HttpStatus.OK);
    }
}



