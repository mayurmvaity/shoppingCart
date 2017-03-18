<div class="panel panel-default">
                 
                  <div class="panel-body">
                  
                   <legend class="col-md-12 viewcatlegend">Suppliers</legend>
                  
                      <div class="form-group pull-right">
              <input type="text" class="search form-control" placeholder="What you looking for?">
          </div>
          <span class="counter pull-right"></span>
          <table class="table table-hover table-bordered results">
            <thead>
              <tr>
                
                <th class="col-md-4 col-xs-4 tablehead">Name</th>
                <th class="col-md-6 col-xs-6 tablehead">Supplier details</th>
                <th class="col-md-2 tablehead">Edit</th>
                </tr>
              <tr class="warning no-result">
                <td colspan="4"><i class="fa fa-warning"></i> No result</td>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${suppliers}" var="supplier">
            
              <tr>
                <th scope="row" class="tablecontent">${supplier.sname}</th>
                <td class="tablecontent">${supplier.sdesc}</td>
                <td><a href="${contextRoot}/admin/supplierUpdate/${supplier.sid}" class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></a>
                <a href="${contextRoot}/admin/supplierDeletion/${supplier.sid}" class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></a>
                </td>
              </tr>
              
             </c:forEach> 
              
            </tbody>
          </table>

          </div>
          </div>

        	
        	
        	
        	

