package com.deepak.school.repository;

import com.deepak.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    @Query("SELECT u FROM Student u WHERE u.classes.id = ?1")
    List<Student> findAllWithClassId(int class_id);
}
