<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<jsp:include page="template/header.jsp"></jsp:include>

<div class='container'>
	<h3 class="d-flex justify-content-center">Please check below details.</h3>

	<table  class="table">
		<tr>
			<th>Name :</th>
			<td>${roomBookingForm.firstName} ${roomBookingForm.lastName  } </td>
		</tr>
		<tr>
			<th>Address :</th>
			<td>
				${roomBookingForm.address.address1}, ${roomBookingForm.address.address2} <br>
				${roomBookingForm.address.city}, ${roomBookingForm.address.state}, ${roomBookingForm.address.zipCode}
			</td>
		</tr>
		<tr>
			<th>Contact :</th>
			<td>${roomBookingForm.mobNumber} / ${roomBookingForm.email}</td>
		</tr>
		
		<tr>
			<th>Check In / Check Out :</th>
			<td><fmt:formatDate type="date" value="${roomBookingForm.checkIn}" /> / <fmt:formatDate type="date" value="${roomBookingForm.checkOut}" /> </td>
		</tr>
		<tr>
			<th>Room Preference :</th>
			<td>${roomBookingForm.roomPreference}</td>
		</tr>
		<tr>
			<th>Adults / Children :</th>
			<td>${roomBookingForm.numOfAdults} / ${roomBookingForm.children}</td>
		</tr>
		
	</table>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.js"></script>
<script src="static/js/app.js"></script>

<div ng-app="RoomPrice" ng-controller="RoomPriceController" 
	ng-init="init('${ roomBookingForm.bookingId }')">
	<jsp:include page="fetchRoomPrice.jsp"></jsp:include>
</div>

<jsp:include page="template/footer.jsp"></jsp:include>

