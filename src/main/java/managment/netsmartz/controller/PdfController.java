package managment.netsmartz.controller;

import jakarta.servlet.http.HttpServletResponse;
import managment.netsmartz.modal.Student;
import managment.netsmartz.service.PdfGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PdfController {

    private final PdfGeneratorService pdfGeneratorService;

    public PdfController(PdfGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/generate-pdf")
    public void generatePdf(HttpServletResponse response) throws IOException , Exception{
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=student_data.pdf");

        List<Student> students = getStudentData(); // Retrieve student data from a data source

        OutputStream outputStream = response.getOutputStream();
        pdfGeneratorService.generatePdf(students, outputStream);
        outputStream.close();
    }

    private List<Student> getStudentData() {
        // Retrieve student data from a data source such as a database
        // For demonstration purposes, we'll create dummy data

        List<Student> students = new ArrayList<>();

        students.add(new Student(1," vanshika", "vanshikamisra73@gmail.com"));
        students.add(new Student(2," vansh", "vanshmisra73@gmail.com"));
        students.add(new Student(3," vanshi", "vanshimisra73@gmail.com"));

        return students;
    }
}

