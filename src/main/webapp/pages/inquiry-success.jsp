
<jsp:include page="template/header.jsp"></jsp:include>

<div class='container'>
	<h3 class="d-flex justify-content-center">Your Inquiry submitted successfully.</h3>

	<table  class="table">
		<tr>
			<td>Name :</td>
			<td>${inquiryForm.name}</td>
		</tr>
		<tr>
			<td>Email :</td>
			<td>${inquiryForm.email}</td>
		</tr>
		<tr>
			<td>Mobile Number :</td>
			<td>${inquiryForm.mobNumber}</td>
		</tr>
		<tr>
			<td>Inquiry :</td>
			<td>${inquiryForm.inquiryText}</td>
		</tr>
	</table>

</div>


<jsp:include page="template/footer.jsp"></jsp:include>

