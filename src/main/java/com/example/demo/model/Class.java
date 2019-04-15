package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Objects;

public class Class {

    String code;

    String title;

    String description;

    @JsonIgnore
    List<Student> students;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return code.equals(aClass.code) &&
                Objects.equals(title, aClass.title) &&
                Objects.equals(description, aClass.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title, description);
    }
}
