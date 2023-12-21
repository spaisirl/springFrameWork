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
		alert("성공했습니다.");
	}

</script>
</head>
<body>
	<h1>doF.jsp</h1>
	<h2>vo: ${vo}</h2>
	<h2>productVO: ${productVO}</h2>
	<h3>name: ${vo.name}</h3> <!-- vo.getName -->
	<h3>price: ${vo.price}</h3>
</body>
</html>