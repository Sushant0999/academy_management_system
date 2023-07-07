package managment.netsmartz.securityConfig;

import managment.netsmartz.modal.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomDetails implements UserDetails {
    private Student studentDetails;

    public CustomDetails(Student studentDetails) {
        this.studentDetails = studentDetails;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(studentDetails.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return studentDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return studentDetails.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
