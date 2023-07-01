package managment.netsmartz.controller;

import managment.netsmartz.modal.Student;
import managment.netsmartz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

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

    @GetMapping("/get/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id) {
        return studentService.findStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

}
