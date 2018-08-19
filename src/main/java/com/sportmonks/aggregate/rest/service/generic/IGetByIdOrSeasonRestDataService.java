package com.sportmonks.aggregate.rest.service.generic;

import java.util.List;
import java.util.Optional;

public interface IGetByIdOrSeasonRestDataService<T> {

    List<T> getBySeasonId(long seasonId);

    Optional<T> getById(long id);
}
