package com.sportmonks.client.rest.service;

import java.util.List;
import java.util.Optional;


public interface ISportmonksRestService {

    <T> List<T> callForEntities(String url, Class<T[]> clazz);

    <T> Optional<T> callForEntity(String url, Class<T> clazz);
}
