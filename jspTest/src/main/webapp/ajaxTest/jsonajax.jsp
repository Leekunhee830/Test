<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button onclick="jsonajax()">클릭</button>
	
	<script>
	function jsonajax(){
		
		var data={
			username:"ssar",
			password:"1234"
		}
		
		//JSON.stringify() -> 자바스크립트 오브젝트를 JSON으로 변경 (JSON)으로 생긴 문자열로 변경
		//JSON.parse() -> JSON을 자바스크립트 오브젝트로 변경
		
		$.ajax({
			type:"POST",
			url:"/jspTest/JsonTest.do",
			data:JSON.stringify(data),
			contentType:"application/json",
			dataType:"json" //응답되는 데이터를 자바스크립트트 오브젝트로 파싱하는 용도
		})
		.done(function(result){
			console.log(result);
			console.log(result.username);
		}) //ajax통신 완료후에 정상이면 done이 가지고 있는 함수 호출
		.fail(function(error){
			
		}); //ajax통신 완료후에 비정상이면 fail이 가지고 있는 함수 호출
	}
	</script>
</body>
</html>