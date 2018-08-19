package com.sportmonks.client.rest.service.generic.by.season;

import com.sportmonks.client.core.data.entity.Round;
import org.junit.Before;

public class RoundsGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Round> {

    @Before
    public void before() {
        super.entityIdToCheck = 127989;
        super.seasonIdToCheck = 6361;
    }
}