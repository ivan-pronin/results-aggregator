package com.sportmonks.aggregate.rest.service.includes;

import com.sportmonks.aggregate.core.data.entity.Season;
import com.sportmonks.aggregate.core.data.entity.Stage;
import com.sportmonks.aggregate.rest.RestConfiguration;
import com.sportmonks.aggregate.rest.service.generic.IGetByIdOrAllRestDataService;
import com.sportmonks.aggregate.rest.service.generic.IGetByIdOrSeasonRestDataService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RestConfiguration.class)
public class RestDataServiceFacadeTest {

    @Autowired
    private IRestDataServiceFacade dataServiceFacade;
    @Autowired
    private IGetByIdOrAllRestDataService<Season> seasonsDataService;
    @Autowired
    private IGetByIdOrSeasonRestDataService<Stage> stagesDataService;

    @Test
    public void getEntity() {
        Optional<Season> entity = dataServiceFacade.getEntity(() -> seasonsDataService.getById(1273));
        Assert.assertTrue(entity.isPresent());
    }

    @Test
    public void getEntities() {
        List<Stage> entities = dataServiceFacade.getEntities(() -> stagesDataService.getBySeasonId(1273));
        Assert.assertNotNull(entities.get(0));
    }
}