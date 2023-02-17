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
	// 여기에서는 request.getAttribute("article") 정보를 변수에 나눠서 저장하기
	Board articleData = (Board)request.getAttribute("article");
	int bNum = articleData.getBoardNum();
	String bAuthor = articleData.getBoardAuthor();
	String bTitle = articleData.getBoardTitle();
	String bContents = articleData.getBoardContent();

 %>
  
  <h1>게시글 수정</h1>
    <form action="edit" method="post">
    	<input type="hidden" name="boardNum" value="<%=bNum%>">
		<input type="hidden" name="boardAuthor" value="<%= bAuthor%>">
    <br><br>
    제목 : <input type="text" name="editTitle" value="<%= bTitle%>" size=50>
    <br>
    내용 : <input type="text" name="editContents" value="<%= bContents%>" size=50>
    <br><br>
    <button type="submit">수정하기</button>
    </form>
    
    <button onclick="history.back()">뒤로가기</button> 
    
</body>
</html>