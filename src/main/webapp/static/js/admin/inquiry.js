var app = angular.module("AdminInquiry", []);

app.controller("AdminInquiryController", function($scope, $http) {
	
	const baseUrl = 'http://localhost:8080/hotel-reservation/api';
	
	$scope.deleteInquiry = function(inquiryId) {
		console.log(inquiryId);
		
		$http({
			method: 'DELETE',
			url: `${baseUrl}/delete-inquiry/${inquiryId}`,
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