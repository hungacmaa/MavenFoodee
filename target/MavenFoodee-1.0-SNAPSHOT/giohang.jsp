<%-- 
    Document   : giohang
    Created on : Jun 1, 2022, 3:25:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="/common/headTag.html" %>
    <body>
        <%@include file="/common/header.jsp" %>

        <main class="trang-gio-hang noidung-trang">
            <div class="baoquanh">
                <div class="tieude-trang">
                    Giỏ hàng
                </div>
                <div class="chiacot">
                    <div class="phantrai">
                        <div class="giohang-list">
                            <% for (CartItem item : giohang) {%>
                            <div class="giohang-item">
                                <div class="avatar">
                                    <img
                                        src="<%= item.getSp().getAvatar()%>"
                                        alt=""
                                        />
                                </div>
                                <div class="box-sanpham">
                                    <p class="tensanpham"><%= item.getSp().getName()%></p>
                                    <p class="motangan">
                                        <%= item.getSp().getIntro()%>
                                    </p>
                                </div>
                                <div class="box-thongtin">
                                    <p class="gia"><%= currencyVN.format(item.getTongtien())%></p>
                                    <!--<button class="them">+</button>-->
                                    <p class="soluong">số lượng : <%= item.getSl()%></p>
                                </div>
                            </div>
                            <% }%>
                        </div>
                    </div>
                    <div class="phanphai">
                        <div class="box-thanhtoan">
                            <h4 class="tieude">Thông tin đơn hàng</h4>
                            <p class="tongtien">
                                Tổng tiền : <%= currencyVN.format(tongtien)%></span>
                            </p>
                            <form action="./hoadon" method="POST" enctype="multipart/form-data">
                                <div class="thongtin-item">
                                    <p class="tieude-thongtin">Họ tên</p>
                                    <input type="text" name="name"/>
                                </div>
                                <div class="thongtin-item">
                                    <p class="tieude-thongtin">Số điện thoại</p>
                                    <input type="text" name="phone"/>
                                </div>
                                <div class="thongtin-item">
                                    <p class="tieude-thongtin">Email</p>
                                    <input type="text" name="email"/>
                                </div>
                                <div class="thongtin-item">
                                    <p class="tieude-thongtin">Địa chỉ</p>
                                    <input type="text" name="address"/>
                                </div>
                                <button type="submit" class="dathang nut">Đặt Hàng</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </main>

        <%@include file="/common/footer.jsp" %>
    </body>
</html>
