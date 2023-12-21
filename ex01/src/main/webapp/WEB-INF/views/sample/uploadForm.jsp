<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<div>
		<form action="/sample/exUploadPost" method="post" 
		enctype="multipart/form-data">
			<input type="file" name="files"><br>
			<input type="file" name="files"><br>
			<input type="file" name="files"><br>
			
			<button type="submit">전송</button>
		</form>
	</div>
</body>
</html>