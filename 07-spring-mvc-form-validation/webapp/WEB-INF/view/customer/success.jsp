<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Success - Page</title>
	<link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body>
	<h2 class="green">Customer Success Page</h2>
	
	<h3 class="green">Congratulations.You have registered our course successful</h3>
	
	<hr>
	
	<p class="red">Your information</p>
	
	<p>first name: ${customer.firstName}</p>
	<p>last name: ${customer.lastName}</p>
	<p>Free passes: ${customer.freePasses}</p>
	<p>Postal Code: ${customer.postalCode}</p>
	<p>Course Code: ${customer.courseCode}</p>
	
</body>
</html>