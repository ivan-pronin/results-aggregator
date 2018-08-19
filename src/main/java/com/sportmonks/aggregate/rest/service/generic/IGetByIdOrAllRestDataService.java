package com.sportmonks.aggregate.rest.service.generic;

import java.util.List;
import java.util.Optional;

public interface IGetByIdOrAllRestDataService<T> {

    List<T> getAll();

    Optional<T> getById(long id);
}
