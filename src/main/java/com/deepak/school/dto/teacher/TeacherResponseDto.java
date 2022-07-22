package com.deepak.school.dto.teacher;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherResponseDto {
    int teacherID;
    String username;
    String displayName;
    String email;
    Date dateOfBirth;
    String specialization;

}
