package com.example.demo.controller;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import com.example.demo.service.IClassService;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    private IClassService classService;

    @GetMapping
    public ResponseEntity getClasses(@RequestParam(name = "search", required = false)String search) {
        if (search != null) {
            ResponseEntity.ok(classService.findBy(search));
        }
        return ResponseEntity.ok(classService.list());
    }

    @GetMapping("/{code}")
    public ResponseEntity getClass(@PathVariable("code") String code) {
        return ResponseEntity.ok(classService.read(code));
    }

    @PostMapping
    public ResponseEntity createClass(@RequestBody Class c) {
        return ResponseEntity.status(HttpStatus.CREATED).body(classService.create(c));
    }

    @PutMapping
    public ResponseEntity updateClass(@RequestBody Class c) {
        return ResponseEntity.ok(classService.update(c));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity deleteClass(@PathVariable("code") String code) {
        classService.delete(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{code}/students")
    public ResponseEntity assignStudents(@PathVariable("code") String code, @RequestBody List<Student> students) {
        return ResponseEntity.ok(classService.assignStudents(code, students));
    }

    @GetMapping("/{code}/students")
    public ResponseEntity getStudents(@PathVariable("code") String code) {
        return ResponseEntity.ok(classService.studentList(code));
    }
}
