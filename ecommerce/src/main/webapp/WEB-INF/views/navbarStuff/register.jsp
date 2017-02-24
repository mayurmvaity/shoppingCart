<div class="container">
<!-- REGISTER PAGE -->
        <div class="row">

            <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
            <div class="panel-heading">
            	<h3 class="panel-title">Register here</h3>
            </div>
            <div class="panel-body">
                <form role="form" method="post" action="">

                    

                    <fieldset>
                        <legend>Account Details</legend>

                        <div class="form-group col-md-6">
                            <label for="first_name">First name</label>
                            <input type="text" class="form-control" name="fname" placeholder="First name">
                            
                        </div>

                        <div class="form-group col-md-6">
                            <label for="last_name">Last name</label>
                            <input type="text" class="form-control" name="lname" placeholder="Last name">
                            
                        </div>

                        <div class="form-group col-md-12">
                            <label for="">Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Email">
                           
                        </div>

                        <div class="form-group col-md-6">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" name="pw" placeholder="Password">
                            
                        </div>

                        <div class="form-group col-md-6">
                            <label for="confirm_password">Re-enter Password</label>
                            <input type="password" class="form-control" name="repass" placeholder="Re-enter password">
                            
                        </div>
						
						<div class="form-group col-md-6">
                            <label for="country">Gender</label>
                            <select class="form-control" name="gender" >
                            	<option>Select one</option>
                                <option>Male</option>
                                <option>Female</option>
                                
                            </select>
                            
                        </div>
						
						<div class="form-group col-md-6">
                            <label for="first_name">Mobile number</label>
                            <input type="text" class="form-control" name="mobileNo" placeholder="Mobile number">
                        	
                        </div>
						
                    </fieldset>
					
					<fieldset>
                        <legend>Address details</legend>

                        <div class="form-group col-md-12">
                            <label for="first_name">Address line 1</label>
                            <input type="text" class="form-control" name="address1" placeholder="Address line 1">
                      
                        </div>

                        <div class="form-group col-md-12">
                            <label for="last_name">Address line 2</label>
                            <input type="text" class="form-control" name="address2" placeholder="Address line 2">
                           
                        </div>

                        <div class="form-group col-md-12">
                            <label for="last_name">Address line 3</label>
                            <input type="text" class="form-control" name="address3" placeholder="Address line 3">
                            
                        </div>

                        <div class="form-group col-md-6">
                            <label for="last_name">City</label>
                            <input type="text" class="form-control" name="city" placeholder="City">
                            
                        </div>

                        <div class="form-group col-md-6">
                            <label for="last_name">State</label>
                            <input type="text" class="form-control" name="state" placeholder="State">
                            
                        </div>
						
						<div class="form-group col-md-12">
                            <label for="last_name">Pin code</label>
                            <input type="text" class="form-control" name="pinCode" placeholder="Pin code">
                            
                        </div>
						
                    </fieldset>
					
                    <div class="form-group">
                        <div class="col-md-12">
                            <button type="submit" class="btn btn-primary">
                                Register
                            </button>
                            <a href="${contextRoot}/login">Already have an account?</a>
                        </div>
                    </div>

                </form>
                </div>
               </div>
            </div>

        </div>
        <!-- REGISTER END -->
        
        
    </div>