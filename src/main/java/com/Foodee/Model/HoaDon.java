/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.Model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int id;
    private String name;
    private String address;
    private String email;
    private String phone;
    private ArrayList<CartItem> dssp = new ArrayList<>();

    public HoaDon(){
        
    }
    
    public HoaDon(int id, String name, String address, String email, String phone, ArrayList<CartItem> dssp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.dssp = dssp;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<CartItem> getDssp() {
        return dssp;
    }

    public void setDssp(ArrayList<CartItem> dssp) {
        this.dssp = dssp;
    }

    public int getTotal(){
        int res = 0;
        for(CartItem item:dssp){
            res+=item.getTongtien();
        }
        return res;
    }
    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phone=" + phone + ", dssp=" + dssp + '}';
    }

    

    
    
    
}
