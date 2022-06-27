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
					<th>Id Bill</th>
					<th>Name Drinking cups</th>
					<th>Price</th>
					<th>Amount</th>

				</tr>

			</thead>
			<tbody>

				<c:forEach var="item" items="${listOrderDrinkingCup_Waiting}">
					<tr>
						<td class="">${item[0]}</td>

						<td class="">${item[1]}</td>

						<td class=""><fmt:formatNumber value="${item[2]}"  pattern="#,###.00"/></td>

						<td class="">${item[3]}</td>

					</tr>

				</c:forEach>


			</tbody>
		</table>
	</div>

</div>


