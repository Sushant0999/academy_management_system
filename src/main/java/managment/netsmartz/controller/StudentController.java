package managment.netsmartz.controller;

import managment.netsmartz.modal.Student;
import managment.netsmartz.service.PdfService;
import managment.netsmartz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PdfService pdfService;

    @GetMapping("/home")
    @PreAuthorize("hasRole('USER')")
    public String home() {
        return "/user/home";
    }



    @GetMapping("/get/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id) {
        return studentService.findStudent(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(value = "/pdf", produces = "application/pdf")
    public ResponseEntity<InputStreamResource> createPdf(){
        ByteArrayInputStream pdf = pdfService.createPdf();
        HttpHeaders httpHeaders = new HttpHeaders();httpHeaders.add("Content-Disposition", "initial;file=StudentName.pdf");
        return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(pdf));
    }


}
