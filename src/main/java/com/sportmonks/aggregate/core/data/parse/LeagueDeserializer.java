package com.sportmonks.aggregate.core.data.parse;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.boot.jackson.JsonComponent;
import com.sportmonks.aggregate.core.data.entity.League;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonComponent
public class LeagueDeserializer extends JsonDeserializer<List<League>> {

    @Override
    public List<League> deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println("IN DESERIALIZER");
        JsonNode node = jsonParser.readValueAsTree();
        JsonNode data = node.get("data");
        List<League> result = new ArrayList<>();
        if (null != data) {
            if (data.isArray()) {
                System.out.println("Data is array");
                ArrayNode nodes = (ArrayNode) data;
                for (JsonNode n : nodes) {


                    result.add(new ObjectMapper().readValue(n.toString(), League.class));
                }
                System.out.println("Data:" + result);
            }
            System.out.println("data exists");
            League[] leagues = new ObjectMapper().readValue(data.toString(),
                    League[].class);
            System.out.println("Leagues parse: " + Arrays.toString(leagues));
            return Arrays.asList(leagues);
        }
        System.out.println("No data exists: " + data);
        return null;
    }
}
