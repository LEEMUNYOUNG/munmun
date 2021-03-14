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
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<div>
<form:form modelAttribute="auction" method="post" align="left" enctype="multipart/form-data">
<%@ include file="IncludeSidebar.jsp" %>
  <table id="tstyle">
  	<tr>
  	  <td>
  	    <h3>경매 상품 등록</h3>
  	    <table>
  	      <tr>
  	        <td>상품카테고리</td>
  	        <td>
  	        <form:label path="item.productId"/>
  	        <form:select path="item.productId" items="${ProductType}" />
  	        <form:errors path="item.productId"/>
  	        </td> 
  	      </tr>
  	      <tr>
  	        <td>등록할 상품명</td>
  	        <td>
  	        <form:label path="item.title" />
  	        <form:input path="item.title" />
  	        <form:errors path="item.title"/>
  	        </td>
  	      </tr>
  	      <tr>
  	        <td>입찰 기한</td>
  	        <td>
  	        <form:label path="deadline" />
  	        <form:input path="deadline" />
  	        <form:errors path="deadline"/>
  	        </td>
  	      </tr>
  	      <tr>
  	        <td>상품 하한가</td>
  	        <td>
  	        <form:label path="item.price" />
  	        <form:input path="item.price" />
  	        <form:errors path="item.price"/>
  	        </td>
  	      </tr>
  	      <tr>
  	        <td>상품 재고</td>
  	        <td>
  	        <form:label path="item.stock" />
  	        <form:input path="item.stock" />
  	        <form:errors path="item.stock"/>
  	        </td>
  	      </tr>
  	      <tr>
  	        <td>사진</td>
  	        <td>
  	        <input type="file" name="report" />
  	        </td>
  	      </tr>
  	      <tr>
  	        <td>상품 설명</td>
  	        <td>
  	        <form:label path="item.description" />
  	        <form:input path="item.description" />
  	        <form:errors path="item.description"/>
  	        </td>
  	      </tr>
  	    </table>
  	  </td>
  	</tr>
  	<tr>
  	  <td>
  	<br />
	  <a href="auctionProduct">취소</a> &nbsp;&nbsp;
	  <input type="submit" value="경매상품 등록하기"/>
	  </td>
	</tr>
  </table>
</form:form>
</div>
</body>
</html>