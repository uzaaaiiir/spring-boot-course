package com.spring.cruddemo.dao;

import com.spring.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entity;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entity = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query =  entity.createQuery("FROM Employee", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entity.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entity.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entity.find(Employee.class, id);
        entity.remove(employee);
    }
}
