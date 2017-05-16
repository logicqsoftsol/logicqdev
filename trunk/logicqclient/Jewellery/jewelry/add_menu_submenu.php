
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
#submenu_mainmenu{
	display:none;
}
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
            <li ><a href="view_edit_delete.php"><i class="fa fa-circle-o"></i> View/Edit/Delete Menus </a></li>
            <li class="active"><a href="#"><i class="fa fa-circle-o"></i> Add Menus</a></li>
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
        Add Menus
        <small>Main Menu, Sub Menu Header and Sub Menu</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
		<li><a href="#">Menu Details</a></li>
        <li class="active">Add Menus</li>
      </ol>
    </section>

    <!-- Main content -->
 <section class="content" >
 <div class="col-md-6 container">
 <div class="panel-heading">
							<h3>Add Main Menu Items</h3>
						</div>
 <div class="panel-body">
 
 <p><span class="error">Enter New Main Menu and its Sub Menus</span></p>
 
 <form method="post" enctype="multipart/form-data" class="form-horizontal" id="add_main_menu"  action="add_menu.php">
     
			 <table class="table table-bordered table-responsive">
			 
				<tr>
				 <td><label class="control-label">Title</label></td>
					<td><input class="form-control" type="text" name="mainmenu_name" id="mainmenu_name" placeholder="Enter Main Menu" value="" /></td>
				</tr>
				<tr>
				 <td><label class="control-label">Is Submenu Need </label></td>
					<td>
					<select name="submenu_select" id="submenu_select" class="form-control">
						<option selected="selected" value="">Select</option>    
						<option value="Yes">Yes</option>
						<option value="No">No</option>
					</select>
					</td>
				</tr>
				<tr id="submenu_mainmenu">
					<tr>
					<td><label class="control-label">Sub Menu Header </label></td>
					<td><input type="text" name="submenu_headername" class="form-control" placeholder="Sub Menu Header Name" value=""></td>
					</tr>
					<tr>
					<td><label class="control-label">Sub Menu </label></td>
					<td><input type="text" name="submenu_name" class="form-control" placeholder="Sub Menu Name" value=""></td>
					</tr>
				</tr>
			  <!--/div-->
				<tr>
					<td colspan="2"><button type="submit" name="add_main_menu" class="btn btn-primary"> Add Main Menu </button>
					</td>
				</tr>
				
				</table>
				
		</form>
	

 <!--form method="post" action="add_menu.php">  
  <div class="row">
	<div class="col-xs-6 col-sm-6 col-md-6"> 
			<div class="form-group">
				<label> Main Menu </label> <input type="text" name="mainmenu_name" id="mainmenu_name" class="form-control" placeholder="Main Menu Name" value="">
			</div>
			<div class="form-group">
			<label>Is Submenu Need </label>
			<select name="submenu_select" id="submenu_select" class="form-control">
			<option selected="selected" value="">Select</option>    
			<option value="Yes">Yes</option>
			<option value="No">No</option>
		  
			</select>
			</div>

			<!-- Dynamically Added DIV for Sub Menu >
			<div id="submenu_mainmenu">
			  <!--div class="col-xs-6 col-sm-6 col-md-6"> 
			  <div class="form-group">
			  <label>Sub Menu Header </label> <input type="text" name="submenu_headername" class="form-control" placeholder="Sub Menu Header Name" value=""> </div>
			  <div class="form-group">
			  <label>Sub Menu </label><input type="text" name="submenu_name" class="form-control" placeholder="Sub Menu Name" value=""></div>
			  <!--/div>
			</div>
			<div class="form-group">
				<!--button type="submit" class="btn btn-default" name="add_main_menu">Add Main_Menu</button>
				<input type="submit" name="add_main_menu" class="btn btn-default" value="Add Main_Menu">
			</div>
	</div>
	
    
  </div>
  </form -->
  </div>
  </div>
  <div class="col-md-6 container">
 <div class="panel-heading">
							<h3>Add Sub Menu Items</h3>
						</div>
 <div class="panel-body">
 
	<p><span class="error"> Enter New Sub Menu Header and its Sub Menu</span></p>
 

 <form method="post" action="add_menu.php" id="add_sub_menu">  
  <div class="row">
	<div class="col-xs-6 col-sm-6 col-md-6"> 
			<div class="form-group">
				<label>Select Main Menu </label>
				<select name="mainmenu_select" id="mainmenu_select" class="form-control">
				<?php 

												error_reporting( ~E_NOTICE );
												 require_once 'dbconfig.php';
												 
												 $stmt = $DB_con->prepare('SELECT * FROM menu_details ORDER BY id ASC');
												 $stmt->execute();
												 
												 if($stmt->rowCount() > 0)
												 {
												  //echo "sucess";
												  while($row=$stmt->fetch(PDO::FETCH_ASSOC))
												  {
												   extract($row);
												

				?>
								


				<option value="<?php echo $row['id']; ?>"><?php echo $row['displayname']; ?></option>
								<!--input type="text" name="mainmenu_name" id="mainmenu_name" class="form-control" placeholder="Main Menu Name" value="" -->
				<?php 
					}
				}

				 ?>			
				</select>


			</div>
			<div class="form-group">
			  <label>Sub Menu Header </label> <input type="text" name="submenu_headername" class="form-control" placeholder="Sub Menu Header Name" value=""> 
			</div>
			
			<div class="form-group">
			  <label>Sub Menu </label> <input type="text" name="submenu_name" class="form-control" placeholder="Sub Menu Name" value="">
			</div>
			
			<div class="form-group">
				<button type="submit" name="add_sub_menu" class="btn btn-primary"> ADD Sub Menu </button>
				<!--input type="submit" name="add_main_menu" class="form-control" value="Add Main_Menu"-->
			</div>
	</div>
	
    
  </div>
  </div>
  </div>
  </form>

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

<script type="text/javascript">
var value = document.getElementById("submenu_select");
value.onchange = function(){
	var hidetr = document.getElementById("submenu_mainmenu");
	hidetr.style.display = (this.value == "Yes") ? "block":"none";
}

</script>


</body>

			
  </html>