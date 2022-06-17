/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.Model;

/**
 *
 * @author Admin
 */
public class CartItem {
    private SanPham sp;
    private int sl;
    private int tongtien;

    public CartItem(SanPham sp, int sl) {
        this.sp = sp;
        this.sl = sl;
        this.tongtien = sp.getPriceDiscount()*sl;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void increaseSL(int n) {
        sl+=n;
        tongtien = sl*sp.getPriceDiscount();
    }
    
    @Override
    public String toString() {
        return "CartItem{" + "sp=" + sp + ", sl=" + sl + ", tongtien=" + tongtien + '}';
    }
    
    
}
