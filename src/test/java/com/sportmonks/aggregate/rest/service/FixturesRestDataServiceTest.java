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
    private AbstractFixturesRestDataService dataService;

    @Test
    public void getBetweenDatesTest() {
        List<Fixture> fixtures = dataService.getBetweenDates(FROM, FROM);
        Assert.assertThat(fixtures, is(not(empty())));
        Assert.assertTrue(fixtures.stream().anyMatch(f -> f.getLeagueId() == SUPERLIGA_ID));
    }

    @Test
    public void getBetweenDatesByTeamTest() {
        List<Fixture> fixtures = dataService.getBetweenDatesByTeam(FROM, FROM, LOCAL_TEAM_ID);
        Assert.assertThat(fixtures, is(not(empty())));
        Assert.assertTrue(fixtures.stream().anyMatch(f -> f.getLocalteamId() == LOCAL_TEAM_ID));
    }

    @Test
    public void getForDateTest() {
        List<Fixture> fixtures = dataService.getForDate(FROM);
        Assert.assertThat(fixtures, is(not(empty())));
        Assert.assertTrue(fixtures.stream().anyMatch(f -> f.getLocalteamId() == LOCAL_TEAM_ID));
    }

    @Test
    public void getByIdTest() {
        Optional<Fixture> fixture = dataService.getById(FIXTURE_ID);
        Assert.assertTrue(fixture.isPresent());
        Assert.assertEquals(LOCAL_TEAM_ID, (long) fixture.get().getLocalteamId());
    }

    @Test
    public void getMultipleByIdsTest() {
        List<Fixture> fixtures = dataService.getMultipleByIds(String.valueOf(FIXTURE_ID));
        Assert.assertThat(fixtures, is(not(empty())));
        Assert.assertTrue(fixtures.stream().anyMatch(f -> f.getLocalteamId() == LOCAL_TEAM_ID));
    }
}