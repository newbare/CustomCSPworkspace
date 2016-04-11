<%--
  User: Ranga Reddy
  Date: 1/27/2015
  Time: 9:48 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Information</title>
    <!-- Bootstrap CSS -->
   <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> 
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
	
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
	<%--  <script src="<c:url value="/resources/js/jquery-2.2.0.min.js"/>"></script>--%>
  <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<script type="text/javascript">
$(document).ready(function() {
	$("#name").focus();
	var id=$("#id").val();
	if(id>0){
		console.log("Edit called");
		$("#saveEmployee").val("Update");
	};
	if(id==0){
		$("#age").val("");
		$("#salary").val("");
	};
});
function clearForm()
{
	$("#name").val("");
	$("#email").val("");
	$("#age").val("");
	$("#salary").val("");
	//document.getElementById("employeeRegisterForm").reset();
	}
</script>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    <b>Employee Details</b>
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="employeeRegisterForm" cssClass="form-horizontal" modelAttribute="employee" method="post" action="saveEmployee">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="name" >Name</form:label> </div>
                        <div class="col-xs-4">
                          	<form:hidden path="id" value="${employeeObject.id}"/>
                            <form:input cssClass="form-control" path="name" maxlength="30"  value="${employeeObject.name}" placeholder="Enter Name"/>
                        </div>
                    </div>
                     <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="email" >Email</form:label> </div>
                        <div class="col-xs-4">
                            <form:input type="email" cssClass="form-control" path="email" maxlength="50" value="${employeeObject.email}" placeholder="Enter Email"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="age" cssClass="control-label col-xs-3">Age</form:label>
                        <div class="col-xs-4">
                            <form:input cssClass="form-control" path="age" maxlength="3" value="${employeeObject.age}" placeholder="Enter Age"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                     <fmt:formatNumber var="fsalary"  type="number" pattern="##,###.00" value="${employeeObject.salary}" maxFractionDigits="2"/>
                        <div class="control-label col-xs-3"><form:label path="salary">Salary</form:label></div>
                        <div class="col-xs-4">
                            <form:input cssClass="form-control" path="salary" maxlength="15" value="${fsalary}" placeholder="Enter Salary"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                             	<input type="button" id="back" style="width: 70px;" class="btn btn-warning"  value="Back" onclick="history.back()"/>
                                <input type="submit" id="saveEmployee" style="width: 70px;" class="btn btn-primary" value="Save" onclick="return submitEmployeeForm();"/>
                                <input type="button" id="button" style="width: 70px;" class="btn btn-danger" value="Reset" onclick="clearForm()"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>

	<script type="text/javascript">
		function submitEmployeeForm() {				
		    // getting the employee form values
		    var name = $('#name').val().trim();
		    var email = $('#email').val().trim();
		    var age = $('#age').val();
		    var salary = $('#salary').val();
		    var number = new RegExp('^[0-9.]+$');
		    var integer = new RegExp('^[0-9]+$');
		    var alphanumaric= new RegExp('^[A-Za-z_0-9-]+$');
		    var emailExp= new RegExp('^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$');
		    if(name.length==0) {
		        alert('Please enter name');
		        $('#name').focus();
		        return false;
		    }
		    if(!name.match(alphanumaric)) {
		        alert('Name should be only alphanumaric with underscore and hiphen');
		        $('#name').focus();
		        return false;
		    }
		    if(email.length ==0) {
		        alert('Please enter email');
		        $('#email').focus();
		        return false;
		    }
		    if(!email.match(emailExp)) {
		        alert('Please enter valid email ID');
		        $('#email').focus();
		        return false;
		    }
		    if(age.trim()=='') {
		        alert('Please enter age');
		        $('#age').focus();
		        return false;
		    }
		    if(age <= 0) {
		        alert('Age can not be negative');
		        $('#age').focus();
		        return false;
		    }
		    if(!age.match(integer)) {
		        alert('Please enter proper age');
		        $('#age').focus();
		        return false;
		    }
	
		    if(salary <= 0) {
		        alert('Please enter proper salary');
		        $('#salary').focus();
		        return false;
		    }
		   
		    if (!salary.match(number))
		    {
		        alert("Please enter salary in number only");
		        $('#salary').focus();
		        return false;
		    }
		    return true;
		};	
	</script>

</body>
</html>