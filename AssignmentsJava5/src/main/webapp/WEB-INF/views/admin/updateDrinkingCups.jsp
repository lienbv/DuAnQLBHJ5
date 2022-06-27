<%@ page language="java" session="true"
         contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="container-fluid">
    <form:form method="post" modelAttribute="drinking" enctype="multipart/form-data"
               action="${ pageContext.request.contextPath }/staff/drinkingCups/update/${drinking.id}">
        <div class="row px-xl-5">
            <div class="col-lg-9">
                <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Manager Drinking cups</span>
                </h5>
                <div class="bg-light p-30 mb-5">

                    <div class="row">
                        <div class="col-md-6 form-group">
                            <label>Name drinking cups</label>
                            <form:input path="name" cssClass="form-control" type="text" placeholder="Name"/>
                            <c:if test="${!empty sessionScope.errorname}">
                                <span class="text-danger">${sessionScope.errorname }</span>
                            </c:if>
                            <c:remove var="errorname" scope="session" />
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Price</label>
                            <form:input path="price" cssClass="form-control" type="text" placeholder="Price"/>
                            <c:if test="${!empty sessionScope.errorprice}">
                                <span class="text-danger">${sessionScope.errorprice }</span>
                            </c:if>
                            <c:remove var="errorprice" scope="session" />
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Amount</label>
                            <form:input path="amount" cssClass="form-control" type="text" placeholder="Amount"/>
                            <c:if test="${!empty sessionScope.erroramount}">
                                <span class="text-danger">${sessionScope.erroramount }</span>
                            </c:if>
                            <c:remove var="erroramount" scope="session" />
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Promotion</label>
                            <form:input path="promotion" class="form-control" type="text"
                                        placeholder="Promotion"/>

                        </div>
                        <div class="col-md-6 form-group">
                            <div class="d-flex mb-3">
                                <strong class="text-dark mr-3">Color:</strong>

                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="color" value="white"
                                                      class="custom-control-input"
                                                      id="size-1"/>
                                    <label class="custom-control-label" for="size-1">White</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="color" value="black"
                                                      class="custom-control-input"
                                                      id="size-2"/>
                                    <label class="custom-control-label" for="size-2">Black</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="color" value="green"
                                                      class="custom-control-input"
                                                      id="size-3"/>
                                    <label class="custom-control-label" for="size-3">Green</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="color" value="red"
                                                      class="custom-control-input"
                                                      id="size-4"/>
                                    <label class="custom-control-label" for="size-4">Red</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="color" value="yellow"
                                                      class="custom-control-input"
                                                      id="size-5"/>
                                    <label class="custom-control-label" for="size-5">Yellow</label>
                                </div>

                            </div>
                            <div class="d-flex mb-3">
                                <strong class="text-dark mr-3">Sizes:</strong>

                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="size" value="XS"
                                                      class="custom-control-input"
                                                      id="size-1"/>
                                    <label class="custom-control-label" for="size-1">XS</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="size" value="S"
                                                      class="custom-control-input"
                                                      id="size-2"/>
                                    <label class="custom-control-label" for="size-2">S</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="size" value="M"
                                                      class="custom-control-input"
                                                      id="size-3"/>
                                    <label class="custom-control-label" for="size-3">M</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="size" value="L"
                                                      class="custom-control-input"
                                                      id="size-4"/>
                                    <label class="custom-control-label" for="size-4">L</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <form:radiobutton path="size" value="XL"
                                                      class="custom-control-input"
                                                      id="size-5"/>
                                    <label class="custom-control-label" for="size-5">XL</label>
                                </div>

                            </div>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Volume</label>
                            <form:input path="volume" class="form-control" type="text" placeholder="Volume"/>
                            <c:if test="${!empty sessionScope.errorvolume}">
                                <span class="text-danger">${sessionScope.errorvolume }</span>
                            </c:if>
                            <c:remove var="errorvolume" scope="session" />
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Material</label>
                            <form:input path="material" class="form-control" type="text" placeholder="Material"/>
                            <c:if test="${!empty sessionScope.errormaterial}">
                                <span class="text-danger">${sessionScope.errormaterial }</span>
                            </c:if>
                            <c:remove var="errormaterial" scope="session" />
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Category</label>
                            <form:select class="form-select" path="idCategory">
                                <c:forEach items="${lstCategory}" var="cate">
                                    <form:option value="${cate.id}">${cate.name}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="col-md-6 form-group">
                            <label>Trạng thái</label>
                            <form:select path="status" id="activated" class="form-control">
                                <form:option value="1">Selling</form:option>
                                <form:option value="0">Stop selling</form:option>
                            </form:select>
                        </div>

                        <div class="col-md-6 form-group">
                            <label>Img</label>
                            <input name="imgfile" class="form-control"
                                   onchange="loadFile(event)" type="file"
                                   id="img" placeholder="img"/>
                        </div>
                            <%--"--%>

                    </div>

                </div>
            </div>
            <div class="col-lg-3" style="margin-top: 40px;">
                <div class="bg-light p-30 mb-5">
                    <div class="row">
                        <img class="m-auto" src="${ pageContext.request.contextPath }/img/${drinking.img}" width="220px"
                             id="output"
                             alt="">
                    </div>

                </div>
            </div>
            <div class="col-md-12 form-group">
                <button type="submit" class="btn btn-primary ">Submit</button>
                <button type="reset" class="btn btn-primary ">Cancel</button>
            </div>

        </div>
    </form:form>
</div>