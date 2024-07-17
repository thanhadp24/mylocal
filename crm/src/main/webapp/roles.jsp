<%@ page isELIgnored="false" %>
<%@page import="crm.model.Role"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>CRM</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>



<body>
	<h2>CRM</h2>

	<div>
		<a href="/crm/roles/add" class="btn btn-primary">Add role</a>
	</div>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Name</th>
				<th scope="col">Description</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="role" items="${roles}">
				<tr>
					<td>${role.getId()}</td>
					<td>${role.getName()}</td>
					<td>${role.getDesc()}</td>
					<td><a href="#" class="btn btn-primary edit"
						role-id="${role.getId()}">Edit</a> <a href="#"
						class="btn btn-danger del" role-id="${role.getId()}">Delete</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="./js/role.js"></script>
</body>
</html>
