<%-- 
    Document   : header
    Created on : Jun 2, 2022, 3:18:20 PM
    Author     : Admin
--%>

<%@page import="com.Foodee.Model.CartItem"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.Foodee.Model.SanPham"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.Foodee.Model.LoaiDA"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ArrayList<LoaiDA> dsLoai = (ArrayList<LoaiDA>) request.getAttribute("dsLoai"); %>
<% ArrayList<SanPham> dssp = (ArrayList<SanPham>) request.getAttribute("dssp"); %>
<% SanPham sp = (SanPham) request.getAttribute("sp");%>
<% Locale localeVN = new Locale("vi", "VN"); %>
<% NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN); %>
<% ArrayList<CartItem> giohang = (ArrayList<CartItem>) request.getAttribute("giohang"); %>
<% int tongtien = (Integer)request.getAttribute("tongtien"); %>
<header>
    <div class="baoquanh">
        <div class="header-tren">
            <div class="phan">
                <a href="" class="link"> Kênh người bán </a>
                <a href="" class="link"> Kênh người bán </a>
                <a href="" class="link"> Kênh người bán </a>
            </div>
            <div class="phan">
                <a href="" class="link"> Kênh người bán </a>
                <a href="" class="link"> Kênh người bán </a>
                <a href="" class="link"> Kênh người bán </a>
            </div>
        </div>
        <div class="header-duoi">
            <a href="./trangchu" class="phan1">
                <img
                    src="https://bachacumin.vn/wp-content/uploads/2021/08/y-nghia-logo-shopee.jpg"
                    alt=""
                    class="logo"
                    />
            </a>
            <div class="phan2">
                <form action="./sanpham" method="get">
                    <div class="form-timmkiem">
                        <input type="text" placeholder="Tìm kiếm sản phẩm" name="nameKey" />
                        <button class="nutdongy" type="submit">
                            <i class="fa-solid fa-search"></i>
                        </button>
                    </div>
                </form>

                <div class="duoi-timkiem">
                    <% for (LoaiDA o : dsLoai) {%>
                    <a href="./loaisanpham?cid=<%= o.getId()%>" class="link"><%= o.getName()%></a>
                    <%}%>
                </div>
            </div>
            <div class="phan3">
                <a href="./giohang" class="giohang">
                    <i class="fa-solid fa-cart-shopping"></i>
                </a>
            </div>
        </div>
    </div>
</header>
