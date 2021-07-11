package com.aquicksoft.sync.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigPublishNewImage {

	@Value("${application.queue.found}")
	String qcNewImageFound;

	@Bean
	Queue queueNewImage() {
		return new Queue(qcNewImageFound);
	}

	@Bean
	Jackson2JsonMessageConverter producerJackson2MessageConverterNewImag() {
		return new Jackson2JsonMessageConverter();
	}
}
