package managment.netsmartz.repository;

import managment.netsmartz.modal.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
