/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Alexander W. Hørsted-Andersen <awha86@gmail.com>
 */
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.activation.DataSource;
import org.apache.commons.mail.*;

public class GeneratePDF {

    static String dest = "C:/itextExamples/GeneratedPDF.pdf";

    public static MultiPartEmail createPDF(String customer, Inquiry inquiry, BillOfMaterials bom) throws FileNotFoundException, IOException, EmailException {

        //TODO Generate PDF file from input, return as bytestream?
        // Creating a PdfDocument object   
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument object      
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document object       
        Document doc = new Document(pdf);

        // Creating a table       
        float[] pointColumnWidths = {150F, 150F, 150F};
        Table table = new Table(pointColumnWidths);

        // Adding cells to the table       
        table.addCell(new Cell().add("Name"));
        table.addCell(new Cell().add("Raju"));
        table.addCell(new Cell().add("Id"));
        table.addCell(new Cell().add("1001"));
        table.addCell(new Cell().add("Designation"));
        table.addCell(new Cell().add("Programmer"));

        // Adding Table to document        
        doc.add(table);

        // Closing the document       
        doc.close();
        System.out.println("Table created successfully..");

        //write PDF to outputStream
        return sendEmail(loadFile(dest));
    }

    public static byte[] loadFile(String sourcePath) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(sourcePath);
            return readFully(inputStream);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static MultiPartEmail sendEmail(byte[] byteArray) throws EmailException, IOException {

        // create the mail
        MultiPartEmail email = new MultiPartEmail();

        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("awha86", "Awha0502862103"));
        email.setSSL(true);
        email.setFrom("awha86@gmail.com");
        email.addTo("awha86@gmail.com", "A Lex");
        email.setFrom("awha86@gmail.com", "A Lex");
        email.setSubject("ITS ALIVE");
        email.setMsg("test test");

        System.out.println("worked???");
        DataSource source = new ByteArrayDataSource(byteArray, "application/pdf");
        source.getInputStream().close();
        // add the attachment
        email.attach(source, "result.pdf", "Description of some file");

        // send the email
//        email.send();  //TODO UNCOMMENT TO ENABLE SENDING
        System.out.println("great succes");
        return email;
    }

    public static byte[] readFully(InputStream stream) throws IOException {
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }
}
