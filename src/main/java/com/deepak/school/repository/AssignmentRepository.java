package com.deepak.school.repository;

import com.deepak.school.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment,Integer>{

}
