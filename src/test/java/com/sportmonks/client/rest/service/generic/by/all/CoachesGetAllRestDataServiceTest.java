package com.sportmonks.client.rest.service.generic.by.all;

import com.sportmonks.client.core.data.entity.Coach;
import org.junit.Before;
import org.junit.Test;

public class CoachesGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Coach> {

    @Before
    public void before() {
        super.entityIdToCheck = 458506;
    }

    @Override
    @Test
    public void getAllTest() {
        System.out.println("Get all is not supported for coaches endpoint");
    }
}