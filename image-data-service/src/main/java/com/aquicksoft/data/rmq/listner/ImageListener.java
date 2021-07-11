package com.aquicksoft.data.rmq.listner;


import com.aquicksoft.rmp.RMQImage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ImageListener {


    @RabbitListener(queues = "QC_NEW_IMAGE_FOUND")
    public void listenNewImages(RMQImage rmqImage){

    }
}
