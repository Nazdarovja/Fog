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
public class ProductPerPrice implements Product {

    private int id;
    private String name;
    private String category;
    private long price;

    public ProductPerPrice(int id, String name, String category, long price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
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
        this.price = (price /100);
    }

    @Override
    public long getPrice() {
        return this.price;
    }

    @Override
    public void setLength(int length) {
        throw new UnsupportedOperationException("NOT USED WITH TOOLS"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getLength() {
        throw new UnsupportedOperationException("NOT USED WITH TOOLS"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWidth() {
        throw new UnsupportedOperationException("NOT USED WITH TOOLS"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHeight() {
        throw new UnsupportedOperationException("NOT USED WITH TOOLS"); //To change body of generated methods, choose Tools | Templates.
    }

}
