package com.sportmonks.client.rest.service.includes;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface IRestDataServiceFacade {

    <T> Optional<T> getEntity(Supplier<Optional<T>> dataService);

    <T> List<T> getEntities(Supplier<List<T>> dataService);
}
