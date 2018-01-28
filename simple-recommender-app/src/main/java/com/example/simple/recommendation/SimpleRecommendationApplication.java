package com.example.simple.recommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleRecommendationApplication {

	public static void main(String[] args) {
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//
//		DataLoader loader = new DataLoaderImpl(context);
//		loader.loadData();
//		
//		context.close();
		SpringApplication.run(SimpleRecommendationApplication.class, args);
	}
}
