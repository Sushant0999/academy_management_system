package managment.netsmartz.controller;

import managment.netsmartz.modal.Admin;
import managment.netsmartz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/insert")
    public Admin insertAdmin(@RequestBody Admin admin) {
        return adminService.insertAdmin(admin);
    }

    @GetMapping("/get/{id}")
    public Optional<Admin> getAdmin(@PathVariable Integer id) {
        return adminService.getAdmin(id);
    }

    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }
}
