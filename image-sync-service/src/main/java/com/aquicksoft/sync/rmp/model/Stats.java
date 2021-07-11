package com.aquicksoft.sync.rmp.model;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class Stats implements Serializable {

	private String action;
	private String txId;
	private List<String> imageStats;

}
