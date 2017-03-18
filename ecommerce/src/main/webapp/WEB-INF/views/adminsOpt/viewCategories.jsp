<div class="panel panel-default">
                  
                  <div class="panel-body">
                  		 <legend class="col-md-12 viewcatlegend">Brands</legend>
                  		 
                  
					            <div class="form-group pull-right">
					    <input type="text" class="search form-control" placeholder="What you looking for?">
					</div>
					<span class="counter pull-right"></span>
					<table class="table table-hover table-bordered results">
					  <thead>
					    <tr>
					      
					      <th class="col-md-4 col-xs-4 tablehead">Brand Name</th>
					      <th class="col-md-6 col-xs-4 tablehead">Brand Description</th>
					      <th class="col-md-2 col-xs-4 tablehead">Edit</th>
					    </tr>
					    <tr class="warning no-result">
					      <td colspan="4"><i class="fa fa-warning"></i> No result</td>
					    </tr>
					  </thead>
					  <tbody>
					  
					  <c:forEach items="${categories}" var="category">
					    <tr>
					      <th scope="row" class="tablecontent">${category.name}</th>
					      <td class="tablecontent">${category.description}</td>
					      <td><a href="${contextRoot}/admin/categoryUpdate/${category.id}" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></a>
					      <a href="${contextRoot}/admin/categoryDeletion/${category.id}" class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></a>
					      </td>
					    </tr>
					  
					  </c:forEach>
					    
					  </tbody>
					</table>

					</div>
					</div>
