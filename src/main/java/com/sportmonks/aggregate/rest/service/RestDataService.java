package com.sportmonks.aggregate.rest.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmonks.aggregate.core.data.entity.Fixture;
import com.sportmonks.aggregate.core.data.entity.League;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RestDataService {

    private static final Logger log = LoggerFactory.getLogger(RestDataService.class);
    private static final String API_URL = "https://soccer.sportmonks.com/api/";
    private static final String VERSION = "v2.0/";
    private static final String PATH = "leagues";
    public static final String COMMON_URL_PARAMS = "?api_token=01pV76Qt4NZe3ay5eRSaqq8cQl8objq2zjEqZc0YE7Sj7WbMkww3uoXBbq8s";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UriComponentsBuilder uriComponentsBuilder;
    @Autowired
    private ObjectMapper objectMapper;

    public Fixture getFixture() {
        ResponseEntity<String> response = restTemplate.exchange(
                uriComponentsBuilder.toUriString(),
                HttpMethod.GET,
                null,
                String.class);
        log.info("Status code: " + response.getStatusCode().value());
        try {
            JsonNode data = objectMapper.readTree(response.getBody()).path("data");
            return objectMapper.treeToValue(data, Fixture.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<League> getLeagues() {
        String url = API_URL + VERSION + PATH + COMMON_URL_PARAMS;
        System.out.println("URL: " + url);
        ResponseEntity<String> response = restTemplate.getForEntity(
                url,
                String.class);
        log.info("Status code: " + response.getStatusCode().value());
        String responseBody = response.getBody();
        log.info("Leagues: " + responseBody);
        JsonNode data;
        List<League> result = new ArrayList<>();
        try {
            data = objectMapper.readTree(responseBody).path("data");
            result = Arrays.asList(objectMapper.treeToValue(data, League[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void debugJackson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String newJsonString = "{\"id\":1,\"name\":\"Program @# 1\",\"ownerId\":1,\"contents\":\"Some contents\"}";
        League league = mapper.readValue(newJsonString, League.class);
        System.out.println("League: " + league);
    }

}
