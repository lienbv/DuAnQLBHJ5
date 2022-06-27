<!-- Checkout Start -->
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container-fluid">

        <div class="row px-xl-5">
            <div class="col-lg-8">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span>
                </h5>
                <div class="bg-light p-30 mb-5">
                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>Full name</label>
                            <input class="form-control" value="${sessionScope.accountKH.fullname}" disabled type="text" placeholder="Fullname">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Email</label>
                            <input class="form-control" value="${sessionScope.accountKH.email}" disabled type="email" placeholder="email">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Address</label>
                            <input class="form-control" value="${sessionScope.accountKH.address}" disabled type="text" placeholder="Address">
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Mobile</label>
                            <input class="form-control" value="${sessionScope.accountKH.phone}" disabled type="text" placeholder="Phone number">
                        </div>


                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span>
                </h5>
                <div class="bg-light p-30 mb-5">
                    <div class="border-bottom">
                        <h6 class="mb-3">Drinking Cups</h6>
                        <c:forEach var="item" items="${sessionScope.listCart}">
                            <div class="d-flex justify-content-between">
                                <p>${item.value.getIdDrinkingCups().getName()}</p>
                                <p>${item.value.amount}</p>
                                <p><fmt:formatNumber value="${item.value.total()}" pattern="#,###.00" /></p>
                            </div>
                        </c:forEach>

                    </div>
                    <div class="border-bottom pt-3 pb-2">
                        <div class="d-flex justify-content-between mb-3">
                            <h6>Subtotal</h6>
                            <h6><fmt:formatNumber value="${sessionScope.sum}"  pattern="#,###.00"/> $</h6>
                        </div>
                        <div class="d-flex justify-content-between">
                            <h6 class="font-weight-medium">Shipping</h6>
                            <h6 class="font-weight-medium"><fmt:formatNumber value="${sessionScope.shippingFee}"  pattern="#,###.00"/>$</h6>
                        </div>
                    </div>
                    <div class="pt-2">
                        <div class="d-flex justify-content-between mt-2">
                            <h5>Total</h5>
                            <h5><fmt:formatNumber value="${sessionScope.sumTT}"  pattern="#,###.00"/>$</h5>
                        </div>
                    </div>
                </div>
                <div class="mb-5">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span>
                    </h5>
                    <div class="bg-light p-30">
                        <div class="form-group">
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input" name="payment" id="paypal">
                                <label class="custom-control-label" for="paypal">Paypal</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input" name="payment" id="directcheck">
                                <label class="custom-control-label" for="directcheck">Direct Check</label>
                            </div>
                        </div>
                        <div class="form-group mb-4">
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input" name="payment" id="banktransfer">
                                <label class="custom-control-label" for="banktransfer">Bank Transfer</label>
                            </div>
                        </div>
                        <form method="POST" action="${pageContext.request.contextPath}/user/checkoutCart">
                        <button type="submit" class="btn btn-block btn-primary font-weight-bold py-3">Place Order
                        </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

</div>
<!-- Checkout End -->