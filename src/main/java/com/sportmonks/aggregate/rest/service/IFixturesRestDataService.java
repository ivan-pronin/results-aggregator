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

    List<Fixture> getBetweenDates(String from, String to, String includes);

    /**
     * @param from   Date Format	YYYY-MM-DD
     * @param to     Date Format	YYYY-MM-DD
     * @param teamId
     * @return
     */
    List<Fixture> getBetweenDatesByTeam(String from, String to, long teamId);

    List<Fixture> getBetweenDatesByTeam(String from, String to, long teamId, String includes);

    /**
     * @param date Date Format	YYYY-MM-DD
     * @return
     */
    List<Fixture> getForDate(String date);

    List<Fixture> getForDate(String date, String includes);

    Optional<Fixture> getById(long id);

    Optional<Fixture> getById(long id, String includes);

    /**
     * @param idsList You can pass a comma separated list of ids
     * @return
     */
    List<Fixture> getMultipleByIds(String idsList);

    List<Fixture> getMultipleByIds(String idsList, String includes);
}
