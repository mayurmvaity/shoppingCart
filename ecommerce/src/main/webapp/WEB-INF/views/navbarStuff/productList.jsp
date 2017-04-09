	<div class="container">
		<!-- Filters added here -->
		<!-- <div class="col-md-12">
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
    	</div> -->
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
					<!-- <div class="panel-heading">
						<h3 class="panel-title">Category Query</h3>
					</div> -->
					<div class="panel-body">
						<div class="row">
						  
						  <c:forEach items="${products}" var="product">
						  
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						      <a href="${contextRoot}/productDetails/${product.pid}"><img src="${product.pimage}" alt="${product.pname}"></a>
						      <div class="caption">
						        <p class="thumbp">
						        <a href="${contextRoot}/productDetails/${product.pid}" >${product.category.name} ${product.pname} ( ${product.pcolor} )</a></p>
						        <p class="coname">by ${product.category.name}</p>
						        <p class="productprice">&#8377;${product.price}</p>
						        <p><c:if test="${product.stock >0 }"><a href="${contextRoot}/user/addToCart/${product.pid}" class="btn btn-primary btn-sm "><span class="glyphicon glyphicon-shopping-cart"></span></a></c:if>
						       		<c:if test="${product.stock <=0 }">Out of stock</c:if></p>
						      </div>
						    </div>
						  </div>
						  
						  </c:forEach>
						  <c:forEach items="${catProducts}" var="cproduct">
						 
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						      <a href="${contextRoot}/productDetails/${cproduct.pid}"><img src="${cproduct.pimage}" alt="${cproduct.pname}"></a>
						      <div class="caption">
						       <p class="thumbp">
						        <a href="${contextRoot}/productDetails/${cproduct.pid}">${cproduct.category.name} ${cproduct.pname} ( ${cproduct.pcolor} )</a></p>
						        <p class="coname">by ${cproduct.category.name}</p>
						        <p class="productprice">&#8377;${cproduct.price}</p>
						        <p><c:if test="${cproduct.stock >0 }"><a href="${contextRoot}/user/addToCart/${cproduct.pid}" class="btn btn-primary btn-sm "><span class="glyphicon glyphicon-shopping-cart"></span></a></c:if>
						       		<c:if test="${cproduct.stock <=0 }">Out of stock</c:if></p>
						      </div>
						    </div>
						  </div>
						 
						  </c:forEach>
						  
						</div>
					</div>	
				</div>
			</div>

		</div>
