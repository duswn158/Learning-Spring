<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Download Page</h1>
	
	file : ${fileObj.name }<br>
	desc : ${fileObj.desc }
	
	<form action="download" method="post">
		<input type="hidden" name="name" value="${fileObj.name }">
		<input type="submit" value="download">
	</form>
	
	<!-- 
		tomcat web.xml 아래쪽 mime-type (Multipurpose Internet Mail Extension)
		request header에 지정되는, 데이터가 어떤 종류의 stream인지를 나타내는 프로토콜
		
		* mime-type 추가하기 (ex) hwp 파일)
		<mime-mapping>
	        <extension>hwp</extension>
	        <mime-type>application/unknown</mime-type>
    	</mime-mapping>
		
	 -->

</body>
</html>