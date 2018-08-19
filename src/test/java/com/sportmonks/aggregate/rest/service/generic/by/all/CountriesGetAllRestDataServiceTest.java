package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.core.data.entity.Country;
import org.junit.Before;

public class CountriesGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Country> {

    @Before
    public void before() {
        super.entityIdToCheck = 2;
    }
}