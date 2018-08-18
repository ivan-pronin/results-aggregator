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

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestConfiguration.class)
public class LeaguesRestDataServiceTest {

    private static final int SUPERLIGA_ID = 271;

    @Autowired
    private IGetByIdOrAllRestDataService<League> dataService;

    @Test
    public void getAllTest() {
        List<League> entities = dataService.getAll();
        Assert.assertEquals(2, entities.size());
        Assert.assertNotNull(entities.get(1));
        Assert.assertThat(entities.stream().anyMatch(l -> l.getId() == SUPERLIGA_ID), CoreMatchers.is(true));
    }

    @Test
    public void getByIdTest() {
        Optional<League> entity = dataService.getById(SUPERLIGA_ID);
        Assert.assertTrue(entity.isPresent());
        Assert.assertNotNull(entity.get());
    }
}