<div class="container">
	    	<div class="col-md-3">
	        
			        <div class="panel panel-default">
			          <div class="panel-heading">
			            <h3 class="panel-title">My Account</h3>
			          </div>
			          <div class="panel-body">
			          	<legend class="text-center"></legend>
			            <ul class="list-group">
			              <a href="${contextRoot}/user/myAccount" id="myAccount" class="list-group-item">Account details</a>
			              <a href="${contextRoot}/user/orderDetails" id="orderDetails" class="list-group-item">Orders</a>
			            <%--   <a href="${contextRoot}/user/wishList" id="wishList" class="list-group-item">Wish list</a> --%>
			              
			            </ul> 
			            <legend class="text-center"></legend>
			            <ul class="list-group">
			              <a href="${contextRoot}/user/personalInfo" id="personalInfo" class="list-group-item">Personal information</a>
			              <a href="${contextRoot}/user/changePW" id="changePW" class="list-group-item">Change password</a>
			              <a href="${contextRoot}/user/billingAddress" id="billingAddress" class="list-group-item">billing address</a>
			              <a href="${contextRoot}/user/manageAddress" id="manageAddress" class="list-group-item">Manage addresses</a>
			              <a href="${contextRoot}/user/changeMobNo" id="changeMobNo" class="list-group-item">Update mobile number</a>
			              
			            </ul> 
			          </div>
			        </div>
			
            
			</div>
			<div class="col-md-9">
				
					<c:if test="${isUserClickChangeMobNo==true}">
						<%@include file="changeMobNo.jsp" %> 
					</c:if>  
					
					<c:if test="${isUserClickMyAccount==true}">
						<%@include file="myAccount.jsp" %>
					</c:if>  
					
					<c:if test="${isUserClickPersonalInfo==true}">
						<%@include file="personalInfo.jsp" %>
					</c:if>  
					
					<c:if test="${isUserClickBillingAddress==true}">
						<%@include file="billingAddress.jsp" %>
					</c:if>
					
					<c:if test="${isUserClickManageAddress==true || isUserClickedUpdateAddress == true}">
						<%@include file="manageAddress.jsp" %>
					</c:if>  					

					<c:if test="${isUserClickChangePW==true}">
						<%@include file="changePW.jsp" %>
						
					</c:if>  
		<!-- ============================== orders pages=========================== -->			
					<c:if test="${isUserClickOrderDetails==true}">
						<%@include file="orderDetails.jsp" %>
					</c:if>
					
					<c:if test="${isUserClickWishList==true}">
						<%@include file="wishList.jsp" %>
					</c:if>
		<!-- ============================== end of orders pages=========================== -->	
	</div>
	
	</div>		
