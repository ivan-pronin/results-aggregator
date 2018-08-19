package com.sportmonks.client.rest.service.generic;

import java.util.List;
import java.util.Optional;

public interface IGetByIdOrSeasonRestDataService<T> {

    List<T> getBySeasonId(long seasonId);

    List<T> getBySeasonId(long seasonId, String includes);

    Optional<T> getById(long id);

    Optional<T> getById(long id, String includes);
}
