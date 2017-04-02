	<div class="panel panel-default">
					  <div class="panel-heading">
						<h3 class="panel-title">Update personal information</h3>
					</div>
						<div class="panel-body">
						<div class="col-md-8 col-md-offset-2">
							<form:form method="post" action="${contextRoot}/user/updatePersonalInfo" commandName="user">
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
						<form:hidden path="pno" class="form-control"
								placeholder="Enter Product Id" value="${user.pno}" />
						
						<form:hidden path="pw" class="form-control"
								placeholder="Enter Product Id" value="${user.pw}" />
								
								<form:hidden path="cart.cartid" class="form-control"
								placeholder="Enter Product Id" value="${user.cart.cartid}" />
								<form:hidden path="gender" class="form-control"
								placeholder="Enter Product Id" value="${user.gender}" />
								<form:hidden path="role" class="form-control"
								placeholder="Enter Product Id" value="${user.role}" />
						

                        <div class="form-group col-md-12">
                            <form:label path="fname">First name: <font color='red'><form:errors path="fname" /></font></form:label>
                            <form:input type="text" class="form-control" path="fname" value="${user.fname}" placeholder="First name" />
                            
                        </div>

						 <div class="form-group col-md-12">
                            <form:label path="lname">Last name: <font color='red'><form:errors path="lname" /></font></form:label>
                            <form:input type="text" class="form-control" path="lname" value="${user.lname}" placeholder="Last name" />
                            
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="email">Email: <font color='red'><form:errors path="email" /></font></form:label>
                            <form:input type="email" class="form-control" path="email" placeholder="Email" value="${user.email}" />
                            
                        </div>
							<!-- <div class="form-group col-md-12">
                            <label for="country">Gender</label>
                            <select class="form-control" name="gender" >
                            	<option>Select one</option>
                                <option>Male</option>
                                <option>Female</option>
                                
                            </select>
                           
                        </div> -->
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
