package com.sportmonks.aggregate.rest.service.types;

import com.sportmonks.aggregate.core.data.entity.Continent;
import com.sportmonks.aggregate.core.data.entity.Country;
import com.sportmonks.aggregate.core.data.entity.League;
import com.sportmonks.aggregate.core.data.entity.Season;

public enum EndpointType {

    СONTINENTS(new TypeContainerData<>("continents", Continent.class, Continent[].class)),
    COUNTRIES(new TypeContainerData<>("countries", Country.class, Country[].class)),
    LEAGUES(new TypeContainerData<>("leagues", League.class, League[].class)),
    SEASONS(new TypeContainerData<>("seasons", Season.class, Season[].class));

    private final TypeContainerData typeContainerData;

    EndpointType(TypeContainerData typeContainerData) {
        this.typeContainerData = typeContainerData;
    }

    public <T> TypeContainerData<T> get() {
        return typeContainerData;
    }
}
