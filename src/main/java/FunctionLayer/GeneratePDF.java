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
import java.io.FileNotFoundException;

public class GeneratePDF {

    public static void main(String[] args) throws FileNotFoundException {
        GeneratePDF();
    }
    
//    public static void GeneratePDF(String customer, Inquiry inquiry, BillOfMaterials bom) throws FileNotFoundException {
    public static void GeneratePDF() throws FileNotFoundException {

        //TODO Generate PDF file from input, return as bytestream?
        
        
        // Creating a PdfDocument object   
        String dest = "C:/itextExamples/addingTable.pdf";
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

    }

}
