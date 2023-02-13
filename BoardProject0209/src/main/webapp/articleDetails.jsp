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
		// BoardArticleDetails.java 에서 받아온 데이터를 변수에 저장
		// 그 데이터를 form 태그 안에 input type="hidden" 으로 저장
		// post 방식으로 form 태그를 submit
		//Board board = (Board)request.getAttribute("article");
	%>
	  <h1>게시글</h1>
      <br><br>
       제목 : <%= ((Board)request.getAttribute("article")).getBoardTitle()%>
       <br>
       작성자 : <%= ((Board)request.getAttribute("article")).getBoardAuthor()%>
       <br>
       내용 : <%= ((Board)request.getAttribute("article")).getBoardContent()%> 
      <br><br>
      
      <br><br>
      <h3>댓글</h3>
      <br><br>
      <table border=2>
         <thead>
            <th>작성자</th>
            <th>내용</th>
         </thead>
         <tbody>
            <% List<Comments> list = (List<Comments>)request.getAttribute("comments");
            	if (list != null) {
               		for(Comments comments: list){
            %>
            <tr>
                <td><%= comments.getCommentsId() %></td>
                <td><%= comments.getCommentsContents() %></td>
            <tr>
            <% 
              		}
            	}
               %> 
         
         </tbody>
      </table>
      <br><br>
      <form action="comments" method="post">
         <input type="hidden" name="commentsArticleNum" value=<%=((Board)request.getAttribute("article")).getBoardNum()%>>
         댓글쓰기 : <input type="text" name="commentsContents" size=100>
         <button type="submit">댓글작성</button>
      </form>     
</body>
</html>