/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

import Product.ProductDTO;
import Product.ProductDTO;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hd
 */
public class CartDTO {

    private Map<String, ProductDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public boolean add(ProductDTO product) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(product.getMobileID())) {
                int currentQuantity = this.cart.get(product.getMobileID()).getQuantity();
                product.setQuantity(currentQuantity + product.getQuantity());
            }
            this.cart.put(product.getMobileID(), product);
            check = true;
        } catch (Exception e) {
        }

        return check;
    }

    public boolean change(String mobileID, ProductDTO product) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(mobileID)) {
                    this.cart.replace(mobileID, product);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
    public boolean remove(String mobileID) {
        boolean check = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(mobileID)) {
                    this.cart.remove(mobileID);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

}
