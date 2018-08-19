package com.sportmonks.aggregate.rest.service.generic.by.season;

import com.sportmonks.aggregate.core.data.entity.Stage;
import org.junit.Before;

public class StagesGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Stage> {

    @Before
    public void before() {
        super.entityIdToCheck = 48050;
        super.seasonIdToCheck = 6361;
    }
}