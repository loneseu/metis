package cn.edu.seu.lone.transaction.entity.repository;

import cn.edu.seu.lone.transaction.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByName(String name);

}
