<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>연산할 두 개의 숫자를 입력하고 연산자를 선택하세요</h1>
     <br><br>
     <form action="/springweb/calc.do" method="post">
         <input type="number" name="firstNum" required="required">
         <select name="operator">
               <option value="plus"> + </option>
                <option value="minus"> -</option>
                 <option value="mul"> * </option>
                  <option value="div"> / </option>
     
         </select>         
    <input type="number" name= "secondNum", required="required">
    <br><br>
    <input type="submit" value="계산하기">
     </form>
</body>
</html>