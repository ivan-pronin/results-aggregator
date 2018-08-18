package com.sportmonks.aggregate.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmonks.aggregate.BootApplication;
import com.sportmonks.aggregate.core.data.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.function.Supplier;

@Configuration
@ComponentScan("com.sportmonks.aggregate.rest")
public class RestConfiguration {

    private static final Logger log = LoggerFactory.getLogger(BootApplication.class);
    private static final String API_URL = "https://soccer.sportmonks.com/api/";
    private static final String VERSION = "v2.0/";
    private static final String API_TOKEN = "01pV76Qt4NZe3ay5eRSaqq8cQl8objq2zjEqZc0YE7Sj7WbMkww3uoXBbq8s";

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return new RestTemplate();
    }

    @Bean
    public Supplier<UriComponentsBuilder> uriComponentsBuilderSupplier() {
        return this::uriComponentsBuilder;
    }

    @Bean
    @Scope("prototype")
    UriComponentsBuilder uriComponentsBuilder() {
        return UriComponentsBuilder.fromUriString(API_URL + VERSION).queryParam("api_token", API_TOKEN);
    }

    //    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
