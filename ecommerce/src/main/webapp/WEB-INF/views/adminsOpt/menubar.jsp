<div class="list-group">
	
	<c:forEach items="${categories}" var="category">
		<a href="${contextRoot}/admin/show/category/${category.id}/adminproducts" class="list-group-item" id="a_${category.name}">${category.name}</a>
	
	</c:forEach>

</div>

