package com.yadav.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
public class kafkaConfig {

	@Value("${kafka.serveripaddress}")
	private String kafkaServerIPaddress;

	@Value("${kafka.groupid}")
	private String groupId;

	@Value("${kafka.autooffsetresetconfig}")
	private String autoOffSetResetConfig;

	// But with the introduction of AdminClient in Kafka, we can now create topics
	// programmatically.
	// We need to add the KafkaAdmin Spring bean, which will automatically add
	// topics for all beans of type NewTopic:

	@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerIPaddress);
		return new KafkaAdmin(configs);
	}


	 @Bean public NewTopic topic() { 
		 return new NewTopic("Darshan", 1, (short)1);
	  }

	// producer configuration
	// To create messages, first, we need to configure a ProducerFactory which sets
	// the strategy for creating Kafka Producer instances.
	// Then we need a KafkaTemplate which wraps a Producer instance and provides
	// convenience methods for sending messages to Kafka topics.

	// Producer instances are thread-safe and hence using a single instance
	// throughout an application context will give higher performance.
	// Consequently, KakfaTemplate instances are also thread-safe and use of one
	// instance is recommended.
	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerIPaddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	// Kafka Consumer configuration
	/*
	 * For consuming messages, we need to configure a ConsumerFactory and a
	 * KafkaListenerContainerFactory. Once these beans are available in the Spring
	 * bean factory, POJO based consumers can be configured using @KafkaListener
	 * annotation.
	 * 
	 * @EnableKafka annotation is required on the configuration class to enable
	 * detection of @KafkaListener annotation on spring managed beans:
	 * 
	 */

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {

		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerIPaddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffSetResetConfig);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props);

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
