/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.dao;

import com.Foodee.Model.LoaiDA;
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
public class LoaiDADAO {

    private String tableName = "Category";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<LoaiDA> getAllCategory() {
        List<LoaiDA> list = new ArrayList<>();
        String query = "select * from " + tableName;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiDA(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4))
                );
            }
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public List<LoaiDA> getElementById(int id) {
        List<LoaiDA> list = new ArrayList<>();
        String query = "select * from " + tableName + " where id=" + id;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new LoaiDA(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4))
                );
            }
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<LoaiDA> list = (ArrayList<LoaiDA>) new LoaiDADAO().getElementById(1);
        for (LoaiDA x : list) {
            System.out.println(x);
        }
    }
}
