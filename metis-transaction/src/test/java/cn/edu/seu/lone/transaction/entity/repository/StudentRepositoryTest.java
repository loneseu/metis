package cn.edu.seu.lone.transaction.entity.repository;

import cn.edu.seu.lone.transaction.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindStudentByName() {
        Student student = studentRepository.findStudentByName("lone");
        System.out.println(student);
    }

    @Test
    public void testSave() {
        Student student = Student.builder()
                .name("Kayla")
                .age(27)
                .class_number("411")
                .build();
        Student result = studentRepository.save(student);
        log.info("result = {}", result);
    }
}