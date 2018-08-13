package sportmonks.db.repository;

import org.springframework.data.repository.CrudRepository;
import sportmonks.db.model.Customer;

import java.util.List;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}