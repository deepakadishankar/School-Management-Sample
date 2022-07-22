package com.deepak.school.repository;

import com.deepak.school.entity.Subject;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    List<Subject> findByClassesId(Integer id);
}
