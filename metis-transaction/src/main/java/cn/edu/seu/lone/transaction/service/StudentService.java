package cn.edu.seu.lone.transaction.service;

import cn.edu.seu.lone.transaction.entity.Student;
import cn.edu.seu.lone.transaction.entity.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentByName(String name) {
        return  studentRepository.findStudentByName(name);
    }

    @Transactional
    public Student createTransactionWithArithmeticException(Student student) throws ArithmeticException {
        // ArithmeticException 是 RuntimeException
        studentRepository.save(student);
        throw new ArithmeticException();
    }

    @Transactional
    public Student createTransactionWithIOException(Student student) throws IOException {
        // IOException 不是 RuntimeException
        studentRepository.save(student);
        throw new IOException();
    }

    public Student createWithNoTransaction(Student student) {
        studentRepository.save(student);
        throw new ArithmeticException();
    }

    @Transactional(rollbackOn = Exception.class)
    public Student createTransactionWithIOExceptionAndRollbackOn(Student student) throws IOException {
        studentRepository.save(student);
        throw new IOException();
    }


    @Transactional
    public Student createTransactionWithArithmeticExceptionWithTryCatch(Student student) {
        Student result = studentRepository.save(student);
        try {
            throw new ArithmeticException();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
