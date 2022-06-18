<%-- 
    Document   : sanpham
    Created on : Jun 1, 2022, 3:24:39 PM
    Author     : Admin
--%>

<%@page import="java.lang.Integer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="/common/headTag.html" %>
    <body>
        <%@include file="/common/header.jsp" %>
        <main class="danhsach-sanpham noidung-trang">
            <div class="baoquanh">
                <div class="chiacot">
                    <div class="phantrai">
                        <div class="box-danhmuc">
                            <h4 class="tieude">
                                Danh mục món ăn
                            </h4>
                            <% for (LoaiDA o : dsLoai) {%>
                            <div class="danhmuc-item">
                                <a class="link <%= ((int) request.getAttribute("cidHD") == o.getId()) ? "hoatdong" : ""%>" href="./loaisanpham?cid=<%= o.getId()%>"><%= o.getName()%></a>
                            </div>
                            <%}%>

                        </div>
                        <div class="box-sanpham-noibat">

                        </div>
                    </div>
                    <div class="phanphai">
                        <div class="hop-tieude">
                            <h4 class="tieude">${tieude}</h4>
                        </div>
                        <div class="boloc">
                            <div class="sapxep">
                                <select class="form-control" name="" id="">
                                    <option>Giá cao đến thấp</option>
                                    <option>Giá thấp đến cao</option>
                                    <option>Ký tự a-z</option>
                                    <option>Ký tự z-a</option>
                                </select>
                            </div>
                            <!--                            <div class="timtheoten">
                                                            <input type="text" />
                                                        </div>
                                                        <div class="sapxep">
                                                            <select class="form-control" name="" id="">
                                                                <option>Giá cao đến thấp</option>
                                                                <option>Giá thấp đến cao</option>
                                                                <option>Ký tự a-z</option>
                                                                <option>Ký tự z-a</option>
                                                            </select>
                                                        </div>-->
                            <button class="nut-tim">Tìm kiếm</button>
                        </div>
                        <div class="sanpham-list">
                            <% for (SanPham o : dssp) {%>
                            <a href="./chitietsanpham?pid=<%= o.getId()%>" class="sanpham-item">
                                <div class="sanpham">
                                    <div class="yeuthich">Yêu thích</div>
                                    <div class="giamgia"><%= o.getDiscount()%>%</div>
                                    <div class="anhdaidien" style="background-image: url(<%= o.getAvatar()%>)">
                                    </div>
                                    <div class="noidung">
                                        <p class="ten"><%= o.getName()%></p>
                                        <div class="duoiten">
                                            <div class="phan">
                                                <p class="gia"><%= currencyVN.format(o.getPriceDiscount())%></p>
                                            </div>
                                            <div class="phan">
                                                <p class="daban">đã bán <%= o.getAmount()%></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="nut-tuongtu">Tìm sản phẩm tương tự</div>
                                </div>
                            </a>
                            <%}%>

                        </div>
                    </div>
                </div>
            </div>
        </main>
      
        <%@include file="/common/footer.jsp" %>
    </body>
</html>
