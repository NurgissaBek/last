package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();
    private long currentId = 1;

    public List<Student> getAllStudents() {
        return students;
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    public void addStudent(Student student) {
        student.setId(currentId++);
        students.add(student);
    }

    public void updateStudent(Student updatedStudent) {
        students.stream()
                .filter(student -> student.getId().equals(updatedStudent.getId()))
                .findFirst()
                .ifPresent(student -> {
                    student.setName(updatedStudent.getName());
                    student.setAge(updatedStudent.getAge());
                    student.setCourse(updatedStudent.getCourse());
                });
    }

    public void deleteStudent(Long id) {
        students.removeIf(student -> student.getId().equals(id));
    }
}
