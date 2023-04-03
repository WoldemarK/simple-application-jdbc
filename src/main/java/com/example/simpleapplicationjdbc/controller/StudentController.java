package com.example.simpleapplicationjdbc.controller;

import com.example.simpleapplicationjdbc.DTO.StudentDTO;
import com.example.simpleapplicationjdbc.dao.StudentDAOImpl;
import com.example.simpleapplicationjdbc.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentDAOImpl st;

    @GetMapping("/all")
    public List<StudentDTO> findAll() {
        return st.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody Student student) {
        st.create(student);
    }

    @GetMapping("/get/{id}")
    public Student findByStudentId(@PathVariable("id") Integer id) {
        return st.findByStudentId(id);
    }

    @PutMapping("/update/{id}/{age}")
    public void update(@PathVariable("id") Integer id, @PathVariable("age") Integer age) {
        st.update(id, age);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        st.delete(id);
    }
}
