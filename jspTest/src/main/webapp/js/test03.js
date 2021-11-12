function go(){
	var dto={
		user_id:$('#id').val(),
		user_password:$('#pw').val()
	};
	
	$.ajax({
		type:"POST",
		url:"/jspTest/member.do",
		data:JSON.stringify(dto),
		contentType:"application/json; charset=utf-8",
		dataType:"text",
		success:function(result){
			alert('결과:'+result);
		},error:function(){
			alert('에러');
		}
		
	});
}