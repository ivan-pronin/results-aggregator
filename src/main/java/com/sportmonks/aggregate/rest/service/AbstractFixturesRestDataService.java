package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Fixture;

import java.util.List;
import java.util.Optional;

public abstract class AbstractFixturesRestDataService {

    /**
     * @param from Date Format	YYYY-MM-DD
     * @param to   Date Format	YYYY-MM-DD
     * @return
     */
    public abstract List<Fixture> getBetweenDates(String from, String to);

    /**
     *
     * @param from Date Format	YYYY-MM-DD
     * @param to   Date Format	YYYY-MM-DD
     * @param teamId
     * @return
     */
    public abstract List<Fixture> getBetweenDatesByTeam(String from, String to, long teamId);

    /**
     *
     * @param date Date Format	YYYY-MM-DD
     * @return
     */
    public abstract List<Fixture> getForDate(String date);

    public abstract Optional<Fixture> getById(long id);

    /**
     * @param idsList You can pass a comma separated list of ids
     * @return
     */
    public abstract List<Fixture> getMultipleByIds(String idsList);
}
