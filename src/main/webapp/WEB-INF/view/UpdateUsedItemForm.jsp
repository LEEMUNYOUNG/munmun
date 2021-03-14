<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BPSP</title>
<style>
a { color:black; text-decoration:none;}
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
<form:form modelAttribute="item" method="post" enctype="multipart/form-data">
  <table id="tstyle">
     <tr>
       <td>
         <h3>중고 상품 수정</h3>
         <table>
           <tr>
             <td>상품명</td>
             <td>
             <form:label path="title" />
             <form:input path="title" />
             <form:errors path="title" />
             </td>
           </tr>
           <tr>
             <td>가격</td>
             <td>
             <form:label path="price" />
             <form:input path="price" />
             <form:errors path="price" />
             </td>
           </tr>
           <tr>
             <td>수량</td>
             <td>
             <form:label path="stock" />
             <form:input path="stock" />
             <form:errors path="stock" />
             </td>
           </tr>
           <tr>
             <td>설명</td>
             <td>
             <form:label path="description" />
             <form:input path="description" />
             <form:errors path="description" />
             </td>
           </tr>
         </table>
       </td>
     </tr>
  </table>
  <br />
  <a href="ProductManagement">취소</a> &nbsp;&nbsp;
  <input type="submit" value="OK">
</form:form>
</div>
</body>
</html>