
function myFunc(){
	// 사용자가 선택한 URL을 form의 action에 설정!
	// > : 직게 자식 
	let url = $("#myForm>select>option:selected").text();
	
	$("#myForm").attr("action",url);
	
	
	
	
	
}