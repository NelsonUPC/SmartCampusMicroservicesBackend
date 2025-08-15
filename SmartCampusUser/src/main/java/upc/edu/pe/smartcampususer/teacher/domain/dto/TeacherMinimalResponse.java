package upc.edu.pe.smartcampususer.teacher.domain.dto;

import lombok.Data;

@Data
public class TeacherMinimalResponse {
    private Long id;
    private String email;
    private String password;
}