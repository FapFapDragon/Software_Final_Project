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
  </div>



  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <!------ Include the above in your HEAD tag ---------->

	<c:if test="${Access.loggedIn  == 2}">

  <div class="container emp-profile">
    <form method="post">
      <div class="row">
        <div class="col-md-4">
          <div class="profile-img">

          </div>
        </div>

        <div class="col-md-2">
          <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile" />
        </div>
      </div> 
      <div class="row">
        <div class="col-md-4">
          <div class="profile-work">
            <p>Hotel</p>
            <a href="">Check In</a><br />
            <a href="">Upgrade Room</a><br />
            <a href="">Change Account Information</a>
            <a href="">Change Check In Time</a><br />
            <a href="">Change Checkout Time</a><br />

          </div>
        </div>
        <div class="col-md-8">
          <div class="tab-content profile-tab" id="myTabContent">
            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
              <div class="row">
                <div class="col-md-6">
                  <label>User Id</label>
                </div>
                <div class="col-md-6">
                  <p>James203</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Name</label>
                </div>
                <div class="col-md-6">
                  <p>James McCormack</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Email</label>
                </div>
                <div class="col-md-6">
                  <p>jwmccorm@gmail.com</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Phone</label>
                </div>
                <div class="col-md-6">
                  <p>807 123 7890</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Membership</label>
                </div>
                <div class="col-md-6">
                  <p>Paid Membership</p>
                </div>
              </div>
            </div>
 
          </div>
        </div>
      </div>
    </form>
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
    $(document).ready(function () {
      $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myList a").filter(function () {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
      });
    });
  </script>

  <style>
    .emp-profile {
      padding: 3%;
      margin-top: 3%;
      margin-bottom: 3%;
      border-radius: 0.5rem;
      background: #fff;
    }

    .profile-img {
      text-align: center;
    }

    .profile-img img {
      width: 70%;
      height: 100%;
    }

    .profile-img .file {
      position: relative;
      overflow: hidden;
      margin-top: -20%;
      width: 70%;
      border: none;
      border-radius: 0;
      font-size: 15px;
      background: #212529b8;
    }

    .profile-img .file input {
      position: absolute;
      opacity: 0;
      right: 0;
      top: 0;
    }

    .profile-head h5 {
      color: #333;
    }

    .profile-head h6 {
      color: #0062cc;
    }

    .profile-edit-btn {
      border: none;
      border-radius: 1.5rem;
      width: 70%;
      padding: 2%;
      font-weight: 600;
      color: #6c757d;
      cursor: pointer;
    }

    .proile-rating {
      font-size: 12px;
      color: #818182;
      margin-top: 5%;
    }

    .proile-rating span {
      color: #495057;
      font-size: 15px;
      font-weight: 600;
    }

    .profile-head .nav-tabs {
      margin-bottom: 5%;
    }

    .profile-head .nav-tabs .nav-link {
      font-weight: 600;
      border: none;
    }

    .profile-head .nav-tabs .nav-link.active {
      border: none;
      border-bottom: 2px solid #0062cc;
    }

    .profile-work {
      padding: 14%;
      margin-top: -15%;
    }

    .profile-work p {
      font-size: 12px;
      color: #818182;
      font-weight: 600;
      margin-top: 10%;
    }

    .profile-work a {
      text-decoration: none;
      color: #495057;
      font-weight: 600;
      font-size: 14px;
    }

    .profile-work ul {
      list-style: none;
    }

    .profile-tab label {
      font-weight: 600;
    }

    .profile-tab p {
      font-weight: 600;
      color: #0062cc;
    }
  </style>





  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>