<%@page import="com.cherradi.ensah.bo.Annonce"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
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
			<div class="col-md-8 offset-md-4" style="margin-left: 100px; margin-top: 100px;">
				<div class="panel panel-info bg-info" style="background-color: #CEF6F5;">
				  <div class="panel-body">Editer une annonce</div>
				  <div class="panel-footer">
				  	<form action="update" method="post">
				  		<div class="form-group">
				  			<label>ID: ${annonce.idAnnonce }</label>
							<input type="hidden" name="id" value="${annonce.idAnnonce }" />
				  		</div>
				  		<div class="form-group">
				  			<label>Titre</label>
							<input type="text" name="titre" class="form-control" value="${annonce.title }" />
				  		</div>
				  		<div class="form-group">
				  			<label>Description</label>
							<textarea name="content" class="form-control"  value="${annonce.description }"></textarea>
				  		</div>
				  		<div class="form-group">
				  			<label></label>
							<input type="submit" name="submit" value="Modifier" class="form-contol"/>
				  		</div>
				  	</form>
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
