<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<jsp:include page="admin_header.jsp"></jsp:include>


<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
<script src="../static/js/admin/booking.js"></script>

<div ng-app="AdminBooking" ng-controller="AdminBookingController" class="container">
	
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">Hotel Bookings</h5>
	    
	<c:choose>
		<c:when test="${ not empty bookingsList }">
			<table class="table table-striped my-5">
				<thead>
					<tr>
						<th style="width:10%">Name</th>
						<th style="width:10%">Email</th>
						<th style="width:10%">Mobile</th>
						<th style="width:10%">Address</th>
						<th style="width:10%">Check In</th>
						<th style="width:10%">Check Out</th>
						<th style="width:10%">Room Preference</th>
						<th style="width:10%">Adults</th>
						<th style="width:10%">Children</th>
						<th style="width:10%">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookingsList}" var="booking">
						<tr>
							<td>${ booking.lastName} ${ booking.firstName }</td>
							<td>${ booking.email }</td>
							<td>${ booking.mobNumber }</td>
							<td>${ booking.address.toString() }</td>
							<td><fmt:formatDate type="date" value="${booking.checkIn}" /></td>
							<td><fmt:formatDate type="date" value="${booking.checkOut}" /></td>
							<td>${ booking.roomPreference }</td>
							<td>${ booking.numOfAdults }</td>
							<td>${ booking.children }</td>
							<td>
								<button type="button" ng-click="deleteBooking('${ booking.bookingId }')" class="btn btn-danger">Delete</button>
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

