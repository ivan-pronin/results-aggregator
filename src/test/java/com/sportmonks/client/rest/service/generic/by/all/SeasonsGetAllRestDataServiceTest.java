package com.sportmonks.client.rest.service.generic.by.all;

import com.sportmonks.client.core.data.entity.Season;
import org.junit.Before;

public class SeasonsGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Season> {

    @Before
    public void before() {
        super.entityIdToCheck = 1273;
    }
}