<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Danh sách khách hàng mua hàng</h1>
	<div class="btn-toolbar mb-2 ml-auto mb-md-0">
		<div class="btn-group mr-2"></div>
	</div>
</div>

<div class="col-sm-12">

	<div class="row">
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
							<a type="button" href="${pageContext.request.contextPath}/staff/drinkingCups/updateBilldetail/${item[0]}"
							   class="btn btn-sm text-dark">Xác nhận đơn hàng
							</a>
							<a type="button" onclick="showCancel(${item[4]})"
							   class="btn btn-sm text-dark">Hủy đơn hàng
							</a>
						</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>

</div>

