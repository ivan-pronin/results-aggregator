package sportmonks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import sportmonks.core.service.DataService;

@SpringBootApplication
public class BootApplication {

    public static void main(String args[]) {
        ConfigurableApplicationContext context = SpringApplication.run(BootApplication.class);
        DataService dataService = context.getBean(DataService.class);
//        dataService.getLeagues();
//        dataService.getFixture();
    }
}