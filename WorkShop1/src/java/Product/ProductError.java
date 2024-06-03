/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

/**
 *
 * @author lienm
 */
public class ProductError {

    private String mobileID, mobileName, Description, Price, yearOfProduction, Quantity, notSale;

    public ProductError() {
        this.mobileID = "";
        this.Description = "";
        this.Price = "";
        this.mobileName = "";
        this.yearOfProduction = "";
        this.Quantity = "";
        this.notSale = "";
    }

    public ProductError(String mobileID, String mobileName, String Description, String Price, String yearOfProduction, String Quantity, String notSale) {
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public String getNotSale() {
        return notSale;
    }

    public void setNotSale(String notSale) {
        this.notSale = notSale;
    }

}
