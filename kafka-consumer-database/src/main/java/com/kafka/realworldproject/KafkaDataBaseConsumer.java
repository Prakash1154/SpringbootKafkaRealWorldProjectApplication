package com.kafka.realworldproject;

import com.kafka.realworldproject.entity.WikiMediaEntity;
import com.kafka.realworldproject.repository.WikiMediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDataBaseConsumer {

    private WikiMediaRepository dataRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDataBaseConsumer.class);

    @Autowired
    public KafkaDataBaseConsumer(WikiMediaRepository wikiMediaRepository) {
        this.dataRepository = wikiMediaRepository;
    }
    @KafkaListener(topics = "MynewTopic", groupId = "myGroupId")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        WikiMediaEntity wikiMediaEntity =  new WikiMediaEntity();
        wikiMediaEntity.setWikimediaData(eventMessage);
        this.dataRepository.save(wikiMediaEntity);
    }

}
