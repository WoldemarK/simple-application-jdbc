package com.example.simpleapplicationjdbc.dao;

import com.example.simpleapplicationjdbc.DTO.StudentDTO;
import com.example.simpleapplicationjdbc.entity.Student;
import com.example.simpleapplicationjdbc.mapper.StudentDTOMapper;
import com.example.simpleapplicationjdbc.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class StudentDAOImpl implements StudentDAO {
    @Value("${LISTS_STUDENTS}")
    private String findAllStudent;
    @Value("${CREATE}")
    private String create;
    @Value("${GET_ID_STUDENT}")
    private String getIdStudent;
    @Value("${UPDATE}")
    private String update;
    @Value("${DELETE_STUDENT}")
    private String deleteStudent;
    @Value("${GET_NAME_BY_ID_STUDENT}")
    private String findNameByIdStudentT;
    public final JdbcTemplate jdbcTemplate;
    private final StudentDTOMapper mapper;

    @Override
    public void create(Student student) {
        log.info("Добавление нового Student " + student.getName());
        jdbcTemplate.update(
                create, student.getId(),
                student.getName(),
                student.getAge());
    }

    @Override
    public Student findByStudentId(Integer id) {
        log.info("Поиск по ID произведен " + id);
        return jdbcTemplate.queryForObject(getIdStudent, new Object[]{id}, new StudentMapper());
    }

    @Override
    public List<StudentDTO> findAll() {
        log.info("Произведен показ всех студентов");
        return jdbcTemplate.query(findAllStudent, new StudentMapper())
                .stream()
                .map(mapper::convertStudentToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, Integer age) {
        log.info("Произведено обновление данных о студенте " + id + " " + age);
        jdbcTemplate.update(update, id, age);
    }

    @Override
    public void delete(Integer id) {
        log.info("Произведено удаление студента" + id);
        jdbcTemplate.update(deleteStudent, id);
    }

    @Override
    public String findStudentNameById(Integer id) {
        log.info("Поиск имени студента по идентификатору ID " + id);
        return jdbcTemplate.queryForObject(findNameByIdStudentT, new Object[]{id}, String.class);
    }
}
