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

    public static MultiPartEmail createPDF(Customer customer, Inquiry inquiry, BillOfMaterials bom) throws FileNotFoundException, IOException, EmailException {

        //TODO Generate PDF file from input, return as bytestream?
        // Creating a PdfDocument object   
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument object      
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document object       
        Document doc = new Document(pdf);

        //Creating customer table
        float[] pointColumnWidthsCustomer = {50F, 50F};  //2 wide
        Table table_cus = new Table(pointColumnWidthsCustomer);
        table_cus.addCell(new Cell().add("Kunde info"));
        table_cus.addCell(new Cell().add(""));
        table_cus.addCell(new Cell().add("Email"));
        table_cus.addCell(new Cell().add(customer.getEmail()));
        table_cus.addCell(new Cell().add("Name"));
        table_cus.addCell(new Cell().add(customer.getName()));
        table_cus.addCell(new Cell().add("Surname"));
        table_cus.addCell(new Cell().add(customer.getSurname()));
        table_cus.addCell(new Cell().add("Phonenumber"));
        table_cus.addCell(new Cell().add(customer.getPhonenumber()+""));
        table_cus.addCell(new Cell().add("Address"));
        table_cus.addCell(new Cell().add(customer.getAddress()));
        table_cus.addCell(new Cell().add("Zipcode"));
        table_cus.addCell(new Cell().add(customer.getZipcode()+""));
        
        doc.add(table_cus);
        
        
        // Creating bom table       
        float[] pointColumnWidthsBom = {50F, 50F, 50F, 50F, 50F};  //5 wide
        Table table_bom = new Table(pointColumnWidthsBom);

        // Adding cells to the table   
        table_bom.addCell(new Cell().add("Stykliste"));
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell().add("Product"));
        table_bom.addCell(new Cell().add("Category"));
        table_bom.addCell(new Cell().add("Qty"));
        table_bom.addCell(new Cell().add("Unit"));
        table_bom.addCell(new Cell().add("Usability Comment"));
        //bom
        for (OrderLine j : bom.getMaterials()) {
            table_bom.addCell(new Cell().add(j.getProductName()));
            table_bom.addCell(new Cell().add(j.getProductCategory()));
            table_bom.addCell(new Cell().add(j.getQuantity() + ""));
            table_bom.addCell(new Cell().add(j.getAmountType()));
            table_bom.addCell(new Cell().add(j.getUsabilityComment()));
        }

        // Adding Tables to document        
        doc.add(table_bom);

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
        email.setAuthenticator(new DefaultAuthenticator("fakejohannesfog", "johannesfogpassword1"));
        email.setSSL(true);
        email.addTo("fakejohannesfog@gmail.com", "Fake Johannes Fog"); //TODO .getEmail
        email.setFrom("fakejohannesfog@gmail.com", "Fake Johannes Fog");
        email.setSubject("Ordre fra Fake Johannes Fog");
        email.setMsg("Besked om din ordre her.");

        System.out.println("worked???");
        DataSource source = new ByteArrayDataSource(byteArray, "application/pdf");
        source.getInputStream().close();
        // add the attachment
        email.attach(source, "result.pdf", "Description of some file");

        // send the email
        email.send();  //TODO UNCOMMENT TO ENABLE SENDING
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
