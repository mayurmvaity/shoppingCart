	<div class="container">
		<!-- Filters added here -->
		<div class="col-md-12">
    		 <nav class="navbar navbar-default">
			  <div class="container-fluid">
			    
			    <ul class="nav navbar-nav">
			    	
			      <li><a href="#">Price low to high</a></li>
			      <li><a href="#">Price high to low</a></li>
			      <li><a href="#">Name</a></li>
			      <li><a href="#">Newest first</a></li>
			    </ul>
			    <form class="navbar-form navbar-left">
			      <div class="input-group">
			        <input type="text" class="form-control" placeholder="Search">
			        
			      </div>
			    </form>
			  </div>
			</nav>
    	</div>
    	<!-- Filters end here -->
    	
    	
    	<!-- Added breadcrumb -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">All Products</li>
					</ol>
					</c:if>
					
					<c:if test="${userClickCategoryProducts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/home">Home</a></li>
						<li class="active">Category</li>
						<li class="active">${category.name}</li>
					</ol>
					</c:if>
				</div>
			</div>
		<!-- Ended breadcrumb -->
			
			
			<!-- To display sidebar -->
			<div class="col-md-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
						Brands
						</h3>
					</div>
					<div class="panel-body">
						
						<%@include file="sidebarC.jsp" %>		
					
					</div>
				</div>
			</div>
			
			<!-- to display products -->
			<div class="col-md-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Category Query</h3>
					</div>
					<div class="panel-body">
						<div class="row">
						  
						  <c:forEach items="${products}" var="variable">
						  
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						      <img src="${variable[0].pimage}" alt="${variable[0].pname}">
						      <div class="caption">
						        <h3>
						        <a href="" style="text-decoration: none;">${variable[1].name} ${variable[0].pname} ( ${variable[0].pcolor} )</a></h3>
						        <h4>&#8377;${variable[0].price}</h4>
						        <p><a href="#" class="btn btn-primary" role="button">to Cart <span class="glyphicon glyphicon-shopping-cart"></span></a>
						        <a href="#" class="btn btn-danger" role="button">to Wish List <span class="glyphicon glyphicon-info-sign"></span></a></p>
						      </div>
						    </div>
						  </div>
						  
						  </c:forEach>
						  <c:forEach items="${catProducts}" var="variable">
						  
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						      <img src="${variable[0].pimage}" alt="${variable[0].pname}">
						      <div class="caption">
						        <h3>
						        <a href="" style="text-decoration: none;">${variable[1].name} ${variable[0].pname} ( ${variable[0].pcolor} )</a></h3>
						        <h4>&#8377;${variable[0].price}</h4>
						        <p><a href="#" class="btn btn-primary" role="button">to Cart <span class="glyphicon glyphicon-shopping-cart"></span></a>
						        <a href="#" class="btn btn-danger" role="button">to Wish List <span class="glyphicon glyphicon-info-sign"></span></a></p>
						      </div>
						    </div>
						  </div>
						  
						  </c:forEach>
						  
						</div>
					</div>	
				</div>
			</div>

		</div>
