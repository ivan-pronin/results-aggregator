package com.sportmonks.client.rest.service.includes;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Component
public class RestDataServiceFacade implements IRestDataServiceFacade {

    @Override
    public <T> Optional<T> getEntity(Supplier<Optional<T>> dataService) {
        return dataService.get();
    }

    @Override
    public <T> List<T> getEntities(Supplier<List<T>> dataService) {
        return dataService.get();
    }
}
