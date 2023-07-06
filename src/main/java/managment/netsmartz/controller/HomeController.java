package managment.netsmartz.controller;

import managment.netsmartz.modal.Student;
import managment.netsmartz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/forget")
    public String forget() {
        return "forget";
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("REGISTED CALLED");
        return "register";
    }

    @PostMapping("/insert")
    public String insertStudent(@ModelAttribute Student student) {
        System.out.println("CALLED\n" + student);
        studentService.insertStudent(student);
        return "redirect:/register";

    }

}
