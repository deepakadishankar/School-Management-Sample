package com.deepak.school.dto.student;

import com.deepak.school.entity.Class;
import com.deepak.school.entity.User;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;
@Data
public class StudentRequestDto {
    String username;
    String password;
    String displayName;
    String email;
    Date dateOfBirth;
    int classId;
}
