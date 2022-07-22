package com.deepak.school.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exam {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    private Class aClass;
}
