package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Offer;

import java.util.List;

public interface IOddsRestDataService {

    List<Offer> getByFixtureAndBookmakerId(long fixtureId, long bookmakerId);

    List<Offer> getByFixtureId(long fixtureId);

    List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId);
}
