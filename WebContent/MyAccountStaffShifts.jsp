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


	<c:if test="${Access.loggedIn  == 2}">

  <div class="container py-5">

    <header class="text-center text-white mb-5">
      <h1 class="display-4">Bootstrap Calendar</h1>
      <p class="font-italic mb-0">A nicely-designed Bootstrap calendar widget. This calendar is just a for design purpose, you can make it work.</p>
      <p class="font-italic">Snippet By <a href="https://bootstrapious.com" class="text-white">
          <u>Bootstrapious</u></a>
      </p>
    </header>
  
    
    <!-- Calendar -->
    <div class="calendar shadow bg-white p-5">
      <div class="d-flex align-items-center"><i class="fa fa-calendar fa-3x mr-3"></i>
        <h2 class="month font-weight-bold mb-0 text-uppercase">December 2019 Shifts</h2>
      </div>
      <br>
      <br>
      <ol class="day-names list-unstyled">
        <li class="font-weight-bold text-uppercase">Sun</li>
        <li class="font-weight-bold text-uppercase">Mon</li>
        <li class="font-weight-bold text-uppercase">Tue</li>
        <li class="font-weight-bold text-uppercase">Wed</li>
        <li class="font-weight-bold text-uppercase">Thu</li>
        <li class="font-weight-bold text-uppercase">Fri</li>
        <li class="font-weight-bold text-uppercase">Sat</li>
      </ol>
  
      <ol class="days list-unstyled">
        <li>
          <div class="date">1</div>
          <div class="event bg-success"><a href="#">9:00AM - 6:00 PM</a></div>
        </li>
        <li>
          <div class="date">2</div>
        </li>
        <li>
          <div class="date">3</div>
        </li>
        <li>
          <div class="date">4</div>
        </li>
        <li>
          <div class="date">5</div>
        </li>
        <li>
          <div class="date">6</div>
        </li>
        <li>
          <div class="date">7</div>
        </li>
        <li>
          <div class="date">8</div>
        </li>
        <li>
          <div class="date">9</div>
        </li>
        <li>
          <div class="date">10</div>
        </li>
        <li>
          <div class="date">11</div>
        </li>
        <li>
          <div class="date">12</div>
        </li>
        <li>
          <div class="date">13</div>
          <div class="event all-day  bg-success">5:00 PM - 10:00 PM</div>
        </li>
        <li>
          <div class="date">14</div>
        </li>
        <li>
          <div class="date">15</div>
          <div class="event all-day  bg-success">5:00 PM - 10:00 PM</div>
        </li>
        <li>
          <div class="date">16</div>
          <div class="event all-day  bg-success">5:00 PM - 10:00 PM</div>

        </li>
        <li>
          <div class="date">17</div>
          <div class="event  bg-success">5:00 PM - 10:00 PM</div>

        </li>
        <li>
          <div class="date">18</div>
        </li>
        <li>
          <div class="date">19</div>
        </li>
        <li>
          <div class="date">20</div>
        </li>
        <li>
          <div class="date">21</div>
          <div class="event bg-success">6:00 PM - 11:00 PM </div>
        </li>
        <li>
          <div class="date">22</div>
          <div class="event bg-info">11:00 PM - 5:00 AM</div>
        </li>
        <li>
          <div class="date">23</div>
        </li>
        <li>
          <div class="date">24</div>
        </li>
        <li>
          <div class="date">25</div>
        </li>
        <li>
          <div class="date">26</div>
        </li>
        <li>
          <div class="date">27</div>
        </li>
        <li>
          <div class="date">28</div>
        </li>
        <li>
          <div class="date">29</div>
        </li>
        <li>
          <div class="date">30</div>
        </li>
        <li>
          <div class="date">31</div>
        </li>
        <li class="outside">
          <div class="date">1</div>
        </li>
        <li class="outside">
          <div class="date">2</div>
        </li>
        <li class="outside">
          <div class="date">3</div>
        </li>
        <li class="outside">
          <div class="date">4</div>
        </li>
      </ol>
    </div>
  </div>

	</c:if>

	<c:if test="${Access.loggedIn  != 2}"> 
  <div class="jumbotron text-center">
    <h1 class="display-3">Sorry You Must Log In To Access This Page</h1>
    <p class="lead"><strong>If you have any concerns please call us or email at support@bckjt.com</strong> </p>
    <hr>
  </div>
	</c:if>




  <style>





.clearfix::after,
.calendar ol::after {
  content: ".";
  display: block;
  height: 0;
  clear: both;
  visibility: hidden;
}

.calendar {
  border-radius: 10px;
}

.month {
  font-size: 2rem;
}

@media (min-width: 992px) {
  .month {
    font-size: 3.5rem;
  }
}

.calendar ol li {
  float: left;
  width: 14.28571%;
}

.calendar .day-names {
  border-bottom: 1px solid #eee;
}

.calendar .day-names li {
  text-transform: uppercase;
  margin-bottom: 0.5rem;
}

.calendar .days li {
  border-bottom: 1px solid #eee;
  min-height: 8rem;
}

.calendar .days li .date {
  margin: 0.5rem 0;
}

.calendar .days li .event {
  font-size: 0.75rem;
  padding: 0.4rem;
  color: white;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  border-radius: 4rem;
  margin-bottom: 1px;
}

.calendar .days li .event.span-2 {
  width: 200%;
}

.calendar .days li .event.begin {
  border-radius: 1rem 0 0 1rem;
}

.calendar .days li .event.end {
  border-radius: 0 1rem 1rem 0;
}

.calendar .days li .event.clear {
  background: none;
}

.calendar .days li:nth-child(n+29) {
  border-bottom: none;
}

.calendar .days li.outside .date {
  color: #ddd;
}

body {
  min-height: 100vh;
}


  </style>
  




  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>