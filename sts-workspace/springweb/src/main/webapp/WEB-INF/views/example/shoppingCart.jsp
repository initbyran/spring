<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>선택된 상품 정보</h1>
    <br><br>
    <ul>
    <li>선택된 사과의 개수 : ${ sessionScope.shoppingList.apple }</li>
    <li>선택된 바나나의 개수 : ${ sessionScope.shoppingList.banana }</li>
    <li>선택된 한라봉의 개수 : ${ sessionScope.shoppingList.halabong }</li>
    </ul>
    <br><br>
    <a href="${header.referer }">뒤로가기</a>
</body>
</html>