package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.core.data.entity.League;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class LeaguesGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<League> {

    private static final int SUPERLIGA_ID = 271;

    @Before
    public void before() {
        super.entityIdToCheck = SUPERLIGA_ID;
    }

    @Override
    @Test
    public void getAllTest() {
        List<League> entities = dataService.getAll();
        Assert.assertEquals(2, entities.size());
        Assert.assertNotNull(entities.get(1));
        Assert.assertThat(entities.stream().anyMatch(l -> l.getId() == SUPERLIGA_ID), CoreMatchers.is(true));
    }
}