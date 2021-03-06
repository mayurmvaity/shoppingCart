
	<div class="container">
			<div class="col-md-7">
				<div class="panel panel-default">
					<div class="panel-body">
						<img src="${product.pimage}" alt="${product.pname}" width="600px">
					</div>
				</div>
			</div>
			<div class="col-md-5">
					<div class="row">
						<div class="panel panel-default">
							 	<div class="panel-body">
							    	<p class="prodetailsname">${product.category.name} ${product.pname} ( ${product.pcolor} )</p>
									<hr />
									<p class="propricedetails"><span class="pricetagspan">Price:</span> <span class="rupeesymbol">&#8377;</span> ${product.price}</p>
								</div>
						</div>
						
					</div>
					<div class="row">
						<div class="panel panel-default">
						  <div class="panel-body">
						    	<h4>Description</h4>
								<p>${product.pdesc}</p>
						  </div>
						</div>
						
					</div>
					<c:if test="${product.stock > 0}">
					<div class="row">
						<div class="panel panel-default">
							 	<div class="panel-body">
							 		<p class="forinstock">In stock</p>
							 	
							    	<a href="${contextRoot}/user/addToCart/${product.pid}" class="btn btn-primary btn-lg">Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span></a>
							    	
								</div>
						</div>
						
					</div>
					</c:if>
					<c:if test="${product.stock <= 0 }">
						<div class="row">
						<div class="panel panel-default">
							 	<div class="panel-body">
							 		<p class="fornotinstock">Not in stock</p>
							 	
								</div>
						</div>
						
					</div>
					</c:if>
			</div>
		</div>




<%-- <!-- beginning of category views -->
<div class="panel panel-default">
	<div class="panel-body">
		
       <div class="col-md-12">
        	<div class="row">
        			<c:set var="count" value="0" scope="page" />
        				
        		
						 
      
        				<c:forEach items="${colors}" var="colors">
        				  	
        			
						
						 	
						 	<c:if test="${count<4}">
						  <div class="col-sm-6 col-md-3">
						    <div class="thumbnail">
						     <a href="${contextRoot}/productDetails/${colors[0].pid}"><img src="${colors[0].pimage}" alt="${colors[0].pname}"></a> 
						      <div class="caption">
						        <h3>
						        <a href="${contextRoot}/productDetails/${colors[0].pid}" style="text-decoration: none;">${colors[1].name} ${colors[0].pname} ( ${colors[0].pcolor} )</a></h3>
						        <h4>&#8377;${colors[0].price}</h4>
						        <h4>&#8377;${count}</h4>
						        <p><a href="#" class="btn btn-primary btn-sm " role="button"><span class="glyphicon glyphicon-shopping-cart"></span></a>
						        <a href="#" class="btn btn-danger btn-sm" role="button"><span class="glyphicon glyphicon-info-sign"></span></a></p>
						      </div>
						    </div>
						  </div>
						 			<c:set var="count" value="${count+1}" scope="page"/>
							</c:if>
							
				
						
						   </c:forEach>
						  
						   
						   
						
                
                
            </div>
       </div>
	</div>
</div>			<!-- end of panel of category -->   --%>
