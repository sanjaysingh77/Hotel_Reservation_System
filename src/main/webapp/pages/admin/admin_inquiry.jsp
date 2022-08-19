<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="admin_header.jsp"></jsp:include>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
<script src="../static/js/admin/inquiry.js"></script>

<div ng-app="AdminInquiry" ng-controller="AdminInquiryController" class="container">
	
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">Hotel Inquiries</h5>
	    
	<c:choose>
		<c:when test="${ not empty inquiriesList }">
			<table class="table table-striped my-5">
				<thead>
					<tr>
						<th style="width:15%">Name</th>
						<th style="width:15%">Email</th>
						<th style="width:15%">Mobile</th>
						<th style="width:40%">Inquiry Text</th>
						<th style="width:15%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${inquiriesList}" var="inquiry">
						<tr>
							<td>${ inquiry.name }</td>
							<td>${ inquiry.email }</td>
							<td>${ inquiry.mobNumber }</td>
							<td>${ inquiry.inquiryText }</td>
							<td>
								<button type="button" ng-click="deleteInquiry('${ inquiry.id }')" class="btn btn-danger">Delete</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<div class="my-5">No Data Found.</div>
		</c:otherwise>
	
	</c:choose>
	    
	    
	  </div>
	</div>
	
</div>



<jsp:include page="admin_footer.jsp"></jsp:include>

