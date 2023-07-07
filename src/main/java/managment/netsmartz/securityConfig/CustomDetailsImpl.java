package managment.netsmartz.securityConfig;

import managment.netsmartz.modal.Student;
import managment.netsmartz.repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailsImpl implements UserDetailsService {

    private StudentRepository studentRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student student = studentRepo.findByEmail(email);
        if (student != null) {
            return new CustomDetails(student);
        }
        throw new UsernameNotFoundException("USER NOT FOUND");
    }
}
