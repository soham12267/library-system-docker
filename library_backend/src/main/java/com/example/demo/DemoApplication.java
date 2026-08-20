package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan; // Import this!

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "com.library"}) // Tells the radar to look at your library code!
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}