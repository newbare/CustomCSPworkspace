<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:52 PM
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employees List</title>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
    <style type="text/css">
        .myrow-container {
            margin: 20px;
        }
    </style>
    <script type="text/javascript">
    function myFunction(name) {
        //alert('<b>'+name+'</b>');
    	var r= confirm("Are You sure You want to Delete Name ? "+name);
    	if(r==true)
        	return true;
        	else
            return false;
    }

    </script>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                <div align="left"><b>Employees List</b> </div>
                <div align="enter"><a href="<c:url value="/logout" />">Logout</a></div>
                <div align="right"><a href="createEmployee">Add New Employee</a></div>
            </h3>
        </div>
        <div class="panel-body">
                <form action="searchEmployee">
					<div class="form-group">
  						<label for="searchName">Search Employees:</label>
  						<input type="text" class="form-control" style="width: 200px;" name='searchName' id='searchName' placeholder="Search by Name or Email">
					</div>
					<div class="form-group">
 				 	 	<input class="btn btn-success" type='submit' value='Search'/>
					</div>
            	</form> 
            <c:if test="${empty employeeList}">
             <div class="panel-heading">
                 <b>There are no Employees</b>
            </div>
            </c:if>
            <c:if test="${not empty employeeList}">   
            
            	        	
            	            	
                <table class="table table-hover table-bordered">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <!-- <th>Id</th> -->
                        <th>Name</th>
                        <th>Email</th>
                        <th>Age</th>
                        <th>Salary</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employeeList}" var="emp">
                    <fmt:formatNumber var="fsalary"  type="number" pattern="##,###.00" value="${emp.salary}" maxFractionDigits="2"/>
                        <tr>
                        	<%-- <th><c:out value="${emp.id}"/></th> --%>
                        	<th><c:out value="${emp.name}"/></th>
                        	<th><c:out value="${emp.email}"/></th>
                        	<th><c:out value="${emp.age}"/></th>
                        	<th><c:out value="${fsalary}"/></th> 
                        	<th><a href="editEmployee?id=<c:out value='${emp.id}'/>" style="width: 70px;" class="btn btn-primary">Edit</a></th>
                        	<th><a href="deleteEmployee?id=<c:out value='${emp.id}'/>" onclick="return myFunction('${emp.name}')" class="btn btn-danger">Delete</a></th>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
    </div>
   <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>    
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
    
    <script src="<c:url value="/resources/js/jquery-2.2.0.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    

</body>
</html>