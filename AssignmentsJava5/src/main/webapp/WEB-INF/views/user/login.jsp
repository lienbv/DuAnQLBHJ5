<%@ page language="java" session="true"
         contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="signup-page">
    <div class="container">
      <div class="row">
        <div class="col-sm-10 col-lg-6 offset-sm-1 offset-lg-3">        
          <div class="form-bg">
            <a href="#"><img src="${pageContext.request.contextPath}/img/img1.jpg" alt="logo" class="logo rounded-circle"></a>
            <h2>Login</h2>
            <form:form modelAttribute="user" action="${pageContext.request.contextPath}/public/login" method="post">
              <span class="option-br"></span>
              <div class="form-group">
                <form:input type="text" path="username"  cssClass="form-control" placeholder="Username" />
                <form:errors path="username" element="span" cssClass="text-danger" />
                <c:if test="${!empty sessionScope.errorUsename}">
                  <span class="text-danger">${sessionScope.errorUsename }</span>
                </c:if>
                <c:remove var="errorUsename" scope="session" />
              </div>

              <div class="form-group">
                <form:input type="Password" path="password"  class="form-control" placeholder="Password"/>
                <form:errors path="password" element="span" cssClass="text-danger" />
                <c:if test="${!empty sessionScope.errorPassword}">
                  <span class="text-danger">${sessionScope.errorPassword }</span>
                </c:if>
                <c:remove var="errorPassword" scope="session" />
              </div>
              <div class="form-group">
                <button class="signup-btn">Signin</button>
              </div>
              <p class="term-policy"><a href="${pageContext.request.contextPath}/public/forgotPassword" >You are forgot password</a>.</p>
            </form:form>
          </div>
          <div class="login-link form-bg">
            <p>Have a account? <a href="#">Log in</a></p>
          </div>
          <div class="get-app">
            <p>Get the app.</p>
            <a href="#"><img src="/img/app5.jpg" width="110px" height=" 60px" alt="app"></a>
            <a href="#"><img src="/img/app4.jpg" width="110px" height="50px" alt="app"></a>
          </div>        
        </div>
      </div>
    </div>
  </div>