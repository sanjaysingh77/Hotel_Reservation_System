<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="template/header.jsp"></jsp:include>

<div class='container'>
	<h3 class="d-flex justify-content-center">Book a Room</h3>
	
	<form:form method="POST" class="d-flex flex-column gap-4"
          action="bookRoom" modelAttribute="roomBookingForm">

		<div class="row">
			<div class="form-group required col-6">
				<label for="name">First Name</label> 
				<form:input path="firstName" class="form-control" placeholder="First Name" />
				<form:errors path="firstName" class="font-monospace error"/>
			</div>
			<div class="form-group col-6">
				<label for="name">Last Name</label> 
				<form:input path="lastName" class="form-control" placeholder="Last Name" />
			</div>
		</div>
		
		<div class="row">
			<div class="form-group required col-6">
				<label for="name">Address 1</label> 
				<form:input path="address.address1" class="form-control" placeholder="Address 1" />
				<form:errors path="address.address1" class="font-monospace error"/>
			</div>
			<div class="form-group col-6">
				<label for="name">Address 2</label> 
				<form:input path="address.address2" class="form-control" placeholder="Address 2" />
			</div>
		</div>
		
		<div class="row">
			<div class="form-group required col-6">
				<label for="name">City</label> 
				<form:input path="address.city" class="form-control" placeholder="City" />
				<form:errors path="address.city" class="font-monospace error"/>
			</div>
			<div class="form-group required col-3">
				<label for="name">State</label> 
				<form:input path="address.state" class="form-control" placeholder="State" />
				<form:errors path="address.state" class="font-monospace error"/>
			</div>
			<div class="form-group col-3">
				<label for="name">ZipCode</label> 
				<form:input path="address.zipCode" class="form-control" placeholder="Zip Code" />
			</div>
		</div>
		
		<div class="row">
			<div class="form-group required col-6">
				<label for="email">Email</label> 
				<form:input type="email" path="email" class="form-control" placeholder="Email" />
				<form:errors path="email" class="font-monospace error"/>
			</div>
			<div class="form-group required col-6">
				<label for="mobNumber">Mobile</label> 
				<form:input type="number" path="mobNumber" maxlength="10" class="form-control" placeholder="Mobile Number" />
				<form:errors path="mobNumber" class="font-monospace error"/>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group required col-6">
				<label for="email">Check In Date</label> 
				<form:input type="date" path="checkIn" class="form-control" placeholder="Check in" />
				<form:errors path="checkIn" class="font-monospace error"/>
			</div>
			<div class="form-group required col-6">
				<label for="mobNumber">Check Out Date</label> 
				<form:input type="date" path="checkOut" class="form-control" placeholder="Check out" />
				<form:errors path="checkOut" class="font-monospace error"/>
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-6">
			<label for="mobNumber">Room Preference</label> 
				<div class="d-flex gap-3">
					<div class="form-check form-check-inline">
					  <form:radiobutton class="form-check-input" path="roomPreference" id="standard" value="standard"/>
					  <label class="form-check-label" for="standard">Standard</label>
					</div>
					<div class="form-check form-check-inline">
					   <form:radiobutton class="form-check-input" path="roomPreference" id="deluxe" value="deluxe"/>
					  <label class="form-check-label" for="deluxe">Deluxe</label>
					</div>
					<div class="form-check form-check-inline">
					   <form:radiobutton class="form-check-input" path="roomPreference" id="suite" value="suite"/>
					  <label class="form-check-label" for="suite">Suite</label>
					</div>
				</div>
			</div>
			
			<div class="form-group required col-3">
			  <label for="inputState">Adults</label>
			  <form:select path="numOfAdults">
			  	<c:forEach var = "i" begin = "1" end = "10">
			  		<form:option value="${i}" label="${i}" />
			  	</c:forEach>
			  </form:select>
			  <form:errors path="numOfAdults" class="font-monospace error"/>
			</div>
			
			<div class="form-group col-3">
			  <label for="inputState">Children</label>
			  <form:select path="children">
			  	<c:forEach var = "i" begin = "0" end = "10">
			  		<form:option value="${i}" label="${i}" />
			  	</c:forEach>
			  </form:select>
			</div>
		</div>
		
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Book Room</button>
		</div>
	</form:form>

</div>


<jsp:include page="template/footer.jsp"></jsp:include>