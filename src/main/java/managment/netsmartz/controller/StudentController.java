package managment.netsmartz.controller;

import managment.netsmartz.modal.Student;
import managment.netsmartz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/insert")
    public Student insertStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentService.insertStudent(student);
    }

}
