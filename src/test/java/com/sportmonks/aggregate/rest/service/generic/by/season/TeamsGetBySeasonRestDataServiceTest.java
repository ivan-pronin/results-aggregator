package com.sportmonks.aggregate.rest.service.generic.by.season;

import com.sportmonks.aggregate.core.data.entity.Team;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class TeamsGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Team> {

    @Before
    public void before() {
        super.entityIdToCheck = 2394;
        super.seasonIdToCheck = 6361;
    }

    @Test
    public void getByIdIncludesTest() {
        Optional<Team> entity = dataService.getById(entityIdToCheck, "stats");
        Assert.assertTrue(entity.isPresent());
        Team team = entity.get();
        Assert.assertNotNull(team);
        Assert.assertNotNull(team.getStats());
    }
}