       	<div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Add new Brand</h3>
                  </div>
				<div class="panel-body">
					<div class="col-md-8 col-md-offset-2">
                     <form:form method="post" action="${contextRoot}/admin/categoryAddition" commandName="category">
                    	   <fieldset>
                        
                        <form:hidden path="id" class="form-control"
								placeholder="Enter Product Id" value="${category.id}" />
                        

                        <div class="form-group col-md-12">
                            <form:label path="name">Name</form:label>
                            <form:input type="text" class="form-control" path="name" placeholder="Brand name" value="${category.name}" />
                           
                        </div>

                        
                        
						<div class="form-group col-md-12">
                            <form:label path="description">
                              Brand description</form:label>
                            <form:textarea path="description" class="form-control" rows="9" cols="25" required="true"
                                placeholder="Brand description" value="${category.description}" />
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
                    <h3 class="panel-title">Brands</h3>
                  </div>
                  <div class="panel-body">
					            <div class="form-group pull-right">
					    <input type="text" class="search form-control" placeholder="What you looking for?">
					</div>
					<span class="counter pull-right"></span>
					<table class="table table-hover table-bordered results">
					  <thead>
					    <tr>
					      
					      <th class="col-md-4 col-xs-4">Brand Name</th>
					      <th class="col-md-6 col-xs-4">Brand description</th>
					      <th class="col-md-2 col-xs-4">Edit</th>
					    </tr>
					    <tr class="warning no-result">
					      <td colspan="4"><i class="fa fa-warning"></i> No result</td>
					    </tr>
					  </thead>
					  <tbody>
					  
					  <c:forEach items="${categories}" var="category">
					    <tr>
					      <th scope="row"><a href="">${category.name}</a></th>
					      <td>${category.description}</td>
					      <td><a href="${contextRoot}/admin/categoryUpdate/${category.id}" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></a>
					      <a href="${contextRoot}/admin/categoryDeletion/${category.id}" class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></a>
					      </td>
					    </tr>
					  
					  </c:forEach>
					    
					  </tbody>
					</table>

					</div>
					</div>
