package com.aquicksoft.sync.config;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.aquicksoft.sync.rmp.listner.TransactionListener;

@SuppressWarnings("unused")

@Configuration
public class BeanConfigListen implements RabbitListenerConfigurer {

	@Bean
	public MappingJackson2MessageConverter mappingJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

	@Bean
	public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory handlerMethodFactory = new DefaultMessageHandlerMethodFactory();
		handlerMethodFactory.setMessageConverter(mappingJackson2MessageConverter());
		return handlerMethodFactory;
	}

	@Override
	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
		rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
	}

	@Autowired
	private TransactionListener transactionListener;
}

