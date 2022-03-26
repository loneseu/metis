package cn.edu.seu.lone.transaction.entity.repository;

import cn.edu.seu.lone.transaction.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindStudentByName() {
        Student student = studentRepository.findStudentByName("lone");
        System.out.println(student);
    }
}