package com.example.simpleapplicationjdbc.dao;

import com.example.simpleapplicationjdbc.DTO.StudentDTO;
import com.example.simpleapplicationjdbc.entity.Student;

import java.util.List;

public interface StudentDAO {
    void create(Student student);

    Student findByStudentId(Integer id);

    List<StudentDTO> findAll();

    void update(Integer id, Integer age);
    void delete(Integer id);
    String findStudentNameById(Integer id);
}
