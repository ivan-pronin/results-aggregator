package com.sportmonks.client.rest.service.generic.by.season;

import com.sportmonks.client.rest.SportmonksRestClientConfiguration;
import com.sportmonks.client.rest.service.generic.IGetByIdOrSeasonRestDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SportmonksRestClientConfiguration.class)
public abstract class GenericGetBySeasonRestDataServiceTest<T> {

    long entityIdToCheck;
    long seasonIdToCheck;

    @Autowired
    IGetByIdOrSeasonRestDataService<T> dataService;

    @Test
    public void getBySeasonIdTest() {
        List<T> entities = dataService.getBySeasonId(seasonIdToCheck);
        Assert.assertNotNull(entities.get(0));
    }

    @Test
    public void getByIdTest() {
        Optional<T> entity = dataService.getById(entityIdToCheck);
        Assert.assertTrue(entity.isPresent());
        Assert.assertNotNull(entity.get());
    }
}