package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.core.data.entity.Season;
import org.junit.Before;

public class SeasonsGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Season> {

    @Before
    public void before() {
        super.entityIdToCheck = 1273;
    }
}