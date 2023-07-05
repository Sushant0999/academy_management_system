package managment.netsmartz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImpl implements UserService{


    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails createUser(UserDetails user) {
        return null;
    }

    @Override
    public List<UserDetails> getAllUser() {
        return null;
    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }

    @Override
    public Page<UserDetails> getAll(PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<UserDetails> getPaginated(int page, int pageSize) {
        return null;
    }

    @Override
    public void updateResetPasswordToken(String token, String email) {

    }

    @Override
    public UserDetails getResetPasswordToken(String token) {
        return null;
    }

    @Override
    public void updatePassword(UserDetails user, String newPassword) {

    }
}
