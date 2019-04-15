package com.example.demo.service;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import java.util.List;

public interface IStudentService {

    Student create(Student t);

    Student update(Student t);

    Student read(Integer id);

    List<Student> list();

    List<Student> findBy(String value);

    void delete(Integer id);

    List<Class> classesByStudent(Integer id);
}
