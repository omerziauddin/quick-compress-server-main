package com.aquicksoft.sync.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigPublishStats {

	@Value("${application.queue.stats}")
	String qcStatsUpdate;

	@Bean
	Queue queueStatsUpdate() {
		return new Queue(qcStatsUpdate);
	}

	@Bean
	Jackson2JsonMessageConverter producerJackson2MessageConverterStatsUpdate() {
		return new Jackson2JsonMessageConverter();
	}
}
