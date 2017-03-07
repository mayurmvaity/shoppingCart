


        	<div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Add product</h3>
                  </div>
				<div class="panel-body">
					<div class="col-md-8 col-md-offset-2">
					
					 <form:form method="post" action="${contextRoot}/admin/productAddition" commandName="product">
                    	   <fieldset>
                        

                        <div class="form-group col-md-12">
                         <form:label path="pname">Name</form:label> 
                            <form:input type="text" class="form-control" path="pname" placeholder="Product name" />
                           
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="price">Price</form:label>
                            <form:input path="price" type="text" class="form-control" placeholder="Prcie" />
                            
                        </div>

                        
						
						<div class="form-group col-md-12">
                            <label>Brand</label>
                            <select class="form-control" >
                            	<c:forEach items="${categories}" var="category">
         							 <option>${category.name}</option>
         						</c:forEach>    
         						
         						
                            </select>
                         
                        </div>
						
                       <div class="form-group col-md-12">
                              <form:label path="pimage">Upload image</form:label>>
                              <form:input type="file" path="pimage" id="uploadFile" />
                       </div>
                        
						<div class="form-group col-md-12">
                            <form:label path="pdesc">
                               Product details</form:label>
                            <form:textarea path="pdesc" class="form-control" rows="9" cols="25" required="true"
                                placeholder="Product details" />
                        </div>
						
                        <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary" value="save">
                            Add</button>
                    </div>
                        
                    </fieldset>
                    </form:form>
					</div>
				</div>
			</div>
      <div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Products</h3>
                  </div>
                  <div class="panel-body">
                      <div class="form-group pull-right">
              <input type="text" class="search form-control" placeholder="What you looking for?">
          </div>
          <span class="counter pull-right"></span>
          <table class="table table-hover table-bordered results">
            <thead>
              <tr>
                
                <th class="col-md-2 col-xs-2">Picture</th>
                <th class="col-md-4 col-xs-4">Product name</th>
                <th class="col-md-4 col-xs-4">Price</th>
                <th class="col-md-2 col-xs-2">Edit</th>
              </tr>
              <tr class="warning no-result">
                <td colspan="4"><i class="fa fa-warning"></i> No result</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"><img src="http://placehold.it/802x615" width="100px"></th>
                <td><a href="">Samsung galaxy S7 edge</a></td>
                <td>&#8377;50900</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button>
                </td>
              </tr>
              <tr>
                <th scope="row"><img src="http://placehold.it/802x615" width="100px"></th>
                <td><a href="">Samsung galaxy Note 5</a></td>
                <td>&#8377;43900</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
              </tr>
              <tr>
                <th scope="row"><img src="http://placehold.it/802x615" width="100px"></th>
                <td><a href="">Samsung galaxy A9 pro</a></td>
                <td>&#8377;32490</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
              </tr>
              <tr>
                <th scope="row"><img src="http://placehold.it/802x615" width="100px"></th>
                <td><a href="">Samsung galaxy on8</a></td>
                <td>&#8377;14900</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
              </tr>
            </tbody>
          </table>

          </div>
          </div>
