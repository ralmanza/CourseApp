package com.example.demo.repository.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.IStudentRepo;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo {

    private List<Student> studentList;

    private static StudentRepo instance;

    private StudentRepo() {
        this.studentList = new ArrayList();
    }

    public static StudentRepo getInstance() {
        if (instance == null) {
            instance = new StudentRepo();
        }

        return instance;
    }

    @Override
    public Student create(Student s) {
        s.setId(studentList.size() + 1);
        studentList.add(s);
        return  s;
    }

    @Override
    public Student update(Student s) {
        Student student = read(s.getId());
        if (student != null) {
            student.setFirstName(s.getFirstName());
            student.setLastName(s.getLastName());
        }

        return s;
    }

    @Override
    public Student read(Integer id) {
        return studentList.stream().filter(s -> s.getId().equals(id)).findAny().orElse(null);
    }

    @Override
    public void delete(Integer id) {
        studentList.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public List<Student> list() {
        return studentList;
    }

    @Override
    public List<Student> findBy(String value) {
        List<Student> list = new ArrayList();
        for (Student s: studentList) {
            if (s.getFirstName().contains(value) || s.getLastName().contains(value)) {
                list.add(s);
            }
        }
        return list;
    }
}
