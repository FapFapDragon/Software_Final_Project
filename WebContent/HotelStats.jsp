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
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
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
      <br>
      <br>
      <br>
      </div>
      <div class="row">
        <div class="col-md-4">
          <h2>Guest Age Today</h2>
          <div id="piechart"></div>
        </div>
        <div class="col-md-3">
        </div>
        <div class="col-md-4">
          <h2>Guests Age All Time</h2>

          <div id="piechart2"></div>
        </div>

      </div>
      <div class="row" style="padding: 10px;"> </div>
      <div class="row">
        <div class="col-md-6">
          <h2>Sales This Month</h2>

          <div id="barchart_values" style="width: 900px; height: 300px;"></div>

        </div>
        <div class="col-md-6">
          <h2>This weeks Shifts</h2>

          <img src="img/cal.png" alt="test" class="img-fluid">
        </div>
      </div>
  
  
    </div>


  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  
  <script type="text/javascript">
  // Load google charts
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);
  
  // Draw the chart and set the chart values
  function drawChart() {
    var data = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['20-30', 2],
    ['30-30', 5],
    ['40-30', 4],
    ['50-30', 7],
    ['60+', 6]
  ]);
  var data2 = google.visualization.arrayToDataTable([
    ['Task', 'Hours per Day'],
    ['20-30', 1234],
    ['30-30', 3434],
    ['40-30', 12233],
    ['50-30', 23233],
    ['60+', 23133]
  ]);

    // Optional; add a title and set the width and height of the chart
    var options = {'title':'Age Today', 'width':550, 'height':400};
  
    // Display the chart inside the <div> element with id="piechart"
    var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    var chart2 = new google.visualization.PieChart(document.getElementById('piechart2'));

    chart.draw(data, options);
    chart2.draw(data2, options);

  }
  </script>

<script type="text/javascript">
  google.charts.load("current", {packages:["corechart"]});
  google.charts.setOnLoadCallback(drawChart);
  function drawChart() {
    var data = google.visualization.arrayToDataTable([
      ["Element", "Density", { role: "style" } ],
      ["Refunds This Month", 5400, "darkred"],
      ["Savings From Canada Day Special Offer", 5000, "darkgreen"],
      ["Resteraunt Sales", 23000, "gold"],
      ["Banquete Hall Sales", 32000, "black"],
      ["Room Sales", 134000, "blue"]
    ]);

    var view = new google.visualization.DataView(data);
    view.setColumns([0, 1,
                     { calc: "stringify",
                       sourceColumn: 1,
                       type: "string",
                       role: "annotation" },
                     2]);

    var options = {
      title: "Sales and refunds this month",
      width: 600,
      height: 400,
      bar: {groupWidth: "95%"},
      legend: { position: "none" },
    };
    var chart = new google.visualization.BarChart(document.getElementById("barchart_values"));
    chart.draw(view, options);
}
</script>




  <!--Navigation bar-->
  <div id="footer-holder"></div>
  <script>
    $(function () { $("#footer-holder").load("footer.jsp"); });
  </script>
</body>
</html>