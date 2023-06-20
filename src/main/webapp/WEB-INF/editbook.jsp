<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book club</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center my-4">
			<h1>Edit your book!</h1>
			<a href="/dashboard">Back to dashboard</a>
		</header>
		<form:form action="/edit/${ book.getId() }" method="post" modelAttribute="book" style="width:50%;" class="mx-auto">
		    <form:input type="hidden" value="${ userId }" path="user"/>
		    <div class="my-3">
		        <form:label path="title" class="form-label">Title</form:label>
		        <form:errors path="title" style="color:red"/>
		        <form:input path="title" type="text" class="form-control"/>
		    </div>
		    <div class="my-3">
		        <form:label path="author" class="form-label">Author Name</form:label>
		        <form:errors path="author" style="color:red"/>
		        <form:input path="author" type="text" class="form-control"/>
		    </div>
		    <div class="my-3">
		        <form:label path="thoughts" class="form-label">Thoughts</form:label>
		        <form:errors path="thoughts" style="color:red"/>
		        <form:textarea path="thoughts" class="form-control" rows="5"/>
		    </div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>