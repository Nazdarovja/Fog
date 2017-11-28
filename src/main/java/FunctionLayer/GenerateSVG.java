/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Orchi
 */
public class GenerateSVG {
    
    public static String generateSVGHTML(int length, int width, boolean withShack, int shackLength, int shackWidth) {
        int gap = 40;
        String html = "<SVG width='50%' viewbox='0 0 " + (length+gap) + " " + (width+gap) + "'>";
        html += generateSVGForLineMeasurements(length, width, shackWidth, gap);
        html += generateSVGForCarportArea(length, width, gap);
        if(withShack)
            html += generateSVGForShack(length, width, shackLength, shackWidth, gap);
        html += generateSVGForEndRafters(length, width, gap);
        html += generateSVGForPost(length, width, gap);
        html += generateSVGForRafters(length, width, gap);
        html += generateSVGForCross(length, width, gap, shackWidth);
        
        
//        html += "<line x1='0' y1='0' x2='"+(length-shackWidth-35)+"' y2='0' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
//        html += "<line x1='"+(length-shackWidth-35)+"' y1='0' x2='"+(length-35)+"' y2='0' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
       // html += "<rect x='0' y='"+gap+"' height="+width+" width="+length+" stroke='black' fill='#cece9f'/>";
        //html += "<rect x='"+(length-shackWidth-30)+"' y='"+(35+gap)+"' height='"+shackLength+"' width='"+shackWidth+"' stroke-width='2' stroke='black' fill='#ffe100'/>";
        //html += "<rect x='0' y='"+gap+"' height="+width+" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
        //html += "<rect x='"+(length-10)+"' y="+gap+" height="+width+" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
       // html += "<rect x='0' y='"+(35+gap)+"' height='10' width='"+length+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
        //html += "<rect x='0' y='"+(width-35+gap)+"' height='10' width='"+length+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
//        boolean oneMoreNeeded = true;
//        int xValue = 55;
//        while(oneMoreNeeded) {
//            html += "<rect x='"+xValue+"' y='"+(35+gap)+"' height='"+width+"' width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
//            xValue += 60;
//            if(xValue >= length-60)
//                oneMoreNeeded = false;
//        }
//        html += "<line x1='55' y1='"+(35+gap)+"' x2='"+(length-shackWidth-30)+"' y2='"+(width-35+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
//        html += "<line x1='"+(length-shackWidth-30)+"' y1='"+(35+gap)+"' x2='55' y2='"+(width-35+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
        html += "</SVG>";
        return html;
    }
    
    private static String generateSVGForEndRafters(int length, int width, int gap) {
        String html = "";
        html += "<rect x="+gap+" y='"+gap+"' height="+width+" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x='"+(length-10+gap)+"' y="+gap+" height="+width+" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
        return html;
    }
    
    private static String generateSVGForPost(int length, int width, int gap) {
        String html = "";
        html += "<rect x="+gap+" y='"+(35+gap)+"' height='10' width='"+length+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x="+gap+" y='"+(width-35+gap)+"' height='10' width='"+length+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
        return html;
    }
    
    private static String generateSVGForCarportArea(int length, int width, int gap) {
        String html = "";
        html += "<rect x="+gap+" y='"+gap+"' height="+width+" width="+length+" stroke='black' fill='#cece9f'/>";
        return html;
    }
    
    private static String generateSVGForShack(int length, int width, int shackLength, int shackWidth, int gap) {
        String html = "";
        html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(35+gap)+"' height='"+shackLength+"' width='"+shackWidth+"' stroke-width='2' stroke='black' fill='#ffe100'/>";
        return html;
    }
    
    private static String generateSVGForRafters(int length, int width, int gap) {
        String html = "";
        boolean oneMoreNeeded = true;
        int xValue = 55;
        while(oneMoreNeeded) {
            html += "<rect x='"+(xValue+gap)+"' y='"+(35+gap)+"' height='"+(width-35)+"' width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
            xValue += 60;
            if(xValue >= length-60)
                oneMoreNeeded = false;
        }
        return html;
    }
    
    private static String generateSVGForCross(int length, int width, int gap, int shackWidth) {
        String html = "";
        html += "<line x1="+(55+gap)+" y1='"+(35+gap)+"' x2='"+(length-shackWidth-30+gap)+"' y2='"+(width-35+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
        html += "<line x1='"+(length-shackWidth-30+gap)+"' y1='"+(35+gap)+"' x2="+(55+gap)+" y2='"+(width-35+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
        return html;
    }
    
    private static String generateSVGForLineMeasurements(int length, int width, int shackWidth, int gap) {
        String html = "";
        html += "<line x1="+gap+" y1='0' x2='"+(length-shackWidth-35+gap)+"' y2='0' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
        html += "<line x1='"+(length-shackWidth-35+gap)+"' y1='0' x2='"+(length-35+gap)+"' y2='0' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
        return html;
    }
    
    
    public static void main(String[] args) {
        System.out.println(GenerateSVG.generateSVGHTML(810, 900, true, 900-60, 210));
    }
}
