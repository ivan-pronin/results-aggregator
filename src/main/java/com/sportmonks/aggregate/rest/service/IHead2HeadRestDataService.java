package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Fixture;

import java.util.List;

public interface IHead2HeadRestDataService {

    List<Fixture> get(long team1Id, long team2Id);

    List<Fixture> get(long team1Id, long team2Id, String includes);
}
