<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.bandung.bean.PostBean"%>
<%@ page import="net.bandung.dao.PostDao"%>
<%@ page import="java.util.*"%>
<html>


<title>Bandung | Destinasi</title>

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
<%
	PostBean post = new PostBean();
	PostDao dao = new PostDao();
	String uid = request.getParameter("destinasiId");
 	if (!((uid) == null)) {
 		int id = Integer.parseInt(uid);
	post = dao.getPostById(id);
%>
<jsp:include page="template/navbar.jsp" />
<div class="class-content">
	<div class="container" style="margin-top:50px">
	<div class="row">
		<div class="col-md-12">
			<h1><%=post.getJudul()%></h1><hr>
			<img src="assets/img/seaworld.jpg" class="img-responsive" style="max-width:275px" >
			<p  style=";margin-top:0px;padding:10px"><%=post.getIsi()%></p>
		</div>		
	<%
 	}else{
 		System.out.print("Tidak Ditemukan");
 	}
	%>
	</div>
		
	</div>
	
	<jsp:include page="template/footer.jsp" />
</div>
</body>
</html>