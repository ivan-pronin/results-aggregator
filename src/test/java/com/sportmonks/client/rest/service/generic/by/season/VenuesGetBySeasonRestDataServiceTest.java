package com.sportmonks.client.rest.service.generic.by.season;

import com.sportmonks.client.core.data.entity.Venue;
import org.junit.Before;

public class VenuesGetBySeasonRestDataServiceTest extends GenericGetBySeasonRestDataServiceTest<Venue> {

    @Before
    public void before() {
        super.entityIdToCheck = 1436;
        super.seasonIdToCheck = 6361;
    }
}