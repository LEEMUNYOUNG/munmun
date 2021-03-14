<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
function moveDelete(){
	
	location.href='/mypage/deleteReview';
}
</script>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<center><h5>${userName }님의 마이페이지</h5></center>
<table>
  <tr>
    <td><%@ include file="IncludeMypageBar.jsp" %></td>
    <td colspan="2"><div> 	
    	<ul>
    		<li><c:out value="아이디 : ${detailReq.userId}" /></li>
    		<li><c:out value="이름 : ${detailReq.name}" /></li>
    		<li><c:out value="이메일 : ${detailReq.email}" /></li>
    		<li><c:out value="주소 : ${detailReq.address}" /></li>
    		<li><c:out value="전화번호 : ${detailReq.phone}" /></li>
    		<li><c:out value="생년월일 : ${detailReq.birth}" /></li>
    		<li><c:out value="성별 : ${detailReq.sex}" /></li>
    	</ul>
    	
	<a href="<c:url value="/shop/viewModifyForm" />">수정</a>
	</div></td>
  </tr>
</table>
</body>
</html>