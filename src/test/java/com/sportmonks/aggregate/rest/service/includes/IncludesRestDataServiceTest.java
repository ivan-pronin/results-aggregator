package com.sportmonks.aggregate.rest.service.includes;

import com.sportmonks.aggregate.core.data.entity.Country;
import com.sportmonks.aggregate.rest.service.generic.IGetByIdOrAllRestDataService;
import org.junit.Test;

public class IncludesRestDataServiceTest {

    IIncludesRestDataService includesDataService;
    IGetByIdOrAllRestDataService<Country> countriesDataService;

    @Test
    public void getEntity() {
//        Optional<Country> entity = includesDataService.getEntity("", () -> countriesDataService.getById(3));

    }

    @Test
    public void getEntities() {
//        List<Country> entity = includesDataService.getEntities("", countriesDataService::getAll);

    }
}