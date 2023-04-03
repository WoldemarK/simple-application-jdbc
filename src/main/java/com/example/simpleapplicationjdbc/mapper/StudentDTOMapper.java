package com.example.simpleapplicationjdbc.mapper;

import com.example.simpleapplicationjdbc.DTO.StudentDTO;
import com.example.simpleapplicationjdbc.DTO.StudentDTOIn;
import com.example.simpleapplicationjdbc.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDTOMapper implements StudentDTOIn {
    @Override
    public StudentDTO convertStudentToDto(Student student) {
        return StudentDTO.builder()
                .id(student.getId())
                .age(student.getAge())
                .name(student.getName())
                .build();
    }
    @Override
    public Student convertDtoToStudent(StudentDTO studentDTO) {
        return Student.builder()
                .id(studentDTO.getId())
                .age(studentDTO.getAge())
                .name(studentDTO.getName())
                .build();
    }
}
