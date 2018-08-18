package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Country;
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
public class CountriesRestDataServiceTest {

    @Autowired
    private IGetByIdOrAllRestDataService<Country> dataService;

    @Test
    public void getAllTest() {
        List<Country> entities = dataService.getAll();
        Assert.assertNotNull(entities.get(0));
    }

    @Test
    public void getByIdTest() {
        Optional<Country> entity = dataService.getById(2);
        Assert.assertTrue(entity.isPresent());
        Assert.assertNotNull(entity.get());
    }
}