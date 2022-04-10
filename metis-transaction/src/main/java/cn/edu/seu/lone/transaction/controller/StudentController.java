package cn.edu.seu.lone.transaction.controller;

import cn.edu.seu.lone.transaction.entity.Student;
import cn.edu.seu.lone.transaction.entity.repository.StudentRepository;
import cn.edu.seu.lone.transaction.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/name/{name}")
    public Student getStudentList(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }
}
