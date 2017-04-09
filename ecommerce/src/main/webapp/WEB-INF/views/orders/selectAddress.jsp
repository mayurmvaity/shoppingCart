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


	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Select delivery address</h3>
		</div>
		<div class="panel-body">
			<div class="row">
			<form:form role="form" modelAttribute="orderData">
			<!-- <input type="hidden" class="choose" > -->
			<c:forEach items="${orderData.addresses}" var="address">
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
 
						<div class="caption">
							<p>${address.add1}</p>
							<p>${address.add2}</p>
							<p>${address.add3}</p>
							<p>${address.city}</p>
							<p>${address.state}</p>
							<p>${address.pincode}</p>
							<div class="checkbox">
								<label> 
								<%-- <a href="${contextRoot}/user/confirmPurchase/${address.addid}" class="btn btn-primary" role="button">Deliver here</a>
								 --%>
								 <%-- <form:input type="radio" path="addressid" value="${address.addid}" /> --%>
								 <form:radiobutton path="addressid" value="${address.addid}"/>
								<input type="submit" name="_eventId_selectAddress" class="btn btn-default" value="Deliver here">
								 
								 </label>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			</form:form>
			
				
				
			</div>
			<div class="panel-body">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Add new address</button>
												<div class="modal fade" id="modal-1">
							<div class="modal-dialog modal-md">
									<div class="modal-content">
											<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h3 class="modal-title">Add new address</h3>
											</div>
											<form:form method="post" action="${contextRoot}/user/addAddressNew" commandName="address">
											<div class="modal-body">
													
											<fieldset>
		                        				
		                        				
		                        				<form:hidden path="addid" class="form-control"
													placeholder="Enter Product Id" value="${address.addid}" />
		                        				
		                        				<form:hidden path="aid" class="form-control"
													placeholder="Enter Product Id" value="${userid}" />
		                        				
		                        				
											<div class="form-group col-md-12">
		                            			<form:label path="add1">Address line 1: <font color='red'><form:errors path="add1" /></font></form:label>
		                            			<form:input type="text" class="form-control" path="add1" value="${address.add1}" placeholder="Address line 1" />
		                          
		                        			</div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="add2">Address line 2: <font color='red'><form:errors path="add2" /></font></form:label>
					                            <form:input type="text" class="form-control" path="add2" value="${address.add2}" placeholder="Address line 2" />
					                            
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="add3">Address line 3: <font color='red'><form:errors path="add3" /></font></form:label>
					                            <form:input type="text" class="form-control" path="add3" value="${address.add3}" placeholder="Address line 3" />
					                           
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="city">City: <font color='red'><form:errors path="city" /></font></form:label>
					                            <form:input type="text" class="form-control" path="city" value="${address.city}" placeholder="City" />
					                          
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="state">State: <font color='red'><form:errors path="state" /></font></form:label>
					                            <form:input type="text" class="form-control" path="state" value="${address.state}" placeholder="State" />
					                            
					                        </div>
								
											<div class="form-group col-md-12">
					                            <form:label path="pincode">Pin code: <font color='red'><form:errors path="pincode" /></font></form:label>
					                            <form:input type="text" class="form-control" path="pincode" value="${address.pincode}" placeholder="Pin code" />
					                            
					                        </div>
		                        
		                        			</fieldset>
				                        <!-- <div class="form-group">
					                        <div class="col-md-12">
					                            <button type="submit" class="btn btn-primary">
					                                Add
					                            </button>
					                            
					                        </div>
				                    	</div> -->
		                    		
											</div>

											<div class="modal-footer">
													<a href="" class="btn btn-default" data-dismiss="modal">Close</a>
													<button type="submit" class="btn btn-primary">
					                                Add
					                            </button>
											</div>
									</form:form>
									</div>
							</div>	
					</div>

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
