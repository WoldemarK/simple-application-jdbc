package com.example.simpleapplicationjdbc;

import com.example.simpleapplicationjdbc.entity.Student;
import com.example.simpleapplicationjdbc.mapper.StudentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class StudentDAOImplTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    @DisplayName("find-All-Users")
    void findAllUsersTest() {
        String sql = "select * from Student ;";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        assertEquals(1     , students.size());
        students.forEach(System.out::println);
    }
}
