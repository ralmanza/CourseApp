package com.example.demo.repository.impl;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import com.example.demo.repository.IClassRepo;

import java.util.ArrayList;
import java.util.List;

public class ClassRepo implements IClassRepo {

    private List<Class> classList;

    private static ClassRepo instance;

    private ClassRepo() {
        this.classList = new ArrayList();
    }

    public static ClassRepo getInstance() {
        if (instance == null) {
            instance = new ClassRepo();
        }

        return instance;
    }

    @Override
    public Class create(Class s) {
        s.setCode(String.valueOf(classList.size() + 1));
        s.setStudents(new ArrayList());
        classList.add(s);
        return  s;
    }

    @Override
    public Class update(Class s) {
        Class c = read(s.getCode());
        if (c != null) {
            c.setTitle(s.getTitle());
            c.setDescription(s.getDescription());
        }

        return s;
    }

    @Override
    public Class read(String code) {
        return classList.stream().filter(s -> s.getCode().equals(code)).findAny().orElse(null);
    }

    @Override
    public void delete(String code) {
        classList.removeIf(s -> s.getCode().equals(code));
    }

    @Override
    public List<Class> list() {
        return classList;
    }

    @Override
    public List<Class> findBy(String value) {
        List<Class> list = new ArrayList();
        for (Class aClass: classList) {
            if (aClass.getTitle().contains(value) || aClass.getDescription().contains(value)) {
                list.add(aClass);
            }
        }
        return list;
    }

    @Override
    public List<Class> classesByStudent(Integer id) {
        List<Class> list = new ArrayList();
        for (Class aClass: classList) {
            for (Student student: aClass.getStudents()) {
                if (student.getId().equals(id)) {
                    list.add(aClass);
                    break;
                }
            }
        }
        return list;
    }
}
