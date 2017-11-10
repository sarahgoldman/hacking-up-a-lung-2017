package com.hual.reverse_forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootConfiguration
public class ReverseForecastApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


	public static void main(String[] args) {
		SpringApplication.run(ReverseForecastApplication.class, args);
	}
}
