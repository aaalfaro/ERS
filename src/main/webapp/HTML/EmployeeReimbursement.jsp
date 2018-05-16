<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Reimbursements</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
        crossorigin="anonymous">
<link rel="stylesheet" href="../CSS/Employee.CSS">
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
                    <a href="./GenericEmployeeHomePage.jsp">Home</a>
                </li>
                <li class ="active">
                    <a href="./EmployeeReimbursement.jsp">Reimbursement
                        <span class="glyphicon glyphicon-usd"></span>
                    </a>
                </li>
                <li>
                    <a href="./EmployeeInformation.jsp">Myself
                        <span class="glyphicon glyphicon-user"></span>
                    </a>
                </li>
                <li>
                    <a href="logout.do">Log off
                        <span class="glyphicon glyphicon-log-out"></span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="container" style="background-color: white">
        <div class="page-header">
            <h3>Your Reimbursement History</h3>
        </div>
        <table class="table table-responsive">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Amount</th>
                    <th>Category</th>
                    <th>Status</th>
                    <th>Date recieved</th>
                    <th>Date resolved</th>
                </tr>
            </thead>
            <tbody id="reimbursement">

            </tbody>
        </table>
        <button type="button" class="btn btn-info" data-toggle="collapse" data-target="#new">Create new reimbursement</button>
        <div id="new" class="collapse">
            <div class="col-md-2">
            <form action="new.do" method ="POST" >
                <div class="form-group">
                    <label for="amount">
                        <h3>Amount</h3>
                    </label>
                    <input required class="form-control" type="text" name="amount">
                    <label for="category">Cateogory</label>
                    <select class="form-control" name="category">
                        <option>Other</option>
                        <option>Travel</option>
                        <option>Food</option>
                        <option>Lodging</option>
                    </select>
                    <br>
                    <input type="file" name="pic" accept="image/*">
                    <br>
                    <input type="submit" value="submit">
                </div>
            </form>
            </div>
        </div>
        <br><br>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="../JS/EmployeeReimbursement.js"></script>
</body>
</html>