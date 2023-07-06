package managment.netsmartz.controller;

import managment.netsmartz.modal.Admin;
import managment.netsmartz.modal.Course;
import managment.netsmartz.service.AdminService;
import managment.netsmartz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
//    @PreAuthorize("hasRole('ADMIN')")
    public String course() {
        return "/admin/course";
    }

    @GetMapping("/addCourse")
    @PreAuthorize("hasRole('ADMIN')")
    public String addCourse() {
        return "/admin/addCourse";
    }

    @PostMapping("/insertCourse")
    @PreAuthorize("hasRole('ADMIN')")
    public String insertCourse(@ModelAttribute Course course) {
        System.out.println(course);
        courseService.insertCourse(course);
        return "redirect:/addCourse";
    }

    @GetMapping("/getAllCourse")
    public ResponseEntity<String> getAllCourse(Model model) {
        List<Course> courseList = courseService.getAll();
        System.out.println(courseList);
        if (courseList != null) {
            model.addAttribute("courseList", courseList);
            System.out.println("m" + model);
            System.out.println("c" + courseList);
            return ResponseEntity.ok("admin/course");
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public String signup() {
        return "/admin/register";
    }

    @GetMapping("/home")
    @PreAuthorize("hasRole('ADMIN')")
    public String home() {
        return "/admin/home";
    }

    @GetMapping("/student")
    @PreAuthorize("hasRole('ADMIN')")
    public String student() {
        return "/admin/student";
    }

    @PostMapping("/insert")
    @PreAuthorize("hasRole('ADMIN')")
    public Admin insertAdmin(@RequestBody Admin admin) {
        return adminService.insertAdmin(admin);
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<Admin> getAdmin(@PathVariable Integer id) {
        return adminService.getAdmin(id);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Admin updateAdmin(@PathVariable Integer id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }
}
