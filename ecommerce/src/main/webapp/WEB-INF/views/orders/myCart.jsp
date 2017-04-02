<div class="container">
			<p class="formycartheader">Shopping Cart</p>

			
			<div class="panel panel-default">
				<%-- <div class="panel-heading">
					<h3 class="panel-title">My Cart <span class="badge">${cartid.items}</span></h3>
 
				</div> --%>

					  <!-- Table -->
					  <table class="table">
				            <thead>
				              <tr>
				                
				                <th class="col-md-2 col-xs-2"></th>
				                <th class="col-md-4 col-xs-4"></th>
				                <th class="col-md-1 col-xs-1">Price</th>
				                <th class="col-md-1 col-xs-1">Quantity</th>
				                <th class="col-md-1 col-xs-1">Delivery charges</th>
				                <th class="col-md-1 col-xs-1">Subtotal</th>
				                <th class="col-md-2 col-xs-1">Edit</th>
				              </tr>
				              
				            </thead>
            <tbody>
            <c:forEach items="${cartitems}" var="cartit">
              <tr>
                <th scope="row"><img src="${cartit.product.pimage}" width="200px"></th>
                <td><p><a href="${contextRoot}/productDetails/${cartit.product.pid}">${cartit.product.category.name} ${cartit.product.pname}</a> by ${cartit.product.category.name} </p><p>${cartit.product.pdesc}</p></td>
                <td><p class="productprice"><span class="rupeesymbol">&#8377;</span>${cartit.iprice}</p></td>
                <td>${cartit.iquantity}</td>
                <td>Free</td>
                <td><p class="productprice"><span class="rupeesymbol">&#8377;</span>${cartit.itotal}</p></td>
                <td><a href="${contextRoot}/user/removeCartitem/${cartit.itemid}" class="btn btn-primary">Remove</a></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>

			</div>
			<div class="panel panel-default">
						<div class="panel-body">
							<p class="pull-right subtotaltext">Subtotal (${cartid.items} items): <span class="cartsubtotal"><span class="rupeesymbol">&#8377;</span>${cartid.totalcost}</span></p>
						</div>
			</div>
			<div class="panel panel-default well">
					<div class="panel-body">

					<div class="col-md-2 col-md-offset-8">
					<a href="${contextRoot}/home" class="btn btn-default btn-lg pull-right">Continue shopping</a>
					</div>
					<div class="col-md-2">
						<a href="${contextRoot}/user/selectAddress/${userid}" class="btn btn-warning btn-lg pull-right">Place order</a>
					</div>
					</div>
			</div>
		</div>