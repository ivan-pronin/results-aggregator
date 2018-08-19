package com.sportmonks.aggregate.rest.service.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.function.Supplier;

@Component
public class UriBuilder implements IUriBuilder {

    @Autowired
    private Supplier<UriComponentsBuilder> uriComponentsBuilderSupplier;

    @Override
    public UriComponents getUriComponents(String path) {
        return uriComponentsBuilderSupplier.get().path(path).build();
    }

    @Override
    public UriComponents getUriComponents(String path, String query) {
        return uriComponentsBuilderSupplier.get().path(path).queryParam(query).build();
    }
}
