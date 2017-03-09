<c:forEach items="${products}" var="product">
	<div class="container">
			<div class="col-md-7">
				<div class="panel panel-default">
					<div class="panel-body">
						<img src="${product[0].pimage}" alt="${product[0].pname}" width="600px">
					</div>
				</div>
			</div>
			<div class="col-md-5">
					<div class="row">
						<div class="panel panel-default">
							 	<div class="panel-body">
							    	<h3>${product[1].name} ${product[0].pname} ( ${product[0].pcolor} )</h3>
									<h4>&#8377;${product[0].price}</h4>
								</div>
						</div>
						
					</div>
					<div class="row">
						<div class="panel panel-default">
						  <div class="panel-body">
						    	<h4>Description</h4>
								<p>${product[0].pdesc}</p>
						  </div>
						</div>
						
					</div>

					<div class="row">
						<div class="panel panel-default">
							 	<div class="panel-body">
							    	<button class="btn btn-primary btn-lg">Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span></button>
							    	<button class="btn btn-danger btn-lg">Add to Wish List <span class="glyphicon glyphicon-info-sign"></span></button>
								</div>
						</div>
						
					</div>
			</div>
		</div>
</c:forEach>