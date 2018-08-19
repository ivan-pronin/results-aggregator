package com.sportmonks.client.rest.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmonks.client.core.exception.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class SportmonksRestService implements ISportmonksRestService {

    private static final Logger log = LoggerFactory.getLogger(SportmonksRestService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public <T> List<T> callForEntities(String url, Class<T[]> clazz) {
        try {
            return Arrays.asList(objectMapper.treeToValue(getNode(url), clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public <T> Optional<T> callForEntity(String url, Class<T> clazz) {
        try {
            return Optional.of(objectMapper.treeToValue(getNode(url), clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private JsonNode getNode(String url) {
        String responseBody = callForPath(url);
        System.out.println("RESPONSE: " + responseBody);
        try {
            return objectMapper.readTree(responseBody).path("data");
        } catch (IOException e) {
            throw new ParseException("Failed to get <data> node", e);
        }
    }

    private String callForPath(String url) {
        log.info("Executing call for url: " + url);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        log.info("Status code: " + response.getStatusCode().value());
        return response.getBody();
    }
}
