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
	<button onclick="getajax()">클릭</button>
	
	<script>
	function getajax(){
		
		$.ajax({
			type:"GET",
			url:"/jspTest/ajaxTest.do?username=ssar&password=1234",
			//data:get은 전송할 http의 body가 없음 그래서 data필드가 필요없음
			//contentType:전송할 data가 없으니까 그 data를 설명할 필드가 필요없음
			dataType:"text" //응답되는 데이터를 자바스크립트트 오브젝트로 파싱하는 용도
		})
		.done(function(result){
			alert(result);
		}) //ajax통신 완료후에 정상이면 done이 가지고 있는 함수 호출
		.fail(function(error){
			
		}); //ajax통신 완료후에 비정상이면 fail이 가지고 있는 함수 호출
	}
	</script>
</body>
</html>