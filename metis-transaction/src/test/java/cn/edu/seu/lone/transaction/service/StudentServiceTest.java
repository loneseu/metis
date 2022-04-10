package cn.edu.seu.lone.transaction.service;

import cn.edu.seu.lone.transaction.entity.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testGetStudentByName() {
        Student student = studentService.getStudentByName("lone");
        log.info("student = {}", student);
    }

    @Test
    public void testTransactionCreateTransactionWithArithmeticException() {
        // 运行时异常会回滚事务
        Student student = Student.builder()
                .name("Kayla")
                .age(27)
                .class_number("411")
                .build();
        Student result = studentService.createTransactionWithArithmeticException(student);
        log.info("result = {}", result);
    }

    @Test
    public void testTransactionCreateTransactionWithIOException() throws IOException {
        // IO异常不回滚事务
        Student student = Student.builder()
                .name("Kayla")
                .age(27)
                .class_number("411")
                .build();
        Student result = studentService.createTransactionWithIOException(student);
        log.info("result = {}", result);
    }

    @Test
    public void testCreateWithNoTransaction() {
        // 没有transaction注解，不回滚
        Student student = Student.builder()
                .name("Kayla")
                .age(27)
                .class_number("411")
                .build();
        Student result = studentService.createWithNoTransaction(student);
        log.info("result = {}", result);
    }

    @Test
    public void testCreateTransactionWithIOExceptionAndRollbackOn() throws IOException {
        // 设置 rollbackOn = Exception.class 回滚
        Student student = Student.builder()
                .name("Kayla")
                .age(27)
                .class_number("411")
                .build();
        Student result = studentService.createTransactionWithIOExceptionAndRollbackOn(student);
        log.info("result = {}", result);
    }


    @Test
    public void testCreateTransactionWithArithmeticExceptionWithTryCatch() {
        Student student = Student.builder()
                .name("Kayla")
                .age(27)
                .class_number("411")
                .build();
        Student result = studentService.createTransactionWithArithmeticExceptionWithTryCatch(student);
        log.info("result = {}", result);
    }

}