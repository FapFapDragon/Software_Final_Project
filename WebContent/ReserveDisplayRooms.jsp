<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ page import= "javax.servlet.jsp.jstl.core.*" %>
<%@ page import="com.company.Access.*"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<head>
<meta charset="ISO-8859-1">
<title>Software Project</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="http://fonts.googleapis.com/css?family=Droid+Serif"
	rel="stylesheet" type="text/css" />
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
	<div class="container">
		<!-- Card group -->
		<div class="card-group">

			<!-- Card -->
			<div class="card mb-4">
  
				<!-- Card image -->
				<div class="view overlay"> 
					<img class="card-img-top"
						src="img/mainBed.png"
						alt="Card image cap"> <a href="#!">
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">
 
					<!-- Title -->
					<h4 class="card-title">Wonderful Summer Get Away</h4>
					<!-- Text -->
					<p class="card-text">Lovely room near the volly ball court.</p>
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
        <a href="SpecialOffers.jsp" class="btn btn-primary btn-lg btn-block" type="submit" >Reserve Room</a>

				</div>
				<!-- Card content -->

			</div>
			<!-- Card -->

			<!-- Card -->
			<div class="card mb-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top"
						src="img/bed1.png"
						alt="Card image cap"> <a href="#!">
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">
					<!-- Title -->
					<h4 class="card-title">Lovers Get Away</h4>
					<!-- Text --> 
					<p class="card-text">Enjoy a bed full of roses for your romantic get away.</p>
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
       				<a href="SpecialOffers.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Reserve Room</a>

				</div>
				<!-- Card content -->

			</div>
			<!-- Card -->

			<!-- Card -->
			<div class="card mb-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top"
						src="img/bed2.png"
						alt="Card image cap"> <a href="#!">
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">Quite And Tranquil</h4>
					<!-- Text -->
					<p class="card-text">Meditate With ease in this room</p>
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
				
        <a href="SpecialOffers.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Reserve Room</a>

					

				</div>
				<!-- Card content -->

			</div>
			<!-- Card -->

		</div>  
		<!-- Card group -->
		<!-- Card group -->
		<div class="card-group">

			<!-- Card -->
			<div class="card mb-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top"
						src="img/bed3.png"
						alt="Card image cap"> <a href="#!">
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">Family Ready Room!</h4>
					<!-- Text -->
					<p class="card-text">Yes your kids can jump on our beds.</p>
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
        <a href="SpecialOffers.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Reserve Room</a>

				</div>
				<!-- Card content -->

			</div>
			<!-- Card -->

			<!-- Card -->
			<div class="card mb-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top"
						src="img/bed4.png"
						alt="Card image cap"> <a href="#!">
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">
					<!-- Title -->
					<h4 class="card-title">Business Ready Room</h4>
					<!-- Text -->
					<p class="card-text">Two beds, two desks, get some work done!</p>
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
        <a href="SpecialOffers.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Reserve Room</a>

				</div>
				<!-- Card content -->

			</div>
			<!-- Card -->

			<!-- Card -->
			<div class="card mb-4">

				<!-- Card image -->
				<div class="view overlay">
					<img class="card-img-top"
						src="img/bed5.png"
						alt="Card image cap"> <a href="#!">
						<div class="mask rgba-white-slight"></div>
					</a>
				</div>

				<!-- Card content -->
				<div class="card-body">

					<!-- Title -->
					<h4 class="card-title">Relax With Blue</h4>
					<!-- Text -->
					<p class="card-text">Enjoyable blue room! We know its your favorite.</p>
					<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
        <a href="SpecialOffers.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Reserve Room</a>

				</div>
				<!-- Card content --> 

			</div>
			<!-- Card -->

		</div>
		<!-- Card group -->
	</div>
	</div>
	<!--Navigation bar-->
	<div id="footer-holder"></div>
	<script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>

</html>