package com.example.demo.repository;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import java.util.List;

public interface IStudentRepo {

    Student create(Student t);

    Student update(Student t);

    Student read(Integer id);

    void delete(Integer id);

    List<Student> list();

    List<Student> findBy(String value);
}
