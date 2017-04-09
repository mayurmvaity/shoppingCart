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
	<p class="forlegends">Confirm Purchase</p>
	
	<div class="panel panel-default">
			<!-- <div class="panel-heading">
				<h3 class="panel-title">Delivery address</h3>
			</div> -->
			 
			
			<div class="panel-body">
				<div class="col-md-4">
				<p class="forusername">${orderData.user.fname} ${orderData.user.lname}</p><p class="foruserpno">Phone: ${orderData.user.pno}</p>
				</div>
				<div class="col-md-4">
				
				<p class="pnobold">Billing Address</p>
				<p>${orderData.user.add1}</p>
				<p>${orderData.user.add2}</p>
				<p>${orderData.user.add3}</p>
				<p>${orderData.user.city}</p>
				<p>${orderData.user.state}</p>
				<p>${orderData.user.pincode}</p>
				</div>
				
				<div class="col-md-4">
				
				<p class="pnobold">Shipping Address</p>
				<p>${orderData.shippingAddress.add1}</p>
				<p>${orderData.shippingAddress.add2}</p>
				<p>${orderData.shippingAddress.add3}</p>
				<p>${orderData.shippingAddress.city}</p>
				<p>${orderData.shippingAddress.state}</p>
				<p>${orderData.shippingAddress.pincode}</p>
				
				</div>
				
				<!-- <div class="col-md-3">
					<button class="btn btn-lg btn-primary pull-right">Change address</button>
				</div> -->
			</div>
		</div>
		<div class="panel panel-default">
			<!-- <div class="panel-heading">
			    <h3 class="panel-title">
			    	Order summary
			    </h3>
			</div> -->
			  <table class="table">
				            <thead>
				              <tr>
				                
				                <th class="col-md-2 col-xs-2"></th>
				                <th class="col-md-6 col-xs-6"></th>
				                <th class="col-md-1 col-xs-1">Price</th>
				                <th class="col-md-1 col-xs-1">Quantity</th>
				                <th class="col-md-1 col-xs-1">Delivery charges</th>
				                <th class="col-md-1 col-xs-1">Subtotal</th>
				              </tr>
				              
				            </thead>
            <tbody>
            <c:forEach items="${orderData.cartitems}" var="cartitem">
              <tr>
                <th scope="row"><img src="${cartitem.product.pimage}" width="200px"></th>
                <td><p class="productname">${cartitem.product.category.name} ${cartitem.product.pname} ${cartitem.product.pcolor}</p><p class="productdesc">${cartitem.product.pdesc}</p></td>
                <td class="productprice"><span class="rupeesymbol">&#8377;</span>${cartitem.iprice}</td>
                <td>${cartitem.iquantity}</td>
                <td>Free</td>
                <td class="productprice"><span class="rupeesymbol">&#8377;</span>${cartitem.itotal}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          

		</div>
		<div class="panel panel-default">
						<div class="panel-body">
							<p class="pull-right subtotaltext">Subtotal (${orderData.cart.items} items): <span class="cartsubtotal"><span class="rupeesymbol">&#8377;</span>${orderData.cart.totalcost}</span></p>
						</div>
			</div>
			<div class="well text-right">
				<form:form modelAttribute="orderData">
						<input type="submit" name="_eventId_payment"
							value="Proceed to Pay" class="btn-lg btn-warning">
					</form:form>
			</div>




</div>
<script src="${js}/tableIndex.js"></script>
	<script src="${js}/tableJquery.min.js"></script>
		<!-- Javascrip file for active menu -->
	<script src="${js}/myapp.js"></script>
	
</body>
</html>
