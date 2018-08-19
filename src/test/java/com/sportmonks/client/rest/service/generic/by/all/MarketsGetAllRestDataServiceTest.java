package com.sportmonks.client.rest.service.generic.by.all;

import com.sportmonks.client.core.data.entity.Market;
import org.junit.Before;

public class MarketsGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Market> {

    @Before
    public void before() {
        super.entityIdToCheck = 1;
    }
}