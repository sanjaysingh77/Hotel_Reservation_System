var app = angular.module("RoomPrice", []);

app.controller("RoomPriceController", function($scope, $http) {
	$scope.bookedRoom = {};
	$scope.bookingId = null;
	$scope.tableVisible = false;

	const baseUrl = 'http://localhost:8080/hotel-reservation/api';

	$scope.init = function(bookingId) {
		$scope.bookingId = bookingId;
		
	};
	
	$scope.getPrice = function() {
		console.log($scope.bookingId)
		$http({
			method: 'GET',
			url: `${baseUrl}/room-pricing/${$scope.bookingId}`,
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.bookedRoom = response.data;
			$scope.tableVisible = true;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});
	}
	
	$scope.confirmBooking = function() {
		
		$http({
			method: 'POST',
			url: `${baseUrl}/confirm-booking`,
			data: angular.toJson($scope.bookedRoom),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};

	function _success(response) {
		if(response.status == 200){
			$scope.showToast = 'true';
			setTimeout(() => {
				$scope.showToast = 'false';
				location.href = `my-bookings?email=${$scope.bookedRoom.email}`;
			}, 3000);
		}
	}

	function _error(response) {
		console.log(response.statusText);
	}

});