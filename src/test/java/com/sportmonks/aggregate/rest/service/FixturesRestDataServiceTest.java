package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Fixture;
import com.sportmonks.aggregate.rest.RestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestConfiguration.class)
public class FixturesRestDataServiceTest {

    private static final int SUPERLIGA_ID = 271;
    private static final String FROM = "2018-03-01";
    private static final long LOCAL_TEAM_ID = 2394;
    private static final long FIXTURE_ID = 1625177;

    @Autowired
    private IFixturesRestDataService dataService;

    @Test
    public void getBetweenDatesTest() {
        List<Fixture> entities = dataService.getBetweenDates(FROM, FROM);
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getLeagueId() == SUPERLIGA_ID));
    }

    @Test
    public void getBetweenDatesIncludesTest() {
        List<Fixture> entities = dataService.getBetweenDates(FROM, FROM, "stats");
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getStats() != null));
    }

    @Test
    public void getBetweenDatesByTeamTest() {
        List<Fixture> entities = dataService.getBetweenDatesByTeam(FROM, FROM, LOCAL_TEAM_ID);
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getLocalteamId() == LOCAL_TEAM_ID));
    }

    @Test
    public void getForDateTest() {
        List<Fixture> entities = dataService.getForDate(FROM);
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getLocalteamId() == LOCAL_TEAM_ID));
    }

    @Test
    public void getByIdTest() {
        Optional<Fixture> fixture = dataService.getById(FIXTURE_ID);
        Assert.assertTrue(fixture.isPresent());
        Assert.assertEquals(LOCAL_TEAM_ID, (long) fixture.get().getLocalteamId());
    }

    @Test
    public void getByIdIncludesTest() {
        Optional<Fixture> fixture = dataService.getById(FIXTURE_ID, "stats");
        Assert.assertTrue(fixture.isPresent());
        Assert.assertNotNull(fixture.get().getStats());
    }

    @Test
    public void getMultipleByIdsTest() {
        List<Fixture> entities = dataService.getMultipleByIds(String.valueOf(FIXTURE_ID));
        Assert.assertThat(entities, is(not(empty())));
        Assert.assertTrue(entities.stream().anyMatch(f -> f.getLocalteamId() == LOCAL_TEAM_ID));
    }
}