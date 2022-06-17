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

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoaiSanPhamControler", urlPatterns = {"/loaisanpham"})
public class LoaiSanPhamControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // load loại sản phẩm lên header
        request.getRequestDispatcher("common").include(request, response);
        // lấy cid
        int cid = Integer.parseInt(request.getParameter("cid"));
        request.setAttribute("cidHD", cid);
        // lấy danh sách sp có cid đó
        //----> vào dao của sản phẩm lấy ra danh sách sp thuộc cid đó
        SanPhamDAO spdao = new SanPhamDAO();
        List<SanPham> dssp = (spdao.getProductByCid(cid)!=null)?spdao.getProductByCid(cid):new ArrayList<SanPham>();
        // đẩy ra trang sản phẩm
        request.setAttribute("dssp", dssp);
        
        request.setAttribute("tieude", "Tất cả sản phẩm");
        request.getRequestDispatcher("sanpham.jsp").forward(request, response);
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
