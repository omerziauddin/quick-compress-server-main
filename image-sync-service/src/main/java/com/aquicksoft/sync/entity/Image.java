package com.aquicksoft.sync.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Image {

	@Id
	private String id;
	private Long hbId;
	private String txId;
	private String userId;
	private Integer portalId;
	private String name;
	private Integer size;
	private Integer height;
	private Integer width;
	private String encoding;
	private String type;
	private String extension;
	private String cloudKey;
	private String s3Url;
	private String friendlyUrl;
	private String altKey;
	private String altKeyHash;
	private String title;
	private Long created;
	private Long updated;
	private Integer deletedAt;
	private Long folderId;
	private Boolean hidden;
	private String cloudKeyHash;
	private Boolean archived;
	private String createdBy;
	private String deletedBy;
	private Boolean replaceable;
	private String defaultHostingUrl;
	private Boolean isIndexable;
	private String url;
	private String cdnPurgeEmbargoTime;
	private String fileHash;
}
