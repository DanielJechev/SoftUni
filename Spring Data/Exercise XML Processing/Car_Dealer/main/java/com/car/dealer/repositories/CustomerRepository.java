package com.car.dealer.repositories;

import com.car.dealer.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c " +
            "ORDER BY c.birthDate, c.isYoungDriver")
    List<Customer> getAllCustomersOrderByBirthDateAndIsYoungDriver();

}
