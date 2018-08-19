package com.sportmonks.aggregate.rest.service.includes;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class IncludesRestDataService implements IIncludesRestDataService {

    @Override
    public <T> Optional<T> getEntity(String includes, Supplier<Optional<T>> dataService) {
        return Optional.empty();
    }

    @Override
    public <T> List<T> getEntities(String includes, Supplier<List<T>> dataService) {
        return null;
    }
}
