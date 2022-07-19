package com.example.demo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @GetMapping("/")
    public String helloClient(){
        String url = "http://name:8081";
        RestTemplate restTemplate = new RestTemplate();
        String name = restTemplate.getForObject(url,String.class);
        return "Hello " + name;
    }
}
