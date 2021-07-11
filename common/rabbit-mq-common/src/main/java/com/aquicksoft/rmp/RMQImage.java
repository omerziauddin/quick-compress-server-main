package com.aquicksoft.rmp;

import java.io.Serializable;

import lombok.Data;

@Data
public class RMQImage implements Serializable{

    private String userId;
    private String txId;
    private String imageId;
    private String url;

}
