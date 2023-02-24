<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- HTML 주석 -->
<%-- JAP 주석 --%>

    <h1>TestController07.jsp 호출</h1>
    <h3>Model안에 저장되어 있는 데이터 출력 : EL</h3>
    <ul>
       <li>이름 : ${myName}</li>
       <li>나이 : ${myAge}</li>
    </ul>
</body>
</html>