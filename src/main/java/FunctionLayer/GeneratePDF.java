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
import com.itextpdf.layout.element.Paragraph;
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

        // Creating a PdfDocument object   
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument object      
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document object       
        Document doc = new Document(pdf);

        /////////////////////
        // Creating inquiry info
        /////////////////////
        float[] pointColumnWidthsInquiry = {50F, 50F};  //2 wide
        Table table_inquiry = new Table(pointColumnWidthsInquiry);
        table_inquiry.addCell(new Cell().add("Forespørgsel").setBold());
        table_inquiry.addCell(new Cell().add(""));
        table_inquiry.addCell(new Cell().add("Carport højde"));
        table_inquiry.addCell(new Cell().add(inquiry.getCarportHeight() + ""));
        table_inquiry.addCell(new Cell().add("Carport længde"));
        table_inquiry.addCell(new Cell().add(inquiry.getCarportLength() + ""));
        table_inquiry.addCell(new Cell().add("Carport bredde"));
        table_inquiry.addCell(new Cell().add(inquiry.getCarportWidth() + ""));
        table_inquiry.addCell(new Cell().add("Skur længde"));
        if (inquiry.getShackLength() > 0) {
            table_inquiry.addCell(new Cell().add(inquiry.getShackLength() + ""));
        } else {
            table_inquiry.addCell(new Cell().add("-"));
        }

        table_inquiry.addCell(new Cell().add("Skur bredde"));
        if (inquiry.getShackWidth() > 0) {
            table_inquiry.addCell(new Cell().add(inquiry.getShackWidth() + ""));
        } else {
            table_inquiry.addCell(new Cell().add("-"));
        }

        table_inquiry.addCell(new Cell().add("Tagtype"));
        table_inquiry.addCell(new Cell().add(inquiry.getRoofType()));

        table_inquiry.addCell(new Cell().add("Taghældning"));
        if (inquiry.getAngle() != null) {
            table_inquiry.addCell(new Cell().add(inquiry.getAngle()));
        } else {
            table_inquiry.addCell(new Cell().add("-"));
        }

        table_inquiry.addCell(new Cell().add("Kommentar ansat"));
        if (inquiry.getCommentEmployee() != null) {
            table_inquiry.addCell(new Cell().add(inquiry.getCommentEmployee()));
        } else {
            table_inquiry.addCell(new Cell().add("-"));
        }

        table_inquiry.addCell(new Cell().add("Kommentar kunde"));
        if (inquiry.getCommentEmployee() != null) {
            table_inquiry.addCell(new Cell().add(inquiry.getCommentCustomer()));
        } else {
            table_inquiry.addCell(new Cell().add("-"));
        }

        table_inquiry.addCell(new Cell().add("Ønsket levering til"));
        if (inquiry.getPeriod() != null) {
            table_inquiry.addCell(new Cell().add(inquiry.getPeriod() + ""));
        } else {
            table_inquiry.addCell(new Cell().add("-"));
        }

        table_inquiry.addCell(new Cell().add("Status"));
        table_inquiry.addCell(new Cell().add(inquiry.getStatus()));

        table_inquiry.addCell(new Cell().add("Behandlet af"));
        if (inquiry.getId_employee() > 0) {
            table_inquiry.addCell(new Cell().add(inquiry.getId_employee() + ""));
        } else {
            table_inquiry.addCell(new Cell().add("-"));
        }

        table_inquiry.addCell(new Cell().add("Forespørgsel afsendt den"));
        if (inquiry.getDate() + "" != null) {
            table_inquiry.addCell(new Cell().add(inquiry.getDate() + ""));
        } else {
            table_inquiry.addCell(new Cell().add("intet valgt"));
        }

        doc.add(table_inquiry);
        doc.add(new Paragraph("\n"));

        /////////////////////
        //Creating customer table
        /////////////////////
        float[] pointColumnWidthsCustomer = {50F, 50F};  //2 wide
        Table table_cus = new Table(pointColumnWidthsCustomer);
        table_cus.addCell(new Cell().add("Kunde info").setBold());
        table_cus.addCell(new Cell().add(""));
        table_cus.addCell(new Cell().add("Email"));
        table_cus.addCell(new Cell().add(customer.getEmail()));
        table_cus.addCell(new Cell().add("Name"));
        table_cus.addCell(new Cell().add(customer.getName()));
        table_cus.addCell(new Cell().add("Surname"));
        table_cus.addCell(new Cell().add(customer.getSurname()));
        table_cus.addCell(new Cell().add("Phonenumber"));
        table_cus.addCell(new Cell().add(customer.getPhonenumber() + ""));
        table_cus.addCell(new Cell().add("Address"));
        table_cus.addCell(new Cell().add(customer.getAddress()));
        table_cus.addCell(new Cell().add("Zipcode"));
        table_cus.addCell(new Cell().add(customer.getZipcode() + ""));
        doc.add(table_cus);
        doc.add(new Paragraph("\n"));

        /////////////////////
        // Creating bom table       
        /////////////////////
        float[] pointColumnWidthsBom = {50F, 50F, 50F, 50F, 50F};  //5 wide
        Table table_bom = new Table(pointColumnWidthsBom);

        // Adding cells to the table   
        table_bom.addCell(new Cell().add("Stykliste").setBold());
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell());
        table_bom.addCell(new Cell().add("Product"));
        table_bom.addCell(new Cell().add("Category"));
        table_bom.addCell(new Cell().add("Qty"));
        table_bom.addCell(new Cell().add("Unit"));
        table_bom.addCell(new Cell().add("Usability Comment"));

        for (OrderLine j : bom.getMaterials()) {
            table_bom.addCell(new Cell().add(j.getProductName()));
            table_bom.addCell(new Cell().add(j.getProductCategory()));
            table_bom.addCell(new Cell().add(j.getQuantity() + ""));
            table_bom.addCell(new Cell().add(j.getAmountType()));
            table_bom.addCell(new Cell().add(j.getUsabilityComment()));
        }
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
