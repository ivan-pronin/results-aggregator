package com.sportmonks.aggregate.rest.service.generic.by.season;

import com.sportmonks.aggregate.core.data.entity.Team;
import org.junit.Before;

public class TeamsGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Team> {

    @Before
    public void before() {
        super.entityIdToCheck = 2394;
        super.seasonIdToCheck = 6361;
    }
}