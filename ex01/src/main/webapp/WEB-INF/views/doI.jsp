<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var result = "${result}";
	if (result == "success") {
		alert("성공");
	}
</script>
</head>
<body>
	<h1>doH.jsp</h1>
	<h2>result: ${result}</h2>
</body>
</html>