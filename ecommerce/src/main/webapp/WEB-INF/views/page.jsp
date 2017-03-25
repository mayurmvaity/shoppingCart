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

	<div class="wrapper">
	<!-- =================  NAVBAR  ================== -->
	<%@include file="./shared/navbar.jsp" %>
		${contextRoot} says - ${greeting}
		${CRUDmsgP}
		${CRUDmsgC}
		${CRUDmsgS}
		${RegMsg}
		${Role}	${Usermsg}
		
				
		
	<div class="content">
		<h2>
		<center>Shopping Cart</center>
	</h2>
	<center>${msg}</center>
	<center>${successMessage}</center>
	<center>${errorMessage}</center>
	${loginMessage} ${adminMessage}
	<hr>
		
	<!-- =====================  MAIN  ======================== -->	
	<!-- Loaging Home content -->
	<c:if test="${userClickHome==true || isUserClickedLogout==true}">
		<%@include file="home.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickLoginPage==true}">
		<%@include file="./navbarStuff/login.jsp" %>
	</c:if>
	
	<%-- <c:if test="${not empty successMessageU }">
		<%@include file="home.jsp" %>
	</c:if>
	
	<c:if test="${ not empty successMessageA}">
		<%@include file="./adminsOpt/adminsProducts.jsp" %>
	</c:if> --%>
	
	<%-- <c:if test="${not empty successMessageA}">
		<%@include file="adminsOpt/adminsHome.jsp" %>
	</c:if> --%>
	
	<c:if test="${not empty errorMessage}">
		<%@include file="./navbarStuff/login.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickRegPage==true}">
		<%@include file="./navbarStuff/register.jsp" %>
	</c:if>
	
	<%-- <c:if test="${isUserClickProductList==true}">
		<%@include file="./navbarStuff/productList.jsp" %>
	</c:if> --%>
	
	
	<c:if test="${userClickCategoryProducts==true or userClickAllProducts==true}">
		<%@include file="./navbarStuff/productList.jsp" %>
	</c:if>
	
	<c:if test="${userClickCategoryAdminProducts==true or isUserClickAdminsProducts==true}">
		<%@include file="./adminsOpt/adminsProducts.jsp" %>
	</c:if>
	
	
	<c:if test="${isUserClickContactUs==true}">
		<%@include file="./navbarStuff/contactUs.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickAboutUs==true}">
		<%@include file="./navbarStuff/aboutUs.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickProductDetails==true}">
		<%@include file="./userStuff/productDetails.jsp" %>
	</c:if>
	<!--  for sidebar A ================== -->
	<c:if test="${isUserClickPersonalInfo==true || isUserClickChangeMobNo==true || isUserClickManageAddress==true ||isUserClickChangePW==true || isUserClickMyAccount==true || isUserClickOrderDetails==true || isUserClickWishList==true || isUserClickBillingAddress==true || isUserClickedUpdateAddress==true}">
		<%@include file="./userStuff/sidebarA.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickMyCart==true}">
		<%@include file="./orders/myCart.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickSelectAddress==true}">
		<%@include file="./orders/selectAddress.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickConfirmPurchase==true}">
		<%@include file="./orders/confirmPurchase.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickPaymentMode==true}">
		<%@include file="./orders/paymentMode.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickOrderDetailsButton==true}">
		<%@include file="./orders/orderDetailsButton.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickAddProduct==true || isUserClickAddCategory==true || isUserClickAddSupplier==true || isUserClickedUpdateCategory==true || isUserClickedUpdateSupplier==true || isUserClickedUpdateProduct==true }">
		<%@include file="./adminsOpt/sidebarB.jsp" %>
	</c:if>
	
	
	
	<%-- <c:if test="${isUserClickAdminsProducts==true}">
		<%@include file="./adminsOpt/adminsProducts.jsp" %>
	</c:if> --%>
	
	<c:if test="${isUserClickAdminsHome==true}">
		<%@include file="./adminsOpt/adminsHome.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickAdminsProDetails==true}">
		<%@include file="./adminsOpt/adminsProDetails.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickViewCategories == true }">
		<%@include file="./adminsOpt/viewCategories.jsp" %>
	</c:if>
	
	<c:if test="${isUserClickViewSuppliers==true}">
		<%@include file="./adminsOpt/viewSuppliers.jsp" %>
	</c:if>
	
	</div>
	<!-- =====================  FOOTER  ======================== -->	
	<%@include file="./shared/footer.jsp" %>
	
	
	
	<!-- ========================= JAVASCRIPT FILES==================== -->
	
	
	<script src="${js}/tableIndex.js"></script>
	<script src="${js}/tableJquery.min.js"></script>
		<!-- Javascrip file for active menu -->
	<script src="${js}/myapp.js"></script>
	
	</div>
	
</body>
</html>