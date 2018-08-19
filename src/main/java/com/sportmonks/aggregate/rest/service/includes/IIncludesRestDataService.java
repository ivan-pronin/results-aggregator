package com.sportmonks.aggregate.rest.service.includes;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface IIncludesRestDataService {

    <T> Optional<T> getEntity(String includes, Supplier<Optional<T>> dataService);

    <T> List<T> getEntities(String includes, Supplier<List<T>> dataService);
}
