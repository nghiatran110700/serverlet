/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.Date;
import org.apache.tomcat.jni.Local;

/**
 *
 * @author TRONG NGHIA
 */
public class Cart {
   private int idUser;
   private int idProduct;
   private String nameProduct;
   private double price;
   private String image;
   private int amount;
   private LocalDate dateBuy;
   
   public Cart(){
   }

    public Cart(int idUser, int idProduct, String nameProduct, double price, String image, int amount, LocalDate dateBuy) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.image = image;
        this.amount = amount;
        this.dateBuy = dateBuy;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(LocalDate dateBuy) {
        this.dateBuy = dateBuy;
    }

    @Override
    public String toString() {
        return "Cart{" + "idUser=" + idUser + ", idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", price=" + price + ", image=" + image + ", amount=" + amount + ", dateBuy=" + dateBuy + '}';
    }

 
    
}
