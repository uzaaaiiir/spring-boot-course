package com.springboot.mappingsdemo.dao;

import com.springboot.mappingsdemo.entity.Instructor;
import com.springboot.mappingsdemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
