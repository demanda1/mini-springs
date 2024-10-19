package org.example.restbasic;


import org.example.restbasic.requests.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    public static AtomicLong counter = new AtomicLong();

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name") String name ){
        return new Greeting( String.valueOf(counter.incrementAndGet()), name);
    }

    @GetMapping("/search")
    public String searchGoogle(@RequestParam(value="query") String query) {
        String url = "https://www.google.co.in/search?q=" + query;

        ResponseEntity<String> response =  restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
