package managment.netsmartz.repository;

import managment.netsmartz.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface StudentRepository extends JpaRepository<Student, Integer> {
//    public boolean existsByEmail(String email);
//
//    public UserDetails findByEmail(String email);
//
//    public UserDetails findByResetPasswordToken(String resetPasswordToken);

}
