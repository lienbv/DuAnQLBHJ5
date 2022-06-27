<!-- Cart Start -->
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container-fluid">
    <div class="row px-xl-5">
        <div class="col-lg-8 table-responsive mb-5">
            <c:if test="${ !empty sessionScope.listCart}">
            <table class="table table-light table-borderless table-hover text-center mb-0">
                <thead class="thead-dark">
                <tr>
                    <th>Products</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Remove</th>
                </tr>
                </thead>
                <tbody class="align-middle">
                <c:forEach var="item" items="${sessionScope.listCart }">
                    <tr>
                        <td class="align-middle"><img
                                src="${ pageContext.request.contextPath }/img/${item.value.getIdDrinkingCups().getImg()}"
                                alt=""
                                style="width: 50px;">
                        </td>
                        <td class="align-middle">${item.value.getIdDrinkingCups().getName()}</td>
                        <td class="align-middle">

                            <div class="input-group quantity mx-auto" style="width: 100px;">
                                <c:if test="${ item.value.amount < item.value.getIdDrinkingCups().getAmount()}">
                                    <form action="${pageContext.request.contextPath}/user/updateDown/${item.key}" method="post">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-primary btn-minus">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </form>
                                </c:if>
                                <c:if test="${ item.value.amount >= item.value.getIdDrinkingCups().getAmount()}">

                                </c:if>

                                <input type="text"
                                       class="form-control form-control-sm bg-secondary border-0 text-center" disabled max="item.value.getIdDrinkingCups().getAmount()" min="1"
                                       value="${item.value.amount}">
                                <c:if test="${ item.value.amount >=2}">
                                    <form action="${pageContext.request.contextPath}/user/updateUp/${item.key}" method="post">
                                        <div class="input-group-btn">
                                            <button class="btn btn-sm btn-primary btn-plus" >
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                    </form>
                                </c:if>
                                <c:if test="${ item.value.amount <1}">

                                </c:if>

                            </div>

                        </td>
                        <td class="align-middle"> <fmt:formatNumber value="${item.value.total()}" pattern="#,###.00" /></td>
                        <td class="align-middle">
                            <a class="btn btn-sm btn-danger" onclick="showMess(${item.key})"><i class="fa fa-times"></i></a>
                        </td>
                    </tr>
                </c:forEach>

                <a class="btn btn-sm btn-danger" onclick="showMessAll()"><i class="fa fa-times"></i></a>

                </tbody>
            </table>
                <div class="row mx-auto justify-content-center">
                    <a href="${ pageContext.request.contextPath }/public/home" class="btn btn-dark rounded-pill ">Continue
                        shopping</a>
                </div>
            </c:if>

            <c:if test="${empty sessionScope.listCart}">

                <div class="row py-2">
                    <div class="col-sm-12">

                        <div class="row mx-auto justify-content-center">
                            <img src="${ pageContext.request.contextPath }/img/empty_cart.webp" class="" alt="">
                        </div>
                        <h5 class="text-center py-sm-3"
                            style="color: rgb(171, 172, 173);">There are no products
                            in your cart</h5>
                        <div class="row mx-auto justify-content-center">
                            <a href="${ pageContext.request.contextPath }/public/home" class="btn btn-dark rounded-pill ">Continue
                                shopping</a>
                        </div>
                    </div>

                </div>
            </c:if>

        </div>
        <div class="col-lg-4">
            <form class="mb-30" action="">
                <div class="input-group">
                    <input type="text" class="form-control border-0 p-4" placeholder="Coupon Code">
                    <div class="input-group-append">
                        <button class="btn btn-primary">Apply Coupon</button>
                    </div>
                </div>
            </form>
            <h5 class="section-title position-relative text-uppercase mb-3"><span
                    class="bg-secondary pr-3">Cart Summary</span></h5>
            <div class="bg-light p-30 mb-5">
                <div class="border-bottom pb-2">
                    <div class="d-flex justify-content-between mb-3">
                        <h6>Subtotal</h6>
                        <h6> <fmt:formatNumber value="${sessionScope.sum}"  pattern="#,###.00"/></h6>
                    </div>
                    <div class="d-flex justify-content-between">
                        <h6 class="font-weight-medium">Shipping</h6>
                        <h6 class="font-weight-medium">${sessionScope.shippingFee}$</h6>
                    </div>
                </div>
                <div class="pt-2">
                    <div class="d-flex justify-content-between mt-2">
                        <h5>Total</h5>
                        <h5><fmt:formatNumber value="${sessionScope.sumTT}"  pattern="#,###.00"/></h5>
                    </div>
                    <a href="${ pageContext.request.contextPath }/user/checkout" class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To Checkout</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function showMess(id) {
        var ques = confirm('Do you want to delete?');
        if (ques == true) {
            window.location.href = '${pageContext.request.contextPath}/user/delete/' + id;
        } else {

        }
    }

    function showMessAll() {
        var ques = confirm('Do you want to delete?');
        if (ques == true) {
            window.location.href = '${pageContext.request.contextPath}/user/deleteAll/';
        } else {

        }
    }
</script>
<!-- Cart End -->