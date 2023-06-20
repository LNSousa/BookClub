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
<title>Book Club</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">				
				<h1 class="fst-italic my-5"><c:out value="${ book.getTitle() }"/></h1>
				<a href="/dashboard">Back to the shelves</a>
		</header>
		<c:choose>
			<c:when test="${ userId == book.user.getId() }">
				<h2>You read <c:out value="${ book.getTitle() }"/> by <c:out value="${ book.getAuthor() }"/>.</h2>
				<h4>Here are your thoughts:</h4>
			</c:when>
			<c:otherwise>
				<h2><c:out value="${ book.user.getName() }"/> read <c:out value="${ book.getTitle() }"/> by <c:out value="${ book.getAuthor() }"/>.</h2>
				<h4>Here are <c:out value="${ book.user.getName() }"/>'s thoughts:</h4>
			</c:otherwise>
		</c:choose>
		<div class="m-5" style="width:60%;">			
			<hr />
			<p class="fst-italic py-3"><c:out value="${ book.getThoughts() }"/></p>
			<hr />
			<c:if test="${ userId == book.user.getId() }" >
				<div class="d-flex justify-content-end">
					<a href="/books/${ id }/edit" class="btn btn-outline-success me-3">Edit</a>
					<form action="/delete/${ id }" method="post">
				        <input type="hidden" name="_method" value="delete">
				        <input type="submit" value="delete" class="btn btn-outline-danger">
				    </form>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>