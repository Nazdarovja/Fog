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
public class ProductPerMeterPrice implements Product {

    private int id;
    private String name;
    private String category;
    private long price;
    private int length;
    private int width;
    private int height;

    public ProductPerMeterPrice(int id, String name, String category, long price, int length, int width, int height) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * Calculates the price for the entire length and returns it.
     *
     * @return total price for length
     */
    @Override
    public long getPrice() {
        return (this.price * (length / 100));
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", length=" + length + ", width=" + width + ", height=" + height + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
