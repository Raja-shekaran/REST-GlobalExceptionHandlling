package com.raja.demo.rest;


import com.raja.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    private List<Student> theStudents;
    @PostConstruct
    public void loadData()
    {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Raja", "Malik"));
        theStudents.add(new Student("Thala", "Thalapathy"));

    }
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if(studentId < 0 || studentId >= theStudents.size())
        {
            throw new StudentNotFoundException("Student id not found - " +studentId);
        }
        return theStudents.get(studentId);
    }



}
