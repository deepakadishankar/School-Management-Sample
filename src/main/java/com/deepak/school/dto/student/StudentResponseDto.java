package com.deepak.school.dto.student;

import com.deepak.school.entity.Class;
import com.deepak.school.entity.User;
import lombok.Data;

import java.util.Date;
@Data
public class StudentResponseDto {
    int studentId;
    String username;
    String displayName;
    String email;
    Date dateOfBirth;
    String className;
}
