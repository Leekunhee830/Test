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
	<button onclick="postajax()">클릭</button>
	
	<script>
	function postajax(){
		//POST으로 key=value 데이터를 전송하고 응답을 json으로 받아보기
		$.ajax({
			type:"POST",
			url:"/jspTest/Postajax.do",
			data:"username=ssar&password=1234",
			contentType:"application/x-www-form-urlencoded",
			dataType:"json"
		})
		.done(function(result){
			console.log(result);
		}) //ajax통신 완료후에 정상이면 done이 가지고 있는 함수 호출
		.fail(function(error){
			
		}); //ajax통신 완료후에 비정상이면 fail이 가지고 있는 함수 호출
	}
	</script>
</body>
</html>