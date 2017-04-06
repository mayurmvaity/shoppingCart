
<link rel="stylesheet" href="${css}/orderD.css" type="text/css">

<p class="forlegends">Your Orders</p>
	<c:forEach items="${orders}" var="order" >



<!-- beginning of category views -->
<div class="panel panel-default">
	<div class="panel-body">
	<div class="row">
		<div class="col-md-2 orderdetailhead">
		TOTAL <br /><p class="orderdetailheadtext"><span class="rsymbol">&#8377;</span> ${order.amount}
		
		</p>
		</div>
		<div class="col-md-2 orderdetailhead">PAYMENT MODE <br /><p class="orderdetailheadtext"> ${order.payment} 
		</p></div>
		<div class="col-md-2 orderdetailhead">
			
				ORDER STATUS
				<br/>
				<p class="orderdetailheadtext">
				Pending...
			</p>
			
		</div>
		
		<div class="col-md-6 orderdetailhead">SHIPPING ADDRESS <br /><p class="orderdetailheadtext">${order.address.add1}, ${order.address.add2}, ${order.address.add3}, ${order.address.city}, ${order.address.state}, ${order.address.pincode}
		</p></div>
	</div>	
       <!--  <div class="panel panel-default"> -->
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
        				  	
        			
						  <c:if test="${order.orderid == cartitem.order.orderid}">
						 	
						 	
						 	
						 	
						  	  <tr>
				                <th scope="row"><img src="${cartitem.product.pimage}" width="200px"></th>
				                <td><p class="odname"><a href="${contextRoot}/productDetails/${cartitem.product.pid}">${cartitem.product.category.name} ${cartitem.product.pname} ${cartitem.product.pcolor}</a></p><p>${cartitem.product.pdesc}</p></td>
				                <td><p class="odprice"><span class="rsymbol">&#8377;</span>${cartitem.product.price}</p></td>
				                <td>${cartitem.quantity}</td>
				                <td>Free</td>
				                <td><p class="odprice"><span class="rsymbol">&#8377;</span>${cartitem.itotal}</p></td>
				              </tr>
						 			
							</c:if>
							
							
							
							
				
						
						   </c:forEach>
						  </tbody>
						  </table> 
						   
						
                
                
           <!--  </div> -->
        </div>
	
</div>			<!-- end of panel of category -->  


</c:forEach>
