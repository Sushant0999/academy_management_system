package managment.netsmartz;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class NetsmartzApplication {

    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(NetsmartzApplication.class, args);
//        // 1) Create Instance a object from the class com.lowagie.text.Document
//        Document myPDFDoc = new Document();
//
//        try {
//            //2) Create a FileOutputStream object with the path and name of the file
//            FileOutputStream pdfOutputFile = new FileOutputStream("./sample1.pdf");
//
//            //3) Now we get a file writer instance from the class com.lowagie.text.pdf.PdfWriter
//            final PdfWriter pdfWriter = PdfWriter.getInstance(myPDFDoc, pdfOutputFile);
//
//            //4) Once the Filewritter is set up we can open
//            //   the document and start adding content
//            myPDFDoc.open();  // Open the Document
//
//            // Add a text within a Paragraph
//            // (we can add objects from classes implementing the interface com.lowagie.text.Element )
//            myPDFDoc.add(new Paragraph("This is a simple PDF created with openPDF"));
//
//            myPDFDoc.close(); //5) Close the Document
//
//            pdfWriter.close();//6) close the File writer
//
//        } catch (IOException de) {
//            System.err.println(de.getMessage());
//        }
    }

}
