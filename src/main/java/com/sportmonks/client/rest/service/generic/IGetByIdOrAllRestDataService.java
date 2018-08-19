package com.sportmonks.client.rest.service.generic;

import java.util.List;
import java.util.Optional;

public interface IGetByIdOrAllRestDataService<T> {

    List<T> getAll();

    List<T> getAll(String includes);

    Optional<T> getById(long id);

    Optional<T> getById(long id, String includes);
}
