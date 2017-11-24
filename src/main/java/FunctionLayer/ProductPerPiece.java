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
public class ProductPerPiece implements Product {

    private String name;
    private String category;
    private long price;
    private int length;
    private int width;
    private int height;

    public ProductPerPiece(String name, String category, long price, int length, int width, int height) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getPrice() {
            return price;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }
    
    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    
}
