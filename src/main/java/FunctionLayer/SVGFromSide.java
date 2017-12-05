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
public class SVGFromSide {
    
    private StringBuilder svg = new StringBuilder();
    
    private int length;
    private int width;
    private int height;
    private boolean withShack;
    private int shackLength;
    private int shackWidth;
    private String roofType;
    private int angle;
    private int gap;

    public SVGFromSide(int length, int width, int height, boolean withShack, int shackLength, int shackWidth, String roofType, int angle) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.withShack = withShack;
        this.shackLength = shackLength;
        this.shackWidth = shackWidth;
        this.roofType = roofType;
        this.angle = angle;
        gap = 40;
        
        if(this.roofType.equals("fladt")) {
            makeFlatRoofCarport();
        } else {
            makePitchedRoofCarport();
        }
    }
    
    public StringBuilder getSVG() {
        return svg;
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
    
    private void makeFlatRoofCarport() {
        svg.append("<SVG width='50%' viewbox='0 0 ").append(length+gap+gap).append(" ").append(height+gap+gap).append("'>");
        makePosts();
        makeTopPlate();
        makeEaves();
        if(withShack) {
            makeShack();
            makeSidePanels();
        }
        makeLineMeasurements();
        svg.append("</SVG>");
    }

    private void makePitchedRoofCarport() {
        svg.append("<SVG width='50%' viewbox='0 0 ").append(length+gap+gap).append(" ").append(height+gap+gap).append("'>");
        svg.append("</SVG>");
    }
    
    public void makePosts() {
        svg.append("<rect x='").append(100+gap).append("' y=").append(gap).append(" height=").append(height).append(" width='10' stroke-width='2' stroke='black' fill='#000000'/>");
        svg.append("<rect x='").append(length+gap-30-10).append("' y=").append(gap).append(" height=").append(height).append(" width='10' stroke-width='2' stroke='black' fill='#000000'/>");
        if(length > 620) {
            int first = 100 + gap;
            int second = length + gap - 30;
            int res = second - first;
            res /= 2;
            svg.append("<rect x='").append(res+gap+100).append("' y=").append(gap).append(" height=").append(height).append(" width='10' stroke-width='2' stroke='black' fill='#000000'/>");
        }
    }
    
    public void makeTopPlate() {
        svg.append("<rect x='").append(gap).append("' y=").append(gap).append(" height='10'").append(" width='").append(length).append("' stroke-width='2' stroke='black' fill='#000000'/>");
    }
    
    public void makeEaves() {
        svg.append("<rect x='").append(gap).append("' y=").append(gap+13).append(" height='10'").append(" width='").append(length).append("' stroke-width='2' stroke='black' fill='#000000'/>");
    }
    
    public void makeShack() {
        svg.append("<rect x='").append(gap+length-shackWidth-30).append("' y=").append(gap+13).append(" height='").append(height-13).append("' width='").append(shackWidth).append("' stroke-width='2' stroke='black' fill='#a0a2a5'/>");
    }
    
    public void makeSidePanels() {
        boolean oneMore = true;
        int xValue = gap + length - shackWidth - 30;
        while(oneMore) {
            svg.append("<rect x='").append(xValue).append("' y='").append(gap+13).append("' height='").append(height-13).append("' width='10'").append("' stroke-width='2' stroke='black' fill='#000000'/>");
            xValue += 15;
            if(xValue + 10 >= gap + length - 30) 
                oneMore = false;
        }
    }
    
    public void makeLineMeasurements() {
        svg.append("<line x1='30' y1=").append(gap+13).append(" x2='30' y2=").append(gap+height).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
        svg.append("<text x='25' y=").append(height/2+gap).append(" style='writing-mode: tb;' fill='black'>").append(height-13).append("</text>"); // height minus Eave
        
        svg.append("<line x1=").append(gap+length+20).append(" y1=").append(gap).append(" x2=").append(gap+length+20).append(" y2=").append(height+gap).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
        svg.append("<text x=").append(gap+length+20-10).append(" y=").append(height/2+gap).append(" style='writing-mode: tb;' fill='black'>").append(height-10).append("</text>"); // end of carport
        
        svg.append("<line x1='10' y1=").append(gap).append(" x2='10' y2=").append(height+gap).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
        svg.append("<text x='5' y=").append(height/2+gap).append(" style='writing-mode: tb;' fill='black'>").append(height).append("</text>"); // height of carport
        
        svg.append("<line x1=").append(gap).append(" y1=").append(height+gap+20).append(" x2=").append(100+gap).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 1 meter
        svg.append("<text x=").append(90).append(" y=").append(height+gap+15).append(">").append(100).append("</text>");
        svg.append("<line x1=").append(gap).append(" y1=").append(height+gap+5).append(" x2=").append(gap).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
        svg.append("<line x1=").append(100+gap).append(" y1=").append(height+gap+5).append(" x2=").append(100+gap).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
        
        if(withShack) {
            int half = shackWidth / 2;
            svg.append("<line x1=").append(gap+length-shackWidth-30).append(" y1=").append(height+gap+20).append(" x2=").append(gap+length-30).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
            svg.append("<line x1=").append(gap+length-30).append(" y1=").append(height+gap+5).append(" x2=").append(gap+length-30).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
            svg.append("<text x=").append(gap+length-half-30).append(" y=").append(height+gap+15).append(">").append(shackWidth).append("</text>");
        }
        
        if(length > 620) { // with 3 posts
            int first = 100 + gap;
            int second = length + gap - 30;
            int centerPost = second - first;
            centerPost /= 2;
            centerPost += 100 + gap;
            
            svg.append("<line x1=").append(100+gap).append(" y1=").append(height+gap+20).append(" x2=").append(centerPost).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
            svg.append("<text x=").append((centerPost+100+gap)/2).append(" y=").append(height+gap+15).append(">").append(centerPost-100-gap).append("</text>");
            svg.append("<line x1=").append(centerPost).append(" y1=").append(height+gap+5).append(" x2=").append(centerPost).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
            
            if(withShack) { // with shack with 3 posts
                svg.append("<line x1=").append(centerPost).append(" y1=").append(height+gap+20).append(" x2=").append(gap+length-shackWidth-30).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
                svg.append("<line x1=").append(gap+length-shackWidth-30).append(" y1=").append(height+gap+5).append(" x2=").append(gap+length-shackWidth-30).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
                svg.append("<text x=").append((gap+length-shackWidth-30+centerPost-8)/2).append(" y=").append(height+gap+15).append(">").append((gap+length-shackWidth-30)-centerPost).append("</text>");
            } 
            else { // with 3 posts
                svg.append("<line x1=").append(centerPost).append(" y1=").append(height+gap+20).append(" x2=").append(gap+length-30).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
                svg.append("<line x1=").append(gap+length-30).append(" y1=").append(height+gap+5).append(" x2=").append(gap+length-30).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
                svg.append("<text x=").append((gap+length-30+centerPost-8)/2).append(" y=").append(height+gap+15).append(">").append((gap+length-30)-centerPost).append("</text>");
            }
        } 
        else {
            if(!withShack) { // with shack with 2 posts
                svg.append("<line x1=").append(100+gap).append(" y1=").append(height+gap+20).append(" x2=").append(gap+length-30).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
                svg.append("<text x=").append((gap+length-30+100+gap)/2).append(" y=").append(height+gap+15).append(">").append((gap+length-30)-(100+gap)).append("</text>");
                svg.append("<line x1=").append(gap+length-30).append(" y1=").append(height+gap+5).append(" x2=").append(gap+length-30).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
            }
            else { // with shack with 2 posts
                svg.append("<line x1=").append(100+gap).append(" y1=").append(height+gap+20).append(" x2=").append(gap+length-shackWidth-30).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
                svg.append("<text x=").append((gap+length-shackWidth-30+100+gap)/2).append(" y=").append(height+gap+15).append(">").append((gap+length-30-shackWidth)-(100+gap)).append("</text>");
                svg.append("<line x1=").append(gap+length-shackWidth-30).append(" y1=").append(height+gap+5).append(" x2=").append(gap+length-shackWidth-30).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>");
            }
        }
        
        // gap at the end
        svg.append("<line x1=").append(gap+length-30).append(" y1=").append(height+gap+20).append(" x2=").append(gap+length).append(" y2=").append(height+gap+20).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 30 cm to the end
        svg.append("<line x1=").append(gap+length).append(" y1=").append(height+gap+5).append(" x2=").append(gap+length).append(" y2=").append(height+gap+30).append(" style='stroke:rgb(0,0,0);stroke-width:2'/>"); // 
        svg.append("<text x=").append(gap+length-20).append(" y=").append(height+gap+15).append(">").append(30).append("</text>");
    }
    
    public static void main(String[] args) {
        SVGFromSide svg = new SVGFromSide(580, 630, 210, true, 400, 240, "fladt", 30);
        System.out.println(svg.getSVG());
    }
}
