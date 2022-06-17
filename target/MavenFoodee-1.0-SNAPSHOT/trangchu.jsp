<%-- 
    Document   : trangchu
    Created on : Jun 1, 2022, 3:25:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="/common/headTag.html" %>
    <body>
        <%@include file="/common/header.jsp" %>

        <main class="trang-chu noidung-trang">
            <div class="baoquanh">
                <div class="danhmuc">
                    <h4 class="tieude">DANH MỤC</h4>
                    <div class="danhmuc-list">
                        <% for (LoaiDA o : dsLoai) {%>
                        <a href="./loaisanpham?cid=<%= o.getId() %>" class="danhmuc-item">
                            <img
                                src="<%= o.getAvatar()%>"
                                alt=""
                                class="anh"
                                />
                            <h4 class="ten"><%= o.getName()%></h4>
                        </a>
                        <%}%>
                    </div>
                </div>
                <div class="hop-tieude">
                    <h4 class="tieude">GỢI Ý HÔM NAY</h4>
                </div>
                <div class="sanpham-list">
                    <% for (SanPham o : dssp) {%>
                    <a href="./chitietsanpham?pid=<%= o.getId() %>" class="sanpham-item">
                        <div class="sanpham">
                            <div class="yeuthich">Yêu thích</div>
                            <div class="giamgia"><%= o.getDiscount() %>%</div>
                            <div class="anhdaidien" style="background-image: url(<%= o.getAvatar() %>)">
                            </div>
                            <div class="noidung">
                                <p class="ten"><%= o.getName() %></p>
                                <div class="duoiten">
                                    <div class="phan">
                                        <p class="gia"><%= currencyVN.format(o.getPriceDiscount()) %></p>
                                    </div>
                                    <div class="phan">
                                        <p class="daban">đã bán <%= o.getAmount() %></p>
                                    </div>
                                </div>
                            </div>
                            <div class="nut-tuongtu">Tìm sản phẩm tương tự</div>
                        </div>
                    </a>
                    <%}%>
                    
                </div>
            </div>
        </main>

        <%@include file="/common/footer.jsp" %>
    </body>
</html>
