<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>

<div
        class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Xác nhận đơn hàng</h1>
    <div class="btn-toolbar mb-2 ml-auto mb-md-0">
        <div class="btn-group mr-2"></div>
    </div>
</div>
<div class="col-sm-12">

    <div class="row">

        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation"><a
                    class="nav-link active" id="home-tab" data-toggle="tab" href="#home"
                    role="tab" aria-controls="home" aria-selected="true">Danh sách
                chưa xác nhận</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link"
                                                        id="profile-tab" data-toggle="tab" href="#profile" role="tab"
                                                        aria-controls="profile" aria-selected="false">Danh sách đã xác
                nhận</a></li>
            <li class="nav-item" role="presentation"><a class="nav-link"
                                                        id="contact-tab" data-toggle="tab" href="#contact" role="tab"
                                                        aria-controls="contact" aria-selected="false">Danh sách đã
                hủy</a></li>
        </ul>
        <div class="tab-content" id="myTabContent" style="margin-right: 500px">
            <div class="tab-pane fade show active" id="home" role="tabpanel"
                 aria-labelledby="home-tab">
                <table class="table table-bordered mb-5 mt-3">
                    <thead>
                    <tr class="text-center">

                        <th>Id</th>
                        <th>Tên khách hàng</th>
                        <th>Ngày mua hàng</th>
                        <th>Địa chỉ</th>
                        <th>Số điện thoại</th>
                        <th>Tổng đơn hàng</th>
                        <th>Xem chi tiết</th>
                    </tr>

                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${listOrder_Waiting_Customer}">
                        <tr>
                            <td class="">${item[1]}</td>

                            <td class="">${item[2]}</td>

                            <td class="">${item[3]}</td>

                            <td class="">${item[4]}</td>

                            <td class="">${item[5]}</td>
                            <td class=""><fmt:formatNumber value="${item[7]}"  pattern="#,###.00"/></td>

                            <td><a  href="${pageContext.request.contextPath}/staff/drinkingCups/getBillByIdUser/${item[0]}" type="button"
                                    class="btn btn-sm btn-outline-secondary">Xem chi tiết</a>

                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tab-pane fade" id="profile" role="tabpanel"
                 aria-labelledby="profile-tab">
                <table class="table table-bordered mb-5 mt-3">
                    <thead>
                    <tr class="text-center">

                        <th>Id</th>
                        <th>Tên khách hàng</th>
                        <th>Ngày mua hàng</th>
                        <th>Địa chỉ</th>
                        <th>Số điện thoại</th>
                        <th>Tổng đơn hàng</th>
                        <th>Xem chi tiết</th>
                    </tr>

                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${listOrder_Confirm_Customer}">
                        <tr>
                            <td class="">${item[1]}</td>

                            <td class="">${item[2]}</td>

                            <td class="">${item[3]}</td>

                            <td class="">${item[4]}</td>

                            <td class="">${item[5]}</td>
                            <td class=""><fmt:formatNumber value="${item[7]}"  pattern="#,###.00"/></td>

                            <td><a  href="${pageContext.request.contextPath}/staff/drinkingCups/getBillByIdUser/${item[0]}" type="button"
                                    class="btn btn-sm btn-outline-secondary">Xem chi tiết</a>

                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>

            </div>

            <div class="tab-pane fade" id="contact" role="tabpanel"
                 aria-labelledby="contact-tab">

                <table class="table table-bordered mb-5 mt-3">
                    <thead>
                    <tr class="text-center">

                        <th>Id</th>
                        <th>Tên khách hàng</th>
                        <th>Ngày mua hàng</th>
                        <th>Địa chỉ</th>
                        <th>Số điện thoại</th>
                        <th>Tổng đơn hàng</th>
                        <th>Xem chi tiết</th>
                    </tr>

                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${listOrder_Cancel_Customer}">
                        <tr>
                            <td class="">${item[1]}</td>

                            <td class="">${item[2]}</td>

                            <td class="">${item[3]}</td>

                            <td class="">${item[4]}</td>

                            <td class="">${item[5]}</td>
                            <td class=""><fmt:formatNumber value="${item[7]}"  pattern="#,###.00"/></td>

                            <td><a  href="${pageContext.request.contextPath}/staff/drinkingCups/getBillByIdUser/${item[0]}" type="button"
                                    class="btn btn-sm btn-outline-secondary">Xem chi tiết</a>

                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>

            </div>

        </div>

    </div>

</div>
<script>
    function showMess(id) {
        var ques = confirm('Do you want to delete?');
        if (ques == true) {
            window.location.href = '${pageContext.request.contextPath}/staff/drinkingCups/deletebyIdDrinkingCups/' + id;
        } else {

        }
    }
</script>