package com.eray;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/greeting")
public class Greeting {
	@GetMapping(path="/", produces = "application/json")
    public String[] getEmployees() 
    {
        return new String[] {
        		"Allah", "Ackbar"
        };
    }
}
