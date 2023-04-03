package com.example.simpleapplicationjdbc.dao;

import com.example.simpleapplicationjdbc.entity.Student;
import com.example.simpleapplicationjdbc.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class StudentJDBCTemplate implements StudentDAO {
    @Value("${LISTS_STUDENTS}")
    private String getAllStudent;
    @Value("${CREATE}")
    private String CREATE;
    @Value("${GET_ID_STUDENT}")
    private String GET_ID_STUDENT;
    @Value("${UPDATE}")
    private String UPDATE;
    @Value("${DELETE_STUDENT}")
    private String DELETE_STUDENT;
    @Value("${GET_NAME_BY_ID_STUDENT}")
    private String GET_NAME_BY_ID_STUDENT;
    public final JdbcTemplate jdbcTemplate;

    public StudentJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Student student) {
        jdbcTemplate.update(CREATE);
    }

    @Override
    public Student findByStudentId(Integer id) {
        return jdbcTemplate.queryForObject
                (
                        GET_ID_STUDENT,
                        new Object[]{id},
                        new StudentMapper()
                );
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query

                (
                        getAllStudent,
                        new StudentMapper()
                );
    }

    @Override
    public void update(Integer id, Integer age) {
        jdbcTemplate.update(UPDATE, age, id);
    }

    @Override
    public void delete(Integer id) {
        jdbcTemplate.update(DELETE_STUDENT, id);
    }

    @Override
    public String findStudentNameById(Long id) {
        return jdbcTemplate.queryForObject
                (
                        GET_NAME_BY_ID_STUDENT,
                        new Object[]{id}, String.class
                );
    }
}
