package managment.netsmartz.service;

import managment.netsmartz.modal.Admin;
import managment.netsmartz.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin insertAdmin(Admin admin){
        return adminRepository.save(admin);
    }

}
