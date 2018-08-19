package com.sportmonks.aggregate.rest.service.generic.by.season;

import com.sportmonks.aggregate.core.data.entity.Round;
import org.junit.Before;

public class RoundsGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Round> {

    @Before
    public void before() {
        super.entityIdToCheck = 127989;
        super.seasonIdToCheck = 6361;
    }
}