package com.sportmonks.client.rest.service;

import com.sportmonks.client.core.data.entity.Offer;
import com.sportmonks.client.rest.service.builder.IUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import java.util.List;

import static com.sportmonks.client.rest.service.constants.Constants.INCLUDES;

@Component
public class OddsRestDataService implements IOddsRestDataService {

    private static final String BASE_PATH = "odds/fixture/{id}";
    private static final String BOOKMAKER_PATH = BASE_PATH + "/bookmaker/{id}";
    private static final String MARKET_PATH = BASE_PATH + "/bookmaker/{id}";

    @Autowired
    private ISportmonksRestService sportmonksRestService;
    @Autowired
    private IUriBuilder uriBuilder;

    @Override
    public List<Offer> getByFixtureAndBookmakerId(long fixtureId, long bookmakerId) {
        return getByFixtureAndBookmakerId(fixtureId, bookmakerId, "");
    }

    @Override
    public List<Offer> getByFixtureAndBookmakerId(long fixtureId, long bookmakerId, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BOOKMAKER_PATH, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(fixtureId, bookmakerId, includes).toUriString(), Offer[].class);
    }

    @Override
    public List<Offer> getByFixtureId(long fixtureId) {
        return getByFixtureId(fixtureId, "");
    }

    @Override
    public List<Offer> getByFixtureId(long fixtureId, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BASE_PATH, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(fixtureId, includes).toUriString(), Offer[].class);
    }

    @Override
    public List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId) {
        return getByFixtureAndMarketId(fixtureId, marketId, "");
    }

    @Override
    public List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(MARKET_PATH, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(fixtureId, marketId, includes).toUriString(), Offer[].class);
    }
}
