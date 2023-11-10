package com.spring.cruddemo.repository;

import com.spring.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(path = "members") // allows defining custom path for entity
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
