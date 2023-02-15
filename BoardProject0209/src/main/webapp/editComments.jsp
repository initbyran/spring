<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.vo.Member, board.vo.Board, comments.vo.Comments, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
   Comments commentsInfo = (Comments)request.getAttribute("comments");
   String commentsContents = commentsInfo.getCommentsContents();
   int commentsNum = commentsInfo.getCommentsNum();
   String commentsId = commentsInfo.getCommentsId();
   
%>
   <form action="editcomments" method="post">
   <input type="hidden" name="commentsNum" value="<%= commentsNum %>">
   <input type="hidden" name="commentsId" value="<%= commentsId %>">
  <h1>댓글수정</h1>
  <br></br>
  내용 : <input type="text" name="editCommentsContents" value="<%=commentsContents %>">
  <br><br>
  <button type="submit">수정하기</button>
  </form>
      
</body>
</html>