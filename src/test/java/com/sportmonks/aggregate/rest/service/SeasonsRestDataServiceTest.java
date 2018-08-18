package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Season;
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
public class SeasonsRestDataServiceTest {

    @Autowired
    private IGetByIdOrAllRestDataService<Season> dataService;

    @Test
    public void getAllTest() {
        List<Season> entities = dataService.getAll();
        Assert.assertNotNull(entities.get(0));
    }

    @Test
    public void getByIdTest() {
        Optional<Season> entity = dataService.getById(1273);
        Assert.assertTrue(entity.isPresent());
        Assert.assertNotNull(entity.get());
    }
}