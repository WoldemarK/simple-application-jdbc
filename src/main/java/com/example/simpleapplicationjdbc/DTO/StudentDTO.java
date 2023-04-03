package com.example.simpleapplicationjdbc.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private Integer id;
    private Integer age;
    private String name;


}
