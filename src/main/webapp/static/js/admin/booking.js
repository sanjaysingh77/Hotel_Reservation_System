var app = angular.module("AdminBooking", []);

app.controller("AdminBookingController", function($scope, $http) {
	
	const bookingBaseUrl = 'http://localhost:8081/api/book-room';
	
	$scope.deleteBooking = function(bookingId) {
		console.log(bookingId);
		
		$http({
			method: 'DELETE',
			url: `${bookingBaseUrl}/${bookingId}`,
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