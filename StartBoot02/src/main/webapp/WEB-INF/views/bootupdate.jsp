<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Update</h1>
	
	<form action="updateres" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" value="${dto.myname }" name="myno"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" value="${dto.title }" name="mytitle"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="mycontent">${dto.mycontent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="목록" onclick="location.href='list'">
					<input type="submit" value="수정완료">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>