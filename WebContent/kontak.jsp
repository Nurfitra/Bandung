<html>

<title>Bandung | Kontak</title>

<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="assets/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
 <script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
 <link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="template/navbar.jsp" />
<div class="class-content">
	<div class="container" style="margin-top:50px">
	<h1>Kontak Kami</h1>
	<hr>
	<div class="row">
		<div class="col-md-12">
			<form action="" method="post">
			<div class="form-group">
	        	<input name="name" type="text" placeholder="Nama Lengkap" class="form-control" required>
	        </div>
			<div class="form-group">
	        <input name="email" type="email" placeholder="Email Valid" class="form-control" required>
	        </div>
			<div class="form-group">
				<textarea class="form-control" placeholder="Tulis pesan..." required></textarea>
			</div>
	        <input type="submit" value="Kirim" class="btn btn-default">
			</form>
		</div>
	</div>
		
	</div>
	<jsp:include page="template/footer.jsp" />
</div>
</body>
</html>