package com.deepak.school.dto.user;

import javax.persistence.Column;
import java.util.Date;

public class UserRequestDto {

    private String username;
    private String password;
    private String displayName;
    private String email;
    private Date dateOfBirth;
    private String role;
}
