package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.core.data.entity.Fixture;

import java.util.List;
import java.util.Optional;

public interface IFixturesRestDataService {

    /**
     * @param from Date Format	YYYY-MM-DD
     * @param to   Date Format	YYYY-MM-DD
     * @return
     */
    List<Fixture> getBetweenDates(String from, String to);

    /**
     * @param from   Date Format	YYYY-MM-DD
     * @param to     Date Format	YYYY-MM-DD
     * @param teamId
     * @return
     */
    List<Fixture> getBetweenDatesByTeam(String from, String to, long teamId);

    /**
     * @param date Date Format	YYYY-MM-DD
     * @return
     */
    List<Fixture> getForDate(String date);

    Optional<Fixture> getById(long id);

    /**
     * @param idsList You can pass a comma separated list of ids
     * @return
     */
    List<Fixture> getMultipleByIds(String idsList);
}
