package com.aquicksoft.sync.rmp.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aquicksoft.sync.rmp.model.TransactionRequest;
import com.aquicksoft.sync.service.SyncService;

@Service
public class TransactionListener {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SyncService syncService;

	@RabbitListener(queues = "${application.queue.transaction}")
	public void transaction(final TransactionRequest transactionRequest) {
		logger.info("successfully received from queue: QC_TASK_START" + transactionRequest);
		syncService.syncData(transactionRequest);
	}
}
