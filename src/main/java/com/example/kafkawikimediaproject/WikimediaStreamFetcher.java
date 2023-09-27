package com.example.kafkawikimediaproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Component
public class WikimediaStreamFetcher {
  @Autowired
  private KafkaProducerService service;

  private final WebClient webClient;

  public WikimediaStreamFetcher() {
    this.webClient = WebClient.builder().baseUrl("https://stream.wikimedia.org/v2").build();
  }

  @Scheduled(fixedDelay = 10000) // adjust the delay as needed
  public void fetchStreamAndPublishToKafka() {
    Flux<String> stream = webClient.get()
        .uri("/stream/recentchange")
        .retrieve()
        .bodyToFlux(String.class);

    stream.subscribe(message -> service.send("wikimedia-recent-changes", message));
  }
}
