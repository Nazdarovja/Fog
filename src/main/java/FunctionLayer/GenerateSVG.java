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
    
    public static String generateSVGHTML(int length, int width, boolean withShack, int shackLength, int shackWidth, String roofType, int angle) {
            int gap = 40;
            String html = "<SVG width='50%' viewbox='0 0 " + (length+gap) + " " + (width+gap) + "'>";
        if(roofType.equals("fladt")) {
            int gapFromEdgePosts = 27;
            int gapFromEdge = 30;
            html += generateSVGForLineMeasurements(length, width, withShack,shackWidth, gap, gapFromEdge);
            html += generateSVGForCarportArea(length, width, gap);
            if(withShack)
                html += generateSVGForShack(length, width, shackLength-60, shackWidth, gap, gapFromEdge);
            if(withShack)
                html += generateSVGForShackPosts(length, width, shackLength, shackWidth, gap, gapFromEdgePosts);
            html += generateSVGForEndRafters(length, width, gap);
            html += generateSVGForTopPlate(length, width, gap, gapFromEdge, 0);
            html += generateSVGForPosts(length, width, withShack, shackLength, shackWidth, gap, gapFromEdgePosts);
            html += generateSVGForRafters(length, width, gap, gapFromEdge);
            html += generateSVGForCross(length, width, gap, withShack, shackWidth, gapFromEdge);
        } else { // rejsning
            int gapFromEdgePosts = 17;
            int gapFromEdge = 20;
            html += generateSVGForLineMeasurements(length, width, withShack,shackWidth, gap, gapFromEdge);
            html += generateSVGForCarportArea(length, width, gap);
            if(withShack)
                html += generateSVGForShack(length, width, shackLength, shackWidth, gap, gapFromEdge);
            if(withShack)
                html += generateSVGForShackPosts(length, width, shackLength, shackWidth, gap, gapFromEdgePosts);
            html += generateSVGForPosts(length, width, withShack, shackLength, shackWidth, gap, gapFromEdgePosts);
            html += generateSVGForTopPlate(length, width, gap, gapFromEdge, 30);
            html += generateSVGForRafters(length, width, gap, gapFromEdge);
            html += generateSVGForLaths(length, width, gap, angle);
            html += generateSVGForTopLath(length, width, gap);
            html += generateSVGForSoffits(length, width, gap);
            html += generateSVGForEndRafterCombiningLines(length, width, gap);
        }
        
        
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
    
    private static String generateSVGForTopLath(int length, int width, int gap) {
        String html = "";
        int middle = width / 2;
            html += "<rect x="+(+gap)+" y='"+(middle+gap-5+2)+"' height='6' width='"+(length)+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
        return html;
    }
    
    private static String generateSVGForLaths(int length, int width, int gap, int angle) {
          String html = ""; // for advanced drawing
//        double halfWidth = width / 2;
//        double radiantAngle = Math.toRadians(angle);
//        double carportHeight =  halfWidth / Math.cos(radiantAngle);
//        Double result = calcHypotenuse(width,carportHeight); // hyp bredde
//        int hypWidth = result.intValue();
//        
//        boolean oneMoreNeeded = true;
//        int yValue = 45;
//        int newYValue = 30; // sets default to 60 if the space between the raftes fits to 60cm.
//        int amountOfRafters;
//        if((hypWidth-90) % 30 > 0) {
//            amountOfRafters = (hypWidth - 90) / 30;
//            amountOfRafters++; // amount of rafters needed
//            newYValue =  length / amountOfRafters;
//        }
          int spaceBetweenLaths = 30;
          int half = width / 2 + gap;
          boolean oneMore = true;
          int yValue = 80;
          while(oneMore) {
              html += "<rect x="+(+gap)+" y='"+(+yValue)+"' height='6' width='"+length+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
              yValue += spaceBetweenLaths;
              if(yValue > half - spaceBetweenLaths)
                  oneMore = false;
          }
          yValue -= 30 - 6; // the value gets incremented in the last loop even though oneMore is set to false; - 6 for width
          int difference = half - yValue; //staringpoint for second side of roof
          yValue += difference * 2;
          oneMore = true;
          while(oneMore) {
              html += "<rect x="+(+gap)+" y='"+(+yValue)+"' height='6' width='"+length+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
              yValue += spaceBetweenLaths;
              if(yValue > (width+gap) - 40)
                  oneMore = false;
          }
        return html;
    }
    
    private static String generateSVGForEndRafterCombiningLines(int length, int width, int gap) {
        String html = "";
        html += "<line x1="+gap+" y1="+(width/2+gap)+" x2="+(gap+6)+" y2="+(width/2+gap)+" style='stroke:rgb(0,0,0);stroke-width:5'/>";
        html += "<line x1="+(length-6+gap)+" y1="+(width/2+gap)+" x2="+((length+gap))+" y2="+(width/2+gap)+" style='stroke:rgb(0,0,0);stroke-width:5'/>";
        return html;
    }
    
    private static String generateSVGForEndRafters(int length, int width, int gap) {
        String html = "";
        html += "<rect x="+gap+" y='"+gap+"' height="+width+" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x='"+(length-10+gap)+"' y="+gap+" height="+width+" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
        return html;
    }
    
    private static String generateSVGForSoffits(int length, int width, int gap) {
        String html = "";
        html += "<rect x="+(gap)+" y='"+gap+"' height="+width+" width='6' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x='"+(length-6+gap)+"' y="+(gap)+" height="+width+" width='6' stroke-width='2' stroke='black' fill='#cece9f'/>";
        return html;
    }
    
    private static String generateSVGForTopPlate(int length, int width, int gap, int gapFromEdge, int topPlateDifference) {
        String html = "";
        html += "<rect x="+(topPlateDifference+gap)+" y='"+(gapFromEdge+gap)+"' height='10' width='"+(length-(topPlateDifference*2))+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x="+(topPlateDifference+gap)+" y='"+(width-gapFromEdge+gap-10)+"' height='10' width='"+(length-(topPlateDifference*2))+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
        if(width > 600) {
            int middle = width / 2;
            html += "<rect x="+(topPlateDifference+gap)+" y='"+(middle+gap-5)+"' height='10' width='"+(length-(topPlateDifference*2))+"' stroke-width='2' stroke='black' fill='#cece9f'/>";
        }
        return html;
    }
    
    private static String generateSVGForCarportArea(int length, int width, int gap) {
        String html = "";
        html += "<rect x="+gap+" y='"+gap+"' height="+width+" width="+length+" stroke='black' fill='#cece9f'/>";
        return html;
    }
    
    private static String generateSVGForShack(int length, int width, int shackLength, int shackWidth, int gap, int gapFromEdge) {
        String html = "";
        html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(gapFromEdge+gap)+"' height='"+(shackLength-20)+"' width='"+shackWidth+"' stroke-width='2' stroke='black' fill='#ffe100'/>";
        return html;
    }
    
    /*private static String generateSVGForShackPosts(int length, int width, int shackLength, int shackWidth, int gap, int gapFromEdge) {
        String html = "";
        
        html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(gapFromEdge+gap)+"' height='"+16+"' width='"+16+"' stroke-width='2' stroke='black' fill='#ffe100'/>";
        if(shackLength ==  width) 
            html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(width-gapFromEdge-5+gap-10)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        else {
            html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(shackLength-gapFromEdge-5+gap-10)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
            html += "<rect x='"+(length+gap-30-16)+"' y='"+(shackLength-gapFromEdge-5+gap-10)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        }
        if(width > 600) {
            int yValue = width / 2;
            yValue += gap - 8;
            html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+yValue+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        }
        return html;
    }*/
    
    private static String generateSVGForShackPosts(int length, int width, int shackLength, int shackWidth, int gap, int gapFromEdge) {
        String html = "";
        
        html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(gapFromEdge+gap)+"' height='"+16+"' width='"+16+"' stroke-width='2' stroke='black' fill='#ffe100'/>";
        if(shackLength ==  width) 
            html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(width-gapFromEdge-5+gap-10)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        else {
            html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+(shackLength+gapFromEdge-5+gap-10-16)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
            if(width / 2 != shackLength)
                html += "<rect x='"+(length+gap-30-16)+"' y='"+(shackLength+gapFromEdge-5+gap-10-16)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        }
        if(width > 600) {
            int yValue = width / 2;
            yValue += gap - 8;
            html += "<rect x='"+(length-shackWidth-30+gap)+"' y='"+yValue+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        }
        return html;
    }
    
    private static String generateSVGForRafters(int length, int width, int gap, int gapFromEdge) {
        
        String html = "";
        boolean oneMoreNeeded = true;
        int xValue = 60;
        int amountOfRafters;
        int newXValue = 60; // sets default to 60 if the space between the raftes fits to 60cm.
        if(length % 60 > 0) {
            amountOfRafters = length / 60;
            amountOfRafters++; // amount of rafters needed
            xValue = length / amountOfRafters;// calculates the space between each raft
            newXValue = xValue; // Assigns the new xValue to another variable, since the variable xValue 
            //gets incremented in the loop, and the space between 
            //each raft gets added to xValue each loop -> therefore xValue += newXValue;
        }
        
        while(oneMoreNeeded) {
            html += "<rect x='"+(xValue+gap)+"' y='"+gap+"' height='"+(width-gapFromEdge+gap)+"' width='10' stroke-width='2' stroke='black' fill='#cece9f'/>";
            xValue += newXValue;
            if(xValue > length - newXValue + 15) // - newXValue because we don't want to place the last raft as an 'end raft'. plus 15 to allow for a not exact fit.
                oneMoreNeeded = false;
        }
        return html;
    }
    
    private static String generateSVGForCross(int length, int width, int gap, boolean withShack, int shackWidth, int gapFromEdge) {
        String html = "";
        if (withShack) {
            html += "<line x1="+(55+gap)+" y1='"+(gapFromEdge+gap)+"' x2='"+(length-shackWidth-30+gap)+"' y2='"+(width-gapFromEdge+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
            html += "<line x1='"+(length-shackWidth-30+gap)+"' y1='"+(gapFromEdge+gap)+"' x2="+(55+gap)+" y2='"+(width-gapFromEdge+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
        } else {
            html += "<line x1="+(55+gap)+" y1='"+(gapFromEdge+gap)+"' x2='"+(length-30+gap)+"' y2='"+(width-gapFromEdge+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
            html += "<line x1='"+(length-30+gap)+"' y1='"+(gapFromEdge+gap)+"' x2="+(55+gap)+" y2='"+(width-gapFromEdge+gap)+"' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>";
        }
        return html;
    }
    
    private static String generateSVGForLineMeasurements(int length, int width, boolean withShack,int shackWidth, int gap, int gapFromEdge) {
        String html = "";
            html += "<text x="+((length/2)+gap)+" y='15' fill='black'>"+length+"</text>";
            html += "<text x='25' y="+((width/2)+gap)+" style='writing-mode: tb;' fill='black'>"+(width-(gapFromEdge*2))+"</text>";
            html += "<text x='5' y="+((width/2)+gap)+" style='writing-mode: tb;' fill='black'>"+width+"</text>";
            
            
            
            
            
            html += "<line x1="+gap+" y1='30' x2='"+(length+gap)+"' y2='30' style='stroke:rgb(0,0,0);stroke-width:2'/>";
            html += "<line x1='30' y1="+(gap+gapFromEdge)+" x2='30' y2="+(width+gap-gapFromEdge)+" style='stroke:rgb(0,0,0);stroke-width:2'/>";
            html += "<line x1='10' y1="+gap+" x2='10' y2="+(width+gap)+" style='stroke:rgb(0,0,0);stroke-width:2'/>";
        return html;
    }
    
    private static String generateSVGForPosts(int length, int width, boolean withShack, int shackLength, int shackWidth, int gap, int gapFromEdge) {
        String html = "";
        html += "<rect x='"+(100+gap)+"' y='"+(gapFromEdge+gap)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x='"+(100+gap)+"' y='"+(width-gapFromEdge-5+gap-10)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x='"+(length+gap-30-16)+"' y='"+(gapFromEdge+gap)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        html += "<rect x='"+(length+gap-30-16)+"' y='"+(width-gapFromEdge-5+gap-10)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        
        if(length >= 620) {
            int res = (length - 130);
            res = res / 2;
            int xValue = res + gap + 100;
            html += "<rect x='"+(xValue-8)+"' y='"+(gapFromEdge+gap)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
            html += "<rect x='"+(xValue-8)+"' y='"+(width-gapFromEdge-5+gap-10)+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        }
        
        if(width > 600) {
            int res = (length - 130);
            res = res / 2;
            int xValue = res + gap + 100;
            int yValue = width / 2;
            yValue += gap - 8;
            
            html += "<rect x='"+(100+gap)+"' y='"+yValue+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
            html += "<rect x='"+(length+gap-30-16)+"' y='"+yValue+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
            html += "<rect x='"+(xValue-8)+"' y='"+yValue+"' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>";
        }
        
        return html;
    }
    
    private static double calcHypotenuse(double a, double b){
        double aPow = Math.pow(a, 2);
        double bPow = Math.pow(b, 2);
        return Math.sqrt(aPow+bPow);
    }
    
    
    
    
    public static void main(String[] args) {
        System.out.println(GenerateSVG.generateSVGHTML(690, 630, true, 345, 210, "rejsning", 30));
    }
}
