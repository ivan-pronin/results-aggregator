package com.sportmonks.client.rest.service.builder;

import org.springframework.web.util.UriComponents;

public interface IUriBuilder {

    UriComponents getUriComponents(String path);

    UriComponents getUriComponents(String path, String query);
}
