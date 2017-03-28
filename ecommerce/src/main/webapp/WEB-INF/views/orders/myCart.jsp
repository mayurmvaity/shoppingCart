<div class="container">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">My Cart <span class="badge">${cartid.items}</span></h3>

				</div>

					  <!-- Table -->
					  <table class="table table-hover">
				            <thead>
				              <tr>
				                
				                <th class="col-md-2 col-xs-2">Item</th>
				                <th class="col-md-6 col-xs-5"></th>
				                <th class="col-md-1 col-xs-1">Price</th>
				                <th class="col-md-1 col-xs-1">Quantity</th>
				                <th class="col-md-1 col-xs-1">Delivery charges</th>
				                <th class="col-md-1 col-xs-1">Subtotal</th>
				                <th class="col-md-1 col-xs-1">Edit</th>
				              </tr>
				              
				            </thead>
            <tbody>
            <c:forEach items="${cartitems}" var="cartit">
              <tr>
                <th scope="row"><img src="${cartit.product.pimage}" width="200px"></th>
                <td><a href="${contextRoot}/productDetails/${cartit.product.pid}">${cartit.product.category.name} ${cartit.product.pname}</a><p>${cartit.product.pdesc}</p></td>
                <td>&#8377;${cartit.iprice}</td>
                <td>${cartit.iquantity}</td>
                <td>Free</td>
                <td>&#8377;${cartit.itotal}</td>
                <td><a href="${contextRoot}/user/removeCartitem/${cartit.itemid}" class="btn btn-primary">Remove</a></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>

			</div>
			<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="pull-right">Amount payable <span style="color: red;">&#8377;Amount</span></h3>
						</div>
			</div>
			<div class="panel panel-default well">
					<div class="panel-body">

					<div class="col-md-2 col-md-offset-8">
					<a href="${contextRoot}/home" class="btn btn-default btn-lg pull-right">Continue shopping</a>
					</div>
					<div class="col-md-2">
						<a href="${contextRoot}/user/selectAddress" class="btn btn-warning btn-lg pull-right">Place order</a>
					</div>
					</div>
			</div>
		</div>