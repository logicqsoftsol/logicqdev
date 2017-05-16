
<?php
if (!session_id()) session_start();
if (!$_SESSION['logon']){
	header("Location:index.php");
	die();
}
?>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>DD Jewellery | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="assets/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="assets/css/skins/_all-skins.min.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <!-- jQuery 2.2.3 -->
<script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- AdminLTE App -->
<script src="assets/js/app.min.js"></script>
<script src="assets/js/custom.js"></script>
<style>
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="admin.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>DD</b>JL</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>DD</b>Jewellery</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
        <a href="index.php" class="btn btn-default btn-sm">
          <span class="glyphicon glyphicon-log-out"></span> Log out
        </a>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="images/admin_pic.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>Admin </p>
          
        </div>
      </div>

      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu">
        <li class="active treeview">
          <a href="">
            <i class="fa fa-dashboard"></i> <span>Menu Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="active treeview-menu">
            <li class="active"><a href="#"><i class="fa fa-circle-o"></i> View/Edit/Delete Menus </a></li>
            <li ><a href="add_menu_submenu.php"><i class="fa fa-circle-o"></i> Add Menus</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Product Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li ><a href="view_edit_delete_product.html"><i class="fa fa-circle-o"></i> View/Edit/Delete Products</a></li>
            <li><a href="add_product.html"><i class="fa fa-circle-o"></i> Add Products</a></li>
          </ul>
        </li>
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        View Menu Details
        <small>View / Edit / Delete Menus</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li><a href="#">Menu Details</a></li>
        <li class="active">View/Edit/Delete Menus</li>
      </ol>
    </section>
    <!-- Main content -->
 <section class="content" >
 <div class="col-md-12 container">
 <div class="panel-heading">
							<!--ul class="pull-right">
								<button id="adddetails" data-toggle="modal" data-target="#productregmodel"
									class="btn btn-default">
									<i class="fa fa-plus-circle" aria-hidden="true"></i>ADD
								</button>
								
								
							</ul-->
						</div>
						<div class="panel-body">
						 <div class="table-responsive">
						 
				
  <table class="table table-bordered table-fixed table-hover">
 
					<!--ul class="pagination pull-left" num-pages="tasks.pageCount"
										current-page="tasks.currentPage">
										<li ng-class="{disabled: noPrevious()}"><a
											ng-click="searchAllSubjectListAccordingToPage()">&laquo;</a></li>
										<li ng-repeat="page in pages"
											ng-class="{active: isActive(page)}"><a
											ng-click="searchAllSubjectListAccordingToPage(page)">1</a></li>
										<li ng-class="{disabled: noNext()}"><a
											ng-click="searchAllSubjectListAccordingToPage()">&raquo;</a></li>
									</ul-->	
   
    <tr class ="success">
		<th class="pull-center">Main Menu</th>
		<th class="pull-center">Sub Menu Header</th>
		<th class="pull-center">Sub Menu</th>
		
	</tr>
	<?php
								 error_reporting( ~E_NOTICE );
								 require_once 'dbconfig.php';
								 
								 $stmt = $DB_con->prepare('SELECT * FROM menu_details ORDER BY id ASC');
								 $stmt->execute();
								 
								 if($stmt->rowCount() > 0)
								 {
								  while($row=$stmt->fetch(PDO::FETCH_ASSOC))
								  {
								   extract($row);
								?>
	
      <tr>
        <td><?php echo $row['displayname']; ?></td>
        <td><?php echo $row['type']; ?></td>
        <td><a data-toggle="modal" data-target="#Editmodel" href="#Editmodel"><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a class="btn btn-danger" href="deletemenus.php?delete_id=<?php echo $row['id']; ?>" title="click for delete" onclick="return confirm('sure to delete ?')"><span class="glyphicon glyphicon-remove-circle"></span> Delete</a></td>
        
	  </tr>
      <?php
			}
		}
      ?>
  </table>
  
  
   </div>
  </div>
</div>
</section>

 </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; 2017-2018 <a href="http://logicqsoftsol.com">Logicq softsol pvt. ltd </a>.</strong> All rights
    reserved.
  </footer>

 <aside>
 
  </aside>
</div>

<div id="Editmodal" class="modal fade" role="dialog" >
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Edit Menu Details</h4>	
						</div>
					
						<div class="modal-body">
				<div class="row">
					<br> <br>
					<div class="panel with-nav-tabs panel-success">
						
						
						<div class="panel-body">
						
							<form method="post" action="">
							Name:<input type="text" name="name" value="<?php echo $query2['name']; ?>" /><br />
							Age:<input type="text" name="age" value="<?php echo $query2['age']; ?>" /><br /><br />
							<br />
							<input type="submit" name="submit" value="update" />
							</form>

						 
						</div>
							
						</div>
					</div>
				</div>
			</div>
			   <div class="modal-footer">
							<button type="submit" id="usersearch" class="btn btn-default" ng-click="downloadAttendaceReport()"
								data-dismiss="modal"><i class="fa fa-check-circle" aria-hidden="true"></i>Confirm</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Close</button>
						</div>
			</div>
  
			</div>
			</div><!---End of Modal Product Reg  details-->

</body>			
  </html>