<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>

<body>

    
    <h1>회원가입</h1>
    <br><br><br><br>
    <form action="join" method="post">
    아이디 : <input type="text" id="memberId" name="memberId">
    <button onclick="idCheck()" id="idCheckBtn" >중복확인</button>
    <br><br>
    비밀번호 : <input type="password" name="memberPw">
    <br><br>
    이름 : <input type="text" name="memberName">
    <br><br><br><br>
    <button type="submit" >가입하기</button>
    </form>
    
      <button onclick="history.back()">뒤로가기</button> 
</body>
<script>
function idCheck(){
	   event.preventDefault();
	   
	   $.ajax({
		   url : "idcheck",
		   type : "POST",
		   dataType : "json",
		   data : {
			  memberId : $('#memberId').val() 
		   },
		   success : 
			 function(idCheck){
			    if (idCheck){
			    	alert("사용할 수 없는 아이디입니다!");
			    	$('#memberId').val('');
			    } else {
			    	alert("사용할 수 있는 아이디입니다!");
			    }
			 }  
		   ,
		   error : 
			   function(){
			    alert("실패");
			   }
	   })
   }
</script> 

</html>