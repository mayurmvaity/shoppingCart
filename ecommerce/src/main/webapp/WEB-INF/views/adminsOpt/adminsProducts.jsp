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
					<c:if test="${isUserClickAdminsProducts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/admin/show/all/adminsProducts">Home</a></li>
						<li class="active">All Products</li>
					</ol>
					</c:if>
					
					<c:if test="${userClickCategoryAdminProducts==true}">
					<ol class="breadcrumb">
						<li><a href="${contextRoot}/admin/show/all/adminsProducts">Home</a></li>
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
						
						<%@include file="menubar.jsp" %>		
					
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
						     <a href="${contextRoot}/admin/adminsProDetails/${product.pid}"><img src="${product.pimage}" alt="${product.pname}"></a> 
						      <div class="caption">
						        <p class="thumbp">
						        <a href="${contextRoot}/admin/adminsProDetails/${product.pid}" >${product.category.name} ${product.pname} ( ${product.pcolor} )</a></p>
						         <p class="coname">by ${product.category.name}</p>
						        <p class="productprice">&#8377;${product.price}</p>
						        <p>Stock: <span class="">${product.stock}</span></p>
						        <p><a href="${contextRoot}/admin/productUpdate/${product.pid}" class="btn btn-primary" role="button">Edit <span class="glyphicon glyphicon-shopping-cart"></span></a>
						        <a href="${contextRoot}/admin/productDeletion/${product.pid}" class="btn btn-danger" role="button">Delete <span class="glyphicon glyphicon-trash"></span></a></p>
						      </div>
						    </div>
						  </div>
						  
						  </c:forEach>
						  <c:forEach items="${catProducts}" var="product">
						  
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						    <a href="${contextRoot}/admin/adminsProDetails/${product.pid}"><img src="${product.pimage}" alt="${product.pname}"></a>
						      <div class="caption">
						        <p class="thumbp">
						        <a href="${contextRoot}/admin/adminsProDetails/${product.pid}">${product.category.name} ${product.pname} ( ${product.pcolor} )</a></p>
						        <p class="coname">by ${product.category.name}</p>
						        <p class="productprice">&#8377;${product.price}</p>
						        <p><a href="${contextRoot}/admin/productUpdate/${product.pid}" class="btn btn-primary" role="button">Edit  <span class="glyphicon glyphicon-shopping-cart"></span></a>
						        <a href="${contextRoot}/admin/productDeletion/${product.pid}" class="btn btn-danger" role="button">Delete <span class="glyphicon glyphicon-info-sign"></span></a></p>
						      </div>
						    </div>
						  </div>
						  
						  </c:forEach>
						  
						</div>
					</div>	
				</div>
			</div>

		</div>
