<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
    	<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example">
    		<span class="icon-bar"></span>
    		<span class="icon-bar"></span>
    		<span class="icon-bar"></span>
    	</button>
 	<c:if test="${empty adminMessage}">   	
      <a class="navbar-brand" href="home">NEXT173</a>
    </c:if>
    
    <c:if test="${not empty adminMessage}">   	
      <a class="navbar-brand" href="adminsHome">NEXT173</a>
    </c:if>
    
    </div>
    <div class="collapse navbar-collapse" id="example">
    <ul class="nav navbar-nav">
    
  <c:if test="${empty adminMessage}">  
      <li id="Home"><a href="home">Home</a></li>
  </c:if>
 
  <c:if test="${not empty adminMessage}">  
      <li id="Home"><a href="adminsHome">Home</a></li>
  </c:if> 
  
       <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Brands<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Samsung</a></li>
          <li><a href="#">HTC</a></li>
          <li><a href="#">Motorola</a></li>
          <li><a href="#">OnePlus</a></li>
          <li><a href="#">Vivo</a></li>
        </ul>
      </li>
      <c:if test="${empty adminMessage}">
     <li id="productList"><a href="productList">All Products</a></li>
     </c:if>
     
     <c:if test="${not empty adminMessage}">
     <li id="adminsProducts"><a href="adminsProducts">All Products</a></li>
     </c:if>
    </ul>

			<ul class="nav navbar-nav navbar-right">

				<li id="aboutUs"><a href="aboutUs"> About Us</a>
				<li id="contactUs"><a href="contactUs"> Contact Us</a>
				 <c:if test="${empty loginMessage && empty adminMessage}">
						<li id="signup"><a href="register">Sign Up<span
								class="glyphicon glyphicon-unchecked"></span></a></li>
						<li id="login"><a href="login">Log In <span
								class="glyphicon glyphicon-log-in"></span></a></li>

					</c:if> 
					<c:if test="${not empty loginMessage}">
						<li id="myCart"><a href="myCart"><span
								class="glyphicon glyphicon-shopping-cart"></span> My Cart <span
								class="badge">14</span></a></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${username}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="myAccount">Account</a></li>
								<li><a href="changePW">Change password</a></li>
								<li><a href="manageAddress">Addresses</a></li>
								<li><a href="wishList">Wish list</a></li>
								<li><a href="orderDetails">Orders</a></li>
								<li><a href="logout">Log Out</a></li>
							</ul></li>

					</c:if>
					 <c:if test="${not empty adminMessage}">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${adminName}<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="addProduct">Add product</a></li>
								<li><a href="addCategory">Add brand</a></li>
								<li><a href="addSupplier">Add supplier</a></li>
								<li><a href="logout">Log Out</a></li>
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