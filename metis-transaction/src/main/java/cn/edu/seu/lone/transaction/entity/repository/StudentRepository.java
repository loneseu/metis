package cn.edu.seu.lone.transaction.entity.repository;

import cn.edu.seu.lone.transaction.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    Student findStudentByName(String name);

}
