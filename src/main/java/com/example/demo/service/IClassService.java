package com.example.demo.service;

import com.example.demo.model.Class;
import com.example.demo.model.Student;

import java.util.List;

public interface IClassService {

    Class create(Class t);

    Class update(Class t);

    Class read(String code);

    List<Class> list();

    List<Class> findBy(String search);

    void delete(String code);

    List<Student> studentList(String code);

    List<Student> assignStudents(String code, List<Student> students);
}
