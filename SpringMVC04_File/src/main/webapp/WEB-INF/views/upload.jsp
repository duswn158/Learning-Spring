<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		form:form -> Spring form 태그
		form:form, form:errors, form:input, ...
		
		form:errors -> Errors, BindingResult를 사용할 때 
		command객체의 특정 field 에서 발생하는 예외에 대한 메시지 출력 가능
		
		id : 기본적으로 command
		action : 자기 페이지의 url / 내가 가고싶은 url
		method : 기본값은 post
		modelAttribute : form에 있는 요소들의 값을 채우기 위해 사용될 객체를 request로 부터 찾을 때 사용
		enctype : 파일 업로드를 위한 속성
				  form data 가 서버로 제출될 때 해당 데이터가 인코딩 되는 방법을 명시.
				  multipart/form-data : 모든 문자를 인코딩하지 않음을 명시.
				  form 요소가 파일이나 이미지를 서버로 전송할 때 사용
	 -->

	<h1>Upload Page</h1>
	
	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		
		file<br>
		<input type="file" name="mpfile"><br>
		<p style="color: red; font-weight: bold;"><form:errors path="mpfile"/></p><br>
		
		description<br>
		<textarea rows="10" cols="40" name="desc"></textarea><br>
		<input type="submit" value="send">
		
	</form:form>
	
	<!-- 		
		enctype 속성
		1. application / www-form-urlencoded : 문자들이 encoding 됨 (default)
		2. multipart/form-data : file upload
		3. text/plain : 문자들을 encoding 하지 않음
	 -->
	
	
</body>
</html>