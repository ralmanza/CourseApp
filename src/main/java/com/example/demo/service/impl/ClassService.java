package com.example.demo.service.impl;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import com.example.demo.repository.IClassRepo;
import com.example.demo.repository.impl.ClassRepo;
import com.example.demo.service.IClassService;
import com.example.demo.utils.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {

    private IClassRepo classRepo;

    public ClassService() {
        this.classRepo = ClassRepo.getInstance();
    }

    @Override
    public Class create(Class c) {
        return classRepo.create(c);
    }

    @Override
    public Class update(Class c) {
        if (classRepo.read(c.getCode()) == null) {
            throw new ResourceNotFoundException(String.format("Class with code %s not found", c.getCode()));
        }
        return classRepo.update(c);
    }

    @Override
    public Class read(String code) {
        Class c = classRepo.read(code);
        if (c == null) {
            throw new ResourceNotFoundException(String.format("Class with code %s not found", code));
        }
        return c;
    }

    @Override
    public List<Class> list() {
        return classRepo.list();
    }

    @Override
    public List<Class> findBy(String search) {
        return classRepo.findBy(search);
    }

    @Override
    public void delete(String code) {
        classRepo.delete(code);
    }

    @Override
    public List<Student> studentList(String code) {
        return classRepo.read(code).getStudents();
    }

    @Override
    public List<Student> assignStudents(String code, List<Student> students) {
        Class c = classRepo.read(code);

        if (c != null) {
            c.setStudents(students);
        }

        return students;
    }
}

