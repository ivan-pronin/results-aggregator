package sportmonks.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import sportmonks.core.data.entity.Fixture;
import sportmonks.core.data.structure.Leagues;

@Component
public class DataService {

    private static final Logger log = LoggerFactory.getLogger(DataService.class);

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UriComponentsBuilder uriComponentsBuilder;

    public void getFixture() {
        ResponseEntity<Fixture> entity = restTemplate.exchange(
                uriComponentsBuilder.toUriString(),
                HttpMethod.GET,
                null,
                Fixture.class);
        log.info("Status code: " + entity.getStatusCode().value());
        log.info("Fixture: " + entity.getBody());
    }

    public void getLeagues() {
        ResponseEntity<Leagues> entity = restTemplate.getForEntity(
                "https://soccer.sportmonks.com/api/v2.0/leagues?api_token=01pV76Qt4NZe3ay5eRSaqq8cQl8objq2zjEqZc0YE7Sj7WbMkww3uoXBbq8s",
                Leagues.class);
        log.info("Status code: " + entity.getStatusCode().value());
        log.info("Leagues: " + entity.getBody());
    }

}
