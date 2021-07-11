package com.aquicksoft.sync.rmp.model;

import lombok.Data;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class TransactionRequest implements Serializable {

	private String userId;
	private String txId;
	private String hbKey;

	@JsonCreator
	public TransactionRequest(@JsonProperty("txId") final String txId, @JsonProperty("userId") final String userId,
			@JsonProperty("hbKey") final String hbKey) {
		this.txId = txId;
		this.userId = userId;
		this.hbKey = hbKey;
	}
}
