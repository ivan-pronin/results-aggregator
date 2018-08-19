package com.sportmonks.client.rest.service;

import com.sportmonks.client.core.data.entity.Fixture;

import java.util.List;

public interface IHead2HeadRestDataService {

    List<Fixture> get(long team1Id, long team2Id);

    List<Fixture> get(long team1Id, long team2Id, String includes);
}
