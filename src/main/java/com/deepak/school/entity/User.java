package com.deepak.school.entity;

import ch.qos.logback.classic.db.names.ColumnName;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "users", uniqueConstraints = {@UniqueConstraint(name = "uk_user_username",
//             columnNames = {"username"}),   @UniqueConstraint(name = "uk_user_email",
//             columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "display_name")
    private String displayName;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "role")
    private String role;
}
