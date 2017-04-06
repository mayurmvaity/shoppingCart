<div class="container">
<!-- REGISTER PAGE -->
        <div class="row">

            <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
            <!-- <div class="panel-heading">
            	<h3 class="panel-title">Register here</h3>
            </div> -->
            <div class="panel-body">
                <form:form method="post" commandName="user" action="${contextRoot}/registeration" >

                    <legend class="col-md-12 forlegends">Create Account</legend>

                    <fieldset>
                        <legend>Account Details</legend>

                        <div class="form-group col-md-6">
                            <form:label path="fname" class="forlabels">First name: <span class="reqstar">&#42;</span><font color='red'><form:errors path="fname" /></font></form:label>
                            <form:input path="fname" type="text" class="form-control" placeholder="First name" />
                            
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="lname" class="forlabels">Last name: <span class="reqstar">&#42;</span><font color='red'><form:errors path="lname" /></font></form:label>
                            <form:input path="lname" type="text" class="form-control" placeholder="Last name" />
                            
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="email" class="forlabels">Email: <span class="reqstar">&#42;</span><font color='red'><form:errors path="email" /></font></form:label>
                            <form:input type="email" class="form-control" path="email" placeholder="Email" />
                           	<p><span style="color: red; font-weight: bold;">${Emailerror}</span></p>
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="pw" class="forlabels">Password: <span class="reqstar">&#42;</span><font color='red'><form:errors path="pw" /></font></form:label>
                            <form:input type="password" class="form-control" path="pw" placeholder="Password at least 8 characters" />
                            
                        </div>

                       <!--  <div class="form-group col-md-6">
                            <form:label path="pw">Re-enter Password</form:label>
                            <form:input type="password" class="form-control" placeholder="Re-enter password" path="pw" />
                            
                        </div> -->
						
						<div class="form-group col-md-6">
                            <label path="gender" class="forlabels">Gender <span class="reqstar">&#42;</span></label>
                            <!-- <select class="form-control" name="gender" >
                            	<option>Select one</option>
                                <option>Male</option>
                                <option>Female</option>
                                
                            </select> -->
                            <form:radiobutton path="gender" value="M"/>Male
							<form:radiobutton path="gender" value="F"/>Female
                            
                            
                        </div>
						
						<div class="form-group col-md-6">
                            <form:label path="pno" class="forlabels">Mobile number: <span class="reqstar">&#42;</span><font color='red'><form:errors path="pno" /></font></form:label>
                            <form:input type="text" class="form-control" path="pno" placeholder="Mobile number" />
                        	
                        </div>
						
                    </fieldset>
					
					<fieldset>
                        <legend>Address details </legend>

                        <div class="form-group col-md-12">
                            <form:label path="add1" class="forlabels">Address line 1: <span class="reqstar">&#42;</span><font color='red'><form:errors path="add1" /></font></form:label>
                            <form:input type="text" class="form-control" path="add1" placeholder="Address line 1" />
                      
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="add2" class="forlabels">Address line 2: <span class="reqstar">&#42;</span><font color='red'><form:errors path="add2" /></font></form:label>
                            <form:input type="text" class="form-control" path="add2" placeholder="Address line 2" />
                           
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="add3" class="forlabels">Address line 3: <span class="reqstar">&#42;</span><font color='red'><form:errors path="add3" /></font></form:label>
                            <form:input type="text" class="form-control" path="add3" placeholder="Address line 3" />
                            
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="city" class="forlabels">City: <span class="reqstar">&#42;</span><font color='red'><form:errors path="city" /></font></form:label>
                            <form:input type="text" class="form-control" path="city" placeholder="City" />
                            
                        </div>

                        <div class="form-group col-md-6">
                            <form:label path="state" class="forlabels">State: <span class="reqstar">&#42;</span><font color='red'><form:errors path="state" /></font></form:label>
                            <form:input type="text" class="form-control" path="state" placeholder="State" />
                            
                        </div>
						
						<div class="form-group col-md-12">
                            <form:label path="pincode" class="forlabels">Pin code: <span class="reqstar">&#42;</span><font color='red'><form:errors path="pincode" /></font></form:label>
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