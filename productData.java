
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class productData {
    private Integer id;
    private String productId;
    private String productName;
    private Double price;
    private Integer quantity;
    private Date date;


public productData(Integer id, String productId, String productName, Integer quantity,Double price, Date date) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;       
        this.quantity = quantity;
        this.price = price;
        this.date = date;
}

    public Integer getId() {
        return id;
    }
    
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity(){
        return quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public Date getDate() {
        return date;
    }
    
}
