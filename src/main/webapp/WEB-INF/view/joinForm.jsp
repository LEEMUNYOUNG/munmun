<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>BPSP</title>
<style>
div {text-align:center;}
</style>
</head>
<body>
<%@ include file="IncludeTop.jsp" %>
   <div>
      <h3>회원가입</h3>
   <form:form modelAttribute="registerReq" method="post" action="register">
      <label for="userId">아이디 : </label>
         <form:input path="userId"/><br>
         <form:errors path="userId"/>
         <br/>
         
      <label for="password">비밀번호 :  </label>
         <form:password path="password"/><br/>
         <form:errors path="password"/>
          <br>
         
      <label for="cPassword">비밀번호 :  </label>
         <form:password path="cPassword"/><br/>
         <form:errors path="cPassword"/>
          <br>
         
      <label for="name">이름 : </label>
         <form:input path="name"/><br/>
         <form:errors path="name"/>
          <br>
         
      <label for="email">이메일 : </label>
         <form:input path="email"/> <br/>
         <form:errors path="email"/>
         <br>
         
      <label for="address">주소</label>
         <form:input path="address"/><br/>
         <form:errors path="address"/>
       <br>
       
      <label for="phone">전화번호 : </label>
         <form:input path="phone"/> <br/>
         <form:errors path="phone"/>
         <br>
         
                   
      <label for="birth">생년월일 </label>
         <form:input path="birth"/> <br/>
         <form:errors path="birth"/>
         <br>
      
      성별 : Female<input type="radio" name="sex" value="F" checked="checked">
          Male<input type="radio" name="sex" value="M"><br><br/>

      
      <a href="<c:url value="/" />">취소</a>&nbsp;&nbsp;
      <input type="submit" value="회원가입"/><br>
   </form:form>
   </div>   
</body>
</html>