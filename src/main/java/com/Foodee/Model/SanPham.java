/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.Model;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class SanPham {

    private int id;
    private String name;
    private String avatar;
    private String description;
    private int price;
    private int rate;
    private int categoryId;
    private String intro;
    private String detail;
    private int discount;
    private int amount;

    public SanPham(){};
    
    public SanPham(int id, String name, String avatar, String description, int price, int rate, int categoryId, String intro, String detail, int discount, int amount) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.description = description;
        this.price = price;
        this.rate = rate;
        this.categoryId = categoryId;
        this.intro = intro;
        this.detail = detail;
        this.discount = discount;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceDiscount() {
        return price - price * discount / 100;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "SanPham{" + "id=" + id + ", name=" + name + ", price=" + price + ", rate=" + rate + ", categoryId=" + categoryId + ", discount=" + discount + '}';
    }


}
