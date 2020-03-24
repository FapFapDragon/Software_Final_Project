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


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/scripts.js"></script>
<script>
	$('.navTrigger').click(function() {
		$(this).toggleClass('active');
		console.log("Clicked menu");
		$("#mainListDiv").toggleClass("show_list");
		$("#mainListDiv").fadeIn();

	});
	$(window).scroll(function() {
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
			<div class="logo" style="float: left;">
				<a href="home.jsp"><img src="img/homeIcon.png"></a>
			</div>
			<div id="mainListDiv" class="main_list">
				<ul class="navlinks">
					<li><a href="#">About</a></li>
					<li><a href="Membership.jsp">Membership</a></li>
					<li><a href="Reservation.jsp">Reserve</a></li>
					<c:if test="${Access.loggedIn  == 0}">
					<li><a href="Login.jsp">Login</a></li>
					</c:if>
					<c:if test="${Access.loggedIn == 1}">
					<li><a href="Login.jsp">My Account</a></li>
					</c:if>
					<c:if test="${Access.loggedIn == 2}">
					<li><a href="Login.jsp">Tickets</a></li>
					<li><a href="Employee.jsp">Account</a></li>
					</c:if>
				</a></li>
				
				</ul>
			</div>
			<span class="navTrigger"> <i></i> <i></i> <i></i>
			</span> 
		</div>
	</nav>
</div>



</html>

