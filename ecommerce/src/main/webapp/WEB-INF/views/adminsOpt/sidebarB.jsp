	<div class="container">
    	<div class="col-md-3">
        
        <div class="panel panel-default">
	          <div class="panel-heading">
	            <h3 class="panel-title">Admin panel</h3>
	          </div>
	          	<div class="panel-body list-group">
	          		<a href="addProduct" id="addProduct" class="list-group-item">Add product</a>
	              	<a href="addCategory" id="addCategory" class="list-group-item">Add brand</a>
	              	<a href="addSupplier" id="addSupplier" class="list-group-item">Add supplier</a>
	            </div>
        </div>
		</div>
		<div class="col-md-9">
        	
		        <c:if test="${isUserClickAddProduct==true}">
					<%@include file="addProduct.jsp" %>
				</c:if>
				
				<c:if test="${isUserClickAddCategory==true}">
					<%@include file="addCategory.jsp" %>
				</c:if>
        	
        		<c:if test="${isUserClickAddSupplier==true}">
					<%@include file="addSupplier.jsp" %>
				</c:if>
        	
        	
		</div>
	</div>
