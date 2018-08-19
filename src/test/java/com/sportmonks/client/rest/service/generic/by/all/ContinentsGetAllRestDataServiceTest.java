package com.sportmonks.client.rest.service.generic.by.all;

import com.sportmonks.client.core.data.entity.Continent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.*;

public class ContinentsGetAllRestDataServiceTest extends GenericGetAllRestDataServiceTest<Continent> {

    @Before
    public void before() {
        super.entityIdToCheck = 1;
    }

    @Test
    public void includesByIdTest() {
        Optional<Continent> entity = dataService.getById(entityIdToCheck, "countries");
        Assert.assertTrue(entity.isPresent());
        Continent continent = entity.get();
        Assert.assertNotNull(continent);
        Assert.assertThat(continent.getCountries().getData(), is(not(empty())));
    }
}