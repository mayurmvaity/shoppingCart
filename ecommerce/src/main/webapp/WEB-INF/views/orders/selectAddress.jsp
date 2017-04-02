<div class="container">


	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Select delivery address</h3>
		</div>
		<div class="panel-body">
			<div class="row">
			
			<c:forEach items="${addresses}" var="address">
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
 
						<div class="caption">
							<p>${address.add1}</p>
							<p>${address.add2}</p>
							<p>${address.add3}</p>
							<p>${address.city}</p>
							<p>${address.state}</p>
							<p>${address.pincode}</p>
							<div class="checkbox">
								<label> 
								<a href="${contextRoot}/user/confirmPurchase/${userid}/${address.addid}" class="btn btn-primary" role="button">Deliver here</a>
								</label>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			
			
				
				
			</div>
			<div class="panel-body">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-1">Add new address</button>
												<div class="modal fade" id="modal-1">
							<div class="modal-dialog modal-md">
									<div class="modal-content">
											<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">&times;</button>
													<h3 class="modal-title">Add new address</h3>
											</div>
											<form:form method="post" action="${contextRoot}/user/addAddressNew/${userid}" commandName="address">
											<div class="modal-body">
													
											<fieldset>
		                        				
		                        				
		                        				<form:hidden path="addid" class="form-control"
													placeholder="Enter Product Id" value="${address.addid}" />
		                        				
		                        				<form:hidden path="aid" class="form-control"
													placeholder="Enter Product Id" value="${userid}" />
		                        				
		                        				
											<div class="form-group col-md-12">
		                            			<form:label path="add1">Address line 1: <font color='red'><form:errors path="add1" /></font></form:label>
		                            			<form:input type="text" class="form-control" path="add1" value="${address.add1}" placeholder="Address line 1" />
		                          
		                        			</div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="add2">Address line 2: <font color='red'><form:errors path="add2" /></font></form:label>
					                            <form:input type="text" class="form-control" path="add2" value="${address.add2}" placeholder="Address line 2" />
					                            
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="add3">Address line 3: <font color='red'><form:errors path="add3" /></font></form:label>
					                            <form:input type="text" class="form-control" path="add3" value="${address.add3}" placeholder="Address line 3" />
					                           
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="city">City: <font color='red'><form:errors path="city" /></font></form:label>
					                            <form:input type="text" class="form-control" path="city" value="${address.city}" placeholder="City" />
					                          
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="state">State: <font color='red'><form:errors path="state" /></font></form:label>
					                            <form:input type="text" class="form-control" path="state" value="${address.state}" placeholder="State" />
					                            
					                        </div>
								
											<div class="form-group col-md-12">
					                            <form:label path="pincode">Pin code: <font color='red'><form:errors path="pincode" /></font></form:label>
					                            <form:input type="text" class="form-control" path="pincode" value="${address.pincode}" placeholder="Pin code" />
					                            
					                        </div>
		                        
		                        			</fieldset>
				                        <!-- <div class="form-group">
					                        <div class="col-md-12">
					                            <button type="submit" class="btn btn-primary">
					                                Add
					                            </button>
					                            
					                        </div>
				                    	</div> -->
		                    		
											</div>

											<div class="modal-footer">
													<a href="" class="btn btn-default" data-dismiss="modal">Close</a>
													<button type="submit" class="btn btn-primary">
					                                Add
					                            </button>
											</div>
									</form:form>
									</div>
							</div>	
					</div>

			</div>


		</div>

	</div>







</div>