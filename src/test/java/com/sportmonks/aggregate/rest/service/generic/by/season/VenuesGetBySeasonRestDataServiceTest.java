package com.sportmonks.aggregate.rest.service.generic.by.season;

import com.sportmonks.aggregate.core.data.entity.Venue;
import org.junit.Before;

public class VenuesGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Venue> {

    @Before
    public void before() {
        super.entityIdToCheck = 1436;
        super.seasonIdToCheck = 6361;
    }
}