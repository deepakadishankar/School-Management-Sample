package com.deepak.school.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SubjectTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Transient
    Year academicYear;
    @OneToOne
    Subject subject;
    @OneToOne
    Teacher teacher;
}
