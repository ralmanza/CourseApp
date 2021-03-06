package com.example.demo.service.impl;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import com.example.demo.repository.IClassRepo;
import com.example.demo.repository.IStudentRepo;
import com.example.demo.repository.impl.ClassRepo;
import com.example.demo.repository.impl.StudentRepo;
import com.example.demo.service.IStudentService;
import com.example.demo.utils.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    private IStudentRepo studentRepo;

    private IClassRepo classRepo;

    public StudentService() {
        this.studentRepo = StudentRepo.getInstance();
        this.classRepo = ClassRepo.getInstance();
    }

    @Override
    public Student create(Student student) {
        return studentRepo.create(student);
    }

    @Override
    public Student update(Student student) {
        if (studentRepo.read(student.getId()) == null) {
            throw new ResourceNotFoundException(String.format("Student with id %d not found", student.getId()));
        }
        return studentRepo.update(student);
    }

    @Override
    public Student read(Integer id) {
        Student student  = studentRepo.read(id);
        if (student == null) {
            throw new ResourceNotFoundException(String.format("Student with id %d not found", id));
        }
        return studentRepo.read(id);
    }

    @Override
    public List<Student> list() {
        return studentRepo.list();
    }

    @Override
    public List<Student> findBy(String value) {
        return studentRepo.findBy(value);
    }

    @Override
    public void delete(Integer id) {
        studentRepo.delete(id);
    }

    @Override
    public List<Class> classesByStudent(Integer id) {
        return classRepo.classesByStudent(id);
    }
}

