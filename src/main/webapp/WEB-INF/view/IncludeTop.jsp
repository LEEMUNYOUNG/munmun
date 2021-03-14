<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>BPSP</title>
<style>
table.top {
    background-image: url('../images/bkg-topbar.gif');
    width: 100%;
    border: none;
    border-collapse: collapse;
}
table.top tr td {
    padding: 5px;
}
</style>
</head>
<body bgcolor="white">
<table class="top">
  <tr>
    <td>
      <a href="<c:url value="/"/>">
        <img border="0" src="../images/logo.png" /><img alt="0" src="../images/logoM.png" /></a>
      
    </td>
    <td style="text-align:right">
      <a href="<c:url value='/shop/viewCart'/>"> <!-- 장바구니 링크 -->
        <img border="0" name="img_cart" src="../images/cart.gif" /></a>
      <img border="0" src="../images/separator.gif" />
      <c:if test="${empty session}" >
        <a href="<c:url value="/shop/loginForm"/>"> <!-- 로그인 링크 -->
          <img border="0" name="img_signin" src="../images/sign-in.gif" /></a>
      </c:if>
      <c:if test="${!empty session}" >
        <a href="<c:url value="/shop/logout"/>"> <!-- 로그아웃 링크 -->
          <img border="0" name="img_signout" src="../images/sign-out.gif" /></a>
        <img border="0" src="../images/separator.gif" />
        <a href="<c:url value="/mypage/main"/>"> <!-- 마이페이지 링크 -->
          <img border="0" name="img_myaccount" src="../images/my_account.gif" /></a>
      </c:if>
    </td>
   </tr>
</table>
</body>
</html>