package com.deepak.school.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @OneToOne
    private User user;
}
