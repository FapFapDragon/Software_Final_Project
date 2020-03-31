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

  <div class="container">
  <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Eric Smith</h5>
      <small>3 days ago</small>
    </div>
    <p class="mb-1">Contacted The General Manager about receiving a refund for a messy room</p>
    <small>In Progress...</small>
  </a>
  <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
    <div class="d-flex w-100 justify-content-between">
      <h5 class="mb-1">Joe Smith (Manager)</h5>
      <small>1 day ago</small>
    </div>
    <p class="mb-1">Contacted Eric, Left Voice Mail</p>
  </a>
  <br>
  <br>
  <form>
    <div class="form-group">
      <label for="exampleFormControlInput1">Your Name</label>
      <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="">
    </div> 
    <div class="form-group">
      <label for="exampleFormControlSelect1">Set Ticket Status</label>
      <select class="form-control" id="exampleFormControlSelect1">
        <option>Closed</option>
        <option>Remain Open</option>

      </select>
    </div>

    <div class="form-group">
      <label for="exampleFormControlTextarea1">Ticket Work Notes</label>
      <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
  </form>
  <input type="submit" class="btn btn-primary" value="Submit">

	</div>

  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>