<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%!
  public void printMenu()
  {
   %>

<!DOCTYPE html>
<html>


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
<div class="d-none d-lg-block">

    <nav class="nav">
      <div class="container">
        <div class="logo" style="float: left; ">
          <a href="home.jsp"><img src="img/homeIcon.png"></a>
        </div>   
        <div id="mainListDiv" class="main_list"> 
          <ul class="navlinks">
            <li><a href="#">About</a></li> 
            <li><a href="Membership.jsp">Membership</a></li>
            <li><a href="Reservation.jsp">Reserve</a></li>
            <li><a href="Login.jsp">Login</a></li>
  
          </ul>
        </div>
        <span class="navTrigger">
          <i></i>
          <i></i>
          <i></i>
        </span>
      </div>
    </nav>
  </div>
  
  <div class="d-lg-none">
  
    <nav role="navigation">
      <div id="menuToggle">
        <input type="checkbox" />
        <span></span>
        <span></span>
        <span></span>
  
        <ul id="menu">
          <a href="#">
            <li>Home</li>
          </a>
          <a href="#">
            <li>About</li>
          </a>
          <a href="#">
            <li>Info</li>
          </a>
          <a href="#">
            <li>Contact</li>
          </a>
          <a href="https://erikterwan.com/" target="_blank">
            <li>Show me more</li>
          </a>
        </ul>
      </div>
    </nav>
  </div>

  

</html>
   <%!
  }
%>
