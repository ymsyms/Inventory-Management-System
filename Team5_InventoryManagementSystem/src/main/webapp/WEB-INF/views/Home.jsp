<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<h3>Student List Page</h3>

<!-- where is pageContext? -->
<a href="${pageContext.request.contextPath}/admin/student/create">Add A New Student</a>
<%-- <c:if test="${fn:length(studentlist) gt 0}"> --%>
	<%--check if the list is empty. only to create if there is data --%>
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th>Student ID</th>
				<th>Student Name</th>
				<th>Student Nick Name</th>
				<th>Course Enrolled</th>
				<th><spring:message code="caption.edit" /></th>
				<%--same as <th>Edit</th>. but can be inside i18n>message.property and translate --%>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${studentlist}">
				<tr class="listRecord">
					<td>${student.id}</td>
					<td>${student.name}</td>
					<td>${student.nick}</td>
					<td>${student.course}</td>
					<%-- html hyperlink <a></a> == <c:url></c:url> == <spring:url></spring:url> --%>
					<td align="center"><a href="${pageContext.request.contextPath}/admin/student/edit/${student.id}.html">Edit</a></td>
					<td align="center"><a href="${pageContext.request.contextPath}/admin/student/delete/${student.id}.html">Delete</a></td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
<%-- </c:if> --%>


