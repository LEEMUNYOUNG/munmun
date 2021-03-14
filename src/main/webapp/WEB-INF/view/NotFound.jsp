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
a { color:black; text-decoration:none; font-size:15px; }
#tstyle { border-spacing:7px; }
#tstyle {
	margin:auto;
}
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeSidebar.jsp" %>
<script type="text/javascript">
var message = '${message}';
if (message != "") {
   alert(message);
}
</script>
<table id="tstyle">
	<tr><td><h2>해당 상품이 존재하지 않습니다.</h2></td></tr>
	<tr><td><a href="<c:url value="/"/>">메인으로 돌아가기</a></td></tr>
</table>
</body>
</html>