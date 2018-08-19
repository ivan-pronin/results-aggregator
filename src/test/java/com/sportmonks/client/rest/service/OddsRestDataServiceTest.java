package com.sportmonks.client.rest.service;

import com.sportmonks.client.core.data.entity.Offer;
import com.sportmonks.client.rest.SportmonksRestClientConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SportmonksRestClientConfiguration.class)
public class OddsRestDataServiceTest {

    private static final int FIXTURE_ID = 10328740;
    private static final int BOOKMAKER_ID = 2;  // bet365
    private static final int MARKET_ID = 1; //3Way Result

    @Autowired
    private IOddsRestDataService dataService;

    @Test
    public void getByFixtureAndBookmakerId() {
        List<Offer> entities = dataService.getByFixtureAndBookmakerId(FIXTURE_ID, BOOKMAKER_ID);
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getBookmaker().getData().stream()
                .anyMatch(b -> b.getId() == BOOKMAKER_ID)));
    }

    @Test
    public void getByFixtureId() {
        List<Offer> entities = dataService.getByFixtureId(FIXTURE_ID);
        Assert.assertThat(entities, is(not(empty())));
    }

    @Test
    public void getByFixtureAndMarketId() {
        List<Offer> entities = dataService.getByFixtureAndMarketId(FIXTURE_ID, MARKET_ID);
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getName().equals("3Way Result")));
    }
}