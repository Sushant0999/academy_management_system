package managment.netsmartz.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    private Logger logger = LoggerFactory.getLogger(PdfService.class);

    public ByteArrayInputStream createPdf() {
        logger.info("Create Pdf Started");

        String title = "Welcome";
        String content = "Some Random Text";

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            Document document = new Document();
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25);
            Paragraph titleParagraph = new Paragraph(title, titleFont);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 10);
            Paragraph paragraph = new Paragraph(content, paraFont);
//        paragraph.add(new Chunk("SOme thibk"));
            document.add(paragraph);

            document.close();
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(null);
    }

}
