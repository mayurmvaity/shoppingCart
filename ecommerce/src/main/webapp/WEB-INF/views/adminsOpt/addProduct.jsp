
        	<div class="panel panel-default">
                  <div class="panel-heading">
                    <h3 class="panel-title">Add product</h3>
                  </div>
				<div class="panel-body">
					<div class="col-md-8 col-md-offset-2">
                    	   <fieldset>
                        

                        <div class="form-group col-md-12">
                            <label for="PName">Name</label>
                            <input type="text" class="form-control" name="pname" placeholder="Product name">
                           
                        </div>

                        <div class="form-group col-md-12">
                            <label for="PPrice">Price</label>
                            <input type="text" class="form-control" name="pprice" placeholder="Prcie">
                            
                        </div>

                        <div class="form-group col-md-12">
                            <label for="">Quantity</label>
                            <input type="text" class="form-control" name="pquant" placeholder="Quantity">
                            
                        </div>

                        
						
						<div class="form-group col-md-12">
                            <label for="country">Brand</label>
                            <select class="form-control" name="pcategory" >
                            	<option>Select one</option>
                                <option>Samsung</option>
                                <option>HTC</option>
                                <option>Gionee</option>
                                
                            </select>
                         
                        </div>
						
                       <div class="form-group col-md-12">
                              <label>Upload image</label>
                              <input type="file">
                       </div>
                        
						<div class="form-group col-md-12">
                            <label for="details">
                               Product details</label>
                            <textarea name="pdetails" class="form-control" rows="9" cols="25" required
                                placeholder="Product details"></textarea>
                        </div>
						
                        <div class="form-group col-md-12">
                        <button type="submit" class="btn btn-primary">
                            Add</button>
                    </div>
                        
                    </fieldset>
                    
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
                <th scope="row"><img src="${images}/s7main.jpg" width="100px"></th>
                <td><a href="">Samsung galaxy S7 edge</a></td>
                <td>&#8377;50900</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button>
                </td>
              </tr>
              <tr>
                <th scope="row"><img src="${images}/note5main.jpg" width="100px"></th>
                <td><a href="">Samsung galaxy Note 5</a></td>
                <td>&#8377;43900</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
              </tr>
              <tr>
                <th scope="row"><img src="${images}/A9main.jpg" width="100px"></th>
                <td><a href="">Samsung galaxy A9 pro</a></td>
                <td>&#8377;32490</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
              </tr>
              <tr>
                <th scope="row"><img src="${images}/on8main.jpg" width="100px"></th>
                <td><a href="">Samsung galaxy on8</a></td>
                <td>&#8377;14900</td>
                <td><button class="btn btn-primary btn-md"><span class="glyphicon glyphicon-edit"></span></button>
                <button class="btn btn-danger btn-md"><span class="glyphicon glyphicon-trash"></span></button></td>
              </tr>
            </tbody>
          </table>

          </div>
          </div>
