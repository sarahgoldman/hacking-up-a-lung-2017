package com.hual.reverse_forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@RestController
@SpringBootConfiguration
public class ReverseForecastApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ReverseForecastApplication.class);
    }


	public static void main(String[] args) {
		SpringApplication.run(ReverseForecastApplication.class, args);
	}
}

@RestController
class GreetingController {
    
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/test")
    String test() {
        return "test!";
    }
}