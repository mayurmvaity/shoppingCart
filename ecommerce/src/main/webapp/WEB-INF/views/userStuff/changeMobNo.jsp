			<div class="panel panel-default">
					  <div class="panel-heading">
						<h3 class="panel-title">Update mobile number</h3>
					</div>
						<div class="panel-body">
						<div class="col-md-8 col-md-offset-2">
							<form:form role="form" method="post" action="${contextRoot}/user/updateMobileNo" commandName="user">
									<fieldset>
			                        	<form:hidden path="uid" class="form-control"
												placeholder="Enter Product Id" value="${user.uid}" />
										<form:hidden path="add1" class="form-control"
												placeholder="Enter Product Id" value="${user.add1}" />
										<form:hidden path="add2" class="form-control"
												placeholder="Enter Product Id" value="${user.add2}" />
										<form:hidden path="add3" class="form-control"
												placeholder="Enter Product Id" value="${user.add3}" />
										<form:hidden path="city" class="form-control"
												placeholder="Enter Product Id" value="${user.city}" />
										<form:hidden path="state" class="form-control"
												placeholder="Enter Product Id" value="${user.state}" />
										<form:hidden path="pincode" class="form-control"
												placeholder="Enter Product Id" value="${user.pincode}" />
										<form:hidden path="fname" class="form-control"
												placeholder="Enter Product Id" value="${user.fname}" />
										<form:hidden path="lname" class="form-control"
												placeholder="Enter Product Id" value="${user.lname}" />
										<form:hidden path="email" class="form-control"
												placeholder="Enter Product Id" value="${user.email}" />
										
										<form:hidden path="pw" class="form-control"
												placeholder="Enter Product Id" value="${user.pw}" />
										
										<form:hidden path="cart.cartid" class="form-control"
								placeholder="Enter Product Id" value="${user.cart.cartid}" />
								<form:hidden path="gender" class="form-control"
								placeholder="Enter Product Id" value="${user.gender}" />
								<form:hidden path="role" class="form-control"
								placeholder="Enter Product Id" value="${user.role}" />
										
					                        <div class="form-group col-md-12">
					                            <form:label path="pno">Enter new mobile number</form:label>
					                            <form:input type="text" class="form-control" path="pno" placeholder="New mobile number" value="${user.pno}" />
					                            
					                        </div>
			
			                        
			                        </fieldset>
				                        <div class="form-group">
					                        <div class="col-md-12">
					                            <button type="submit" class="btn btn-primary">
					                                Update
					                            </button>
					                            
					                        </div>
				                    	</div>
                    		</form:form>
                    	</div>
						</div>							

			
		
				</div>
