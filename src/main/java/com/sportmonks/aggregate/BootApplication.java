package com.sportmonks.aggregate;

import com.sportmonks.aggregate.core.data.entity.Fixture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.sportmonks.aggregate.core.data.entity.League;
import com.sportmonks.aggregate.rest.service.RestDataService;

import java.util.List;

@SpringBootApplication
public class BootApplication {

    public static void main(String args[]) {
        ConfigurableApplicationContext context = SpringApplication.run(BootApplication.class);
        RestDataService restDataService = context.getBean(RestDataService.class);
        List<League> leagues = restDataService.getLeagues();
        System.out.println("Leagues: " + leagues);
        Fixture fixture = restDataService.getFixture();
        System.out.println("Fixture: " + fixture);

    }
}