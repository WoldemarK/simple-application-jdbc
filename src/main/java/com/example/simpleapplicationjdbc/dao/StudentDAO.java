package com.example.simpleapplicationjdbc.dao;

import com.example.simpleapplicationjdbc.entity.Student;

import java.util.List;

public interface StudentDAO {
    void create(String name, Integer age);

    Student getStudent(Integer id);
    List<Student> listStudents();
}
