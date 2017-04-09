<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<spring:url var="jq" value="/resources/jq" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Shopping - ${title}</title>
	<script>
		window.menu = '${title}';
	
	</script>
	
	
	<!-- CSS files -->
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
	
	
	
	
	<link rel="stylesheet" href="${css}/tableStyle.css" type="text/css">
	<link rel="stylesheet" href="${css}/myapp.css" type="text/css">
	<link rel="stylesheet" href="${css}/mytheme.css" type="text/css">
	<link rel="stylesheet" href="${css}/thestyle.css" type="text/css">
	
	<style>
		
	</style>
	
</head>
<body>

<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Select a payment mode</h3>
					</div>
					<div class="panel-body">
						
						<form:form class="form" modelAttribute="orderData">
						
							<div class="form-group">	
							<form:radiobutton path="paymentMode" value="ONLINE"/>Pay Online<br>
							<form:radiobutton path="paymentMode" value="COD"/>Cash on Delivery
						 	</div>
						 	
						 	
						 <div class="well text-center">
							<input type="submit" name = "_eventId_paymentMode" class="btn btn-primary" value="Proceed">						</div>
						</form:form>

						
					</div>
				</div>
			</div>
		</div>
		
		<script src="${js}/tableIndex.js"></script>
	<script src="${js}/tableJquery.min.js"></script>
		<!-- Javascrip file for active menu -->
	<script src="${js}/myapp.js"></script>
		
</body>
</html>