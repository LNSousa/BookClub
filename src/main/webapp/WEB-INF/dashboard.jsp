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
		<header class="d-flex justify-content-between align-items-center my-5">			
			<div class="">				
				<h1>Welcome, <c:out value="${ userName }"/></h1>
				<p>Books from everyone's shelves</p>
			</div>
			<div class="text-end">
				<a href="/logout">Log out</a><br />
				<a href="/books/new">+ Add a book to my shelf</a>
			</div>
		</header>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Book Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${ books }">
					<tr>						
						<td scope="row"><c:out value="${ book.getId() }" /></td>
						<td><a href="/books/${ book.getId() }"><c:out value="${ book.getTitle() }" /></a></td>
						<td><c:out value="${ book.getAuthor() }" /></td>
						<td><c:out value="${ book.user.getName() }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>