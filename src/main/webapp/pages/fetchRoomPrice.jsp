
<div class="container">

	<div class="card">
		<div class="card-body">

			<div class="align-content-center d-flex justify-content-between">
				<h4 class="card-title">Hotel SS Room Pricing</h4>

				<button type="button" ng-click="getPrice()"
					class="btn btn-primary">Check Pricing</button>
			</div>

			<table class="table my-5" ng-show="tableVisible">
				<tr>
					<td>Room Preference :</td>
					<td>{{bookedRoom.roomPref}}</td>
				</tr>
				<tr>
					<td>Number of Guests (adults) :</td>
					<td>{{bookedRoom.adults}}</td>
				</tr>
				<tr>
					<td>Number of Guests (children) :</td>
					<td>{{bookedRoom.children}}</td>
				</tr>
				<tr>
					<td>Number of days :</td>
					<td>{{bookedRoom.numOfDays}}</td>
				</tr>
				<tr>
					<td>Final Price :</td>
					<td>{{bookedRoom.price | currency}}</td>
				</tr>
			</table>

			<button ng-show="tableVisible" type="button"
				ng-click="confirmBooking()" class="btn btn-primary float-end">Confirm
				Booking</button>

		</div>
	</div>
</div>
<div class="position-fixed top-0 mx-3 p-3" style="z-index: 11">
<div id="confirmToast" class="toast" ng-class="{'show': showToast == 'true' , 'hide': showToast == 'false' }" role="alert" aria-live="assertive" aria-atomic="true">
  <div class="toast-header">
    <strong class="me-auto">Congratulations</strong>
    <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
  </div>
  <div class="toast-body">
  	Your room booking with Hotel SS is successful.
  </div>
</div>
</div>

