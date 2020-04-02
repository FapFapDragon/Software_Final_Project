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

  <div class="container">
    <div class="row">
      <div class="span12">


        <hr>
              <a href = "TicketsRequest.jsp" type="button" class="btn btn-lg btn-block btn-outline-primary">New Ticket</a>

        <p class="lead">Select Tickets:</p>
        <input type="text" placeholder="Search.."> 
        <br>
        <br>
        <div id="tab" class="btn-group container" data-toggle="buttons-radio">
          <a href="#prices2" class="btn btn-large btn-info" data-toggle="tab">Customer Care</a>
          <a href="#features2" class="btn btn-large btn-info" data-toggle="tab">Food Order</a>
          <a href="#requests2" class="btn btn-large btn-info" data-toggle="tab">Clean Request</a>
          <a href="#contact2" class="btn btn-large btn-info" data-toggle="tab">Order Request</a>
        </div>

        <div class="tab-content">
          <div class="tab-pane active" id="prices2">
            <br>

            <p class="lead">Customer Care Tickets</p>
            <div class="list-group">
              <a href="TicketsIndividual.jsp" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Eric Smith</h5>
                  <small>3 days ago</small>
                </div>
                <p class="mb-1">Contacted The General Manager about receiving a refund for a messy room</p>
                <small>In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">John Bon</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">Had concerns about credit card being canceled, wanted to be contacted to insure no
                  double charge occured</p>
                <small class="text-muted">In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Samantha White</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">Found a mouse in the room and wanted a full refund.</p>
                <small class="text-muted">Closed</small>
              </a>
            </div>
          </div>
          <div class="tab-pane" id="features2">
            <br>
            <p class="lead">Food Orders</p>
            <div class="list-group">
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Room 510</h5>
                  <small>3 days ago</small>
                </div>
                <p class="mb-1">Hamburger with fries</p>
                <small>In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Room 33</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">Ceaser Salad</p>
                <small class="text-muted">In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Room 123</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">Lobster Grilled Cheese with tomatoe soup.</p>
                <small class="text-muted">Closed</small>
              </a>
            </div>
          </div>
          <div class="tab-pane" id="requests2">
            <br>
            <p class="lead">Clean Request</p>
            <div class="list-group">
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start ">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Floor 5</h5>
                  <small>Today</small>
                </div>
                <p class="mb-1">Daily Cleaning</p>
                <small>In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start ">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Floor 4</h5>
                  <small>Today</small>
                </div>
                <p class="mb-1">Daily Cleaning</p>
                <small>In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Room 103</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">Beer Spilt On Floor</p>
                <small class="text-muted">In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Room 123</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">Out Of Toilet Paper</p>
                <small class="text-muted">Closed</small>
              </a>
            </div>
          </div>
          <div class="tab-pane" id="contact2">
            <br>
            <p class="lead">Orders</p>
            <div class="list-group">
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start ">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Maintenance</h5>
                  <small>3 days ago</small>
                </div>
                <p class="mb-1">100 Light Bulbs</p>
                <small>In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Cleaning Service</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">100 Toilet Paper Rolls</p>
                <small class="text-muted">In Progress...</small>
              </a>
              <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                  <h5 class="mb-1">Front Desk</h5>
                  <small class="text-muted">3 days ago</small>
                </div>
                <p class="mb-1">New pens</p>
                <small class="text-muted">Closed</small>
              </a>
            </div>
          </div>
        </div>
        <br>

        <br> <br>
        <p>Any concerns about tickets should be brought up with your supervisor. To access and create a new ticket
          please access your account section and create a ticket. This is a list of all the tickets </p>

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