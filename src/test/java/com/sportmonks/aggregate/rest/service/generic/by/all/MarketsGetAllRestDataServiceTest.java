package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.core.data.entity.Market;
import org.junit.Before;

public class MarketsGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Market> {

    @Before
    public void before() {
        super.entityIdToCheck = 1;
    }
}