/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.dao;

import com.Foodee.Model.BillItem;
import com.Foodee.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class BillItemDAO {
    private String tableName = "Bill_Item";
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
    
    public void addBillItem(BillItem bi){
//        String query = "insert into "+tableName+" values("+bi.getId()+", "+bi.getSp().getId()+"', N'"+bi.getHd().getId()+"', '"+bi.getSl()+ ")";
        String query = "insert into Bill_Item values("+bi.getId()+", "+bi.getSp().getId()+", "+bi.getHd().getId()+", "+bi.getSl()+")";
        try {
            connectDB();
            ps = conn.prepareStatement(query);
            ps.executeQuery();
            stopConnectDB();
        } catch (Exception e) {

        }
    }
    
    public static void main(String[] args) {
//        new BillItemDAO().addBillItem();
    }
}
