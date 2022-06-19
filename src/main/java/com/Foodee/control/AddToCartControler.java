/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.control;

import com.Foodee.Model.CartItem;
import com.Foodee.Model.SanPham;
import com.Foodee.dao.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "AddToCartControler", urlPatterns = {"/addtocart"})
public class AddToCartControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SanPhamDAO spdao = new SanPhamDAO();
        // sản phẩm đang xem
        SanPham thisSP = spdao.getElementById(Integer.parseInt(request.getParameter("pid")));
        // số lượng muốn thêm vào giỏ hàng
        int soluong = Integer.parseInt(request.getParameter("soluong"));

        // xử lý thêm giỏ hàng bằng session
        if (soluong > 0) {
            HttpSession session = request.getSession();
            
            if (session.getAttribute("giohang") != null) {
                System.out.println(session.getAttribute("giohang"));
                ArrayList<CartItem> giohang = (ArrayList<CartItem>) session.getAttribute("giohang");
                int co = 0;
                for (CartItem item : giohang) {
                    if (item.getSp().getId() == thisSP.getId()) {
                        item.increaseSL(soluong);
                        co = 1;
                        break;
                    }
                }
                if (co == 0) {
                    giohang.add(new CartItem(thisSP, soluong));
                }

            } else {
                ArrayList<CartItem> giohang = new ArrayList<>();
                giohang.add(new CartItem(thisSP, soluong));
                session.setAttribute("giohang", giohang);
            }
            response.sendRedirect("./chitietsanpham?pid="+request.getParameter("pid")+"&added=true");
        }
        else{
            response.sendRedirect("./chitietsanpham?pid="+request.getParameter("pid")+"&added=false");
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
