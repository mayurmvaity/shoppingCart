<div class="container">
<!-- REGISTER PAGE -->
        <div class="row">

            <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
            <div class="panel-heading">
            	<h3 class="panel-title">Register here</h3>
            </div>
            <div class="panel-body">
                <form:form method="post" commandName="user" action="${contextRoot}/registeration" name="registration">

                    

                    <fieldset>
                        <legend>Account Details</legend>

                        <div class="form-group col-md-6">
                            <form:label path="fname">First name</form:label>
                            <form:input path="fname" type="text" class="form-control" placeholder="First name" />
                            
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="lname">Last name</form:label>
                            <form:input path="lname" type="text" class="form-control" placeholder="Last name" />
                            
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="email">Email</form:label>
                            <form:input type="email" class="form-control" path="email" placeholder="Email" />
                           
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="pw">Password</form:label>
                            <form:input type="password" class="form-control" path="pw" placeholder="Password" />
                            
                        </div>

                       <!--  <div class="form-group col-md-6">
                            <form:label path="pw">Re-enter Password</form:label>
                            <form:input type="password" class="form-control" placeholder="Re-enter password" path="pw" />
                            
                        </div> -->
						
						<div class="form-group col-md-6">
                            <label for="country">Gender</label>
                            <select class="form-control" name="gender" >
                            	<option>Select one</option>
                                <option>Male</option>
                                <option>Female</option>
                                
                            </select>
                            
                        </div>
						
						<div class="form-group col-md-6">
                            <form:label path="pno">Mobile number</form:label>
                            <form:input type="text" class="form-control" path="pno" placeholder="Mobile number" />
                        	
                        </div>
						
                    </fieldset>
					
					<fieldset>
                        <legend>Address details</legend>

                        <div class="form-group col-md-12">
                            <form:label path="add1">Address line 1</form:label>
                            <form:input type="text" class="form-control" path="add1" placeholder="Address line 1" />
                      
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="add2">Address line 2</form:label>
                            <form:input type="text" class="form-control" path="add2" placeholder="Address line 2" />
                           
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="add3">Address line 3</form:label>
                            <form:input type="text" class="form-control" path="add3" placeholder="Address line 3" />
                            
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="city">City</form:label>
                            <form:input type="text" class="form-control" path="city" placeholder="City" />
                            
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="state">State</form:label>
                            <form:input type="text" class="form-control" path="state" placeholder="State" />
                            
                        </div>
						
						<div class="form-group col-md-12">
                            <form:label path="pincode">Pin code</form:label>
                            <form:input type="text" class="form-control" path="pincode" placeholder="Pin code" />
                            
                        </div>
						
						<div class="form-group">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-primary">
                            Add</button>
                            <a href="${contextRoot}/login">Already have an account?</a>
                        </div>
                    </div>
						
                    </fieldset>
					
                    

                </form:form>
                </div>
               </div>
            </div>

        </div>
        <!-- REGISTER END -->
        
        
    </div>