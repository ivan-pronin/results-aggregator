package com.sportmonks.client.rest.service;

import com.sportmonks.client.core.data.entity.Offer;

import java.util.List;

public interface IOddsRestDataService {

    List<Offer> getByFixtureAndBookmakerId(long fixtureId, long bookmakerId);

    List<Offer> getByFixtureAndBookmakerId(long fixtureId, long bookmakerId, String includes);

    List<Offer> getByFixtureId(long fixtureId);

    List<Offer> getByFixtureId(long fixtureId, String includes);

    List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId);

    List<Offer> getByFixtureAndMarketId(long fixtureId, long marketId, String includes);
}
