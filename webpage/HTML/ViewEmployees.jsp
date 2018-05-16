<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
 crossorigin="anonymous">
<link rel="stylesheet" href="../CSS/FinancialManager.CSS">
<title>Manage employees</title>
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
            	<li class="active">
            		<a href="./ViewEmployees.jsp">Employees <span class="glyphicons glyphicons-family"></span></a>
            	</li>
            	<li>
            		<a href="./ManagerReimbursement.jsp">Reimbursement <span class="glyphicon glyphicon-usd"></span></a>
            	</li>
            	<li>
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
	<div class="container" style="background-color: white">
	<div class="page-header">
            <h3>Employees</h3>
        </div>
        <table class="table table-responsive">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Telephone</th>
                    <th>Address</th>
                    
                </tr>
            </thead>
            <tbody id="employee">

            </tbody>
        </table>
	</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../JS/ViewAll.js"></script>
	
</body>
</html>