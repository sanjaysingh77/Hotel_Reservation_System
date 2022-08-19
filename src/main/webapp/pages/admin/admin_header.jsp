<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hotel SS</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100&display=swap" rel="stylesheet">

<link href="../static/styles/main.css" rel="stylesheet">

</head>
<body>

	
		<header
			class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
			<a href="/hotel-reservation/admin/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<span class="fs-4 mx-4">Hotel SS</span>
			</a>

			<ul class="nav nav-pills">
				<li class="nav-item">
					<a href="inquiries" class="nav-link ${activeLink == 'inquiries' ? 'active' :'' }" aria-current="page">Inquiries</a>
				</li>
				<li class="nav-item">
					<a href="bookings" class="nav-link ${activeLink == 'bookings' ? 'active' :'' }">Bookings</a>
				</li>
			</ul>
		</header>