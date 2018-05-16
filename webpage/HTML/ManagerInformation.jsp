<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Information</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
 crossorigin="anonymous">
<link rel="stylesheet" href="../CSS/FinancialManager.CSS">
</head>
<body>
	<div class="container">
    	<nav class="navbar navbar-inverse">
        	<div class="navbar-header">
             	<h3 style="color: white;">
                	<strong>GENERIC</strong>
                </h3>
            </div>
        	<ul class="navbar-nav nav">
        		<li>
            		<a href="./FinancialManagerHome.jsp">Home</a>
            	</li>
            	<li>
            		<a href="./ViewEmployees.jsp">Employees <span class="glyphicons glyphicons-family"></span></a>
            	</li>
            	<li>
            		<a href="./ManagerReimbursement.jsp">Reimbursement <span class="glyphicon glyphicon-usd"></span></a>
            	</li>
            	<li class="active">
            		<a href="./ManagerInformation.jsp">Myself <span class="glyphicon glyphicon-user"></span></a>
            	</li>
            	<li>
            		<a href ="logout.do">Log off <span class="glyphicon glyphicon-log-out"></span></a>
            	</li>
        	</ul>
       </nav>
       <%@ page import="com.revature.model.Employee" %>
       <%Employee user = (Employee) request.getSession().getAttribute("Employee"); %>
    </div>
    <div class="container" style="background-color: White">
        <div class="col-md-5" id ="pageContainer">
            <div class="container" id="personal">
                <strong>Note: You are responsible for keeping your personal data up to date</strong>
                <h3>First Name: <%=user.getFname() %> </h3>
       	        <h3>Last Name: <%=user.getLname() %> </h3>
                <h3>Phone Number: <%=user.getPhone() %> </h3>
                <h3>Address: <%=user.getAddress() %> </h3>
        	</div>
        	<button type="button" class="btn btn-info" data-toggle="collapse" data-target="#update">Update Information</button>
    		<br><br>
    	
    	<div id="update" class="collapse">
    		<div class="col-md-6">
    		<form method="POST" action="update.do">
    			<div class="form-group">
    			<label for="First name">
                        <strong>First name</strong>
                    </label>
                    <input class="form-control" type="text" name="firstname">
                    <label for="Last name">
                        <strong>Last name</strong>
                    </label>
                    <input class="form-control" type="text" name="lastname">
                    <label for="telephone">
                        <strong>Phone number</strong>
                    </label>
                    <input class="form-control" type="text" name="telephone">
                    <label for="Address">
                        <strong>Address</strong>
                    </label>
                    <input class="form-control" type="text" name="address">
                    <br>
                    <div class="form-group button-group">
                    	<button class="btn btn-primary" type ="submit">Submit</button>
                    </div>
    			</div>
    		</form>
    		</div>
    	</div>
    	</div>
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>