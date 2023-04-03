package com.example.simpleapplicationjdbc.DTO;

import com.example.simpleapplicationjdbc.entity.Student;

public interface StudentDTOIn {
    StudentDTO convertStudentToDto(Student student);

    Student convertDtoToStudent(StudentDTO studentDTO);
}
