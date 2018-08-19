package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Fixture;
import com.sportmonks.aggregate.rest.service.builder.IUriBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import java.util.List;

@Component
public class Head2HeadRestDataService implements IHead2HeadRestDataService {

    private static final String BASE_PATH = "head2head/{team1id}/{team2id}";

    @Autowired
    private ISportmonksRestService sportmonksRestService;
    @Autowired
    private IUriBuilder uriBuilder;

    @Override
    public List<Fixture> get(long team1Id, long team2Id) {
        UriComponents uriComponents = uriBuilder.getUriComponents(BASE_PATH);
        return sportmonksRestService.callForEntities(uriComponents.expand(team1Id, team2Id).toUriString(), Fixture[].class);
    }
}