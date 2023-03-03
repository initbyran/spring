<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>연산성공!</h1>
     <% pageContext.setAttribute("msg1", "소리없는 아우성!"); %>
     <br>
     <h3>request.getAttribute("msg")-결과는 : <%= request.getAttribute("msg") %></h3>
     <h3>result(EL) : ${ msg }</h3>
     <h3>result(EL) : ${ param.msg }</h3>
     <h3>result(EL) : ${ param.firstNum }</h3>
     <h3>result(EL) : ${ pageScope.msg1 }</h3>
     <h3>result(EL) : ${ requestScope.msg }</h3>
  
     <br><br>
     <a href="${header.referer}">뒤로가기</a>
</body>
</html>