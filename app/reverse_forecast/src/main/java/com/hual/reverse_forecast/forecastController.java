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

@RestController
public class forecastController {
    
    @RequestMapping("/")
    public String home() {
        return "index";
    }
	
	@RequestMapping(path="/conditions", method = RequestMethod.GET)
    public ResponseEntity<List<RefData>> test() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

