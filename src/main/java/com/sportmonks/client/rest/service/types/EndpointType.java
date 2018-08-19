package com.sportmonks.client.rest.service.types;

import com.sportmonks.client.core.data.entity.*;

public enum EndpointType {

    // ByIdOrAll containers
    CONTINENTS(new TypeContainerData<>("continents", Continent.class, Continent[].class)),
    COUNTRIES(new TypeContainerData<>("countries", Country.class, Country[].class)),
    LEAGUES(new TypeContainerData<>("leagues", League.class, League[].class)),
    SEASONS(new TypeContainerData<>("seasons", Season.class, Season[].class)),
    BOOKMAKERS(new TypeContainerData<>("bookmakers", Bookmaker.class, Bookmaker[].class)),
    MARKETS(new TypeContainerData<>("markets", Market.class, Market[].class)),
    PLAYERS(new TypeContainerData<>("players", Player.class, Player[].class)),
    COACHES(new TypeContainerData<>("coaches", Coach.class, Coach[].class)),

    // ByIdOrSeason containers
    STAGES(new TypeContainerData<>("stages", Stage.class, Stage[].class)),
    TEAMS(new TypeContainerData<>("teams", Team.class, Team[].class)),
    VENUES(new TypeContainerData<>("venues", Venue.class, Venue[].class)),
    ROUNDS(new TypeContainerData<>("rounds", Round.class, Round[].class));

    private final TypeContainerData typeContainerData;

    EndpointType(TypeContainerData typeContainerData) {
        this.typeContainerData = typeContainerData;
    }

    @SuppressWarnings("unchecked")
    public <T> TypeContainerData<T> get() {
        return typeContainerData;
    }
}
