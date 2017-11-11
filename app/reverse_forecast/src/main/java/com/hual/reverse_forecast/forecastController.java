package com.hual.reverse_forecast;

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
	
	@RequestMapping(path="/test", method = RequestMethod.GET)
    public ResponseEntity<Void> test() {
		String url = "http://api.openweathermap.org/data/2.5/find?lat=38.88&lon=77.09&cnt=50";
		List<RefData> a = new ArrayList<RefData>();
		String line = "";
		BufferedReader rd = getRest(url);
		try{
			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
		}
		catch(Exception e){
		}
		
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

