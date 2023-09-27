package com.example.kafkawikimediaproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public Object send(String topic, String message) {
    return kafkaTemplate.send(topic, message);
  }

}
