package com.deepak.school.repository;

import com.deepak.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    @Query("SELECT u FROM Teacher u WHERE u.specialization = ?1")
    List<Teacher> findAllBySpecialization(String specialization);
}
