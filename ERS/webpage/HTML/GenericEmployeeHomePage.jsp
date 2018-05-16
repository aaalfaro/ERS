<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Employee Home page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
    <link rel="stylesheet" href="../CSS/Employee.CSS">
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-inverse">
            <div class="navbar-header">
                <h3 style="color: white;"><strong>GENERIC</strong></h3>
            </div>
            <ul class="navbar-nav nav">
                <li class="active">
                    <a href="./GenericEmployeeHomePage.jsp">Home</a>
                </li>
                <li>
                    <a href="./EmployeeReimbursement.jsp">Reimbursement <span class="glyphicon glyphicon-usd"></span></a>
                </li>
                <li>
                    <a href="./EmployeeInformation.jsp">Myself <span class="glyphicon glyphicon-user"></span></a>
                </li>
                <li>
            		<a href ="logout.do">Log off <span class="glyphicon glyphicon-log-out"></span></a>
            	</li>
            </ul>
        </nav>
    </div>
    <div class="container">
        <div class="jumbotron">
            <%@ page import="com.revature.model.Employee" %>
            <%Employee user = (Employee) request.getSession().getAttribute("Employee"); %>
            <h1>Welcome, <%= user.getFname()+" "+user.getLname() %></h1>
        </div>
    </div>
     <div class="container">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="../CSS/JokeNotFunnyButImGonnaLaughSoIDontGetFired.jpg" alt="Sorry" style="width:100%;">
                    <div class="carousel-caption" style="background-color: black">
                        <h2>What we do</h2>
                        <p>GENERIC is the at the forefront of...uh...what do we do again?</p>
                    </div>
                </div>

                <div class="item">
                    <img src="../CSS/smile_for_the_camera.jpg" alt="Yikes" style="width:100%;">
                    <div class="carousel-caption" style="background-color: black">
                        <h2>Our Mission</h2>
                        <p>Here at Generic, we strive to create...stuff</p>
                    </div>
                </div>

                <div class="item">
                    <img src="../CSS/businessPeople.jpg" alt="Whoops" style="width:100%;">
                    <div class="carousel-caption" style="background-color: black">
                        <h2>Our Commitment</h2>
                        <p>We continually strive to deliver the best customer experience....EVER</p>
                    </div>
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    
</body>
</html>