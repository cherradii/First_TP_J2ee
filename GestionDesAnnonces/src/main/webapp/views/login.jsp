<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="views/static_files_login_form/fonts/icomoon/style.css">

    <link rel="stylesheet" href="views/static_files_login_form/css/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="views/static_files_login_form/css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="views/static_files_login_form/css/style.css">

    <title>Login page | Gestion des annonces</title>
  </head>
  <body>
  
  
  <div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <img src="views/static_files_login_form/images/undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
              <h3>Sign In</h3>
            </div>
			
			<% if(request.getAttribute("msg") != null) { %>
				<div class="alert alert-danger alert-dismissible">
				  <button type="button" class="close" data-dismiss="alert">&times;</button>
				  <strong>Oops! </strong> <% out.print(request.getAttribute("msg")); %>
				</div>
			<% } %>
			
            <form action="login.php" method="post">
              <div class="form-group first">
                <label for="login">Login</label>
                <input type="email" class="form-control" name="login" required>
              </div>
              
			  <div class="form-group last mb-4">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" required>  
              </div>
              
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                <span class="ml-auto"><a href="#" class="forgot-pass">Forgot Password</a></span> 
              </div>

              <input type="submit" value="Log In" class="btn btn-block btn-primary">

              <span class="d-block text-left my-4 text-muted">&mdash; or login with &mdash;</span>
              
              <div class="social-login">
                <a href="#" class="facebook">
                  <span class="icon-facebook mr-3"></span> 
                </a>
                <a href="#" class="twitter">
                  <span class="icon-twitter mr-3"></span> 
                </a>
                <a href="#" class="google">
                  <span class="icon-google mr-3"></span> 
                </a>
              </div>
            </form>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>

  
    <script src="views/static_files_login_form/js/jquery-3.3.1.min.js"></script>
    <script src="views/static_files_login_form/js/popper.min.js"></script>
    <script src="views/static_files_login_form/js/bootstrap.min.js"></script>
    <script src="views/static_files_login_form/js/main.js"></script>
  </body>
</html>