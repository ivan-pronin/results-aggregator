package com.sportmonks.aggregate.rest.service.generic.by.all;

import com.sportmonks.aggregate.core.data.entity.Player;
import org.junit.Before;
import org.junit.Test;

public class PlayersGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Player> {

    @Before
    public void before() {
        super.entityIdToCheck = 1;
    }

    @Override
    @Test
    public void getAllTest() {
        System.out.println("Get all is not supported for players endpoint");
    }
}