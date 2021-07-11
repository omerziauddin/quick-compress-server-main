package com.aquicksoft.sync.service;

import com.aquicksoft.sync.entity.Image;
import com.aquicksoft.sync.model.HBPicture;
import com.aquicksoft.sync.rmp.model.TransactionRequest;

public class HBImageMapper {

	public static Image map(HBPicture hbPicture, TransactionRequest transactionRequest) {
		Image image = new Image();
		image.setArchived(hbPicture.getArchived());
		image.setAltKey(hbPicture.getAlt_key());
		image.setAltKeyHash(hbPicture.getAlt_key_hash());
		image.setCloudKey(hbPicture.getCloud_key());
		image.setCreated(hbPicture.getCreated());
		image.setCloudKeyHash(hbPicture.getCloud_key_hash());
		image.setCdnPurgeEmbargoTime(hbPicture.getCdn_purge_embargo_time());
		image.setCreatedBy(hbPicture.getCreatedBy());
		image.setDeletedAt(hbPicture.getDeleted_at());
		image.setDefaultHostingUrl(hbPicture.getDefault_hosting_url());
		image.setEncoding(hbPicture.getEncoding());
		image.setExtension(hbPicture.getExtension());
		image.setDeletedBy(hbPicture.getDeletedBy());
		image.setFileHash(hbPicture.getFile_hash());
		image.setFolderId(hbPicture.getFolder_id());
		image.setFriendlyUrl(hbPicture.getFriendly_url());
		image.setHeight(hbPicture.getHeight());
		image.setHbId(hbPicture.getId());
		image.setIsIndexable(hbPicture.getIs_indexable());
		image.setPortalId(hbPicture.getPortal_id());
		image.setWidth(hbPicture.getWidth());
		image.setUserId(transactionRequest.getUserId());
		image.setUrl(hbPicture.getUrl());
		image.setUpdated(hbPicture.getUpdated());
		image.setType(hbPicture.getType());
		image.setTxId(transactionRequest.getTxId());
		image.setTitle(hbPicture.getTitle());
		image.setSize(hbPicture.getSize());
		image.setReplaceable(hbPicture.getReplaceable());
		image.setName(hbPicture.getName());

		return image;
	}
}
