package com.sportmonks.client.rest.service.generic.by.all;

import com.sportmonks.client.core.data.entity.Bookmaker;
import org.junit.Before;

public class BookmakersGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Bookmaker> {

    @Before
    public void before() {
        super.entityIdToCheck = 1;
    }
}