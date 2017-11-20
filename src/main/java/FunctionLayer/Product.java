/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 * @author Stanislav
 */
public interface Product {

    public String getName();
    public long getPrice();
    public String getCategory();
    public void setLength(int length);
    public int getLength();
    public int getWidth();
    public int getHeight();
}
