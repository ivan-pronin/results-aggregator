package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.core.data.entity.Bookmaker;
import org.junit.Before;

public class BookmakersGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Bookmaker> {

    @Before
    public void before() {
        super.entityIdToCheck = 1;
    }
}