<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BPSP</title>
<style>
a { color:black; text-decoration:none; }
table.t1 {
    border-collapse: collapse;
    text-align:center;
    margin: auto;
    align:center;
}
h3 { text-align:center; }
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeMypageBar.jsp" %>
<h3>등록한 중고 상품</h3>
<table class="t1">
   <tr>
      <th>상품번호</th>
      <th>상품명</th>
   </tr>
   <c:forEach var="item" items="${Useditems}">
   <tr>
      <td>${item.itemId}</td>
      <td>${item.title}</td>
      <td><a href='<c:url value="updateUsedProduct">
         <c:param name="itemId" value="${item.itemId}"/></c:url>'>수정</a></td>
      <td><a href='<c:url value="deleteUsedProduct">
         <c:param name="itemId" value="${item.itemId}"/></c:url>'>삭제</a></td>
   </tr>
   </c:forEach>
</table>
</body>
</html>