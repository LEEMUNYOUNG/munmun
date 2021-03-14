<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
#tstyle { border-spacing:7px; }
#tstyle {
	margin:auto;
}
div { text-align:center; }
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeSidebar.jsp" %>
<div>
<form:form modelAttribute="bidding" method="post">
<table id="tstyle">
  	<tr>
  	  <td>
  	    <h3>입찰하기</h3>
  	    <table>
  	      <tr>
  	        <td><label for="bidding.auction.item.title">상품명</label>: ${auction.item.title}</td>
  	      </tr>
  	      <tr>
  	        <td><label for="bidding.auction.item.price">시작가</label>:${auction.item.price}</td>
  	      </tr>
  	      <tr>
  	        <td>
	  	        <b>최고가:</b>
				<c:if test="${maxPrice == 0}" >
					<b>${auction.item.price}</b> <br/>
				</c:if>
				<c:if test="${maxPrice != 0}" >
					<b>${maxPrice}</b> <br/>
				</c:if>
			</td>
  	      </tr>
  	      <tr>
  	        <td><label for="bidding.auction.deadline">입찰 마감기한</label>:${auction.deadline}</td>
  	      </tr>
  	      <tr>
<!--   	         <td><label for="bidding.bCount">입찰할 물품 수량</label>:  -->
<%--              <form:input path="bidding.bCount"/> --%>
					<form:hidden path="bidding.bCount" name="bidding.bCount" value="1"/>
             <form:errors path="bidding.bCount"/>
				<br/>
				</td>
  	      </tr>
  	      <tr>
  	        <td><label for="bidding.price">입찰 가격</label>: 
				<form:input path="bidding.price"/>
				<form:errors path="bidding.price" />
				<br/></td>
  	      </tr>
  	    </table>
  	  </td>
  	</tr>
  	<tr>
  	  <td>
  	<br />
	  <input type="submit" value="입찰하기"/> &nbsp;&nbsp;
	  <a href="<c:url value="/shop/auctionItemDetail?itemId=${auction.item.itemId}" />">돌아가기</a>
	  </td>
	</tr>
  </table>
</form:form>
</div>
</body>
</html>