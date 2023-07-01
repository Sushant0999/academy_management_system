package managment.netsmartz.service;

import managment.netsmartz.modal.Admin;
import managment.netsmartz.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin insertAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdmin(Integer id) {
        return adminRepository.findById(id);
    }

    public Admin updateAdmin(Integer id, Admin admin) {
        Admin adminOld = adminRepository.findById(id).get();
        if (adminOld != null) {
            adminOld.setName(admin.getName());
            adminOld.setEmail(admin.getEmail());
            adminOld.setPassword(admin.getPassword());
            adminOld.setUsername(admin.getUsername());
            adminRepository.save(adminOld);
            return adminRepository.save(adminOld);
        } else {
            System.out.println("NOT FOUND");
            return null;
        }
    }

}
