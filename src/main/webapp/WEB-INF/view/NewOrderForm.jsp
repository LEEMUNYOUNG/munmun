<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BPSP</title>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
<%@ include file="IncludeSidebar.jsp" %>
<div align="center">
<form:form modelAttribute="orderForm" method="post">
  <form:errors cssClass="error" /> <br><br>
  
  <table>
    <tr>
      <td colspan="2">
        <font color="green" size="4"><b>Payment Details</b></font></td>
    </tr>
    <tr>
      <td>Card Type:</td>
      <td><form:select path="order.cardType" items="${creditCardTypes}" />
        <form:errors path="order.cardType" /></td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td><form:input path="order.cardNumber" /> 
        <form:errors path="order.cardNumber" /></td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YY):</td>
      <td><form:input path="order.expireDate" /> 
        <form:errors path="order.expireDate" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <font color="green" size="4"><b>Billing Address</b></font></td>
    </tr>
    <tr>
      <td>이름:</td>
      <td><form:input path="order.name" /> 
        <form:errors path="order.name" /></td>
    </tr>
    <tr>
      <td>주소:</td>
      <td><form:input path="order.address" />
        <form:errors path="order.address" /></td>
    </tr>
    <tr>
      <td>ShipAddress:</td>
      <td><form:input path="order.shipAddress" />
        <form:errors path="order.shipAddress" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <form:checkbox path="shippingAddressRequired"
          label="Ship to different address..." /></td>
    </tr>
  </table>
  <p>
    <input type="image" src="../images/button_submit.gif">
  </p>
</form:form>
</div>
</body>
</html>