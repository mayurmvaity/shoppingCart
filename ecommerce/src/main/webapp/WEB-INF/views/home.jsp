<div class="container">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="http://placehold.it/1274x444" alt="S6s">
    </div>

    <div class="item">
      <img src="http://placehold.it/1274x444" alt="HTC10">
    </div>

    <div class="item">
      <img src="http://placehold.it/1274x444" alt="s7edge">
    </div>

    <div class="item">
      <img src="http://placehold.it/1274x444" alt="vivov5plus">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<!-- end of carousel -->

	<c:forEach items="${categories}" var="variable" >

<!-- beginning of category views -->
<div class="panel panel-default">
	<div class="panel-body">
		<div class="col-md-2">
        	<h4>${variable.name}</h4>
            <a href="" class="btn btn-primary">View All</a>
        </div>
        <div class="col-md-10">
        	<div class="row">
        			<c:set var="count" value="0" scope="page" />
        				
        		
						 
      
        				<c:forEach items="${products}" var="innerv">
        				  	
        			
						  <c:if test="${variable.id == innerv[0].cid}">
						 	
						 	<c:if test="${count<4}">
						  <div class="col-sm-6 col-md-3">
						    <div class="thumbnail">
						      <img src="${innerv[0].pimage}" alt="image">
						      <div class="caption">
						        <h3>
						        <a href="" style="text-decoration: none;">${innerv[1].name} ${innerv[0].pname} ( ${innerv[0].pcolor} )</a></h3>
						        <h4>&#8377;${innerv[0].price}</h4>
						       <%--  <h4>&#8377;${count}</h4> --%>
						        <p><a href="#" class="btn btn-primary btn-sm" role="button"><span class="glyphicon glyphicon-shopping-cart"></span></a>
						        <a href="#" class="btn btn-danger btn-sm" role="button"><span class="glyphicon glyphicon-info-sign"></span></a></p>
						      </div>
						    </div>
						  </div>
						 			<c:set var="count" value="${count+1}" scope="page"/>
							</c:if>
							</c:if>
				
						
						   </c:forEach>
						  
						   
						   
						
                
                
            </div>
        </div>
	</div>
</div>			<!-- end of panel of category -->  


</c:forEach>
<!-- end of the c for each -->


</div>			<!-- end of main container --->
