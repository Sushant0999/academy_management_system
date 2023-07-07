package managment.netsmartz.repository;

import managment.netsmartz.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public boolean existsByEmail(String email);
    public Student findByEmail(String email);
}
