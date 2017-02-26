<!DOCTYPE html>
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
                    <li>
                        <a href="Admin?action=listuser"><i class="fa fa-fw fa-users"></i> Users</a>
                    </li>
                    <li class="active">
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

                <div class="row pull-right">
                    <div class="col-lg-6">
                        <a href="#" class="btn btn-default">Back to List</a>
                    </div>
                </div>

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Destinasi <small>Add Destinasi</small>
                        </h1>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                    <div class="col-lg-6">
                        <form method="post" action="Admin?action=addDestinasi">
                            <div class="form-group">
                                <label>Nama Destinasi</label>
                                <input type="text" class="form-control" name="judul" placeholder="Nama Destinasi" required>
                            </div>
                            <div class="form-group">
                                <label>Gambar</label>
                                <input type="file" class="form-control">
                            </div>
                            <div class="form-group">
                                <label>Deskripsi</label>
                                <textarea class="form-control" rows="3" name="deskripsi" placeholder="Deskripsi" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Kategori</label>
                                <select class="form-control" name="kategori">
                                    <option value="alam">Alam</option>
                                    <option value="museum">Museum</option>
                                    <option value="taman">Taman</option>
                                    <option value="kuliner">Kuliner</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-default">Add</button>
                            <button type="reset" class="btn btn-default">Reset</button>
                        </form>
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
    <script src="assets/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/plugins/tinymce/tinymce.min.js"></script>
	<script>
	tinymce.init({ selector: 'textarea',
		  setup: function (editor) {
	      editor.on('change', function () {
	            editor.save();
	        });
	      },
		  height: 120,
		  menubar: false,
		  plugins: [
		    'advlist autolink lists link image charmap print preview anchor',
		    'searchreplace visualblocks code fullscreen',
		    'insertdatetime media table contextmenu paste code'
		  ],
		  toolbar: 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image', });
	</script>
</body>

</html>
