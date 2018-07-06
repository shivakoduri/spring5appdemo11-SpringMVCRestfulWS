package com.myprojects.spring.examples.SpringMVCRestWS.repositories;

import com.myprojects.spring.examples.SpringMVCRestWS.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
