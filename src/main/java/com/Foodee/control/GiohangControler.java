/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.control;

import com.Foodee.Model.CartItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GiohangControler", urlPatterns = {"/giohang"})
public class GiohangControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // load loại sản phẩm lên header
        request.getRequestDispatcher("common").include(request, response);
        // lấy ra các sản phẩm trong giỏ hàng dùng session
        HttpSession session = request.getSession();
        ArrayList<CartItem> giohang = new ArrayList<>();
        if(session.getAttribute("giohang")!=null){
            giohang = (ArrayList<CartItem>) session.getAttribute("giohang");
        }
        request.setAttribute("giohang", giohang);
        int tongtien = 0;
        for(CartItem item:giohang){
            tongtien += item.getTongtien();
        }
        request.setAttribute("tongtien", tongtien);
        
        // xử lý khi đặt hàng
        if (request.getParameter("added") != null) {
            request.setAttribute("display", true);
            if (request.getParameter("added").equals("true")) {
                request.setAttribute("note", "Đặt hàng thành công");
            }
            else{
                request.setAttribute("note", "Đặt hàng không thành công");
            }
        }
        
        request.getRequestDispatcher("giohang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
