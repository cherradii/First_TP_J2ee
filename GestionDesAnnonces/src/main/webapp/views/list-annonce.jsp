<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!doctype html>
<html lang="en">
<head>
  <title>Ajouter annonce | Gestion des annonces</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="//cdn.ckeditor.com/4.5.5/standard/ckeditor.js"></script>
</head>
<body>


  	<%@include file="includes/header.jsp" %>
  	
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-12 offset-md-4" style="margin-left: 20px; margin-top: 100px;">
				<div class="panel panel-info bg-info" style="background-color: #CEF6F5;">
				  <div class="panel-body">Liste des annonces</div>
				  <div class="panel-footer">
				  	<table class="table">
				  		<thead>
				  			<tr>
					  			<th>Titre</th>
					  			<th>Description</th>
					  			<th>Date de publication</th>
					  			<th>Editeur</th>
					  			<th colspan="2">Action</th>
					  		</tr>
				  		</thead>
				  		<tbody>
				  			<c:forEach var="annonce" items="${listAnnonce}">
				  				<tr>
									<td><c:out value="${annonce.idAnnonce}" /></td>
									<td><c:out value="${annonce.title}" /></td>
									<td><c:out value="${annonce.description}" /></td>
									<td><c:out value="${annonce.datePublication}" /></td>
									<td><c:out value="${annonce.publisher}" /></td>
									<td>
										<a href="edit?id=<c:out value='${annonce.idAnnonce}' />">Edit</a>
											&nbsp;&nbsp;&nbsp;&nbsp; 
										<a href="delete?id=<c:out value='${annonce.idAnnonce}' />">Delete</a>
									</td>
								</tr>
				  			</c:forEach>
				  		</tbody>
				  	</table>
				  </div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="views/sckeditor/sckeditor.js"></script>
	<script type="text/javascript">
		CKEDITOR.replace('content');
	</script>

</body>
</html>
