/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.api;

import com.Foodee.Model.Person;
import com.Foodee.Model.SanPham;
import com.Foodee.Model.TrangThai;
import com.Foodee.dao.SanPhamDAO;
import com.Foodee.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
@WebServlet(name = "SanPhamAPI", urlPatterns = {"/api-sanpham"})
public class SanPhamAPI extends HttpServlet {

    private SanPhamDAO spdao = new SanPhamDAO();
    private ObjectMapper om = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        List<SanPham> listSP = spdao.getAllProduct();
        om.writerWithDefaultPrettyPrinter().writeValue(response.getOutputStream(), listSP);

    }

    // thêm sản phẩm
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        SanPham sp = null;
        int res = 0;
        TrangThai tt = new TrangThai();
        try {
            sp = HttpUtil.of(request.getReader()).toModel(SanPham.class); // convert chuỗi json nhận được về model
            res = new SanPhamDAO().insertProduct(sp); // lưu sản phẩm đó lại
            tt = new TrangThai(res);
        } catch (Exception e) {
            tt.setStatus("Cần nhập không thiếu các trường của sản phẩm");
        }

        om.writeValue(response.getOutputStream(), tt);
    }

    // sửa sản phẩm
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        SanPham sp = null;
        int res = 0;
        TrangThai tt = new TrangThai(res);
        sp = HttpUtil.of(req.getReader()).toModel(SanPham.class); // convert chuỗi json nhận được về model
        
        if (sp.getId() != 0) {
            res = new SanPhamDAO().updateProduct(sp.getId(), sp); // lưu sản phẩm đó lại
            tt = new TrangThai(res);
            om.writeValue(resp.getOutputStream(), tt);
        }
        else{
            om.writeValue(resp.getOutputStream(), tt);
        }
        
    }

//    // xóa sản phẩm
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xoa san pham thanh cong");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
