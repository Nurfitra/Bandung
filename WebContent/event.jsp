<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.bandung.bean.EventBean"%>
<%@ page import="net.bandung.dao.EventDao"%>
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
	//PostBean post = new PostBean();
	EventDao dao = new EventDao();
	String cat = request.getParameter("sort");
%>
<jsp:include page="template/navbar.jsp" />
<div class="class-content">
	<div class="container" style="margin-top:50px">
	<h1>Event di Bandung</h1>
	<hr>
	<div class="row">
		<%
			List<EventBean> postList = dao.getAllEvents();
			for (EventBean post : postList) {
		%>
		<div class="col-md-4">
			<img src="assets/img/seaworld.jpg" class="img-responsive" style="min-height:275px" >
			<h3 style="background:#eee;margin-top:0px;padding:10px;font-weight:900;margin-bottom:0px;padding-bottom:0px;border-top:2px solid #29d846;font-family:open"><strong></strong><%=post.getEvent()%></h3>
			<p  style="background:#eee;margin-top:0px;padding:10px"><%=post.getIsi().replaceAll("\\<[^>]*>","").substring(0,150)%></p>
			<a href="Index?page=event&sort=detail&eventId=<%=post.getEid()%>"><button class="btn btn-block" style="background:#29d846;color:#fff">Read More..</button></a>
		</div>		
		<%
			}
		%>
	</div>
		
	</div>
	
	<jsp:include page="template/footer.jsp" />
</div>
</body>
</html>