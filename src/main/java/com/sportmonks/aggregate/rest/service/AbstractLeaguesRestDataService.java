package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.League;

import java.util.List;
import java.util.Optional;

public abstract class AbstractLeaguesRestDataService {

    public abstract List<League> getAll();

    public abstract Optional<League> getById(long id);
}
