

			<div class="panel panel-default">
				<%-- <div class="panel-heading">
					<a class="btn btn-primary btn-lg" href="${contextRoot}/user/orderDetailsButton">View details</a>
				</div> --%>
				<table class="table">
				            <thead>
				              <tr>
				                
				                <th class="col-md-2 ">Item</th>
				                <th class="col-md-6 "></th>
				                 <th class="col-md-1 ">Price</th>
				                <th class="col-md-1">Quantity</th>
				                <th class="col-md-1 ">Delivery Charges</th>
				                <th class="col-md-1 ">Subtotal</th>
				              </tr>
				              
				            </thead>
            <tbody>
            <c:forEach items="${carto}" var="cartitem">
              <tr>
                <th scope="row"><img src="${cartitem.product.pimage}" width="200px"></th>
                <td><p class="odname">${cartitem.product.category.name} ${cartitem.product.pname} ${cartitem.product.pcolor}</p><p>${cartitem.product.pdesc}</p></td>
                <td><p class="odprice"><span class="rsymbol">&#8377;</span>${cartitem.product.price}</p></td>
                <td>${cartitem.quantity}</td>
                <td>Free</td>
                <td><p class="odprice"><span class="rsymbol">&#8377;</span>${cartitem.itotal}</p></td>
              </tr>
              </c:forEach>
            </tbody>
          </table>
			</div>

