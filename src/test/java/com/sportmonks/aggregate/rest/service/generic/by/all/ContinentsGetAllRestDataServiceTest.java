package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.core.data.entity.Continent;
import org.junit.Before;

public class ContinentsGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Continent> {

    @Before
    public void before() {
        super.entityIdToCheck = 1;
    }
}