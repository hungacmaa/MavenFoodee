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
public class LoaiDA {
    private int id;
    private String name;
    private String avatar;
    private String desciption;

    public LoaiDA(int id, String name, String avatar, String desciption) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.desciption = desciption;
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

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "LoaiDA{" + "id=" + id + ", name=" + name + ", avatar=" + avatar + ", desciption=" + desciption + '}';
    }
    
    
}
