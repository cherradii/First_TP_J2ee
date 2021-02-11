<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<nav class="navbar navbar-light bg-secondary">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">Gestion des annonces</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>
	      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="list">Consulter la liste des annonces</a></li>
	          <li><a href="new">Ajouter une annonce</a></li>
	          <li><a href="#">Suivre l'etat de mon annonce</a></li>
	        </ul>
	      </li>
	      <li><a href="#">Page 2</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#"><span class="glyphicon glyphicon-user"></span> 
	      	<% 
	      		if(session.getAttribute("user") != null)
	      			out.print(session.getAttribute("fullName"));
	      	%>
	      		      </a></li>
	      <li><a href="logout.php"><span class="glyphicon glyphicon-log-in"></span> Logout </a></li>
	    </ul>
	  </div>
	</nav>
</body>
</html>