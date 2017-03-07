       	<div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Add new Brand</h3>
                  </div>
				<div class="panel-body">
					<div class="col-md-8 col-md-offset-2">
                     <form:form method="post" action="${contextRoot}/admin/categoryAddition" commandName="category">
                    	   <fieldset>
                        

                        <div class="form-group col-md-12">
                            <form:label path="name">Name</form:label>
                            <form:input type="text" class="form-control" path="name" placeholder="Brand name" />
                           
                        </div>

                        
                        
						<div class="form-group col-md-12">
                            <form:label path="description">
                              Brand description</form:label>
                            <form:textarea path="description" class="form-control" rows="9" cols="25" required="true"
                                placeholder="Brand description" />
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
					    <tr>
					      <th scope="row"><a href="">Samsung</a></th>
					      <td>ero.</td>
					      <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
					      <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button>
					      </td>
					    </tr>
					    <tr>
					      <th scope="row"><a href="">HTC</a></th>
					      <td>ero. In sed nibh in diam commodo fermentum vitae ac lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec tempor varius suscipit. M</td>
					      <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
					      <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
					    </tr>
					    <tr>
					      <th scope="row"><a href="">Gionee</a></th>
					      <td>ctetur adipiscing elit. Cras id est ac elit volutpat placerat. Pellentesque nec arcu in felis facilisis semper ut nec ante. In pellentesque pharetra vulputat</td>
					      <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
					      <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
					    </tr>
					    <tr>
					      <th scope="row"><a href="">Motorola</a></th>
					      <td>nc imperdiet est at eleifend posuere. Aliquam tellus mi, dapibus eu turpis at, </td>
					      <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
					      <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
					    </tr>
					  </tbody>
					</table>

					</div>
					</div>
