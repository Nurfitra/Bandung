<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.bandung.bean.UserBean"%>
<%@ page import="net.bandung.dao.UserDao"%>
<%@ page import="java.util.*"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Bootstrap Admin Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="assets/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="assets/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<%
	//UserBean user = new UserBean();
	UserDao dao = new UserDao();
	List<UserBean> userList = dao.getAllUsers();
	//Iterator<UserBean> itr = userList.iterator();
	
	String username = (String)request.getSession().getAttribute("username"); 
%>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        	<jsp:include page="template/navbar.jsp" />
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="Admin"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li class="active">
                        <a href="Admin?action=listuser"><i class="fa fa-fw fa-users"></i> Users</a>
                    </li>
                    <li>
                        <a href="Admin?action=listdestinasi"><i class="fa fa-fw fa-table"></i> Destinasi</a>
                    </li>
                    <li>
                        <a href="Admin?action=listevent"><i class="fa fa-fw fa-table"></i> Event</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Users <small>Manage Users</small>
                        </h1>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                    <div class="col-lg-6">
                        <a href="Admin?action=useradd" class="btn btn-primary">Add User</a>
                    </div>
                </div><br/>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>Username</th>
                                        <th>Email</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
										/*while(itr.hasNext())
										 {
										 System.out.println(user.getId());*/
										int no = 1;
										for (UserBean user : userList) {
									%>
                                    <tr>
                                        <td><%=no%></td>
                                        <td><%=user.getUname()%></td>
                                        <td><%=user.getEmail()%></td>
                                        <td>
                                        <a href="Admin?action=editform&userId=<%=user.getId()%>" class="btn btn-xs btn-success">Edit</a>
                                        <a href="Admin?action=deleteuser&userId=<%=user.getId()%>" class="btn  btn-xs  btn-danger">Hapus</a>
                                        </td>
                                    </tr>
									<%
									no += 1;
									}
										//}
									%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="assets/js/jquerydash.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="assets/js/bootstrap.min.js"></script>
</body>

</html>
