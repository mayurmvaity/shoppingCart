<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example">
    		<span class="icon-bar"></span>
    		<span class="icon-bar"></span>
    		<span class="icon-bar"></span>
    	</button>
 	
    		<c:if test="${pageContext.request.userPrincipal.name == null }">
    			<a class="navbar-brand" href="${contextRoot}/home">NEXT173</a>
    		</c:if> 

			 

    		<c:if test="${pageContext.request.userPrincipal.name != null }">
    			<security:authorize access="hasRole('ROLE_USER')">
    				<a class="navbar-brand" href="${contextRoot}/home">NEXT173</a>
    			</security:authorize>
    		
    		
				<security:authorize access="hasRole('ROLE_ADMIN')">
    				<a class="navbar-brand" href="${contextRoot}/admin/show/all/adminsProducts">NEXT173</a>
    			</security:authorize>
    		</c:if> 
    
    		
    </div>
    <div class="collapse navbar-collapse" id="example">
    <ul class="nav navbar-nav">
    
		 
	  	<c:if test="${pageContext.request.userPrincipal.name == null }">
	  	 <li id="Home"><a href="${contextRoot}/home">Home</a></li>
	  	
  
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Brands<span class="caret"></span></a>
        <ul class="dropdown-menu">
         
         <c:forEach items="${categories}" var="category">
         	 <li><a href="${contextRoot}/show/category/${category.id}/products">${category.name}</a></li>
		 </c:forEach>
		
        </ul>
      </li>
      <li id="productList"><a href="${contextRoot}/show/all/products">All Products</a></li>
      </c:if>
      
      
      
      
      
      
      				
					<c:if test="${pageContext.request.userPrincipal.name != null }">
					 		<security:authorize access="hasRole('ROLE_ADMIN')">
			
      				  <li id="Home"><a href="${contextRoot}/admin/show/all/adminsProducts">Home</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Products<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/admin/addProduct">Add product</a></li>
								<li><a href="${contextRoot}/admin/show/all/adminsProducts">View products</a></li>
								
							</ul></li>
							<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Brands<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/admin/addCategory">Add brand</a></li>
									<li><a href="${contextRoot}/admin/viewCategories">View brands</a></li>
								
							</ul></li>
							<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">Suppliers<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/admin/addSupplier">Add supplier</a></li>
									<li><a href="${contextRoot}/admin/viewSuppliers">View suppliers</a></li>
								
							</ul></li>
							
							
							</security:authorize>
							
							<security:authorize access="hasRole('ROLE_USER')">
							  	 <li id="Home"><a href="${contextRoot}/home">Home</a></li>
							  	
						  
						       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Brands<span class="caret"></span></a>
						        <ul class="dropdown-menu">
						         
						         <c:forEach items="${categories}" var="category">
						         	 <li><a href="${contextRoot}/show/category/${category.id}/products">${category.name}</a></li>
								 </c:forEach>
								
						        </ul>
						      </li>
						      <li id="productList"><a href="${contextRoot}/show/all/products">All Products</a></li>
						      
						      </security:authorize>
							
							
							</c:if>
					
      
      
     
    </ul>

			<ul class="nav navbar-nav navbar-right">
				
				<li id="aboutUs"><a href="${contextRoot}/aboutUs"> About Us</a></li>
				<li id="contactUs"><a href="${contextRoot}/contactUs"> Contact Us</a></li>
			
				 	
				 	<c:if test="${pageContext.request.userPrincipal.name == null }">
						<li id="signup"><a href="${contextRoot}/register">Sign Up</a></li>
						<li id="login"><a href="${contextRoot}/login">Log In <span
								class="glyphicon glyphicon-log-in"></span></a></li>
					</c:if>
					
					
					
					<c:if test="${pageContext.request.userPrincipal.name != null }">
					 		<security:authorize access="hasRole('ROLE_USER')">

						
						<li id="myCart"><a href="${contextRoot}/user/myCart"><span
								class="glyphicon glyphicon-shopping-cart"></span> Cart <span
								class="badge">${cartid.items}</span></a></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${username}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/user/myAccount">Account</a></li>
								<li><a href="${contextRoot}/user/changePW">Change password</a></li>
								<li><a href="${contextRoot}/user/manageAddress">Addresses</a></li>
								<%-- <li><a href="${contextRoot}/user/wishList">Wish list</a></li> --%>
								<li><a href="${contextRoot}/user/orderDetails">Orders</a></li>
								<li><a href="${contextRoot}/logout">Log Out</a></li>
							</ul></li>
							
							</security:authorize>
						</c:if>
						
						
							<c:if test="${pageContext.request.userPrincipal.name != null }">
					 		<security:authorize access="hasRole('ROLE_ADMIN')">
									<li class="dropdown"><a class="dropdown-toggle"
									data-toggle="dropdown" href="#">${adminName}<span
										class="caret"></span></a>
										<ul class="dropdown-menu">
											<%-- <li><a href="${contextRoot}/admin/addProduct">Add product</a></li>
											<li><a href="${contextRoot}/admin/addCategory">Add brand</a></li>
											<li><a href="${contextRoot}/admin/addSupplier">Add supplier</a></li> --%>
											<li><a href="<c:url value="/logout"/>" />Log Out</a></li> 
										</ul>
									</li>
							</security:authorize>
							</c:if>
							
			</ul>



	<%-- <c:if test="${pageContext.request.userPrincipal.name == null }">
				
			<form class="navbar-form navbar-left">
      <div class="input-group">
      <input type="text" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Search</button>
      </span>
    </div>
    </form>
    
    </c:if>

	<c:if test="${pageContext.request.userPrincipal.name != null }">
				<security:authorize access="hasRole('ROLE_USER')">
			<form class="navbar-form navbar-left">
      <div class="input-group">
      <input type="text" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Search</button>
      </span>
    </div>
    </form>
    </security:authorize>
    </c:if> --%>
    
    
    </div>
  </div>
</nav>

