package com.example.simpleapplicationjdbc.dao;

import com.example.simpleapplicationjdbc.entity.Student;
import com.example.simpleapplicationjdbc.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
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


    @Override
    public void create(Student student) {
        jdbcTemplate.update(CREATE);
    }

    @Override
    public Student findByStudentId(Integer id) {
        log.info("Поиск по ID произведен " + id);
        return jdbcTemplate.queryForObject
                (
                        GET_ID_STUDENT,
                        new Object[]{id},
                        new StudentMapper()
                );
    }

    @Override
    public List<Student> findAll() {
        log.info("Произведен показ всех студентов");
        return jdbcTemplate.query

                (
                        getAllStudent,
                        new StudentMapper()
                );
    }

    @Override
    public void update(Integer id, Integer age) {
        log.info("Произведено обновление данных о студенте " + id + " " + age);
        jdbcTemplate.update(UPDATE, age, id);
    }

    @Override
    public void delete(Integer id) {
        log.info("Произведено удаление студента" + id);
        jdbcTemplate.update(DELETE_STUDENT, id);
    }

    @Override
    public String findStudentNameById(Long id) {
        log.info("Поиск имени студента по идентификатору ID " + id);
        return jdbcTemplate.queryForObject
                (
                        GET_NAME_BY_ID_STUDENT,
                        new Object[]{id}, String.class
                );
    }
}
