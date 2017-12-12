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
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.activation.DataSource;
import org.apache.commons.mail.*;

public class GeneratePDF {
    
    static String path = "C:/itextExamples/";
    static String destPDF = path + "Tilbud på carport.pdf";
    static String topHTML = "Top.html";
    static String sideHTML = "Side.html";
    
    public static MultiPartEmail createPDF(Customer customer, Inquiry inquiry, BillOfMaterials bom) throws FileNotFoundException, IOException, EmailException, FogException, InterruptedException {

        // Creating a PdfDocument object   
        PdfWriter writer = new PdfWriter(destPDF);

        // Creating a PdfDocument object      
        PdfDocument pdf = new PdfDocument(writer);

        // Creating a Document object       
        Document doc = new Document(pdf);
        
        float[] pointColumnWidthsTitle = {100F};  //1 wide
        Table title_table = new Table(pointColumnWidthsTitle);
        title_table.addCell(new Paragraph("Tilbud på carport"));
        doc.add(title_table.setBold());
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
        
        System.out.println("Table created successfully..");
        doc.close();
        //Save SVG (as html String) to HTML file
        saveAsHTML("Top.html", new SVGFromTop(inquiry.getCarportLength(), inquiry.getCarportWidth(), true, inquiry.getShackWidth(), inquiry.getShackLength(), inquiry.getRoofType(), Integer.parseInt(inquiry.getAngle())).getSVG().toString());
        saveAsHTML("Side.html", new SVGFromSide(inquiry.getCarportLength(), inquiry.getCarportWidth(), inquiry.getCarportHeight(), true, inquiry.getShackWidth(), inquiry.getShackLength(), inquiry.getRoofType(), Integer.parseInt(inquiry.getAngle())).getSVG().toString());
        
        byte[] pdfAttachment = loadFile(destPDF);
        byte[] topAttachment = loadFile(path + topHTML);
        byte[] sideAttachment = loadFile(path + sideHTML);
        return sendEmail(pdfAttachment, topAttachment, sideAttachment);
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
    
    public static byte[] readFully(InputStream stream) throws IOException {
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        int bytesRead;
        while ((bytesRead = stream.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }
    
    private static MultiPartEmail sendEmail(byte[] PDF, byte[] carportTop, byte[] carportSide) throws EmailException, IOException {

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

        //attach pdf 
        DataSource source = new ByteArrayDataSource(PDF, "application/pdf");
        email.attach(source, "Tilpud på carport", "Tilpud på carport");

        //attach carport top image  
        source = new ByteArrayDataSource(carportTop, "text/html");
        email.attach(source, "Carport fra top", "Carport fra top");

        //attach carport side image 
        source = new ByteArrayDataSource(carportSide, "text/html");
        email.attach(source, "Carport fra siden", "Carport fra siden");
        
        source.getInputStream().close();
        // send the email
//        email.send();  //TODO UNCOMMENT TO ENABLE SENDING
        return email;
    }
    
    public static String saveAsHTML(String filename, String svgHTML) throws IOException, FogException {
        
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter(path + filename);
            writer = new BufferedWriter(fWriter);
            writer.write("<span>" + svgHTML + "</span>");
            writer.close(); //make sure you close the writer object 
        } catch (IOException e) {
            throw new FogException("unable to save svghtml string as HTML");
        }
        return filename;
    }
}
