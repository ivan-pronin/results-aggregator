package com.sportmonks.client.rest.service;

import com.sportmonks.client.core.data.entity.Fixture;
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
public class Head2HeadRestDataServiceTest {

    private static final int TEAM1_ID = 2394;
    private static final int TEAM2_ID = 7466;

    @Autowired
    private IHead2HeadRestDataService dataService;

    @Test
    public void getHead2HeadTest() {
        List<Fixture> entities = dataService.get(TEAM1_ID, TEAM2_ID);
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getLocalteamId() == TEAM1_ID));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getVisitorteamId() == TEAM2_ID));
    }

}