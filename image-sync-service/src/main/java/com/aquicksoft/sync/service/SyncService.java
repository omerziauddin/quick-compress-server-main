package com.aquicksoft.sync.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aquicksoft.rmp.RMQImage;
import com.aquicksoft.sync.entity.Image;
import com.aquicksoft.sync.model.HBBaseRessponse;
import com.aquicksoft.sync.model.HBPicture;
import com.aquicksoft.sync.repository.ImageRepository;
import com.aquicksoft.sync.rmp.model.Stats;
import com.aquicksoft.sync.rmp.model.TransactionRequest;
import com.aquicksoft.sync.rmp.producer.ImageProducer;
import com.aquicksoft.sync.rmp.producer.StatsProducer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Service
public class SyncService {

	@Value("${application.fileAccept}")
	private List<String> acceptFileType;

	@Value("${application.limit}")
	private int limit;

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	public ImageRepository imageRepository;

	@Autowired
	public ImageProducer imageProducer;

	@Autowired
	public StatsProducer statsProducer;

	public void syncData(TransactionRequest transactionRequest) {

		List<HBPicture> imageList = hbImageUpdateGateway(transactionRequest.getHbKey());
		for (HBPicture image : imageList) {

			if (!imageRepository.existsByHbId(image.getId())
					&& getAcceptFileType().contains(image.getExtension().toLowerCase())) {
				Image img = HBImageMapper.map(image, transactionRequest);
				imageRepository.save(img);
				image.setUserId(transactionRequest.getUserId());
				image.setTxId(transactionRequest.getTxId());
				produceImage(image);
				produceStats(image);
			}

		}

	}

	public List<HBPicture> hbImageUpdateGateway(String hbKey) {
		int totalCount = 0;
		int treveser = 0;
		int offset = 0;

		List<HBPicture> imageList = new ArrayList<>();
		for (int i = 0; i <= treveser; i++) {

			offset = i * limit;

			String url = "https://api.hubapi.com/filemanager/api/v2/" + "files?type=IMG&limit=" + limit + "&hapikey="
					+ hbKey + "&offset=" + offset;
			log.info(url);
			HBBaseRessponse forObject = restTemplate.getForObject(url, HBBaseRessponse.class);
			totalCount = forObject.total_count.intValue();
			if (totalCount > 0) {
				treveser = totalCount / limit;
			}
			imageList.addAll(forObject.getObjects());

		}
		return imageList;
	}

	private void produceImage(HBPicture image) {
		RMQImage rmqImage = new RMQImage();

		rmqImage.setImageId(Long.toString(image.getId()));
		rmqImage.setTxId(image.getTxId());
		rmqImage.setUrl(image.getUrl());
		rmqImage.setUserId(image.getUserId());

		imageProducer.produce(rmqImage);

	}

	private void produceStats(HBPicture image) {
		Stats stats = new Stats();

		List<String> statList = new ArrayList<String>();
		statList.add(Long.toString(image.getId()));
		statList.add(Integer.toString(image.getSize()));
		statList.add(image.getName());
		statList.add(image.getUrl());

		stats.setAction("NEW_IMAGE_FOUND");
		stats.setTxId(image.getTxId());
		stats.setImageStats(statList);

		statsProducer.produce(stats);

	}

}
