<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Add role</h3>
	<form class="form">
		<input id="name" class="form-control my-1" type="text" name="name" placeholder="Role">
		<input id="desc" class="form-control" type="text" name="desc" placeholder="Description">
		<button id=" add-role" type="submit" class="btn btn-success mt-3">Add</button>
	</form>
	<a href="/crm/roles" class="btn btn-primary mt-2">Back</a>
	
	<script src="./js/role.js"></script>
</body>
</html>