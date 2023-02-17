<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.vo.Member,board.vo.Board,board.vo.BoardComments,java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP에서는 나에게 할당된 session 객체를 그냥 사용할 수 있다 
     어떤 이름을 사용해야 하나요 : session -->
    <h1><%=((Member)session.getAttribute("member")).getMemberName()%>님 환영합니다.</h1>
    <h3>게시글 목록</h3>
    <br><br>
    
    <form action="newArticle.html" method="post">
    <button >새글작성</button>
    </form>
    
    <form action="modifyMembership.jsp" method="post">
    <button>회원정보 수정</button>
    </form>
    
    <form action="logout" method="post">
    <button>로그아웃</button>
    </form>
    
    <br><br>
    <table border=2>
    <!-- border : 테두리 -->
        <thead>
            <th>글번호</th>
            <th>글제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>댓글수</th>
            <th>좋아요</th>
        </thead>
        <tbody>
            
             <%
                List<BoardComments> list = (List<BoardComments>)request.getAttribute("boardList"); 
                for(BoardComments board: list){
              %>
                
            <tr>
                 <td><%= board.getBoardNum()%></td>
                 <td><a href="article?boardNum=<%=board.getBoardNum()%>" ><%= board.getBoardTitle()%></a></td>
                 <td><%= board.getBoardAuthor()%></td>
                 <td><%= board.getBoardDate()%></td>
                 <td><%= board.getCntComments() %></td>
                 <td><%= board.getBoardLike()%></td>
            </tr>
            
            <%
               } 
            %>
        </tbody>
    </table>
</body>
</html>