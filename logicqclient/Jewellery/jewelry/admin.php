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
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>DD</b>JL</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>DD</b>Jewellery</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="admin.html" class="sidebar-toggle" data-toggle="offcanvas" role="button">
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
       
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Product Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="product_details.html"><i class="fa fa-circle-o"></i> View </a></li>
            <li><a href="addmenu_page.php"><i class="fa fa-circle-o"></i> Add/Edit Product</a></li>
			<li><a href="addmenu_page.php"><i class="fa fa-circle-o"></i> Create bulk Product</a></li>
          </ul>
        </li>
		 <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Inventory Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="#"><i class="fa fa-circle-o"></i> Stock Details </a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Supplier Details</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Vendor Details</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Invoice Details</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Offer Details</a></li>
            <li><a href="view_edit_delete.php"><i class="fa fa-circle-o"></i>Bulk Inventory Upload</a></li>         
		 </ul>
        </li>
		 <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Customer Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="#"><i class="fa fa-circle-o"></i> View Details </a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Add</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Recent Orders</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Transaction Details</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Feedback/Review Details</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Payment Details</a></li>
	      </ul>
        </li>
			 <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>User Settings</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li class="active"><a href="#"><i class="fa fa-circle-o"></i>Create User</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Assigne Role</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Setup SMS/Email</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Setup Offer</a></li>
			 <li class="treeview">
          <a href="">
            <i class="fa fa-dashboard"></i> <span>Admin Operation Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="view_edit_delete.php"><i class="fa fa-circle-o"></i>Setup Menus</a></li>
			<li><a href="view_edit_delete.php"><i class="fa fa-circle-o"></i>Setup popular Collection</a></li>
			<li><a href="view_edit_delete.php"><i class="fa fa-circle-o"></i>Setup new Collection</a></li>
			<li><a href="view_edit_delete.php"><i class="fa fa-circle-o"></i>Setup price Chart</a></li>
			
			<li><a href="view_edit_delete.php"><i class="fa fa-circle-o"></i>Audit info</a></li>
           </ul>
         </li>
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
        Welcome to DD Jewellery ADMIN Page
      </h1>
      <ol class="breadcrumb">
        <li><a href="admin.html"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
 
<section class="content" >
 <div class="col-md-12 container">
 <!--div class="panel-heading">
							<ul class="pull-right">
								<button id="adddetails" data-toggle="modal" data-target="#productregmodel"
									class="btn btn-default">
									<i class="fa fa-plus-circle" aria-hidden="true"></i>ADD
								</button>
								
								
							</ul>
						</div>
						<div class="panel-body">
						 <div class="table-responsive">
  <table class="table table-bordered table-fixed table-hover">
 
					<ul class="pagination pull-left" num-pages="tasks.pageCount"
										current-page="tasks.currentPage">
										<li ng-class="{disabled: noPrevious()}"><a
											ng-click="searchAllSubjectListAccordingToPage()">&laquo;</a></li>
										<li ng-repeat="page in pages"
											ng-class="{active: isActive(page)}"><a
											ng-click="searchAllSubjectListAccordingToPage(page)">1</a></li>
										<li ng-class="{disabled: noNext()}"><a
											ng-click="searchAllSubjectListAccordingToPage()">&raquo;</a></li>
									</ul>	
   
    <tr class ="success">
		<th class="pull-center">NAME</th>
		<th class="pull-center">CATEGORY</th>
		<th class="pull-center">AVAILABEL QUANTITY</th>
		<th class="pull-center">PRICE</th>
		<th class="pull-center">INVENTORY LAST UPDATE</th>
	</tr>
      <tr>
        <td>Gold</td>
        <td>Necklace</td>
        <td>2kg</td>
		<td>3000000</td>
		<td>12/04/17</td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
        
		</tr>
      <tr>
         <td>Diamond</td>
        <td>Ring</td>
        <td>10gm</td>
        <td>600000</td>
		<td>12/04/17</td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
      </tr>
      <tr>
         <td>Silver</td>
        <td>Bracelet</td>
        <td>2kg</td>
        <td>1000000</td>
		<td>18/04/17</td>
        <td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
      </tr>
  </table>
   </div>
  </div-->
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
</body>

<div id="productregmodel" class="modal fade" role="dialog">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Product Registartion Details</h4>	
						</div>
					
						<div class="modal-body">
				<div class="row">
					<br> <br>
					<div class="panel with-nav-tabs panel-success">
						
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" class="pull-center"
								href="#productbasicdetails">Product Basic Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productquntitydetails">Quantity Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productpricedetails">Price Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productdescdetails">Description Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productvenderdetails">Vender Details</a></li>
						</ul>

						<div class="panel-body">
							<div class="tab-content col-md-12">
								<div id="productbasicdetails" class="tab-pane fade in active">
									
										<h4>Product Basic Details</h4>
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">

												<div class="form-group">
													<input type="text" name="pname" id="pname"
														 class="form-control" 
														placeholder="Product Name">
													
												</div>

												<div class="form-group">
													<input type="text" name="type" id="typename"
														class="form-control" 
														placeholder="Product Type">
														<datalist id="datalisttypename">
														<option>Gold</option>
														<option>Silver</option>
													</datalist>
												</div>
												<div class="form-group">
													<input type="text" name="Category" id="cgname"
														class="form-control" 
														placeholder="Catagory">
														<datalist id="datalistcategory">
														<option>Gold</option>
														<option>Silver</option>
													</datalist>
												</div>
												<div class="form-group">
													<input type="text" name="scategory" id="scategory"
														class="form-control" 
														placeholder="Sub Catagory">
												    </div>
											</div>
										<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="text" name="createdate" id="createdate"
														class="form-control" 
														placeholder="Creation Date">
												</div>
												<div class="form-group">
													<input type="text" name="mfgdate" id="mfgdate"
														class="form-control" 
														placeholder="Mfg Date">
												</div>
												<div class="form-group">
													<input type="text" name="expdate" id="expdate"
														class="form-control" 
														placeholder="Exp Date">
												</div>
												<div class="form-group">
													<input type="textarea" name="desc" id="desc"
														class="form-control" 
														placeholder="Description">
												    </div>
											</div>
										</div>		
										</div>
								</div>

								<div id="productquntitydetails" class="tab-pane fade">

									<h4> Quantity Details</h4>
									<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												
													<div class="form-group">
													<input type="text" name="s" id="scategory"
														class="form-control" 
														placeholder="Sub Catagory">
												    </div>

											</div>
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="textarea" name="desc" id="desc"
														class="form-control" 
														placeholder="Description">
												    </div>
											</div>
										</div>
								</div>

								<div id="productpricedetails" class="tab-pane fade">

									<h4>Price Details</h4>
									<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												
													<div class="form-group">
													<input type="text" name="scategory" id="scategory"
														class="form-control" 
														placeholder="Sub Catagory">
												    </div>
													<div class="form-group">
													<input type="text" name="scategory" id="scategory"
														class="form-control" 
														placeholder="Sub Catagory">
												    </div>
													<div class="form-group">
													<input type="textarea" name="desc" id="desc"
														class="form-control" 
														placeholder="Description">
												    </div>
											</div>
									</div>
								</div>

								<div id="productdescdetails" class="tab-pane fade">
								
    
                           <h4>Description Details</h4>
									<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												
													<div class="form-group">
													<input type="text" name="descname" id="descname"
														class="form-control" 
														placeholder="Product Name">
												    </div>

											</div>
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="color" name="color "id=""
														class="form-control"> 
														
												    </div>
											</div>
										</div>
								</div>

								<div id="productvenderdetails" class="tab-pane fade">

									<h4>Vender Details</h4>
									<div class="row">
											<div class="col-xs-6 col-sm-6 col-md-6">
												
													<div class="form-group">
													<input type="text" name="scategory" id="scategory"
														class="form-control" 
														placeholder="Sub Catagory">
												    </div>

											</div>
											<div class="col-xs-6 col-sm-6 col-md-6">
												<div class="form-group">
													<input type="textarea" name="desc" id="desc"
														class="form-control" 
														placeholder="Description">
												    </div>
											</div>
										</div>
								</div>
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
			
  </html>