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


<style>
  body {font-family: Arial, Helvetica, sans-serif;}
  form {border: 3px solid #f1f1f1;}
  
  input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
  }
  
  button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
  }
  
  button:hover {
    opacity: 0.8;
  }
  
  .cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
  }
  
  .imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
  }
  
  img.avatar {
    width: 40%;
    border-radius: 50%;
  }
  
  
  span.psw {
    float: right;
    padding-top: 16px;
  }
  
  </style>
<body>

  <div class="hero-image-small">
      <img src="img/logo.png" class="marginauto">
  </div>
  </div>



  <br>
  <br>
<c:if test="${Access.loggedIn  == 1}"> 
  <form action="/action_page.php" method="post">
    <div class="container">
      <label for="uname"><b>Old Password</b></label>
      <input type="text" placeholder="Enter Username" name="psw" required>
  
      <label for="psw"><b>New Password</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
      <label for="psw"><b>New Password Confirmed</b></label>
      <input type="password" placeholder="Enter Password" name="psw" required>
          
        <a href="MyAccountCustomerChangePasswordSuccess.jsp" class="btn btn-primary">Submit</a>
           

    </div>
  
  </form>

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