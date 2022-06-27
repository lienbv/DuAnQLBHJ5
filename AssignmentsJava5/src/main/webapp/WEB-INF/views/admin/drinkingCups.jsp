<%@ page language="java" session="true"
         contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
    <h1 class="h2">Manager Drinking Cups</h1>
    <div class="btn-toolbar mb-2 ml-auto mb-md-0">
        <div class="btn-group mr-2">
            <a href="${pageContext.request.contextPath}/staff/drinkingCups/create" type="button" class="btn btn-sm btn-outline-secondary">Add Drinking Cups</a>
        </div>
    </div>
    <div class="btn-toolbar mb-2 mb-md-0">
        <div class="btn-group mr-2">

        </div>

    </div>
</div>


<!-- <h2>Section title</h2> -->
<div class="table-responsive">
    <table class="table table-striped table-sm table-bordered">
        <thead>
        <tr>
            <th>Name drinking cups</th>
            <th>Category</th>
            <th>Price</th>
            <th>Promotion</th>
            <th>Color</th>
            <th>Size</th>
            <th>Volume</th>
            <th>Material</th>
            <th>Status</th>
            <th>Amount</th>
            <th>
                Action
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ pageData.content }" var="coc">
            <c:if test="${coc.status==1 or coc.status==0}">
            <tr>
                <td>${coc.name}</td>
                <td>${coc.idCategory}</td>
                <td><fmt:formatNumber value="${coc.price}"  pattern="#,###.00"/></td>
                <td>${coc.promotion}</td>
                <td>${coc.color}</td>
                <td>${coc.size}</td>
                <td>${coc.volume}</td>
                <td>${coc.material}</td>
                <td><c:if test="${coc.status ==1}">Selling</c:if>
                    <c:if test="${coc.status ==0}">Stop Selling</c:if>
                </td>
                <td>${coc.amount}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/staff/drinkingCups/edit/${coc.id}"
                       class="btn btn-sm btn-outline-secondary">Edit</a>
                    <a onclick="showDelete(${coc.id})"
                       class="btn btn-sm btn-outline-secondary">Delete</a>
                </td>
            </tr>
            </c:if>
        </c:forEach>

        </tbody>
    </table>

</div>
<div class="container-fluid py-5">
    <div class="row px-xl-5">
        <ul class="pagination">
            <c:forEach begin="0" end="${ pageData.totalPages - 1 }"
                       varStatus="page">

                <li class="page-item"><a
                        href="${pageContext.request.contextPath}/staff/drinkingCups/getAll?page=${page.index}"
                        class="page-link">${ page.index + 1 }</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
<script !src="">
    function showDelete(id) {
        var ques = confirm('Do you want to delete?');
        if (ques == true) {
            window.location.href = '${pageContext.request.contextPath}/staff/drinkingCups/delete/'+id;
        } else {

        }
    }

</script>
