package com.sportmonks.aggregate.rest.service.builder;

import org.springframework.web.util.UriComponents;

public interface IUriBuilder {

    UriComponents getUriComponents(String path);
}
