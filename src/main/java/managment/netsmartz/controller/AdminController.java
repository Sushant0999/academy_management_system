package managment.netsmartz.controller;

import managment.netsmartz.modal.Admin;
import managment.netsmartz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @GetMapping("/course")
    public String course() {
        return "/admin/course";
    }

    @GetMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public String signup() {
        return "/admin/register";
    }

    @GetMapping("/home")
    public String home() {
        return "/admin/home";
    }

    @GetMapping("/student")
    public String student() {
        return "/admin/student";
    }

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
