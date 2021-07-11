
package com.aquicksoft.sync.model;

import java.util.List;

import lombok.Data;

@Data
public class HBBaseRessponse {

	public Long limit;
	public Long offset;
	public List<HBPicture> objects;
	public Long total_count;

}
