package com.yadav.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {


  @KafkaListener(topics = "Darshan", groupId = "DarshanGroupID")	
  public void listen(String message) {
	  System.out.println("Message Consumed from Kafka: " + message);
  }
	
	
}
