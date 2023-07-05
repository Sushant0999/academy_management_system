package managment.netsmartz.service;

import managment.netsmartz.modal.Student;
import org.springframework.stereotype.Service;
import com.itextpdf.layout.Document;
import  com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;


import java.io.OutputStream;
import java.util.List;

@Service
    public class PdfGeneratorService {

        public void generatePdf(List<Student> students, OutputStream outputStream) throws Exception {
            String file
                    = "C:/Test/DocumentPDF/Sample.pdf";

            // Creating a PdfDocument object
            PdfDocument pdfDoc
                    = new PdfDocument(new PdfWriter(file));

            // Creating a Document object
            Document document = new Document(pdfDoc);

//            PdfWriter.getInstance(document, outputStream);
//            document.open();

            // Add content to the PDF document
            addContent(document, students);

            document.close();
        }

        private void addContent(Document document, List<Student> students) throws Exception {
            for (Student student : students) {
                document.add(new Paragraph("id: " + student.getId()));
                document.add(new Paragraph("Name: " + student.getName()));
                document.add(new Paragraph("Email: " + student.getEmail()));
                document.add(new Paragraph("---------------------------------------"));
            }
        }
    }


