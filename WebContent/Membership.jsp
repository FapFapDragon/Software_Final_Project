<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.lang.*,java.util.*,java.net.*,java.util.*,java.text.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html>

    <%! 
          public String sendMail(String to, String sub, String msg) {
            String res = null;      
            System.out.println("HI");      
            return res;
         }
     %>

    <%        
    String a = request.getParameter("to");
    if(a != null){
        sendMail(request.getParameter("to"),request.getParameter("sub"),request.getParameter("msg"));
    }
    %>

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

  <br>
  <br>


  <div class="container">
    <div class="card-deck mb-3 text-center">
      <div class="card mb-4 box-shadow">
        <div class="card-header">
          <h4 class="my-0 font-weight-normal">Free</h4>
        </div>
        <div class="card-body">
          <h1 class="card-title pricing-card-title">$0 <small class="text-muted">/ mo</small></h1>
          <ul class="list-unstyled mt-3 mb-4">
            <li>Email support</li>
            <li>Check in and out of rooms online</li>
          </ul>
          <a href="MembershipSignupFree.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Sign up</a>
     
        </div> 
      </div> 
      <div class="card mb-4 box-shadow">
        <div class="card-header"> 
          <h4 class="my-0 font-weight-normal">Loyal Member</h4>
        </div>
        <div class="card-body"> 
          <h1 class="card-title pricing-card-title">$15 <small class="text-muted">/ mo</small></h1>
          <ul class="list-unstyled mt-3 mb-4">
            <li>10% Off Rooms</li>
            <li>Complementary Drink</li>
            <li>Email support</li>
            <li>Check in and out of rooms online</li>
          </ul>
          <a href="MembershipSignupMembership.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Sign up</a>
          
        </div>
      </div>
      <div class="card mb-4 box-shadow">
        <div class="card-header">  
          <h4 class="my-0 font-weight-normal">Enterprise</h4>
        </div>
        <div class="card-body">
          <h1 class="card-title pricing-card-title">$29 <small class="text-muted">/ mo</small></h1>
          <ul class="list-unstyled mt-3 mb-4">
            <li>10% Off Rooms And 5% off Banquet Rooms</li>
            <li>5% Off Banquet Food Orders</li>
            <li>Email support</li>
            <li>Check in and out of rooms online</li>
          </ul>
          <a href="MembershipSignupMembershipEnterprise.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Sign up</a>
          
        </div>
      </div>
    </div>

  </div>

      
  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>