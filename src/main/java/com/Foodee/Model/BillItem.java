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
public class BillItem {
    private int id;
    private SanPham sp;
    private HoaDon hd;
    private int sl;

    public BillItem(int id, SanPham sp, HoaDon hd, int sl) {
        this.id = id;
        this.sp = sp;
        this.hd = hd;
        this.sl = sl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    @Override
    public String toString() {
        return "BillItem{" + "id=" + id + ", sp=" + sp + ", hd=" + hd + ", amount=" + sl + '}';
    }
    
}
