<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>BPSP</title>
<style>
.login {width: 410px; position: absolute;  left: 37%; top: 25%; transform: tramslate(-50%, -50%);}
ul { list-style:none;}
.login ul {padding: 20px 0 33px;}
.login li {padding: 0 0 12px;}
.l input {height: 35px; width:244px;}
.p input {height: 35px; width:228px;}
.b input {height: 40px; width:300px;}
</style>
</head>
<body>

<%@ include file="IncludeTop.jsp" %><br>

   <form:form modelAttribute="loginForm" method="post" action="login">
      <section class="login">
         <ul>
         <li class="l">
             <label for="loginId">아이디  </label>
            <form:input path="loginId"/>
            <form:errors path="loginId"/>
            <br>
         </li>
         <li class="p">
         <label for="loginpw">비밀번호  </label>
            <form:password path="loginpw"/>
            <form:errors path="loginpw"/>
         </li>
         <li class="b">
         <input type="submit" value="로그인" /> <br><br>
         </li>
         <li>
         <a href="<c:url value="/shop/joinForm" />">회원가입</a> <br/>
         </li>

        </ul>
     </section>
   </form:form>
   
 
</body>
</html>