<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.bandung.bean.EventBean"%>
<%@ page import="net.bandung.dao.EventDao"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*"%>
<html>


<title>Bandung | Event</title>

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
	EventBean event = new EventBean();
	EventDao dao = new EventDao();
	String eid = request.getParameter("eventId");
 	if (eid != null) {
 		int id = Integer.parseInt(eid);
 		event = dao.getEventById(id);
 		Blob image = event.getGambar();
 		byte[] imgData = null; 
 		imgData = image.getBytes(1,(int)image.length());
 		String imgDataBase64=new String(Base64.getEncoder().encode(imgData));
%>
<jsp:include page="template/navbar.jsp" />
<div class="class-content">
	<div class="container" style="margin-top:50px">
	<div class="row">
		<div class="col-md-12">
			<h1><%=event.getEvent()%></h1><hr>
			<img src="data:image/gif;base64,<%=imgDataBase64%>" class="img-responsive" style="float:left;max-width:540px;padding-right:10px;padding-bottom:5px;" >
			<%=event.getIsi()%>
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