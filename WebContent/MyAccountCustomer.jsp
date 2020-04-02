<%@page import="com.company.Access"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import= "javax.servlet.jsp.jstl.core.*" %>
<%@ page import="com.company.Access.*"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>


<head>
  <meta charset="ISO-8859-1">
  <title>Software Project</title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href="http://fonts.googleapis.com/css?family=Droid+Serif" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" type="text/css" href="WebStyle.css">
  <!--Navigation bar-->
  <div id="nav-holder"></div>
  <script>	 
    $(function () { $("#nav-holder").load("nav.jsp"); });
  </script>
</head>

<script>
  function clicked() {
    return confirm('Are you sure you want to cancel your membership');
}
  </script>
<body>

  <div class="hero-image-small">
      <img src="img/logo.png" class="marginauto">
  </div>
  </div>
 
  <br>
  <br>
  
  
	<c:if test="${Access.loggedIn  == 1}"> 
  
	<div class="container">
	  <div class="col-sm-12">
	    <div class="card">
	      <div class="card-body">
	        <h3 class="card-title">My Reservations</h3>
	        <a href="MyAccountCustomerMyReservations.jsp" class="btn btn-primary">View Reservations</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-12">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Account Management</h5>
	        <a href="MyAccountCustomerChangePassword.jsp" class="btn btn-primary">Change Password</a>
	        <input type="submit" onclick="return clicked();" class="btn btn-primary" value="Cancel Membership" />
	      </div>
	    </div>
	  </div>
	</div>
	</div>
	</c:if>

	<c:if test="${Access.loggedIn  != 1}"> 
  <div class="jumbotron text-center">
    <h1 class="display-3">Sorry You Must Log In To Access This Page</h1>
    <p class="lead"><strong>If you have any concerns please call us or email at support@bckjt.com</strong> </p>
    <hr>
  </div>
	</c:if>


  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>