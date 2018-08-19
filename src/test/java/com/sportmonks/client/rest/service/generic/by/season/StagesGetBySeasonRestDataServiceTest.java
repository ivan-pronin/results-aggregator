package com.sportmonks.client.rest.service.generic.by.season;

import com.sportmonks.client.core.data.entity.Stage;
import org.junit.Before;

public class StagesGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Stage> {

    @Before
    public void before() {
        super.entityIdToCheck = 48050;
        super.seasonIdToCheck = 6361;
    }
}