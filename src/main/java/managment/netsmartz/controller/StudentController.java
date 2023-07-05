package managment.netsmartz.controller;

import managment.netsmartz.modal.Student;
import managment.netsmartz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/home")
    public String home(){
        return "/user/home";
    }

    @GetMapping("/login")
    public String login(){
        System.out.println("CALLED LOGIN");
        return "/user/login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "/user/signup";
    }

    @GetMapping("/forget")
    public String forget(){
        return "/user/forget";
    }

    @Autowired
    private StudentService studentService;

    @PostMapping("/insert")
    public Student insertStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentService.insertStudent(student);
    }

    @GetMapping("/get/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id) {
        return studentService.findStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }


}
