package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Offer;

import java.util.List;

public interface IOddsRestDataService {

    List<Offer> getByFixtureAndBookmakerId(long fixtureId, long bookmakerId);

    List<Offer> getByFixtureAndBookmakerId(long fixtureId, long bookmakerId, String includes);

    List<Offer> getByFixtureId(long fixtureId);

    List<Offer> getByFixtureId(long fixtureId, String includes);

    List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId);

    List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId, String includes);
}
