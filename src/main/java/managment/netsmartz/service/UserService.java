package managment.netsmartz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    public UserDetails createUser(UserDetails user);

    public List<UserDetails> getAllUser();

    public boolean checkEmail(String email);

    public Page<UserDetails> getAll(PageRequest pageRequest);

    public Page<UserDetails> getPaginated(int page, int pageSize);

    public void updateResetPasswordToken(String token, String email);

    public UserDetails getResetPasswordToken(String token);

    public void updatePassword(UserDetails user, String newPassword);

}
