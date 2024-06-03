/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

/**
 *
 * @author hd
 */
public class ProductDTO {

    private String mobileID, mobileName, Description;
    private float Price;
    private int yearOfProduction, Quantity, notSale;

    public ProductDTO() {
    }

    public ProductDTO(String mobileID, String Description, float Price, String mobileName, int yearOfProduction, int Quantity, int notSale) {
        this.mobileID = mobileID;
        this.mobileName = mobileName;
        this.Description = Description;
        this.Price = Price;
        this.yearOfProduction = yearOfProduction;
        this.Quantity = Quantity;
        this.notSale = notSale;
    }

    
    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getNotSale() {
        return notSale;
    }

    public void setNotSale(int notSale) {
        this.notSale = notSale;
    }

    
    

}
