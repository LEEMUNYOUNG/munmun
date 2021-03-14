<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
	<table border=1 cellspacing=0 width="50%">
	<tr align="center">
		<th>이름</th>
		<th>아이디</th>
		<th>이메일</th>
		<th>생년월일</th>
		<th>성별</th>
	</tr>
	<c:forEach var="ml" items="${memberList}" varStatus="status">
	<tr algin="center">
		<td><c:out value="${ml.name}"></c:out></td>
		<td><a href="<c:url value="/shop/viewModifyForm?userId=${ml.userId}"/>">
 				<c:out value="${ml.userId}" /></a></td>
		<td><c:out value="${ml.email}"></c:out></td>
		<td><c:out value="${ml.birth}"></c:out></td>
		<td><c:out value="${ml.sex}"></c:out></td>
	</tr>
	</c:forEach>
	
	</table>
</body>
</html>