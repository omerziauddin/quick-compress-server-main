package com.aquicksoft.sync.rmp.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.aquicksoft.sync.rmp.model.Stats;

@Service
public class StatsProducer {
	@Value("${application.queue.stats}")
	String statsqueue;

	@Autowired
	RabbitTemplate rabbitTemplate;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Async
	public void produce(final Stats stats) {

		rabbitTemplate.convertAndSend(statsqueue, stats);
		logger.info("Sending the following event object to the queue:qcNewImageFound " + stats);

	}

}
