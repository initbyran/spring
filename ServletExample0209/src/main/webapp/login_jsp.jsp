<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <% 
    // 1. 입력 받기
    // 2. 로직 처리 : myBatis 처리 코드
    // 3. 출력은 HTML에 끼워 넣기
    
    %>
    <% 
       String name = "홍길동"; // 지역변수
       for(int i=0; i<5; i++){
    %>	
       <h1>반복돼요!</h1>
    <% 
       }
    %>   

   뾰로로로롱 
   사용자의 이름은 : <%= name %>  입니다.
   
   
</body>
</html>