package com.yadav.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yadav.kafka.producer.KafkaProducerService;

@RestController
@SpringBootApplication
public class SpringBootMainApplication {
	
	@Autowired
	private KafkaProducerService kafkaProducerService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}
	
	@GetMapping("/post")
	public void postMessage(@RequestBody String message) {
		System.out.println("reached controller");
		kafkaProducerService.sendMessage("Darshan", message);
		
	}

}
