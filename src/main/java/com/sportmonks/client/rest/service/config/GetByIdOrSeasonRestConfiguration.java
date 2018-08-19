package com.sportmonks.client.rest.service.config;

import com.sportmonks.client.core.data.entity.Round;
import com.sportmonks.client.core.data.entity.Stage;
import com.sportmonks.client.core.data.entity.Team;
import com.sportmonks.client.core.data.entity.Venue;
import com.sportmonks.client.rest.service.generic.GetByIdOrSeasonRestDataService;
import com.sportmonks.client.rest.service.generic.IGetByIdOrSeasonRestDataService;
import com.sportmonks.client.rest.service.types.EndpointType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetByIdOrSeasonRestConfiguration {

    @Bean
    public IGetByIdOrSeasonRestDataService<Stage> stageIGetByIdOrSeasonRestDataService() {
        return new GetByIdOrSeasonRestDataService<>(EndpointType.STAGES.get());
    }

    @Bean
    public IGetByIdOrSeasonRestDataService<Team> teamIGetByIdOrSeasonRestDataService() {
        return new GetByIdOrSeasonRestDataService<>(EndpointType.TEAMS.get());
    }

    @Bean
    public IGetByIdOrSeasonRestDataService<Venue> venueIGetByIdOrSeasonRestDataService() {
        return new GetByIdOrSeasonRestDataService<>(EndpointType.VENUES.get());
    }

    @Bean
    public IGetByIdOrSeasonRestDataService<Round> roundIGetByIdOrSeasonRestDataService() {
        return new GetByIdOrSeasonRestDataService<>(EndpointType.ROUNDS.get());
    }
}
