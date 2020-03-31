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
  <br>
  <div class="container">
  <form>
    <div class="form-group">
      <label for="exampleFormControlInput1">Ticket Request Title</label>
      <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
    </div>
    <div class="form-group">
      <label for="exampleFormControlSelect1">Urgency (1 Not Urgent 5 Very Urgent)</label>
      <select class="form-control" id="exampleFormControlSelect1">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
    </div>
    <div class="form-group">
      <label for="exampleFormControlSelect1">Type Of Ticket</label>
      <select class="form-control" id="exampleFormControlSelect1">
        <option>Customer Care</option>
        <option>Clean Request</option>
      </select>
    </div>
    <div class="form-group">
      <label for="exampleFormControlInput1">Room Number (If applicable)</label>
      <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
      <label for="exampleFormControlInput1">Customer Name</label>
      <input type="email" class="form-control" id="exampleFormControlInput1" placeholder=""> 
 
    </div> 
    <div class="form-group"> 
      <label for="exampleFormControlTextarea1">Explanation of Order</label>
      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea> 
    </div>
  </form>
              <a href = "TicketsMain.jsp" type="button" class="btn btn-lg btn-block btn-outline-primary">Submit</a>

</div>




  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>