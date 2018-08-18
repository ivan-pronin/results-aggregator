package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.League;
import com.sportmonks.aggregate.rest.service.builder.IUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Optional;

@Component
public class LeaguesRestDataService extends AbstractLeaguesRestDataService {

    private static final String LEAGUES = "leagues";
    private static final String BY_ID_PATH = LEAGUES + "/{id}";

    @Autowired
    private ISportmonksRestService sportmonksRestService;
    @Autowired
    private IUriBuilder uriBuilder;

    @Override
    public List<League> getAll() {
        UriComponents uriComponents = uriBuilder.getUriComponents(LEAGUES);
        return sportmonksRestService.callForEntities(uriComponents.toUriString(), League[].class);
    }

    @Override
    public Optional<League> getById(long id) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BY_ID_PATH);
        return sportmonksRestService.callForEntity(uriComponents.expand(id).toUriString(), League.class);
    }
}
