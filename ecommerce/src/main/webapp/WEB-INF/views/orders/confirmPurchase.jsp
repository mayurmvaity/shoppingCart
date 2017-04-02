<div class="container">
	<p class="forlegends">Confirm Purchase</p>
	
	<div class="panel panel-default">
			<!-- <div class="panel-heading">
				<h3 class="panel-title">Delivery address</h3>
			</div> -->
			
			
			<div class="panel-body">
				<div class="col-md-4">
				<p class="forusername">${user.fname} ${user.lname}</p><p class="foruserpno">Phone: ${user.pno}</p>
				</div>
				<div class="col-md-4">
				
				<p class="pnobold">Billing Address</p>
				<p>${user.add1}</p>
				<p>${user.add2}</p>
				<p>${user.add3}</p>
				<p>${user.city}</p>
				<p>${user.state}</p>
				<p>${user.pincode}</p>
				</div>
				
				<div class="col-md-4">
				
				<p class="pnobold">Shipping Address</p>
				<p>${shipadd.add1}</p>
				<p>${shipadd.add2}</p>
				<p>${shipadd.add3}</p>
				<p>${shipadd.city}</p>
				<p>${shipadd.state}</p>
				<p>${shipadd.pincode}</p>
				
				</div>
				
				<!-- <div class="col-md-3">
					<button class="btn btn-lg btn-primary pull-right">Change address</button>
				</div> -->
			</div>
		</div>
		<div class="panel panel-default">
			<!-- <div class="panel-heading">
			    <h3 class="panel-title">
			    	Order summary
			    </h3>
			</div> -->
			  <table class="table">
				            <thead>
				              <tr>
				                
				                <th class="col-md-2 col-xs-2"></th>
				                <th class="col-md-6 col-xs-6"></th>
				                <th class="col-md-1 col-xs-1">Price</th>
				                <th class="col-md-1 col-xs-1">Quantity</th>
				                <th class="col-md-1 col-xs-1">Delivery charges</th>
				                <th class="col-md-1 col-xs-1">Subtotal</th>
				              </tr>
				              
				            </thead>
            <tbody>
            <c:forEach items="${cartitems}" var="cartitem">
              <tr>
                <th scope="row"><img src="${cartitem.product.pimage}" width="200px"></th>
                <td><p class="productname">${cartitem.product.category.name} ${cartitem.product.pname} ${cartitem.product.pcolor}</p><p class="productdesc">${cartitem.product.pdesc}</p></td>
                <td class="productprice"><span class="rupeesymbol">&#8377;</span>${cartitem.iprice}</td>
                <td>${cartitem.iquantity}</td>
                <td>Free</td>
                <td class="productprice"><span class="rupeesymbol">&#8377;</span>${cartitem.itotal}</td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
          

		</div>
		<div class="panel panel-default">
						<div class="panel-body">
							<p class="pull-right subtotaltext">Subtotal (${cartx.items} items): <span class="cartsubtotal"><span class="rupeesymbol">&#8377;</span>${cartx.totalcost}</span></p>
						</div>
			</div>
			<div class="well text-right">
				<a class="btn btn-lg btn-warning" href="${contextRoot}/user/paymentMode/${oid}">Proceed to Pay</a>
			</div>




</div>