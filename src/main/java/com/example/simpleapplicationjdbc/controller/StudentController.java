package com.example.simpleapplicationjdbc.controller;

import com.example.simpleapplicationjdbc.dao.StudentJDBCTemplate;
import com.example.simpleapplicationjdbc.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentJDBCTemplate studentJDBCTemplate;
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/all")
    public List<Student> students() {
        return studentJDBCTemplate.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody Student student) {
        studentJDBCTemplate.create(student);
    }

    @GetMapping("/get/{id}")
    public Student getID1(@PathVariable("id") Integer id) {
        return studentJDBCTemplate.findByStudentId(id);
    }
}
