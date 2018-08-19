package com.sportmonks.aggregate.rest.service.config;

import com.sportmonks.aggregate.core.data.entity.*;
import com.sportmonks.aggregate.rest.service.generic.GetByIdOrAllRestDataService;
import com.sportmonks.aggregate.rest.service.generic.IGetByIdOrAllRestDataService;
import com.sportmonks.aggregate.rest.service.types.EndpointType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetByIdOrAllRestConfiguration {

    @Bean
    public IGetByIdOrAllRestDataService<Continent> continentIGetByIdOrAllRestDataService() {
        return new GetByIdOrAllRestDataService<>(EndpointType.CONTINENTS.get());
    }

    @Bean
    public IGetByIdOrAllRestDataService<Country> countryIGetByIdOrAllRestDataService() {
        return new GetByIdOrAllRestDataService<>(EndpointType.COUNTRIES.get());
    }

    @Bean
    public IGetByIdOrAllRestDataService<League> leagueIGetByIdOrAllRestDataService() {
        return new GetByIdOrAllRestDataService<>(EndpointType.LEAGUES.get());
    }

    @Bean
    public IGetByIdOrAllRestDataService<Season> seasonIGetByIdOrAllRestDataService() {
        return new GetByIdOrAllRestDataService<>(EndpointType.SEASONS.get());
    }

    @Bean
    public IGetByIdOrAllRestDataService<Bookmaker> bookmakerIGetByIdOrAllRestDataService() {
        return new GetByIdOrAllRestDataService<>(EndpointType.BOOKMAKERS.get());
    }

    @Bean
    public IGetByIdOrAllRestDataService<Market> marketIGetByIdOrAllRestDataService() {
        return new GetByIdOrAllRestDataService<>(EndpointType.MARKETS.get());
    }

    @Bean
    public IGetByIdOrAllRestDataService<Player> playerIGetByIdOrAllRestDataService() {
        return new GetByIdOrAllRestDataService<>(EndpointType.PLAYERS.get());
    }
}