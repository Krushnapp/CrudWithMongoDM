package com.Alphaware.CrudWithMongoDM.Controller;

import com.Alphaware.CrudWithMongoDM.CustomException.CustomExceptions;
import com.Alphaware.CrudWithMongoDM.Model.Student;
import com.Alphaware.CrudWithMongoDM.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private StudentRepo studentRepo;


    @GetMapping("/students")
    public List<Student> getAllStudents() {
        try {
            return studentRepo.findAll();
        } catch (Exception e) {
            throw new CustomExceptions.CustomException("Failed to retrieve students", e);
        }
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        try {
            return studentRepo.save(student);
        } catch (Exception e) {
            throw new CustomExceptions.CustomException("Failed to add student", e);
        }
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        Student student = studentRepo.findById(id).orElse(null);
        if (student == null) {
            throw new CustomExceptions.ResourceNotFoundException("Student with ID " + id + " not found");
        }
        return student;
    }

    @PutMapping("/students/{rollno}")
    public Student updateStudent(@PathVariable Integer rollno, @RequestBody Student updatedStudent) {
        try {
            Student existingStudent = studentRepo.findById(rollno).orElse(null);
            if (existingStudent != null) {
                existingStudent.setName(updatedStudent.getName());
                existingStudent.setAddress(updatedStudent.getAddress());
                return studentRepo.save(existingStudent);
            } else {
                throw new CustomExceptions.ResourceNotFoundException("Student with roll number " + rollno + " not found");
            }
        } catch (Exception e) {
            throw new CustomExceptions.CustomException("Failed to update student", e);
        }
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        try {
            studentRepo.deleteById(id);
            return "Student with ID " + id + " deleted successfully.";
        } catch (Exception e) {
            throw new CustomExceptions.CustomException("Failed to delete student", e);
        }
    }


}

