package com.deepak.school.service;

import com.deepak.school.entity.Class;
import com.deepak.school.entity.Subject;
import com.deepak.school.errorHandling.NotFoundException;
import com.deepak.school.repository.ClassRepository;
import com.deepak.school.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    ClassRepository classRepository;

    public Subject createSubject(Subject subject){
        int classId = subject.getClasses().getId();
        Class classes = classRepository.findById(classId).get();
        subject.getClasses().setName(classes.getName());
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(int id, Subject subject) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()){
            Subject selectedSubject = optionalSubject.get();

            selectedSubject.setName(subject.getName());

            Class classes = classRepository.findById(subject.getClasses().getId()).get();
            selectedSubject.setClasses(classes);
            subjectRepository.save(selectedSubject);
            return selectedSubject;
        }else throw new NotFoundException("id: "+id);
    }

    public Subject getSubject(int id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            return optionalSubject.get();
        } else throw new NotFoundException("id:" + id);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public List<Subject> getAllSubjectsByClassId(Integer id) {
        return subjectRepository.findByClassesId(id);
    }
}
