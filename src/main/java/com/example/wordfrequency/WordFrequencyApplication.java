package com.example.wordfrequency;

import Controller.WordFrequencyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = WordFrequencyController.class,
		basePackages = {"com.example.wordfrequency"})
public class WordFrequencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordFrequencyApplication.class, args);
	}

}
