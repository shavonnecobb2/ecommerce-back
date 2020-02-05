package com.shavonne.ecommerce.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity(name = "ECommerce")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id")
    private Integer id;

    @NotNull
    @Column(name = "Product_Name")
    private String productName;

    @NotNull
    @Column(name = "Product_Image")
    private String productImage;

    @NotNull
    @Column(name = "Product_Price")
    private String productPrice;

    @NotNull
    @Column(name = "Product_Description")
    private String productDescription;

    @NotNull
    @Column(name = "Product_Serving_Size")
    private String productServingSize;


    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductServingSize() {
        return productServingSize;
    }
}
