package com.sportmonks.aggregate.core.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sportmonks.aggregate.core.data.structure.Seasons;

//@JsonDeserialize(using = LeagueDeserializer.class)
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonPropertyOrder({"id", "legacy_id", "name", "is_cup", "current_season_id", "current_round_id", "current_stage_id", "country_id", "seasons", "season", "country"})
public class League {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("legacy_id")
    private Integer legacyId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_cup")
    private Boolean isCup;
    @JsonProperty("current_season_id")
    private Long currentSeasonId;
    @JsonProperty("current_round_id")
    private Long currentRoundId;
    @JsonProperty("current_stage_id")
    private Long currentStageId;
    @JsonProperty("country_id")
    private Long countryId;
    @JsonProperty("seasons")
    private Seasons seasons;
    @JsonProperty("season")
    private Season season;
    @JsonProperty("country")
    private Country country;

    public Long getId() {
        return id;
    }
}