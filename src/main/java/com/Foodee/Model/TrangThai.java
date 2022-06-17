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
public class TrangThai {
    private String status;

    public TrangThai(){
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public TrangThai(int s) {
        if(s==1){
            this.status = "thanh cong";
        }
        else{
            this.status = "that bai";
        }
    }

    @Override
    public String toString() {
        return "TrangThai{" + "status=" + status + '}';
    }
    
}
