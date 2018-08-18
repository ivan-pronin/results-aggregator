package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Fixture;
import com.sportmonks.aggregate.rest.service.builder.IUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Optional;

@Component
public class FixturesRestDataService implements IFixturesRestDataService {

    private static final String BASE_PATH = "fixtures/";
    private static final String BETWEEN_DATES = BASE_PATH + "between/{from}/{to}";
    private static final String BY_TEAM = BETWEEN_DATES + "/{team_id}";
    private static final String FOR_DATE = BASE_PATH + "date/{date}";
    private static final String BY_ID = BASE_PATH + "{id}";
    private static final String MULTI = BASE_PATH + "multi/{id_list}";

    @Autowired
    private ISportmonksRestService sportmonksRestService;
    @Autowired
    private IUriBuilder uriBuilder;

    @Override
    public List<Fixture> getBetweenDates(String from, String to) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BETWEEN_DATES);
        return sportmonksRestService.callForEntities(uriComponents.expand(from, to).toUriString(), Fixture[].class);
    }

    @Override
    public List<Fixture> getBetweenDatesByTeam(String from, String to, long teamId) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BY_TEAM);
        return sportmonksRestService.callForEntities(uriComponents.expand(from, to, teamId).toUriString(), Fixture[].class);
    }

    @Override
    public List<Fixture> getForDate(String date) {
        UriComponents uriComponents = uriBuilder.getUriComponents(FOR_DATE);
        return sportmonksRestService.callForEntities(uriComponents.expand(date).toUriString(), Fixture[].class);
    }

    @Override
    public Optional<Fixture> getById(long id) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BY_ID);
        return sportmonksRestService.callForEntity(uriComponents.expand(id).toUriString(), Fixture.class);
    }

    @Override
    public List<Fixture> getMultipleByIds(String idsList) {
        UriComponents uriComponents = uriBuilder.getUriComponents(MULTI);
        return sportmonksRestService.callForEntities(uriComponents.expand(idsList).toUriString(), Fixture[].class);
    }
}
