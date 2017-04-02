<div class="container">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Select a payment mode</h3>
					</div>
					<div class="panel-body">
						
						<form:form method="POST" action="${contextRoot}/user/addPaymentMode" commandName="orderitem">
						
							<form:hidden path="orderid" class="form-control"
								placeholder="Enter Product Id" value="${orderitem.orderid}" />
								
								<form:hidden path="user.uid" class="form-control"
								placeholder="Enter Product Id" value="${orderitem.user.uid}" />
								
								<form:hidden path="address.addid" class="form-control"
								placeholder="Enter Product Id" value="${orderitem.address.addid}" />
								
								<form:hidden path="amount" class="form-control"
								placeholder="Enter Product Id" value="${orderitem.amount}" />
							
							
							<div class="form-group">	
							<form:radiobutton path="payment" value="ONLINE"/>Pay Online
							<form:radiobutton path="payment" value="COD"/>Cash on Delivery
						 	</div>
						 	
						 	
						 <div class="well text-center">
							<button type="submit" class="btn btn-primary">
                            Place Order</button>
						</div>
						</form:form>

						
					</div>
				</div>
			</div>
		</div>
