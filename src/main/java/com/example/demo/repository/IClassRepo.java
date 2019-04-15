package com.example.demo.repository;

import com.example.demo.model.Class;
import com.example.demo.model.Student;

import java.util.List;

public interface IClassRepo {

    Class create(Class c);

    Class update(Class c);

    Class read(String code);

    void delete(String code);

    List<Class> list();

    List<Class> findBy(String value);

    List<Class> classesByStudent(Integer id);
}
