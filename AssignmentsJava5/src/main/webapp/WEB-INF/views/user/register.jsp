<%@ page language="java" session="true"
         contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<div class="signup-page">
    <div class="container">
      <div class="row">
        <div class="col-sm-10 col-lg-6 offset-sm-1 offset-lg-3">        
          <div class="form-bg">
            <a href="#"><img src="${pageContext.request.contextPath}/img/img1.jpg" alt="logo" class="logo rounded-circle"></a>
            <h2>Sign up to see photos and videos from your friends.</h2>

            <c:if test="${!empty sessionScope.message}">
              <p>${sessionScope.message }</p>
            </c:if>
            <c:remove var="message" scope="session" />
            <form:form modelAttribute="messages_vi" action="${pageContext.request.contextPath}/public/register" method="post">
              <span class="option-br"></span>
              <div class="form-group">
                <form:input type="text" path="fullname"  cssClass="form-control" placeholder="Full Name" />
                <form:errors path="fullname" element="span" cssClass="text-danger" />
              </div>
              <div class="form-group">
                <form:input type="text" path="username"  cssClass="form-control" placeholder="Username" />
                <form:errors path="username" element="span" cssClass="text-danger" />
                <c:if test="${!empty sessionScope.errorUsename}">
                  <span class="text-danger">${sessionScope.errorUsename }</span>
                </c:if>
                <c:remove var="errorUsename" scope="session" />
              </div>
              <div class="form-group">
                <form:input type="email" path="email"  class="form-control" placeholder="Email" />
                <form:errors path="email" element="span" cssClass="text-danger" />
                <c:if test="${!empty sessionScope.errorEmail}">s
                  <span class="text-danger">${sessionScope.errorEmail }</span>
                </c:if>
                <c:remove var="errorEmail" scope="session" />
              </div>

              <div class="form-group">
                <form:input type="Password" path="password"  cssClass="form-control" placeholder="Password" />
                <form:errors path="password" element="span" cssClass="text-danger" />
              </div>
              <div class="form-group">
                <form:input type="Password" path="rePassword" cssClass="form-control" placeholder="RePassword" />
                <form:errors path="rePassword" element="span" cssClass="text-danger" />
                <c:if test="${!empty sessionScope.errorPass}">
                  <span class="text-danger">${sessionScope.errorPass }</span>
                </c:if>
                <c:remove var="errorPass" scope="session" />
              </div>
              <div class="form-group">
                <form:input type="text" path="address"  cssClass="form-control" placeholder="Address" />
                <form:errors path="address" element="span" cssClass="text-danger" />
              </div>
              <div class="form-group">
                <form:input type="text" path="phoneNumber"  cssClass="form-control" placeholder="phone number" />
                <form:errors path="phoneNumber" element="span" cssClass="text-danger" />
                <c:if test="${!empty sessionScope.errorPhoneNumber}">
                  <span class="text-danger">${sessionScope.errorPhoneNumber }</span>
                </c:if>
                <c:remove var="errorPhoneNumber" scope="session" />
              </div>
              <div class="form-group">
                <button type="submit" class="signup-btn">Signup</button>
                <button type="reset" class="signup-btn">Cancel</button>
              </div>
              <p class="term-policy">By signing up, you agree to our <a target="_blank" href="#" rel="noopener noreferrer">Terms</a> , <a target="_blank" href="#" rel="noopener noreferrer">Data Policy</a> and <a target="_blank" href="#" rel="noopener noreferrer">Cookies Policy</a>.</p>
            </form:form>
          </div>
          <div class="login-link form-bg">
            <p>Have a account? <a href="#">Log in</a></p>
          </div>
          <div class="get-app">
            <p>Get the app.</p>
            <a href="#"><img src="${pageContext.request.contextPath}/img/app5.jpg" width="110px" height=" 60px" alt="app"></a>
            <a href="#"><img src="${pageContext.request.contextPath}/img/app4.jpg" width="110px" height="50px" alt="app"></a>
          </div>        
        </div>
      </div>
    </div>
  </div>