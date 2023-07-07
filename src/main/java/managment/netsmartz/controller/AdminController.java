package managment.netsmartz.controller;

import managment.netsmartz.modal.Admin;
import managment.netsmartz.modal.Course;
import managment.netsmartz.service.AdminService;
import managment.netsmartz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private CourseService courseService;

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
    public String getAllCourse(Model model) {
        //TODO DISPLAY COURSES AND THEIR DETAILS
//        List<Course> courseList = courseService.getAll();
//        System.out.println(courseList);
//        model.addAttribute("courseList", courseList);
        return "/admin/getAllCourse";
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
