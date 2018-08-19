package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Offer;
import com.sportmonks.aggregate.rest.service.builder.IUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import java.util.List;

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
        UriComponents uriComponents = uriBuilder.getUriComponents(BOOKMAKER_PATH);
        return sportmonksRestService.callForEntities(uriComponents.expand(fixtureId, bookmakerId).toUriString(), Offer[].class);
    }

    @Override
    public List<Offer> getByFixtureId(long fixtureId) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BASE_PATH);
        return sportmonksRestService.callForEntities(uriComponents.expand(fixtureId).toUriString(), Offer[].class);
    }

    @Override
    public List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId) {
        UriComponents uriComponents = uriBuilder.getUriComponents(MARKET_PATH);
        return sportmonksRestService.callForEntities(uriComponents.expand(fixtureId, marketId).toUriString(), Offer[].class);
    }
}
