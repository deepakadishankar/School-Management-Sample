package com.deepak.school.dto.teacher;

import com.deepak.school.entity.Class;
import com.deepak.school.entity.Subject;
import com.deepak.school.entity.User;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class TeacherRequestDto {

    String username;
    String password;
    String displayName;
    String email;
    Date dateOfBirth;
    String specialization;
}
