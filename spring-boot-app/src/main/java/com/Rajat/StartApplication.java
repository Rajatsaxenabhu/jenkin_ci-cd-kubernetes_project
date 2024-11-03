package com.rajat; // Ensure this is specified

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@Controller
public class StartApplication {

    @GetMapping("/")
    public String index(final Model model) {
        // Add attributes to the model
        model.addAttribute("title", "I have successfully built a Spring Boot application using Maven");
        model.addAttribute("msg", "This application is project to be deployed on to Kubernetes using Argo CD");
        // Format current timestamp to AM/PM format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a").withZone(ZoneId.of("Asia/Kolkata")); // India time zone
        String formattedTime = formatter.format(Instant.now()); // Use Instant.now() for current time
        
        // Concatenate the message with the formatted time
        model.addAttribute("timestamp", "Current time of India is " + formattedTime); // Add formatted time to model
        
        model.addAttribute("project_developer", "Rajat saxena");
        return "index";
    }
    
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
