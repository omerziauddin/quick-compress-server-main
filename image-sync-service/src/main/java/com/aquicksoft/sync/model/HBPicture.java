
package com.aquicksoft.sync.model;

import lombok.Data;

@Data
public class HBPicture {

	private Long id;
	private String txId;
	private String userId;
	private Integer portal_id;
	private String name;
	private Integer size;
	private Integer height;
	private Integer width;
	private String encoding;
	private String type;
	private String extension;
	private String cloud_key;
	private String s3_url;
	private String friendly_url;
	private String alt_key;
	private String alt_key_hash;
	private String title;
	private Long created;
	private Long updated;
	private Integer deleted_at;
	private Long folder_id;
	private Boolean hidden;
	private String cloud_key_hash;
	private Boolean archived;
	private String createdBy;
	private String deletedBy;
	private Boolean replaceable;
	private String default_hosting_url;
	private Boolean is_indexable;
	private String url;
	private String cdn_purge_embargo_time;
	private String file_hash;

}
