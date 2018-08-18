package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Continent;
import com.sportmonks.aggregate.rest.RestConfiguration;
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
public class ContinentsRestDataServiceTest {

    @Autowired
    private IGetByIdOrAllRestDataService<Continent> dataService;

    @Test
    public void getAllTest() {
        List<Continent> entities = dataService.getAll();
        Assert.assertNotNull(entities.get(0));
    }

    @Test
    public void getByIdTest() {
        Optional<Continent> league = dataService.getById(1);
        Assert.assertTrue(league.isPresent());
        Assert.assertNotNull(league.get());
    }
}