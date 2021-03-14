<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#t table {
	background-color: #FFFF88;	
	border: none;
	width: 170px;
	border-collapse: collapse;
}
table tr td {
    padding: 5px; 
}
</style>
</head>
<body>
<table id="t" style="border:none;border-collapse:collpase;width:15%">
	<tr>
	 <td style="text-align:left;vertical-align:top;width:100%">
      <table style="border:none;border-collapse:collapse;width:80%">
        <tr>
          <td valign="top">                    
            <table id="index">
              <tr>
          	    <td>
          	      <a href="<c:url value='/mypage/MyBidMain'/>">입찰신청내역</a>
          	    </td>
          	  </tr>
          	  <tr>
          	    <td>
          	      <a href="<c:url value="/mypage/MyOrderList" />">구매내역</a>
          	    </td>
          	  </tr>
          	  <tr>
          	    <td>
          	      <a href="<c:url value="/shop/ProductManagement" />">상품등록관리 - 중고</a>
          	    </td>
          	  </tr>
          	  <tr>
          	    <td>
          	      <a href="<c:url value="/mypage/MyAuctionMain"/>">상품등록관리(경매)</a>
          	    </td>
          	  </tr>
          	  <tr>
          	    <td>
          	      <a href="<c:url value="/mypage/memberDetail" />">회원정보관리</a>
          	    </td>
          	  </tr>
          	  <tr>
          	    <td>
          	      <a href="<c:url value="/mypage/myReview" />">리뷰 관리</a>
          	    </td>
          	  </tr>
            </table>
          </td>
        </tr>
        </table>
      </td>
    </tr>
</table>
</body>
</html>