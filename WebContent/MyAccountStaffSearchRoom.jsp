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


<body>

  <div class="hero-image-small">
      <img src="img/logo.png" class="marginauto">
  </div>



  <br>
  <br>
  	<c:if test="${Access.loggedIn  == 2}">
  
  <div class="container mt-3">
    <h2>Search Room</h2>
    <input class="form-control" id="myInput" type="text" placeholder="Search..">
    <br>
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>Room Number</th>
          <th>Status</th>
          <th>Room Service Ticket</th>
          <th>View Room</th>
        </tr>
      </thead>
      <tbody id="myTable">
        <tr>
          <td>101</td>
          <td>In Use</td>
          <td>Yes</td>
          <td>  <input type="submit" class="btn btn-primary" value="View"></td>

        </tr>
        <tr>
          <td>103</td>
          <td>Closed</td>
          <td>Yes</td>
          <td>  <input type="submit" class="btn btn-primary" value="View"></td>

        </tr>
        <tr>
          <td>204</td>
          <td>Open</td>
          <td>No</td>
          <td>  <input type="submit" class="btn btn-primary" value="View"></td>

        </tr>
        <tr>
          <td>210</td>
          <td>In Use</td>
          <td>Yes</td>
          <td>  <input type="submit" class="btn btn-primary" value="View"></td>

        </tr>
      </tbody>
    </table>
    
  </div>
  
  	</c:if>

	<c:if test="${Access.loggedIn  != 2}"> 
  <div class="jumbotron text-center">
    <h1 class="display-3">Sorry You Must Log In To Access This Page</h1>
    <p class="lead"><strong>If you have any concerns please call us or email at support@bckjt.com</strong> </p>
    <hr>
  </div>
	</c:if>
  
  
  <script>
  $(document).ready(function(){
    $("#myInput").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("#myTable tr").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });
  </script>
  



  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>