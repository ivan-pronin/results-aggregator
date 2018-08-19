package com.sportmonks.client.rest.service;

import com.sportmonks.client.core.data.entity.Fixture;
import com.sportmonks.client.rest.service.builder.IUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Optional;

import static com.sportmonks.client.rest.service.constants.Constants.INCLUDES;

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
        return getBetweenDates(from, to, "");
    }

    @Override
    public List<Fixture> getBetweenDates(String from, String to, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BETWEEN_DATES, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(from, to, includes).toUriString(), Fixture[].class);

    }

    @Override
    public List<Fixture> getBetweenDatesByTeam(String from, String to, long teamId) {
        return getBetweenDatesByTeam(from, to, teamId, "");
    }

    @Override
    public List<Fixture> getBetweenDatesByTeam(String from, String to, long teamId, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BY_TEAM, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(from, to, teamId, includes).toUriString(), Fixture[].class);
    }

    @Override
    public List<Fixture> getForDate(String date) {
        return getForDate(date, "");
    }

    @Override
    public List<Fixture> getForDate(String date, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(FOR_DATE, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(date, includes).toUriString(), Fixture[].class);
    }

    @Override
    public Optional<Fixture> getById(long id) {
        return getById(id, "");
    }

    @Override
    public Optional<Fixture> getById(long id, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BY_ID, INCLUDES);
        return sportmonksRestService.callForEntity(uriComponents.expand(id, includes).toUriString(), Fixture.class);
    }

    @Override
    public List<Fixture> getMultipleByIds(String idsList) {
        return getMultipleByIds(idsList, "");
    }

    @Override
    public List<Fixture> getMultipleByIds(String idsList, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(MULTI, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(idsList, includes).toUriString(), Fixture[].class);
    }
}
