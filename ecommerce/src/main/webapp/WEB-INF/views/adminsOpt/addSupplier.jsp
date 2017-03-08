   	
		<div class="col-md-9">
        	
		        
        	<div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Add supplier</h3>
                  </div>
				<div class="panel-body">
					<div class="col-md-8 col-md-offset-2">
                    	   <form:form method="post" action="${contextRoot}/admin/supplierAddition" commandName="supplier">
                    	   <fieldset>
                        

                        <div class="form-group col-md-12">
                            <form:label path="sname">Name</form:label>
                            <form:input type="text" class="form-control" path="sname" placeholder="Supplier name" />
                           
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="sdesc">
                               Supplier description</form:label>
                            <form:textarea path="sdesc" class="form-control" rows="9" cols="25" required="true"
                                placeholder="Supplier address" />
                        </div>

                        
						
                        <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary">
                            Add</button>
                    </div>
                        
                    </fieldset>
                    </form:form>
					</div>
				</div>
			</div>
      <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Suppliers</h3>
                  </div>
                  <div class="panel-body">
                      <div class="form-group pull-right">
              <input type="text" class="search form-control" placeholder="What you looking for?">
          </div>
          <span class="counter pull-right"></span>
          <table class="table table-hover table-bordered results">
            <thead>
              <tr>
                
                <th class="col-md-4 col-xs-4">Name</th>
                <th class="col-md-6 col-xs-6">Supplier details</th>
                <th class="col-md-2">Edit</th>
                </tr>
              <tr class="warning no-result">
                <td colspan="4"><i class="fa fa-warning"></i> No result</td>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${suppliers}" var="supplier">
            
              <tr>
                <th scope="row">${supplier.sname}</th>
                <td>${supplier.sdesc}</td>
                <td><a class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></a>
                <a class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
              </tr>
              
             </c:forEach> 
              
            </tbody>
          </table>

          </div>
          </div>

        	
        	
        	
        	
		</div>
