package com.aquicksoft.sync.rmp.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.aquicksoft.rmp.RMQImage;

@Service
public class ImageProducer {
	@Value("${application.queue.found}")
	String qcNewImageFound;

	@Autowired
	RabbitTemplate rabbitTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Async
	public void produce(final RMQImage rmqImage) {

		rabbitTemplate.convertAndSend(qcNewImageFound, rmqImage);
		logger.info("Sending the following event object to the queue:qcNewImageFound " + rmqImage);
	}

}
