<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
   <form action="modify" method="post">
   <h1>회원 정보 수정</h1>
   <br><br>
   비밀번호 변경 : <input type="password" name="changedPw" >
   회원이름 변경 : <input type="text" name="changedName" >
   <br><br><br><br>
   <button type="submit" id="modifyBtn">변경하기</button>
   </form>
   <button onclick="history.back()">뒤로가기</button> 
   
</body>
</html>