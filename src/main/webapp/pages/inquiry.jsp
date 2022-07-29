<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="template/header.jsp"></jsp:include>

<div class='container'>
	<h3 class="d-flex justify-content-center">Hotel SS Inquiry</h3>
	
	<form:form method="POST" class="d-flex flex-column gap-4"
          action="postInquiry" modelAttribute="inquiryForm">

		<div class="form-group required">
			<label for="name">Name</label> 
			<form:input path="name" class="form-control" placeholder="Name" />
			<form:errors path="name" class="font-monospace error"/>
		</div>
		<div class="form-group">
			<label for="email">Email</label> 
			<form:input type="email" path="email" class="form-control" placeholder="Email" />
		</div>
		
		<div class="form-group required">
			<label for="mobNumber">Mobile</label> 
			<form:input type="number" maxlength="10" path="mobNumber" class="form-control" placeholder="Mobile Number" />
			<form:errors path="mobNumber" class="font-monospace error"/>
		</div>
		
		<div class="form-group required">
			<label for="inquiryText">Inquiry</label> 
			<form:textarea path="inquiryText" class="form-control" />
			<form:errors path="inquiryText" class="font-monospace error"/>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form:form>

</div>


<jsp:include page="template/footer.jsp"></jsp:include>

