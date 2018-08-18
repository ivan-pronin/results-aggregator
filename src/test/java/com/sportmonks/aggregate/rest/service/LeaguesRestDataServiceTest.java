package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.League;
import com.sportmonks.aggregate.rest.RestConfiguration;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestConfiguration.class)
public class LeaguesRestDataServiceTest {

    private static final int SUPERLIGA_ID = 271;
    private static final String API_URL = "https://soccer.sportmonks.com/api/";
    private static final String VERSION = "v2.0/";
    private static final String API_TOKEN = "01pV76Qt4NZe3ay5eRSaqq8cQl8objq2zjEqZc0YE7Sj7WbMkww3uoXBbq8s";
    private final String URL = "https://soccer.sportmonks.com/api/v2.0/leagues/271?api_token=01pV76Qt4NZe3ay5eRSaqq8cQl8objq2zjEqZc0YE7Sj7WbMkww3uoXBbq8s";

    @Autowired
    private AbstractLeaguesRestDataService dataService;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void getAllTest() {
        List<League> leagues = dataService.getAll();
        Assert.assertEquals(2, leagues.size());
        Assert.assertNotNull(leagues.get(1));
        Assert.assertThat(leagues.stream().anyMatch(l -> l.getId() == SUPERLIGA_ID), CoreMatchers.is(true));
    }

    @Test
    public void getByIdTest() {
        Optional<League> league = dataService.getById(SUPERLIGA_ID);
        Assert.assertTrue(league.isPresent());
        Assert.assertNotNull(league.get());
    }
//
//    @Test
//    public void rawRestTest() {
//        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
//        HttpStatus statusCode = response.getStatusCode();
//        System.out.println("Statuc code:" + statusCode);
//        Assert.assertEquals(200, statusCode.value());
//        System.out.println("Response: " + response.getBody());
//    }
//
//    @Test
//    public void uriBuilderRestTest() {
//        UriComponents uriComponents = UriComponentsBuilder.fromUriString(URL).build();
//        ResponseEntity<String> response = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
//        HttpStatus statusCode = response.getStatusCode();
//        System.out.println("Statuc code:" + response.getStatusCode());
//        Assert.assertEquals(200, statusCode.value());
//        System.out.println("Response: " + response.getBody());
//    }
//
//    @Test
//    public void uriBuilderConfiguredRestTest() {
//        UriComponentsBuilder builder =  UriComponentsBuilder.fromUriString(API_URL + VERSION).queryParam("api_token", API_TOKEN)
//                .path("leagues/271");
//        UriComponents uriComponents = builder.build();
//        ResponseEntity<String> response = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
//        HttpStatus statusCode = response.getStatusCode();
//        System.out.println("Statuc code:" + response.getStatusCode());
//        Assert.assertEquals(200, statusCode.value());
//        System.out.println("Response: " + response.getBody());
//    }

}