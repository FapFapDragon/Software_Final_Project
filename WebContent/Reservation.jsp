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

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
  <script
    src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <!--Navigation bar-->

  <link rel="stylesheet" type="text/css" href="WebStyle.css">

  <div id="nav-holder"></div>
  <script>
    $(function () { $("#nav-holder").load("nav.jsp"); });
  </script>
</head>


<script>
  $(function () {
    $('#datetimepicker1').datetimepicker();
  });
  $(function () {
    $('#datetimepicker2').datetimepicker();
  });
</script>

<body>

  <div class="hero-image-small">
      <img src="img/logo.png" class="marginauto">
  </div>


  <div class="container">
    <h1 style="font-family: Arial;">
      Select Check In Information
    </h1>
    <div class="panel panel-primary">
      <div class="panel-body">
        <div class="row">
          <div class='col-md-6'>
            <div class="form-group">
              <label class="control-label" style="font-family: Arial;">Arrival Date</label>
              <div class='input-group date' id='datetimepicker1'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                  <span class="glyphicon glyphicon-calendar"></span>
                </span>
              </div>
            </div>
          </div>
          <div class='col-md-6'>
            <div class="form-group">
              <label class="control-label" style="font-family: Arial;">Checkout Date</label>
              <div class='input-group date' id='datetimepicker2'>
                <input type='text' class="form-control" />
                <span class="input-group-addon">
                  <span class="glyphicon glyphicon-calendar"></span>
                </span>
              </div>
            </div>
          </div>
        </div>
        <form action="DisplayRooms.jsp" method="get">
        <input type="submit" class="btn btn-primary" value="Submit">
      </form>
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