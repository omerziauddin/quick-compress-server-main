package com.aquicksoft.sync;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aquicksoft.sync.service.SyncService;

@SpringBootApplication
public class SyncApplication {

	@Autowired
	SyncService syncService;

	public static void main(String[] args) {
		SpringApplication.run(SyncApplication.class, args);
	}

}
