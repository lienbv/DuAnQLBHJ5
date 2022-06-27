<%@ page language="java" session="true"
         contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="signup-page">
    <div class="container">
        <div class="row">
            <div class="col-sm-10 col-lg-6 offset-sm-1 offset-lg-3">
                <div class="form-bg">
                    <a href="#"><img src="/img/" alt="logo" class="logo rounded-circle"></a>
                    <h2>Sign up to see photos and videos from your friends.</h2>
                    <form:form modelAttribute="user" method="post" action="${pageContext.request.contextPath}/public/forgotPassword">

                        <span class="option-br"></span>

                        <div class="form-group">
                            <form:input type="text" path="username"  class="form-control" placeholder="Username" />
                            <form:errors path="username" element="span" cssClass="text-danger" />
                            <c:if test="${!empty sessionScope.errorUsername}">
                                <span class="text-danger">${sessionScope.errorUsername }</span>
                            </c:if>
                            <c:remove var="errorUsername" scope="session" />
                        </div>
                        <div class="form-group">
                            <form:input type="email" path="email"  class="form-control" placeholder="Email" />
                            <form:errors path="email" element="span" cssClass="text-danger" />
                            <c:if test="${!empty sessionScope.errorEmail}">
                                <span class="text-danger">${sessionScope.errorEmail }</span>
                            </c:if>
                            <c:remove var="errorEmail" scope="session" />
                        </div>

                        <div class="form-group">
                            <button class="signup-btn">Submit</button>
                        </div>
                        <p class="term-policy">By signing up, you agree to our <a target="_blank" href="#" rel="noopener noreferrer">Terms</a> , <a target="_blank" href="#" rel="noopener noreferrer">Data Policy</a> and <a target="_blank" href="#" rel="noopener noreferrer">Cookies Policy</a>.</p>
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