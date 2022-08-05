var app = angular.module("RoomPrice", []);

app.controller("RoomPriceController", function($scope, $http) {
	$scope.bookedRoom = {};
	$scope.tableVisible=false;

	const baseUrl = 'http://localhost:8080/hotel-reservation/api';

	$scope.init = function(roomPref, adults, children, numOfDays) {
		$scope.bookedRoom = {
			roomPref,
			adults,
			children,
			numOfDays
		}
		console.log($scope.bookedRoom);
	};

	$scope.getPrice = function() {

		$http({
			method: 'POST',
			url: `${baseUrl}/room-pricing`,
			data: angular.toJson($scope.bookedRoom),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then(_success, _error);
	};

	function _success(response) {
		$scope.bookedRoom = response.data;
		$scope.tableVisible=true;
		console.log('success', $scope.bookedRoom);
	}

	function _error(response) {
		console.log(response.statusText);
	}
	
	$scope.confirmBooking = function() {
		$scope.showToast='true';
		setTimeout(() => {
			$scope.showToast='false';
			location.href="/hotel-reservation";
		},3000);
	};

});