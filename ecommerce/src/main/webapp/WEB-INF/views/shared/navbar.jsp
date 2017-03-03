<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example">
    		<span class="icon-bar"></span>
    		<span class="icon-bar"></span>
    		<span class="icon-bar"></span>
    	</button>
 	<c:if test="${empty adminMessage}">   	
      <a class="navbar-brand" href="${contextRoot}/home">NEXT173</a>
    </c:if>
    
    <c:if test="${not empty adminMessage}">   	
      <a class="navbar-brand" href="${contextRoot}/adminsHome">NEXT173</a>
    </c:if>
    
    </div>
    <div class="collapse navbar-collapse" id="example">
    <ul class="nav navbar-nav">
    
  <c:if test="${empty adminMessage}">  
      <li id="Home"><a href="${contextRoot}/home">Home</a></li>
  </c:if>
 
  <c:if test="${not empty adminMessage}">  
      <li id="Home"><a href="${contextRoot}/adminsHome">Home</a></li>
  </c:if> 
  
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Brands<span class="caret"></span></a>
        <ul class="dropdown-menu">
         
         <c:forEach items="${categories}" var="category">
         	 <li><a href="#">${category.name}</a></li>
         
         </c:forEach>
         
         
        </ul>
      </li>
      <c:if test="${empty adminMessage}">
     <li id="productList"><a href="${contextRoot}/show/all/products">All Products</a></li>
     </c:if>
     
     <c:if test="${not empty adminMessage}">
     <li id="adminsProducts"><a href="${contextRoot}/adminsProducts">All Products</a></li>
     </c:if>
    </ul>

			<ul class="nav navbar-nav navbar-right">

				<li id="aboutUs"><a href="${contextRoot}/aboutUs"> About Us</a>
				<li id="contactUs"><a href="${contextRoot}/contactUs"> Contact Us</a>
				 <c:if test="${empty loginMessage && empty adminMessage}">
						<li id="signup"><a href="${contextRoot}/register">Sign Up</a></li>
						<li id="login"><a href="${contextRoot}/login">Log In <span
								class="glyphicon glyphicon-log-in"></span></a></li>

					</c:if> 
					<c:if test="${not empty loginMessage}">
						<li id="myCart"><a href="${contextRoot}/myCart"><span
								class="glyphicon glyphicon-shopping-cart"></span> My Cart <span
								class="badge">14</span></a></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${username}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/myAccount">Account</a></li>
								<li><a href="${contextRoot}/changePW">Change password</a></li>
								<li><a href="${contextRoot}/manageAddress">Addresses</a></li>
								<li><a href="${contextRoot}/wishList">Wish list</a></li>
								<li><a href="${contextRoot}/orderDetails">Orders</a></li>
								<li><a href="${contextRoot}/logout">Log Out</a></li>
							</ul></li>

					</c:if>
					 <c:if test="${not empty adminMessage}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${adminName}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="${contextRoot}/addProduct">Add product</a></li>
								<li><a href="${contextRoot}/addCategory">Add brand</a></li>
								<li><a href="${contextRoot}/addSupplier">Add supplier</a></li>
								<li><a href="${contextRoot}/logout">Log Out</a></li>
							</ul></li>
					</c:if>
			</ul>




			<form class="navbar-form navbar-left">
      <div class="input-group">
      <input type="text" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="button">Search <span class="glyphicon glyphicon-search"></span></button>
      </span>
    </div>
    </form>
    </div>
  </div>
</nav>