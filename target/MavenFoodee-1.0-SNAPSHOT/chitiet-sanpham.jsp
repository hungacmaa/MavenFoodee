<%-- 
    Document   : chitiet-sanpham
    Created on : Jun 1, 2022, 3:25:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="/common/headTag.html" %>
    <body>
        <%@include file="/common/header.jsp" %>

        <main class="chi-tiet-sanpham noidung-trang">
            <div class="tongquat baoquanh">
                <div class="phan-trai">
                    <div class="box-anh">
                        <div class="anh-to">
                            <img
                                src="https://cdn.tgdd.vn/Files/2019/03/07/1153472/chinese-new-year_600x800.jpg"
                                alt=""
                                />
                        </div>
                        <div class="anh-duoi">
                            <div class="anh-list">
                                <div class="anh-item">
                                    <img
                                        src="https://cdn.tgdd.vn/Files/2019/03/07/1153472/chinese-new-year_600x800.jpg"
                                        alt=""
                                        />
                                </div>
                                <div class="anh-item">
                                    <img
                                        src="https://cdn.tgdd.vn/Files/2019/03/07/1153472/chinese-new-year_600x800.jpg"
                                        alt=""
                                        />
                                </div>
                                <div class="anh-item">
                                    <img
                                        src="https://cdn.tgdd.vn/Files/2019/03/07/1153472/chinese-new-year_600x800.jpg"
                                        alt=""
                                        />
                                </div>
                                <div class="anh-item">
                                    <img
                                        src="https://cdn.tgdd.vn/Files/2019/03/07/1153472/chinese-new-year_600x800.jpg"
                                        alt=""
                                        />
                                </div>
                                <div class="anh-item">
                                    <img
                                        src="https://cdn.tgdd.vn/Files/2019/03/07/1153472/chinese-new-year_600x800.jpg"
                                        alt=""
                                        />
                                </div>
                                <div class="anh-item">
                                    <img
                                        src="https://cdn.tgdd.vn/Files/2019/03/07/1153472/chinese-new-year_600x800.jpg"
                                        alt=""
                                        />
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="benduoi"></div>

                </div>

                <div class="phan-phai">
                    <h4 class="ten-sanpham"><%= sp.getName()%></h4>
                    <div class="box-danhgia">
                        <div class="danhgia">
                            <% for (int i = 1; i <= 5; ++i) {%>
                            <span class="ngoisao <%= (i <= sp.getRate()) ? "hoatdong" : ""%>">
                                <i class="fa-solid fa-star"></i>
                            </span>
                            <%}%>
                        </div>
                    </div>
                    <div class="box-gia">
                        <div class="gia"><%= currencyVN.format(sp.getPriceDiscount())%></div>
                    </div>
                    <form action="./addtocart" method="post">
                        <div class="soluong">
                            <span class="chonsoluong">Chọn số lượng : </span>
                            <div class="soluong-form">
                                <div onclick="giam()" class="soluong-nut" id="giam">-</div>
                                <input class="soluong" name="soluong" type="number" id="soluong" value="0" />
                                <div onclick="tang()" class="soluong-nut" id="tang">+</div>
                                <input style="display: none;" type="text" name="pid" value="<%= sp.getId()%>"/>
                            </div>
                        </div>
                        <div class="box-nut">
                            <button type="submit" class="nut-them nut">Thêm vào giỏ hàng</button>

                        </div>
                    </form>

                    <hr />
                    <p><%= sp.getIntro()%></p>
                </div>

            </div>

            <div class="chitiet baoquanh">
                <h4 class="tieude">CHI TIẾT SẢN PHẨM</h4>
                <%= sp.getDetail()%>
                <h4 class="tieude">MÔ TẢ SẢN PHẨM</h4>
                <p class="noidung">
                    <%= sp.getDescription()%>
                </p>
            </div>

            <div class="thongbao-tong thanhcong">
                <h4 class="title"></h4>
                <p class="text"></p>
            </div>
        </main>

        <%@include file="/common/footer.jsp" %>

        <script>
            const inputSL = document.getElementById("soluong")

            function giam(e) {
                const sl = Number(inputSL.value) - 1
                if (sl >= 0) {
                    inputSL.value = sl
                }
            }

            function tang(e) {
                const sl = Number(inputSL.value) + 1
                inputSL.value = sl
            }

            <% if (request.getAttribute("display")!=null && (Boolean) request.getAttribute("display")) {%>
            guiThongbao('${note}', 'Kiểm tra giỏ hàng')
            <%}%>

            function guiThongbao(title, text) {
                document.querySelector('.thongbao-tong').style.display = 'block';
                document.querySelector('.thongbao-tong .title').textContent = title;
                document.querySelector('.thongbao-tong .text').textContent = text;
                setTimeout(() => {
                    document.querySelector('.thongbao-tong').style.display = 'none';
                }, 4000);

            }
        </script>
    </body>


</html>
