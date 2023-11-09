package com.spring.demo.CrudDemo.dao;

import com.spring.demo.CrudDemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
