<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<jsp:include page="template/header.jsp"></jsp:include>

<div class='container'>
	<h3 class="d-flex justify-content-center">Please check below details.</h3>

	<table  class="table">
		<tr>
			<td>Name :</td>
			<td>${roomBookingForm.firstName} ${roomBookingForm.lastName  } </td>
		</tr>
		<tr>
			<td>Address :</td>
			<td>
				${roomBookingForm.address.address1}, ${roomBookingForm.address.address2} <br>
				${roomBookingForm.address.city}, ${roomBookingForm.address.state}, ${roomBookingForm.address.zipCode}
			</td>
		</tr>
		<tr>
			<td>Contact :</td>
			<td>${roomBookingForm.mobNumber} / ${roomBookingForm.email}</td>
		</tr>
		
		<tr>
			<td>Check In / Check Out :</td>
			<td><fmt:formatDate type="date" value="${roomBookingForm.checkIn}" /> / <fmt:formatDate type="date" value="${roomBookingForm.checkOut}" /> </td>
		</tr>
		<tr>
			<td>Room Preference :</td>
			<td>${roomBookingForm.roomPreference}</td>
		</tr>
		<tr>
			<td>Adults / Children :</td>
			<td>${roomBookingForm.numOfAdults} / ${roomBookingForm.children}</td>
		</tr>
		
	</table>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
<script src="static/js/app.js"></script>

<div ng-app="RoomPrice" ng-controller="RoomPriceController" 
	ng-init="init('${ roomBookingForm.roomPreference }','${ roomBookingForm.numOfAdults }', '${ roomBookingForm.children }','${ numOfDays }')">
	<jsp:include page="fetchRoomPrice.jsp"></jsp:include>
</div>

<jsp:include page="template/footer.jsp"></jsp:include>

