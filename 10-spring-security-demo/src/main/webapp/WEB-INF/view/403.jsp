<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access denied page</title>
<link href="${contextPath}/static/css/style.css" rel="stylesheet">
</head>
<body>
	You have no permission to enter this resource
	
	<hr>
	<h3>Redirect to your home page after <span id="runner">10</span></h3>
	<a href="${contextPath}/">Back to homepage</a>
	
	<script>
		let counter = 10;
		let interval = setInterval(()=> {
			counter--;
			document.querySelector("#runner").textContent = counter;
			if(counter === 0){
				window.location.href = "${contextPath}/";
				clearInterval();
			}
		}, 1000);
	</script>
</body>
</html>