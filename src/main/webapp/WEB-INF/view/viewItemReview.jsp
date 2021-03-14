<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>BPSP</title>
<style>
a { color:black; text-decoration:none; }
table.top {
    background-image: url('../../../images/bkg-topbar.gif');
    width: 100%;
    border: none;
    border-collapse: collapse;
}
table.top tr td {
    padding: 5px;
}
</style>
</head>
<body>
<table class="top">
  <tr>
    <td>
      <a href="<c:url value="/"/>">
        <img border="0" src="../../../images/logo.png" /><img alt="0" src="../../../images/logoM.png" /></a>
      
    </td>
    <td style="text-align:right">
      <a href="<c:url value='/shop/viewCart'/>"> <!-- 장바구니 링크 -->
        <img border="0" name="img_cart" src="../../../images/cart.gif" /></a>
      <img border="0" src="../../../images/separator.gif" />
      <c:if test="${empty session}" >
        <a href="<c:url value="/shop/loginForm"/>"> <!-- 로그인 링크 -->
          <img border="0" name="img_signin" src="../../../images/sign-in.gif" /></a>
      </c:if>
      <c:if test="${!empty session}" >
        <a href="<c:url value="/shop/logout"/>"> <!-- 로그아웃 링크 -->
          <img border="0" name="img_signout" src="../../../images/sign-out.gif" /></a>
        <img border="0" src="../../../images/separator.gif" />
        <a href="<c:url value="/mypage/main"/>"> <!-- 마이페이지 링크 -->
          <img border="0" name="img_myaccount" src="../../../images/my_account.gif" /></a>
      </c:if>
    </td>
   </tr>
</table>
<%@ include file="IncludeSidebar.jsp" %>
<div align="center">
<table>
  <tr>
    <td colspan="2">
    <table border=1 width=160% cellspacing=0>
       <tr align="center">
      <th>제목</th>
       <th>작성자</th>
      <th>별점</th>
      <th>내용</th>
      </tr>
       <c:forEach var="ir" items="${itemReview}" varStatus="status">
         <tr align="center">   
            <td><c:out value="${ir.title}"></c:out></td>
            <td><c:out value="${ir.userId}"></c:out></td>    
            <td><c:out value="${ir.rating}"></c:out></td>
            <td><c:out value="${ir.content}"></c:out></td>
         </tr>
      </c:forEach>
   </table>
</table>
</div>
</body>
</html>