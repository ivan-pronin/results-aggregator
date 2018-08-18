package com.sportmonks.aggregate.db.repository;

import org.springframework.data.repository.CrudRepository;
import com.sportmonks.aggregate.db.model.Customer;

import java.util.List;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}