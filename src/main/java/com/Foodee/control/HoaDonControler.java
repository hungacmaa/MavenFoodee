/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.control;

import com.Foodee.Model.BillItem;
import com.Foodee.Model.CartItem;
import com.Foodee.Model.HoaDon;
import com.Foodee.dao.BillItemDAO;
import com.Foodee.dao.HoaDonDAO;
import com.Foodee.dao.SanPhamDAO;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "HoaDonControler", urlPatterns = {"/hoadon"})
public class HoaDonControler extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // lấy đt hddao quản lý dịch vụ về hóa đơn
        HoaDonDAO hddao = new HoaDonDAO();
        BillItemDAO bidao = new BillItemDAO();
        SanPhamDAO spdao = new SanPhamDAO();
        // lấy id cao nhất hiện tại của bảng hóa đơn
        int id = hddao.getTopId();
        // lấy thông tin hóa đơn
        String ten = request.getParameter("name");
        String sdt = request.getParameter("phone");
        String email = request.getParameter("email");
        String diachi = request.getParameter("address");
        ArrayList<CartItem> dssp = new ArrayList<>();
        if (request.getSession().getAttribute("giohang") != null) {
            dssp = (ArrayList<CartItem>) request.getSession().getAttribute("giohang");
        }
        
        System.out.println(ten + sdt + email + diachi);
        
        if (ten == null || sdt == null || email == null || diachi == null) {
            response.sendRedirect("giohang?added=false");
        } else {
            // tạo 1 đối tượng hóa đơn
            HoaDon hd = new HoaDon(id, ten, diachi, email, sdt, dssp);
            // thêm hóa đơn vào cơ sở dữ liệu
            hddao.addHoaDon(hd);
            // thêm các sản phẩm trong hóa đơn vào bảng Bill_Item
            for (CartItem item : dssp) {
                BillItem bi = new BillItem(bidao.getTopId(), item.getSp(), hd, item.getSl());
                bidao.addBillItem(bi);
                spdao.updateAmount(item.getSp().getId(), item.getSl());
            }
            // xóa sản phẩm trong giỏ hàng ở session
            if (request.getSession().getAttribute("giohang") != null) {
                ArrayList<CartItem> list = (ArrayList<CartItem>) request.getSession().getAttribute("giohang");
                list.clear();
            }
            response.sendRedirect("giohang?added=true");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
