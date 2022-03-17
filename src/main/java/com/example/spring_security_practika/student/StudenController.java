package com.example.spring_security_practika.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudenController {

    private static final List<Student> STUDENT= Arrays.asList(
            new Student(1,"Muxammed"),
            new Student(2,"Raxim"),
            new Student(3,"Meder")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        return STUDENT.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Student" + studentId + "does not exists"));
    }
}
