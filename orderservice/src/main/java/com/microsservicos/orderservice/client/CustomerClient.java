package com.microsservicos.orderservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CustomerClient {

    private final WebClient webClient;

    public CustomerClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:8081").build();
    }

    public boolean isCustomerValid(Long customerId) {
        try {
            return webClient.get()
                    .uri("/api/customers/{id}", customerId)
                    .retrieve()
                    .toBodilessEntity() // não importa o conteúdo, só o status
                    .map(response -> true)
                    .onErrorReturn(false)
                    .block(); // executa de forma síncrona (simples pra esse caso)
        } catch (Exception e) {
            return false;
        }
    }
}
