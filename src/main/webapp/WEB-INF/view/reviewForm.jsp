<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeSidebar.jsp" %>
<table id="tstyle" style="margin:auto; text-aligin:center; width:80%;">
<tr><!-- action="registerReview" -->
	<form:form modelAttribute="reviewReq" method="POST" >
		<label for="title" path="title">제목</label>
			<form:input path="title" />
			<form:errors path="title"/>
			<br>
		
		<label for="rating">별점
			5.0<form:radiobutton path="rating" value="5.0"/>
			4.0<form:radiobutton path="rating" value="4.0"/>
			3.0<form:radiobutton path="rating" value="3.0"/>
			2.0<form:radiobutton path="rating" value="2.0"/>
			1.0<form:radiobutton path="rating" value="1.0"/>
		</label>
				<form:errors path="rating"/>
		<br>
				
		<label for="content">내용</label>
			<form:textarea path="content"/>
			<form:errors path="content"/>
			<br>
			
		<input type="hidden" name="itemId" value="${reviewReq.itemId}"/>
		
		<input type="submit" value="등록"/>
		
	</form:form>
</tr>
</table>
</body>
</html>