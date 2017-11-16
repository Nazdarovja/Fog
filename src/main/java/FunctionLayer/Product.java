/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Stanislav
 */
public class Product {

    private int id;
    private String name;
    private String category;
    private long pricePrM;
    private int length;
    private int width;
    private int height;

    public Product(int id, String name, String category, long pricePrM, int length, int width, int height) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.pricePrM = pricePrM;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Calculates the price for the entire length and returns it.
     *
     * @return total price for length
     */
    public long getCalculatedPrice() {
        return (this.pricePrM * (length / 100));
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", category=" + category + ", price=" + pricePrM + ", length=" + length + ", width=" + width + ", height=" + height + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getPricePrM() {
        return pricePrM;
    }

    public void setPricePrM(long pricePrM) {
        this.pricePrM = pricePrM;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
