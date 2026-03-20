package com.deshdarshan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeshDarshanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeshDarshanApplication.class, args);
        System.out.println("===========================================");
        System.out.println("  DeshDarshan Backend is running!");
        System.out.println("  API available at: http://localhost:8080");
        System.out.println("===========================================");
    }
}
