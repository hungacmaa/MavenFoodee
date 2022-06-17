/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.dao;

import com.Foodee.Model.CartItem;
import com.Foodee.Model.HoaDon;
import com.Foodee.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonDAO {

    private String tableName = "Bill";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private void connectDB() {
        try {
            conn = new DBContext().getConnection();
        } catch (Exception e) {
        }
    }

    private void stopConnectDB() {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }

    public int getTopId() {
        String query = "select top 1 id from " + tableName + " order by id desc";
        int id = 1;
        try {
            connectDB();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1)+1;
            }
            stopConnectDB();
        } catch (Exception e) {

        }
        return id;
    }
    
    public void addHoaDon(HoaDon hd){
        String query = "insert into "+tableName+" values("+hd.getId()+", N'"+hd.getName()+"', N'"+hd.getAddress()+"', '"+hd.getEmail()+"', '"+hd.getPhone()+"', "+hd.getTotal()+")";
        try {
            connectDB();
            ps = conn.prepareStatement(query);
            ps.executeQuery();
            stopConnectDB();
        } catch (Exception e) {

        }
    }
    
//    public void deleteHoaDon(int id){
//        String query = "select top 1 id from " + tableName + " order by id desc";
//        int id = 1;
//        try {
//            connectDB();
//            ps = conn.prepareStatement(query);
//            rs = ps.executeQuery();
//            while(rs.next()){
//                id = rs.getInt(1);
//            }
//            stopConnectDB();
//        } catch (Exception e) {
//
//        }
//        
//    }
    public static void main(String[] args) {
        HoaDon hd = new HoaDon(1, "hung", "asd", "asda", "asdasd", new ArrayList<CartItem>());
        System.out.println(new HoaDonDAO().getTopId());
//        new HoaDonDAO().addHoaDon(hd);
    }
}
