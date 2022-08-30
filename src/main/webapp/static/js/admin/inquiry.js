var app = angular.module("AdminInquiry", []);

app.controller("AdminInquiryController", function($scope, $http) {
	
	const inquiryBaseUrl = 'http://localhost:8081/api/inquiry';
	
	$scope.deleteInquiry = function(inquiryId) {
		console.log(inquiryId);
		
		$http({
			method: 'DELETE',
			url: `${inquiryBaseUrl}/${inquiryId}`,
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