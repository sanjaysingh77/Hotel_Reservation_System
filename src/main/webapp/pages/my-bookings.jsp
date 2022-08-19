<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<jsp:include page="template/header.jsp"></jsp:include>

<div class='container'>
	<h3 class="d-flex justify-content-center">My Bookings</h3>
	
	<form method="POST" class="d-flex flex-column my-5 gap-4" action="my-bookings">
     
     	<div class="row">
			<div class="form-group required col-6">
				<input type="text" name="email" value="${searchEmail}" class="form-control" placeholder="Enter Email to Search" />
			</div>
			<div class="form-group col-6">
				<button type="submit" class="btn btn-primary">Search</button>
			</div>
		</div>
     
     </form>
     
     <div class="card my-5">
	  <div class="card-body">
			<c:choose>
				<c:when test="${ not empty myBookingList }">
					<table class="table table-striped">
						<thead>
							<tr>
								<th style="width:10%">Name</th>
								<th style="width:15%">Email</th>
								<th style="width:10%">Check In</th>
								<th style="width:10%">Check Out</th>
								<th style="width:15%">Room Preference</th>
								<th style="width:10%">Adults</th>
								<th style="width:10%">Children</th>
								<th style="width:10%">Price</th>
								<th style="width:20%">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${myBookingList}" var="booking">
								<tr>
									<td>${ booking.lastName} ${ booking.firstName }</td>
									<td>${ booking.email }</td>
									<td><fmt:formatDate type="date" value="${booking.checkIn}" /></td>
									<td><fmt:formatDate type="date" value="${booking.checkOut}" /></td>
									<td>${ booking.roomPreference }</td>
									<td>${ booking.numOfAdults }</td>
									<td>${ booking.children }</td>
									<td>${ booking.price }</td>
									<td>
										<div class="d-flex gap-2">
											<form method="POST" action="edit-booking">
												<input type="hidden" name="bookingId" value="${booking.bookingId}" />
												<button type="submit" class="btn btn-primary">Edit</button>
											</form>
											
											<form method="POST" action="delete-booking">
												<input type="hidden" name="bookingId" value="${booking.bookingId}" />
												<input type="hidden" name="email" value="${booking.email}" />
												<button type="submit" class="btn btn-danger">Delete</button>
											</form>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div>No Data Found.</div>
				</c:otherwise>
			
			</c:choose>
	  </div>
	</div>
	
</div>


<jsp:include page="template/footer.jsp"></jsp:include>