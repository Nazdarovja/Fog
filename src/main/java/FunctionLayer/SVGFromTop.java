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
public class SVGFromTop {
    private StringBuilder svg = new StringBuilder();
    
    private int length;
    private int width;
    private boolean withShack;
    private int shackLength;
    private int shackWidth;
    private String roofType;
    private int angle;
    
    private int gap;
    private int gapFromEdgePosts;
    private int gapFromEdge;
    
    public SVGFromTop(int length, int width, boolean withShack, int shackLength, int shackWidth, String roofType, int angle) {
        this.length = length;
        this.width = width;
        this.withShack = withShack;
        this.shackLength = shackLength;
        this.shackWidth = shackWidth;
        this.roofType = roofType;
        this.angle = angle;
        gap = 40;

        if(this.roofType.equals("fladt")) {
            gapFromEdgePosts = 27;
            gapFromEdge = 30;
            makeFlatRoofCarport();
        } else {
            gapFromEdgePosts = 17;
            gapFromEdge = 20;
            makePitchedRoofCarport();
        }
    }
    
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWithShack() {
        return withShack;
    }

    public int getShackLength() {
        return shackLength;
    }

    public int getShackWidth() {
        return shackWidth;
    }

    public String getRoofType() {
        return roofType;
    }

    public int getAngle() {
        return angle;
    }
    
    public StringBuilder getSVG() {
        return svg;
    }
    
    public int getMaxShackLength() {
        return width - (gapFromEdge * 2);
    }
    
    public double minusRight() {
        double widthC = this.width;
        double shackL = this.shackLength;
        double res = shackL / widthC;
        return gapFromEdge * res;
    }

    private void makeFlatRoofCarport() {
        svg.append("<SVG width='50%' viewbox='0 0 ").append(length+gap).append(" ").append(width+gap).append("'>");
        generateSVGForLineMeasurements();
        generateSVGForCarportArea();
        if(withShack)
            generateSVGForShack();
        if(withShack)
            generateSVGForShackPosts();
        generateSVGForEndRafters();
        generateSVGForTopPlate();
        generateSVGForPosts();
        generateSVGForRafters();
        generateSVGForCross();
        svg.append("</SVG>");
    }

    private void makePitchedRoofCarport() {
        svg.append("<SVG width='50%' viewbox='0 0 ").append(length+gap).append(" ").append(width+gap).append("'>");
        generateSVGForLineMeasurements();
        generateSVGForCarportArea();
        if(this.withShack)
            generateSVGForShack();
        if(this.withShack)
            generateSVGForShackPosts();
        generateSVGForPosts();
        generateSVGForTopPlate();
        generateSVGForRafters();
        generateSVGForLaths();
        generateSVGForTopLath();
        generateSVGForSoffits();
        generateSVGForEndRafterCombiningLines();
        svg.append("</SVG>");
    }
    
    private void generateSVGForTopLath() {
        int middle = width / 2;
            svg.append("<rect x=").append(gap).append(" y='").append(middle+gap-5+2).append("' height='6' width='").append(length).append("' stroke-width='2' stroke='black' fill='#cece9f'/>");
    }
    
    private void generateSVGForLaths() {
          int spaceBetweenLaths = 30;
          int half = width / 2 + gap;
          boolean oneMore = true;
          int yValue = 80;
          while(oneMore) {
              svg.append("<rect x=").append(gap).append(" y='").append(+yValue).append("' height='6' width='").append(length).append("' stroke-width='2' stroke='black' fill='#cece9f'/>");
              yValue += spaceBetweenLaths;
              if(yValue > half - spaceBetweenLaths)
                  oneMore = false;
          }
          yValue -= 30 - 6; // the value gets incremented in the last loop even though oneMore is set to false; - 6 for width
          int difference = half - yValue; //staringpoint for second side of roof
          yValue += difference * 2;
          oneMore = true;
          while(oneMore) {
              svg.append("<rect x=").append(gap).append(" y='").append(+yValue).append("' height='6' width='").append(length).append("' stroke-width='2' stroke='black' fill='#cece9f'/>");
              yValue += spaceBetweenLaths;
              if(yValue > (width+gap) - 40)
                  oneMore = false;
          }
    }
    
    private void generateSVGForEndRafterCombiningLines() {
        svg.append("<line x1=").append(gap).append(" y1=").append(width/2+gap).append(" x2=").append(gap+6).append(" y2=").append(width/2+gap).append(" style='stroke:rgb(0,0,0);stroke-width:5'/>");
        svg.append("<line x1=").append(length-6+gap).append(" y1=").append(width/2+gap).append(" x2=").append(length+gap).append(" y2=").append(width/2+gap).append(" style='stroke:rgb(0,0,0);stroke-width:5'/>");
    }
    
    private void generateSVGForEndRafters() {
        svg.append("<rect x=").append(gap).append(" y='").append(gap).append("' height=").append(width).append(" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>");
        svg.append("<rect x='").append(length-10+gap).append("' y=").append(gap).append(" height=").append(width).append(" width='10' stroke-width='2' stroke='black' fill='#cece9f'/>");
    }
    
    private void generateSVGForSoffits() {
        svg.append("<rect x=").append(gap).append(" y='").append(gap).append("' height=").append(width).append(" width='6' stroke-width='2' stroke='black' fill='#cece9f'/>");
        svg.append("<rect x='").append(length-6+gap).append("' y=").append(gap).append(" height=").append(width).append(" width='6' stroke-width='2' stroke='black' fill='#cece9f'/>");
    }
    
    private void generateSVGForTopPlate() {
        int topPlateDifference = 0;
        if(roofType.equals("rejsning"))
            topPlateDifference = 30;
        svg.append("<rect x=").append(topPlateDifference+gap).append(" y='").append(gapFromEdge+gap).append("' height='10' width='").append(length-(topPlateDifference*2)).append("' stroke-width='2' stroke='black' fill='#cece9f'/>");
        svg.append("<rect x=").append(topPlateDifference+gap).append(" y='").append(width-gapFromEdge+gap-10).append("' height='10' width='").append(length-(topPlateDifference*2)).append("' stroke-width='2' stroke='black' fill='#cece9f'/>");
        if(width > 600) {
            int middle = width / 2;
            svg.append("<rect x=").append(topPlateDifference+gap).append(" y='").append(middle+gap-5).append("' height='10' width='").append(length-(topPlateDifference*2)).append("' stroke-width='2' stroke='black' fill='#cece9f'/>");
        }
    }
    
    private void generateSVGForCarportArea() {
        svg.append("<rect x=").append(gap).append(" y='").append(gap).append("' height=").append(width).append(" width=").append(length).append(" stroke='black' fill='#cece9f'/>");
    }
    
    private void generateSVGForShack() {
        svg.append("<rect x='").append(length-shackWidth-30+gap).append("' y='").append(gapFromEdge+gap).append("' height='").append(shackLength-(minusRight()*2)).append("' width='").append(shackWidth).append("' stroke-width='2' stroke='black' fill='#ffe100'/>");
    }
    
    private void generateSVGForShackPosts() {
        svg.append("<rect x='").append(length-shackWidth-30+gap).append("' y='").append(gapFromEdgePosts+gap).append("' height='").append(16).append("' width='").append(16).append("' stroke-width='2' stroke='black' fill='#ffe100'/>");
        if(shackLength ==  width) 
            svg.append("<rect x='").append(length-shackWidth-30+gap).append("' y='").append(width-gapFromEdgePosts-5+gap-10).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        else {
            svg.append("<rect x='").append(length-shackWidth-30+gap).append("' y='").append(shackLength+gapFromEdge+gap-(minusRight()*2)-8).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
            if(width / 2 != shackLength)
                svg.append("<rect x='").append(length+gap-30-16).append("' y='").append(shackLength+gapFromEdge+gap-(minusRight()*2)-8).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        }
        if(width > 600 && shackLength > width / 2) {
            int yValue = width / 2;
            yValue += gap - 8;
            svg.append("<rect x='").append(length-shackWidth-30+gap).append("' y='").append(yValue).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        }
    }
    
    private void generateSVGForRafters() {
        
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
            svg.append("<rect x='").append(xValue+gap).append("' y='").append(gap).append("' height='").append(width-gapFromEdge+gap).append("' width='10' stroke-width='2' stroke='black' fill='#cece9f'/>");
            xValue += newXValue;
            if(xValue > length - newXValue + 15) // - newXValue because we don't want to place the last raft as an 'end raft'. plus 15 to allow for a not exact fit.
                oneMoreNeeded = false;
        }
    }
    
    private void generateSVGForCross() {
        if (withShack) {
            svg.append("<line x1=").append(55+gap).append(" y1='").append(gapFromEdge+gap).append("' x2='").append(length-shackWidth-30+gap).append("' y2='").append(width-gapFromEdge+gap).append("' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>");
            svg.append("<line x1='").append(length-shackWidth-30+gap).append("' y1='").append(gapFromEdge+gap).append("' x2=").append(55+gap).append(" y2='").append(width-gapFromEdge+gap).append("' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>");
        } else {
            svg.append("<line x1=").append(55+gap).append(" y1='").append(gapFromEdge+gap).append("' x2='").append(length-30+gap).append("' y2='").append(width-gapFromEdge+gap).append("' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>");
            svg.append("<line x1='").append(length-30+gap).append("' y1='").append(gapFromEdge+gap).append("' x2=").append(55+gap).append(" y2='").append(width-gapFromEdge+gap).append("' style='stroke:rgb(255,255,255);stroke-width:5'<path stroke-dasharray='5,5' d='M5 20 1215 0'/>/>");
        }
    }
    
    private void generateSVGForLineMeasurements() {
            svg.append("<text x=").append(length/2+gap).append(" y='15' fill='black'>").append(length).append("</text>");
            svg.append("<text x='25' y=").append(width/2+gap).append(" style='writing-mode: tb;' fill='black'>").append(width-(gapFromEdge*2)).append("</text>");
            svg.append("<text x='5' y=").append(width/2+gap).append(" style='writing-mode: tb;' fill='black'>").append(width).append("</text>");
            
            svg.append("<line x1=").append(gap).append(" y1='30' x2='").append(length+gap).append("' y2='30' style='stroke:rgb(0,0,0);stroke-width:2'/>");
            svg.append("<line x1='30' y1=").append(gap+gapFromEdge).append(" x2='30' y2=").append(width+gap-gapFromEdge).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
            svg.append("<line x1='10' y1=").append(gap).append(" x2='10' y2=").append(width+gap).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
    }
    
    private void generateSVGForPosts() {
        svg.append("<rect x='").append(100+gap).append("' y='").append(gapFromEdgePosts+gap).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        svg.append("<rect x='").append(100+gap).append("' y='").append(width-gapFromEdgePosts-5+gap-10).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        svg.append("<rect x='").append(length+gap-30-16).append("' y='").append(gapFromEdgePosts+gap).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        svg.append("<rect x='").append(length+gap-30-16).append("' y='").append(width-gapFromEdgePosts-5+gap-10).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        
        if(length >= 620) {
            int res = (length - 130);
            res = res / 2;
            int xValue = res + gap + 100;
            svg.append("<rect x='").append(xValue-8).append("' y='").append(gapFromEdgePosts+gap).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
            svg.append("<rect x='").append(xValue-8).append("' y='").append(width-gapFromEdgePosts-5+gap-10).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        }
        
        if(width > 600) {
            int res = (length - 130);
            res = res / 2;
            int xValue = res + gap + 100;
            int yValue = width / 2;
            yValue += gap - 8;
            
            svg.append("<rect x='").append(100+gap).append("' y='").append(yValue).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
            svg.append("<rect x='").append(length+gap-30-16).append("' y='").append(yValue).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
            svg.append("<rect x='").append(xValue-8).append("' y='").append(yValue).append("' height='16' width='16' stroke-width='2' stroke='black' fill='#cece9f'/>");
        }
    }
    
    public static void main(String[] args) {
        SVGFromTop svg = new SVGFromTop(690, 630, true, 400, 240, "fladt", 30);
        System.out.println(svg.getSVG());
    }
    
    
}
