<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" type="text/css" href="css/WebStyle.css">

<!--Navigation bar-->
<div id="nav-holder"></div>
<script>
$(function(){$("#nav-holder").load("nav.jsp");});
</script>
</head>


<body>
  <div class="hero-image" style= "background-image: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url("homeHero.jpeg")">
    <div class="hero-text">
      <h1 style="font-size:3.5vw;">Superior In Every Way </h1>
      <h4 style="font-size:1.5vw;">Experience The Largest Lake In The World</h4>
    </div>
    <div>
      <img src="img/logo.png" class="marginauto">
    </div>
  </div>

  <div class="container">
    <div class="row">
    <br>
    <br>
    <br>
    </div>
    <div class="row">
      <div class="col-md-12">
        <img src="img/swim.jpg" alt="test" class="img-fluid">
        <div class="carousel-caption">
          <h1 style="z-index: -2;">Example headline.</h1>
        </div>
      </div>
    </div>
    <div class="row" style="padding: 60px;"> </div>
    <div class="row">
      <div class="col-md-6">
        <img src="img/kayaking.jpg" alt="test" class="img-fluid">
        <div class="carousel-caption">
          <h2>Example headline.</h2>
        </div>
      </div>
      <div class="col-md-6">
        <img src="img/indoors.jpg" alt="test" class="img-fluid">
        <div class="carousel-caption">
          <h2>Example headline.</h2>
        </div>
      </div>
    </div>

    <div class="row" style="padding: 60px;">
    </div>

    <div class="row">
      <div class="col-md-12">
        <img src="img/membership.jpg" alt="test" class="img-fluid">
        <div class="carousel-caption">
          <h1>Become a member today!</h1>
        </div>
      </div>


      <div class="row" style="padding: 60px;">
      </div>
    </div>

  </div>

  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
  $(function(){$("#footer-holder").load("footer.jsp");});
  </script>d
</body>
</html>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/scripts.js"></script>
<script>
  $('.navTrigger').click(function () {
    $(this).toggleClass('active');
    console.log("Clicked menu");
    $("#mainListDiv").toggleClass("show_list");
    $("#mainListDiv").fadeIn();

  });
  $(window).scroll(function () {
    if ($(document).scrollTop() > 50) {
      $('.nav').addClass('affix');
      console.log("OK");
    } else {
      $('.nav').removeClass('affix');
    }
  });

</script>