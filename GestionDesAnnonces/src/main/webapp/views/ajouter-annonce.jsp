<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				  <div class="panel-body">Ajouter une annonce</div>
				  <div class="panel-footer">
				  	<form action="insert" method="post">
				  		<div class="form-group">
				  			<label>Titre</label>
							<input type="text" name="titre" class="form-control" />
				  		</div>
				  		<div class="form-group">
				  			<label>Description</label>
							<textarea name="content" class="form-control"></textarea>
				  		</div>
				  		<div class="form-group">
				  			<label></label>
							<input type="submit" name="submit" value="Publiée" class="form-contol"/>
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
