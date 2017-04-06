


        	<div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Add product</h3>
                  </div>
				<div class="panel-body">
					<div class="col-md-8 col-md-offset-2">
					
					 <form:form name="addpform" method="post" action="${contextRoot}/admin/productAddition" commandName="product" enctype="multipart/form-data">
                    	   <fieldset>
                        
                        <form:hidden path="pid" class="form-control"
								placeholder="Enter Product Id" value="${product.pid}" />

                        <div class="form-group col-md-12">
                         <form:label path="pname">Name: <span class="reqstar">&#42;</span> <font color='red'><form:errors path="pname" /></font></form:label> 
                            <form:input type="text" class="form-control" path="pname" placeholder="Product name" value="${product.pname}"/>
                           
                        </div>
                        
                        <div class="form-group col-md-12">
                         <form:label path="pcolor">Color: <span class="reqstar">&#42;</span> <font color='red'><form:errors path="pcolor" /></font></form:label> 
                            <form:input type="text" class="form-control" path="pcolor" placeholder="Product color" value="${product.pcolor}"/>
                           
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="price">Price : <span class="reqstar">&#42;</span> (in &#8377;) <font color='red'><form:errors path="price" /></font></form:label>
                            <form:input path="price" type="text" class="form-control" placeholder="Prcie" value="${product.price}"/>
                            
                        </div>

                        <div class="form-group col-md-12">
                            <form:label path="stock">Stock : <span class="reqstar">&#42;</span><font color='red'><form:errors path="stock" /></font></form:label>
                            <form:input path="stock" type="text" class="form-control" placeholder="Prcie" value="${product.stock}"/>
                            
                        </div>
						
						<div class="form-group col-md-12">
                            <form:label path="category.id">Brand <span class="reqstar">&#42;</span></form:label>
                            
                         	<form:select path="category.id" class="form-control">
								<c:forEach items="${categories}" var="category">
									<form:option value="${category.id}">${category.name}</form:option>
								</c:forEach>
							</form:select>
							
							
                         
                         
                        </div>
						
                       <div class="form-group col-md-12">
                              <form:label path="image">Upload image <span class="reqstar">&#42;</span></form:label>
                              <form:input type="file" path="image" />
                       </div>
                        
						<div class="form-group col-md-12">
                            <form:label path="pdesc">
                               Product details: <span class="reqstar">&#42;</span> <font color='red'><form:errors path="pdesc" /></font></form:label>
                            <form:textarea path="pdesc" class="form-control" rows="9" cols="25" required="true"
                                placeholder="Product details" value="${product.pdesc}"/>
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
                <th class="col-md-2 col-xs-2">Price</th>
                <th class="col-md-2 col-xs-2">Stock</th>
                <th class="col-md-2 col-xs-2">Edit</th>
              </tr>
              <tr class="warning no-result">
                <td colspan="4"><i class="fa fa-warning"></i> No result</td>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${listProducts}" var="product">
              <tr>
                <th scope="row"><img src="${product.pimage}" width="100px"></th>
                <td><a href="">${product.category.name} ${product.pname} ( ${product.pcolor} ) </a></td>
                <td>&#8377;${product.price}</td>
                <td>${product.stock}</td>
                <td><a class="btn btn-primary btn-md" href="${contextRoot}/admin/productUpdate/${product.pid}"><span class="glyphicon glyphicon-edit"></span></a>
                <a class="btn btn-danger btn-md" href="${contextRoot}/admin/productDeletion/${product.pid}"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
              </tr>
              </c:forEach>
            </tbody>
          </table>

          </div>
          </div>
