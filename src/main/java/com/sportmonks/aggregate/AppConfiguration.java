package com.sportmonks.aggregate;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.sportmonks.aggregate.db.DbConfiguration;
import com.sportmonks.aggregate.rest.RestConfiguration;

@Configuration
@Import({DbConfiguration.class, RestConfiguration.class})
public class AppConfiguration {
}
