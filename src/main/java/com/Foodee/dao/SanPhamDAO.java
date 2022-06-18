/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.dao;

import com.Foodee.Model.SanPham;
import com.Foodee.context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SanPhamDAO {

    private String tableName = "Product";
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
    
    public List<SanPham> getAllProduct() {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from " + tableName;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11))
                );
            }
        } catch (Exception e) {
        }
        return list;
    }

    public SanPham getElementById(int id) {
        String query = "select * from " + tableName + " where id=" + id;
        SanPham res = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                res = new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11));
            }
        } catch (Exception e) {
        }
        return res;
    }

    public List<SanPham> getProductByCid(int cid) {
        List<SanPham> list = new ArrayList<>();

        String query = "select * from " + tableName + " where categoryid = " + cid;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11))
                );
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<SanPham> getProductByNameKey(String nameKey) {
        List<SanPham> list = new ArrayList<>();
        String query = "select * from " + tableName + " where name like '%" + nameKey + "%'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getInt(11))
                );
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateAmount(int id, int amount) {
        String query = "update Product set amount = amount+" + amount + " where id = " + id;
        SanPham res = null;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
    }
    
    public int insertProduct(SanPham sp){
        int id = getTopId();
        int a = 0;
        String query ="insert into Product values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            connectDB();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, sp.getName());
            ps.setString(3, sp.getAvatar());
            ps.setString(4, sp.getDescription());
            ps.setInt(5, sp.getPrice());
            ps.setInt(6, sp.getRate());
            ps.setInt(7, sp.getCategoryId());
            ps.setString(8, sp.getIntro());
            ps.setString(9, sp.getDetail());
            ps.setInt(10, sp.getDiscount());
            ps.setInt(11, sp.getAmount());
            a = ps.executeUpdate();
            stopConnectDB();
            
        } catch (Exception e) {
        }
        return a;
    }
    
    public int updateProduct(int pid, SanPham sp){
        int id = getTopId();
        int a = 0;
        String query ="update Product set name = ?,avatar = ?,description = ?,price = ?,rate = ?,categoryid = ?,intro = ?,detail = ?,discount = ?,amount = ? where id = ?";
        try {
            connectDB();
            ps = conn.prepareStatement(query);
            ps.setString(1, sp.getName());
            ps.setString(2, sp.getAvatar());
            ps.setString(3, sp.getDescription());
            ps.setString(4, ""+sp.getPrice());
            ps.setString(5, ""+sp.getRate());
            ps.setString(6, ""+sp.getCategoryId());
            ps.setString(7, sp.getIntro());
            ps.setString(8, sp.getDetail());
            ps.setString(9, ""+sp.getDiscount());
            ps.setString(10, ""+sp.getAmount());
            ps.setInt(11, pid);
            a = ps.executeUpdate();
            stopConnectDB();
            
        } catch (Exception e) {
        }
        return a;
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
    
    public static void main(String[] args) {
    }
}
