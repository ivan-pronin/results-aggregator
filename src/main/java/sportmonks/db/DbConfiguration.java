package sportmonks.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sportmonks.db.model.Customer;
import sportmonks.db.repository.ICustomerRepository;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DbConfiguration.class);

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.driverClassName}")
    private String driverClassName;

    @Value("${db.username}")
    private String userName;

    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(dbUrl, userName, password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setSchema("SPORTMONKS");
        System.out.println("URL: " + dbUrl);
        System.out.println("username: " + userName);
        System.out.println("password: " + password);
        System.out.println("driver: " + driverClassName);
        return dataSource;
    }

    @Bean
    public CommandLineRunner demo(ICustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });

            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            log.info("");
        };
    }
}
