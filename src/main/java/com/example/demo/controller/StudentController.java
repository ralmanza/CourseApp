package com.example.demo.controller;

import com.example.demo.model.Class;
import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService estudentService;

    @GetMapping
    public ResponseEntity getEstudents(@RequestParam(name = "search", required = false)String search) {
        if (search != null) {
            return ResponseEntity.ok(estudentService.findBy(search));
        }
        return ResponseEntity.ok(estudentService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity getEstudent(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(estudentService.read(id));
    }

    @PostMapping
    public ResponseEntity createEstudent(@RequestBody Student est) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudentService.create(est));
    }

    @PutMapping
    public ResponseEntity updateEstudent(@RequestBody Student est) {
        return ResponseEntity.ok(estudentService.update(est));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEstudent(@PathVariable("id") Integer id) {
        estudentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/classes")
    public ResponseEntity getClasses(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(estudentService.classesByStudent(id));
    }
}
