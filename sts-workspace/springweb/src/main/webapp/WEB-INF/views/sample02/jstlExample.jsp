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
     <!-- 변수를 만들고 값을 할당할 수 있어요 -->
     <%
       int k = 100;
     %>
     
     <c:set var="num1" value="100" />

     <!-- 제어문 중 대표적인 제어문 ; if -->
     <c:if test="${ num1 + myNum > 300 }" >
       100보다 커요!!
     </c:if>
     
     <!-- else문이 없어요 ; 조건이 여러개인 경우 다른 걸 사용 -->
     <c:choose>
         <c:when test="${ num1 + myNum > 50 }">
            50보다 커요
         </c:when>
         <c:when test=""${ num1 + myNum > 100 }"">
            100보다 커요
         </c:when>
         <c:when test=""${ num1 + myNum > 300 }"">
            300보다 커요
         </c:when>
         <c:otherwise>
                         이도저도 아니예요
         </c:otherwise>
     </c:choose>
     <br><br>
     <!-- 반복문 -->
     <ul>	
     <c:forEach var="tmp" begin="1" end="5" step="1">
        <li>${ tmp }</li>    
     </c:forEach>
     </ul>
     <!-- 집합자료구조 -->
     <ul> 
     <c:forEach var="name" items="${ myList }" >
         <li>${ name }</li>
     </c:forEach>
     </ul>
     
     <!--formatter ; fmt 사용하기 위해 변수 잡기-->
     <c:set var="number" value="123456789"/>
     <br><br>
     <!-- 숫자 표현 : 3자리마다  ','표시 -->
     <fmt:formatNumber value="${ number }"/>
     <!-- 화폐단위 표현 -->
      <fmt:formatNumber value="${ number }" type="currency"/>
      
      <c:set var="number" value="0.783"/>
      <br><br>
      
      <fmt:formatNumber value="${ number }" type="percent"/>
      
      
     </body>
</html>