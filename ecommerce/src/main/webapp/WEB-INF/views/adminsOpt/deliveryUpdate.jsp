<div class="panel panel-default">
                 
                  <div class="panel-body">
                  
                   <legend class="col-md-12 viewcatlegend">Delivery Status</legend>
                  
                      <div class="form-group pull-right">
              <input type="text" class="search form-control" placeholder="What you looking for?">
          </div>
          <span class="counter pull-right"></span>
          <table class="table table-hover table-bordered results">
            <thead>
              <tr>
                
                <th class="col-md-1 col-xs-4 tablehead">Userid</th>
                <th class="col-md-1 col-xs-6 tablehead">Orderid</th>
                <th class="col-md-1 tablehead">Pending</th>
                <th class="col-md-3 tablehead">Dispatched</th>
                <th class="col-md-3 tablehead">Delivered</th>
                
                </tr>
              <tr class="warning no-result">
                <td colspan="4"><i class="fa fa-warning"></i> No result</td>
              </tr>
            </thead>
            <tbody>
            <c:forEach items="${allorders}" var="order">
            
              <tr>
                <th scope="row" class="tablecontent">${order.user.uid}</th>
                <td class="tablecontent">${order.orderid}</td>
                <td>${order.ordered}</td>
                <td>${order.dispatched} <a class="btn btn-primary" href="${contextRoot}/admin/makeDispatch/${order.orderid}">Dispatched</a>&nbsp;<a class="btn btn-danger" href="${contextRoot}/admin/cancelDispatch/${order.orderid}">Cancel</a></td>
                <td>${order.delivered} <a class="btn btn-primary" href="${contextRoot}/admin/makeDelivered/${order.orderid}">Delivered</a>&nbsp;<a class="btn btn-danger" href="${contextRoot}/admin/cancelDelivered/${order.orderid}">Cancel</a></td>
                
              </tr>
              
             </c:forEach> 
              
            </tbody>
          </table>

          </div>
          </div>

        	
        	
        	
        	
