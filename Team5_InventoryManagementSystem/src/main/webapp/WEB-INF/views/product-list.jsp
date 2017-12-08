<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Product List page</h3>
<a href="${pageContext.request.contextPath}/admin/product/create">Add A New Product</a>
<c:if test="${fn:length(productList) gt 0}">
<table style="cellspacing: 2; cellpadding: 2; border: 1;">

	<tr class="listHeading">
		<th>Product partNo /></th>
		<th>carDealer /></th>
		<th>partDescription</th>
		<th>avaliableQty</th>
		<th>color</th>
		<th>dimension</th>
		<th>reorderLevel</th>
		<th>shelfLocation</th>
	</tr>


	<c:forEach var="department" items="${departmentList}">
		<tr class="listRecord">
			<td align="left">${department.departmentId}</td>
			<td align="left">${department.managerInCharge}</td>
			<td align="center"><a
				href="${pageContext.request.contextPath}/admin/department/edit/${department.departmentId}.html"><spring:message
						code="caption.edit" /></a></td>
			<td><a
				href="${pageContext.request.contextPath}/admin/department/delete/${department.departmentId}.html"><spring:message
						code="caption.delete" /></a></td>
		</tr>
	</c:forEach>

</table>
</c:if>


</body>
</html>