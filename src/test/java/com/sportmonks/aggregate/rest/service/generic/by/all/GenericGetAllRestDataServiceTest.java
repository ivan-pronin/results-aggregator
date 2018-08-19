package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.rest.RestConfiguration;
import com.sportmonks.aggregate.rest.service.generic.IGetByIdOrAllRestDataService;
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
public abstract class GenericGetAllRestDataServiceTest<T> {

    long entityIdToCheck;

    @Autowired
    IGetByIdOrAllRestDataService<T> dataService;

    @Test
    public void getAllTest() {
        List<T> entities = dataService.getAll();
        Assert.assertNotNull(entities.get(0));
    }

    @Test
    public void getByIdTest() {
        Optional<T> entity = dataService.getById(entityIdToCheck);
        Assert.assertTrue(entity.isPresent());
        Assert.assertNotNull(entity.get());
    }
}