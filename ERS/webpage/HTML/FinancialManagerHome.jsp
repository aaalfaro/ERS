<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Home</title>
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
                <li class="active">
                    <a href="./FinancialManagerHome.jsp">Home</a>
                </li>
                <li>
            		<a href="./ViewEmployees.jsp">Employees <span class="glyphicons glyphicons-family"></span></a>
            	</li>
                <li>
                    <a href="./ManagerReimbursement.jsp">Reimbursement<span class="glyphicon glyphicon-usd"></span></a>
                </li>
                <li>
                    <a href="./ManagerInformation.jsp">Myself<span class="glyphicon glyphicon-user"></span></a>
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
            <h1>Welcome <%=user.getFname()+" "+user.getLname() %></h1>
            <p>Financial Managers are reminded that they must approve or reject pending reimbursements within a week from their submission</p>
            <p>If there are any requests that are older than one week, resolving those requests take priority</p>
        </div>
        <table class="table table-responsive" style="background-color: snow">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Employee ID</th>
                    <th>Manager ID</th>
                    <th>Category</th>
                    <th>Amount (USD)</th>
                    <th>Date Recieved</th>
                    <th>Date Resolved</th>
                    <th>Status</th>
                    <th>image</th>
                    <th>Approve/Reject</th>
                    
                </tr>
            </thead>
            <tbody id="reimbursement">

            </tbody>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="../JS/Manager.js"></script>
</body>
</html>