<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.vo.Member, board.vo.Board, board.vo.BoardComments, board.vo.BoardLike, comments.vo.Comments, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>

	<%
	// 여기에서는 request.getAttribute("article") 정보를 변수에 나눠서 저장하기
	Board articleData = (Board)request.getAttribute("article");
	int bNum = articleData.getBoardNum();
	String bAuthor = articleData.getBoardAuthor();
	String bTitle = articleData.getBoardTitle();
	String bContents = articleData.getBoardContent();
    int bLIKE = articleData.getBoardLike();
		// BoardArticleDetails.java 에서 받아온 데이터를 변수에 저장
		// 그 데이터를 form 태그 안에 input type="hidden" 으로 저장
		// post 방식으로 form 태그를 submit
		//Board board = (Board)request.getAttribute("article");
	
    // 로그인 아이디
	Member loginMember = (Member)session.getAttribute("member");
	String loginId = loginMember.getMemberId();
	
    // 좋아요 중복 방지
    List<BoardLike> likeIdList = (List<BoardLike>)request.getAttribute("likeInfo");
    boolean idSearching = false;
    
    if( likeIdList != null){
    	for (BoardLike item: likeIdList) {
    	     BoardLike idInfo = new BoardLike();
    	     idInfo.setClicklikeId(loginId);
             idSearching = likeIdList.contains(idInfo);
    	}
    }
    
	%>
	
	  <form action="delete" method="post">
	  <h1>게시글</h1>
	    <button onclick="history.back()">뒤로가기</button> 
      <br><br>
        <input type="hidden" name="boardNum" value=<%=bNum%>>
        <input type="hidden" name="boardAuthor" value=<%=bAuthor%>>
       제목 : <%= bTitle%>
       <br>
       작성자 : <%= bAuthor%>
       <br>
       내용 : <%= bContents%>
       <br>
       <% //좋아요 수 : <%= bLIKE %> 
       <div>좋아요 수 : <%= bLIKE %> </div> 
      
      <br><br>
      
      <% // 삭제 수정 버튼  %>
      <% if( bAuthor.equals(loginId)){
      %>
      <button type="button" onclick="location.href='edit?boardNum=<%=bNum%>'" id="editBtn">수정</button>
      <button type="submit" id="deleteBtn">삭제</button>
      <% } else { %>
      <button type="button" hidden="hidden" onclick="location.href='edit?boardNum=<%=bNum%>'" id="editBtn">수정</button>
      <button type="submit" hidden="hidden" id="deleteBtn">삭제</button>
      <% };%>
      </form>
      
      <% //좋아요 버튼 %>
      <% if (idSearching == false) {
      %>
       
       <input type="hidden" name="boardNum" value=<%=bNum%>>
       <button onclick="addLike(<%= bNum%>)" id="addLikeBtn">좋아요</button>
       <button onclick="deleteLike(<%= bNum%>)" hidden="hidden" id="deleteLikeBtn">좋아요취소</button>
      
      <% } else {%>
       <input type="hidden" name="boardNum" value=<%=bNum%>>
       <button onclick="addLike(<%= bNum%>)" hidden="hidden" id="addLikeBtn">좋아요</button>
       <button onclick="deleteLike(<%= bNum%>)" id="deleteLikeBtn">좋아요취소</button>
      
      <% } %>
     
      <br><br>
      <h3>댓글</h3>
      <br><br>
      <table border=2>
         <thead>
            <th>작성자</th>
            <th>내용</th>
         </thead>
         <tbody>
              <form action="deletecomments" method="post"> 
            <% 
               List<Comments> list = (List<Comments>)request.getAttribute("comments");
               boolean idMatching = false;
            	if (list != null) {
               		for(Comments comments: list){
            %>
            <tr>
                <input type="hidden" name="commentsArticleNum" value=<%=comments.getCommentsArticleNum() %>>
                <input type="hidden" name="commentsNum" value=<%=comments.getCommentsNum()%>>         
                <td><%= comments.getCommentsId() %></td>
                <td><%= comments.getCommentsContents() %></td>
                <% 
                	idMatching = (comments.getCommentsId()).equals(loginId);
                    if(idMatching) {
                %>
                <td><button type="button" id="editCommentsBtn" onclick="location.href='editcomments?commentsNum=<%=comments.getCommentsNum()%>'">댓글수정</button></td>
                <td><button type="submit" id="deleteCommentsBtn">댓글삭제</button></td>
                <%  
                    } else { 
                 %>
                <td><button type="button" hidden="hidden" id="editCommentsBtn" onclick="location.href='editcomments?commentsNum=<%=comments.getCommentsNum()%>'">댓글수정</button></td>
                <td><button type="submit" hidden="hidden" id="deleteCommentsBtn">댓글삭제</button></td>                
                <%  
                    } 
                 %>
            <tr>
            <% 
               		}
            	}
               %> 
             </form>
         </tbody>
      </table>
      <br><br>
      <form action="comments" method="post">
         <input type="hidden" name="commentsArticleNum" value=<%=((Board)request.getAttribute("article")).getBoardNum()%>>
         댓글쓰기 : <input type="text" name="commentsContents" size=100>
         <button type="submit">댓글작성</button>
      </form>  
<script>

   function addLike(boardNum){
	   $.ajax({
		   url : "like",
		   type : "POST",
		   dataType : "json",
		   data : {
		       "boardNum" : boardNum 
		   },
		   success : 
			 function(countLikes){
			   $('div').html("<div>"+'좋아요 수 : '+countLikes+"</div>");
			   $('#addLikeBtn').hide();
			   $('#deleteLikeBtn').show();
			   
			 }  
		   ,
		   error : 
			   function(){
			    alert("실패");
			   }
	   })
   }
   
   function deleteLike(boardNum){
	   $.ajax({
		 
		   url : "likedelete",
		   type : "POST",
		   dataType : "json",
		   data : {
			   "boardNum" : boardNum
		   },
		   success : 
			   function(countLikes){
			      $('div').html("<div>"+'좋아요 수 : '+countLikes+"</div>");
			      $('#addLikeBtn').show();
				  $('#deleteLikeBtn').hide();
		   },
		   error : 
			   function(){
			   alert("fail");
		   }
		   
	   })
   }
   


</script>      
       
</body>

</html>