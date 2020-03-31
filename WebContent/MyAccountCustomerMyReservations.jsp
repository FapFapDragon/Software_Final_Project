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
    <!-- Card group -->
    <div class="card-group">

      <!-- Card -->
      <div class="card mb-4">

        <!-- Card image -->
        <div class="view overlay">
          <img class="card-img-top" src="img/mainBed.png" alt="Card image cap">
          <a href="#!">
            <div class="mask rgba-white-slight"></div>
          </a> 
        </div>

        <!-- Card content -->
        <div class="card-body">

          <!-- Title -->
          <h4 class="card-title">Room Reservation</h4>
          <!-- Text -->
          <p class="card-text">Aug 25 - Aug 30</p>  
          <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
          <a href="MyAccountCustomerCancelReservationSuccess.jsp" class="btn btn-primary btn-md">Cancel Reservation</a>
           
        </div>
        <!-- Card content -->
      </div>
      <!-- Card -->
      <div class="card mb-4">
  
        <!-- Card image -->
        <div class="view overlay">
          <img class="card-img-top" src="img/vbImage.png" alt="Card image cap">
          <a href="#!">
            <div class="mask rgba-white-slight"></div>
          </a>  
        </div> 

        <!-- Card content -->
        <div class="card-body">

          <!-- Title -->
          <h4 class="card-title">Volly Ball Court Reservation</h4>
          <!-- Text --> 
          <p class="card-text">6:00 - 7:00 PM Aug / 28</p>
          <!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
          <button type="button" class="btn btn-primary btn-md">Cancel Reservation</button>

        </div>
        <!-- Card content -->
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