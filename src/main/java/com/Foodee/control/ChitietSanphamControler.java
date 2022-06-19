/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.control;

import com.Foodee.Model.SanPham;
import com.Foodee.dao.SanPhamDAO;
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
@WebServlet(name = "ChitietSanphamControler", urlPatterns = {"/chitietsanpham"})
public class ChitietSanphamControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        // load loại sản phẩm lên header
        request.getRequestDispatcher("common").include(request, response);
        
        // lấy id sản phẩm
        int pid = Integer.parseInt(request.getParameter("pid"));
        // get ra sản phẩm với id đó
        SanPham sp = new SanPhamDAO().getElementById(pid);
        // đẩy vào jsp
        request.setAttribute("sp", sp);
        
        if (request.getParameter("added") != null) {
            request.setAttribute("display", true);
            if (request.getParameter("added").equals("true")) {
                request.setAttribute("note", "Thêm vào giỏ hàng thành công");
            }
            else{
                request.setAttribute("note", "Bạn phải chọn ít nhất 1 sản phẩm");
            }
        }
        

        request.getRequestDispatcher("chitiet-sanpham.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
