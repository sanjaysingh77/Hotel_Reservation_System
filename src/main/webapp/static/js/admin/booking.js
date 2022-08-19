var app = angular.module("AdminBooking", []);

app.controller("AdminBookingController", function($scope, $http) {
	
	const baseUrl = 'http://localhost:8080/hotel-reservation/api';
	
	$scope.deleteBooking = function(bookingId) {
		console.log(bookingId);
		
		$http({
			method: 'DELETE',
			url: `${baseUrl}/delete-booking/${bookingId}`,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function successCallback(response) {
			location.reload(); 
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}
	
});