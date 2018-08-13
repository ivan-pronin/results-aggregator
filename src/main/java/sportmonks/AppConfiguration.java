package sportmonks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import sportmonks.core.data.Quote;

@Configuration
public class AppConfiguration {

    private static final String URL = "https://soccer.sportmonks.com/api/v2.0/fixtures/1625177";
    private static final String API_TOKEN = "01pV76Qt4NZe3ay5eRSaqq8cQl8objq2zjEqZc0YE7Sj7WbMkww3uoXBbq8s";
    private static final Logger log = LoggerFactory.getLogger(BootApplication.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public UriComponentsBuilder uriComponentsBuilder() {
        return UriComponentsBuilder.fromHttpUrl(URL).queryParam("api_token", API_TOKEN);
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        };
    }
}
