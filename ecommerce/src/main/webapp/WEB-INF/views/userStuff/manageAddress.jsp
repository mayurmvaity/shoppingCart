						<div class="panel panel-default">
						  	<div class="panel-heading">
								<h3 class="panel-title">Manage addresses</h3>
							</div>
								<div class="panel-body">
									<div class="col-md-8 col-md-offset-2">
										<form:form method="post" action="${contextRoot}/user/addNewAddress" commandName="address">
											<fieldset>
		                        				<legend>Add new address</legend>
		                        				
		                        				<form:hidden path="addid" class="form-control"
													placeholder="Enter Product Id" value="${address.addid}" />
		                        				
		                        				<form:hidden path="aid" class="form-control"
													placeholder="Enter Product Id" value="${userid}" />
		                        				
		                        				
											<div class="form-group col-md-12">
		                            			<form:label path="add1">Address line 1</form:label>
		                            			<form:input type="text" class="form-control" path="add1" value="${address.add1}" placeholder="Address line 1" />
		                          
		                        			</div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="add2">Address line 2</form:label>
					                            <form:input type="text" class="form-control" path="add2" value="${address.add2}" placeholder="Address line 2" />
					                            
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="add3">Address line 3</form:label>
					                            <form:input type="text" class="form-control" path="add3" value="${address.add3}" placeholder="Address line 3" />
					                           
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="city">City</form:label>
					                            <form:input type="text" class="form-control" path="city" value="${address.city}" placeholder="City" />
					                          
					                        </div>
		
					                        <div class="form-group col-md-12">
					                            <form:label path="state">State</form:label>
					                            <form:input type="text" class="form-control" path="state" value="${address.state}" placeholder="State" />
					                            
					                        </div>
								
											<div class="form-group col-md-12">
					                            <form:label path="pincode">Pin code</form:label>
					                            <form:input type="text" class="form-control" path="pincode" value="${address.pincode}" placeholder="Pin code" />
					                            
					                        </div>
		                        
		                        			</fieldset>
				                        <div class="form-group">
					                        <div class="col-md-12">
					                            <button type="submit" class="btn btn-primary">
					                                Add
					                            </button>
					                            
					                        </div>
				                    	</div>
		                    		</form:form>
		                    
								</div>
		
								</div>
						</div>							
						<div class="panel panel-default">
							  	<div class="panel-heading">
									<h3 class="panel-title">Other addresses</h3>
								</div>
								<div class="panel-body">
										<div class="row">
										<c:forEach items="${Addresses}" var="addresses">
										  <div class="col-sm-6 col-md-4">
										    <div class="thumbnail">
										     
										      	<div class="caption">
											        <p>${addresses.add1},</p>
											        <p>${addresses.add2},</p>
											        <p>${addresses.add3},</p>
											        <p>${addresses.city},</p>
											       <p>${addresses.state},</p>
											        <p>${addresses.pincode},</p>
											        
		                                                <label>
		                                                   <a href="${contextRoot}/user/updateAddress/${addresses.addid}" class="btn btn-primary " role="button">Edit</a>
		                                                   <a href="${contextRoot}/user/deleteAddresses/${addresses.addid}" class="btn btn-danger " role="button">Remove</a>
		                                                </label>
                                            		
										        </div>
										    </div>
										  </div>
										</c:forEach>
										  
										</div>
										


								</div>

						</div>
