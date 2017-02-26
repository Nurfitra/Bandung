<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.bandung.bean.PostBean"%>
<%@ page import="net.bandung.dao.PostDao"%>
<%@ page import="java.util.*"%>
<html>

<title>Bandung | Beranda</title>

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
	//UserBean user = new UserBean();
	PostDao dao = new PostDao();
	List<PostBean> postList = dao.getLastPosts();
	//Iterator<UserBean> itr = userList.iterator();
%>
<jsp:include page="template/navbar.jsp" />
<div id="section1" style="background:url('assets/img/tebing-kraton.jpg')no-repeat center center fixed; -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;background-size: cover;">

	<div class="container">
      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron text-center" style="margin-top:110px;margin-bottom:110px;padding:40px;background:rgba(1,1,1,0.3);">
        <h1 style="color:#eee;font-weight:600">Visit <span style="color:rgba(41, 216, 70, 0.8);">Bandung</span></h1>
	
        <p style="color:#eee">Kota kembang merupakan sebutan lain untuk kota ini, karena pada zaman dulu kota ini dinilai sangat cantik dengan banyaknya pohon-pohon dan bunga-bunga yang tumbuh di sana. Selain itu Bandung dahulunya disebut juga dengan Parijs van Java karena keindahannya.</p>
      </div>
    </div> <!-- /container -->	
	
</div>
<div id="section2" >
	<div class="row" style="background:#29d846">
		<div class="text-center">
			<h4 style="color:#fff;padding-top:10px;padding-bottom:10px">Destinasi</h4>
		</div>
	</div>
	<div class="container">
	<div class="row" style="margin-top:20px">
		<%
			/*while(itr.hasNext())
			 {
			 System.out.println(user.getId());*/
			for (PostBean post : postList) {
		%>
		<div class="col-md-4">
			<img src="assets/img/seaworld.jpg" class="img-responsive" style="min-height:275px" >
			<h3 style="background:#eee;margin-top:0px;padding:10px;font-weight:900;margin-bottom:0px;padding-bottom:0px;border-top:2px solid #29d846;font-family:open"><strong></strong><%=post.getJudul()%></h3>
			<p  style="background:#eee;margin-top:0px;padding:10px"><%=post.getIsi()%></p>
			<a href="Index?page=destinasi&sort=detail&destinasiId=<%=post.getPid()%>"><button class="btn btn-block" style="background:#29d846;color:#fff">Read More..</button></a>
		</div>	
		<%
			}
			//}
		%>
	</div>
		
	</div>
	
	<div class="row">
		<div class="container">
		<hr>
			<div class="col-sm-12" >
				<div class="row">
					<h1>Bandung Map</h1>
					<div class="row"  style="background:#eee;padding-bottom:10px;margin-top:15px">
						<div class="col-md-12">
							<iframe style="padding:10px" src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d224322.9614295285!2d107.619079!3d-6.917420!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2suk!4v1435612345285" width="100%" height="400" frameborder="0" style="border:0" allowfullscreen></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="template/footer.jsp" />
</div>
</body>
</html>