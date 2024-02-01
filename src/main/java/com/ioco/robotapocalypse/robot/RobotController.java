package com.ioco.robotapocalypse.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/robots")
public class RobotController {

    private final String apiUrl = "https://jsonplaceholder.typicode.com/todos/1"; // Replace with your JSON API URL

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/data")
    public String fetchData() {
        String jsonData = restTemplate.getForObject(apiUrl, String.class);
        return jsonData;
    }
}

