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
            <li class="active"><a href="#producttable" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i> View </a></li>
            <li><a href="#productadd" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i> Add/Edit Product</a></li>
			<li><a href="#productbulkupload" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i> Create bulk Product</a></li>
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
            <li class="active"><a href="#" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i> Stock Details </a></li>
            <li><a href="#" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i>Supplier Details</a></li>
			<li><a href="#venderdetails" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i>Vendor Details</a></li>
			<li><a href="#" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i>Invoice Details</a></li>
			<li><a href="#" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i>Offer Details</a></li>
            <li><a href="#" class="pull-center" data-toggle="tab"><i class="fa fa-circle-o"></i>Bulk Inventory Upload</a></li>         
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
            <li><a href="#"><i class="fa fa-circle-o"></i>Setup Menus</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Setup popular Collection</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Setup new Collection</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Setup price Chart</a></li>
			
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
        <li><a href="admin.php"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

    <!-- Main content -->
 <div class="col-md-12 container">
  
  <div  id="producttable" class="tab-pane fade">
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
	</div>
 </div>
 
 <div  id="productadd" class="tab-pane fade">
 	<div class="panel-body">
				
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
								href="#productvenderprice">Vender Price</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productimagedetails">Product Image</a></li>
						</ul>
						<div class="panel-body">
							<div class="tab-content col-md-10">
								<div id="productbasicdetails" class="tab-pane fade in active">
									
										<h3 style="text-align:center">Product Basic Details</h3>
										<div class="row">
										  <div class="col-xs-3 col-sm-3 col-md-3">
                                              
												<div class="form-group">
												<label for="productname">Product Name :</label>
													<input type="text" name="productname" id="productname"
														 class="form-control" 
														placeholder="Product Name">
											    </div>
												<div class="form-group">
												<label for="productid">Product Id:</label>
													<input type="text" name="productid" id="productid"
														 class="form-control" 
														placeholder="Product Id">
											    </div>
												<div class="form-group">
										         <label for="productmatterialtype">Product Matterial Type :</label>
												 <select class="form-control" id="productmatterialtype" name="productmatterialtype">
													<option>Select</option>
													<option>Gold</option>
													<option>Diamond</option>
                                                     <option>Silver</option>
                                                   </select>
												</div>
												</div>
												<div class="col-xs-3 col-sm-3 col-md-3">
												<div class="form-group">
												<label for="productcatagory">Product Category :</label>
													<select class="form-control" id="productcatagory" name="productcatagory">
														<option>Select</option>
														<option>Earring</option>
														<option>Pedant</option>
                                                       <option>Chain</option>
                                                    </select>
												</div>
												<div class="form-group">
												   <label for="subcatagory">Sub Catagory :</label>
												   <select class="form-control"id="subcatagory"name="subcatagory">
												     <option>Select</option>
												     <option>Necklace</option>
													 <option>Bracelet</option>
												   </select>
												  </div>
												  <div class="form-group">
												  <label for="purchasedate">Purchase Date :</label>
													<input type="text" name="purchasedate" id="purchasedate"
														class="form-control" 
														placeholder="Mfg Date">
												</div>
												
											</div>
										
											<div class="col-xs-3 col-sm-3 col-md-3">
												
												
												<div class="form-group">
												   <label for="productsize">Product Size:</label>
													<input type="text" name="productsize" id="productsize"
														class="form-control" 
														placeholder="">
												</div>
												<div class="form-group">
												<label for="barcode">Barcode:</label>
													<input type="text" name="barcode" id="barcode"
														class="form-control" 
														placeholder="Barcode">
												</div>
												<div class="form-group">
													    <label for="description">Description:</label>
														<input type="text" class="form-control" name="description" id="description">
												</div>
											 </div>
											
										</div>
								</div>

								<div id="productquntitydetails" class="tab-pane fade">

								<h3 style="text-align:center"> Quantity Details</h3>
									<div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3">
												<div class="form-group">
												   <label for="carat">Carat:</label>
												   <select class="form-control"id="carat"name="carat">
												     <option>Select</option>
												     <option>14KT</option>
													 <option>18KT</option>
													 <option>22KT</option>
													 <option>24KT</option>
												   </select>
												  </div>
													<div class="form-group">
												   <label for="stoneweight">Stone Weight</label>
													<input type="text" name="stoneweight" id="stoneweight"
														class="form-control" 
														placeholder="">
												    </div>
													
													<div class="form-group">
												   <label for="stonecolor">Stone Color:</label>
												   <select class="form-control"id="stonecolor"name="stonecolor">
												     <option>Select</option>
												     <option>Yellow</option>
													 <option>White</option>
													 <option>Pink</option>
													 <option>Diamond</option>
												   </select>
												  </div>
												  <div class="form-group">
												   <label for="venderid">Vender Id:</label>
													<input type="text" name="venderid" id="venderid"
														class="form-control" 
														placeholder="">
												  </div>
												  <div class="form-group">
												   <label for="venderprice">Vender Price:</label>
													<input type="text" name="venderprice" id="venderprice"
														class="form-control" 
														placeholder="">
												 </div>
													
												</div>
												<div class="col-xs-3 col-sm-3 col-md-3">
												 <div class="form-group">
												   <label for="netweight">Net Weight:</label>
													<input type="text" name="netweight" id="netweight"
														class="form-control" 
														placeholder="">
												  </div>
												  <div class="form-group">
												   <label for="stonepcs">Stone Pcs:</label>
													<input type="text" name="stonepcs" id="stonepcs"
														class="form-control" 
														placeholder="">
												    </div>
												
												  <div class="form-group">
												   <label for="meenaweight">Meena Weight:</label>
													<input type="text" name="meenaweight" id="meenaweight"
														class="form-control" 
														placeholder="">
														</div>
														<div class="form-group">
												   <label for="vatprice">VAT Price:</label>
													<input type="text" name="vatprice" id="vatprice"
														class="form-control" 
														placeholder="">
												  </div>
												</div>
											<div class="col-xs-3 col-sm-3 col-md-3">
												 <div class="form-group">
												   <label for="pureweight">Pure Weight:</label>
													<input type="text" name="pureweight" id="pureweight"
														class="form-control" 
														placeholder=""readonly>
												  </div>
												
												  <div class="form-group">
												   <label for="grossweight">Gross Weight:</label>
													<input type="text" name="grossweight" id="grossweight"
														class="form-control" 
														placeholder="">
												</div>
												 <div class="form-group">
												   <label for="wastage">Wastage:</label>
													<input type="text" name="wastage" id="wastage"
														class="form-control" 
														placeholder="">
												  </div>
												  
												  <div class="form-group">
												   <label for="vendername">Vender Name:</label>
													<input type="text" name="vendername" id="vendername"
														class="form-control" 
														placeholder="">
												  </div>
												  
												  
											</div>
											<div class="col-xs-3 col-sm-3 col-md-3">
												  
												  <div class="form-group">
												   <label for="makingcharges">Making Charges:</label>
													<input type="text" name="makingcharges" id="makingcharges"
														class="form-control" 
														placeholder="">
												  </div>
												 <div class="form-group">
												   <label for="mrpprice">MRP Price:</label>
													<input type="text" name="mrpprice" id="mrpprice"
														class="form-control" 
														placeholder="">
												 </div>
												  
												   <div class="form-group">
												   <label for="totalprice">Sell Price:</label>
													<input type="text" name="totalprice" id="totalprice"
														class="form-control" 
														placeholder="">
												 </div>
												 <div class="form-group">
												   <label for="stoneprice">Stone Price:</label>
													<input type="text" name="stoneprice" id="stoneprice"
														class="form-control" 
														placeholder="">
												  </div>
												  
											</div>
										</div>
								</div>

								<div id="productpricedetails" class="tab-pane fade">

									<h3 style="text-align:center">Price Details</h3>
									<div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3 ">
												<div class="form-group">
												   <label for="venderid">Vender Id:</label>
													<input type="text" name="venderid" id="venderid"
														class="form-control" 
														placeholder="">
												  </div>
												  <div class="form-group">
												   <label for="vendername">Vender Name:</label>
													<input type="text" name="vendername" id="vendername"
														class="form-control" 
														placeholder="">
												  </div>
												  <div class="form-group">
												   <label for="venderprice">Vender Price:</label>
													<input type="text" name="venderprice" id="venderprice"
														class="form-control" 
														placeholder="">
												 </div>
											</div>
											<div class="col-xs-3 col-sm-3 col-md-3 ">
											    <div class="form-group">
												   <label for="mrpprice">MRP Price:</label>
													<input type="text" name="mrpprice" id="mrpprice"
														class="form-control" 
														placeholder="">
												 </div>
											  <div class="form-group">
												   <label for="totalprice">Sell Price:</label>
													<input type="text" name="totalprice" id="totalprice"
														class="form-control" 
														placeholder="">
												 </div>
												 <div class="form-group">
												   <label for="stoneprice">Stone Price:</label>
													<input type="text" name="stoneprice" id="stoneprice"
														class="form-control" 
														placeholder="">
												  </div>
													
											 </div>
											<div class="col-xs-3 col-sm-3 col-md-3" >
											 
												 <div class="form-group">
												   <label for="makingcharges">Making Charges:</label>
													<input type="text" name="makingcharges" id="makingcharges"
														class="form-control" 
														placeholder="">
												  </div>
												  <div class="form-group">
												   <label for="vatprice">VAT Price:</label>
													<input type="text" name="vatprice" id="vatprice"
														class="form-control" 
														placeholder="">
												  </div>
												  <div class="form-group">
												   <label for="hmtagprice">HM Tag Price:</label>
													<input type="text" name="totalcostprice" id="totalcostprice"
														class="form-control" 
														placeholder="">
												 </div>
												 
												 
											</div>
									</div>
								</div>

								<div id="productdescdetails" class="tab-pane fade">
								
    
                           <h3 style="text-align:center">Description Details</h3>
									<div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3 ">
													<div class="form-group">
													 <label for="brand">Brand:</label>
													<input type="text" name="brand" id="brand"
														class="form-control" 
														placeholder="">
												    </div>
												  <div class="form-group">
													 <label for="metal">Metal:</label>
												<select class="form-control"id="metal"name="metal">
												     <option>Select</option>
												     <option>Gold</option>
													 <option>Silver</option>
												   </select>
												    </div>
													<div class="form-group">
													 <label for="metalcolor">Metal Color:</label>
														<select class="form-control"id="metalcolor"name="metalcolor">
												     <option>Select</option>
												     <option>Yellow</option>
													 <option>Silver</option>
													 <option>Bicolor</option>
												   </select>
												    </div>
													<div class="form-group">
													 <label for="gender">Gender:</label>
													<select class="form-control"id="gender"name="gender">
												     <option>Select</option>
												     <option>Men</option>
													 <option>Women</option>
													 <option>Kids</option>
												   </select>
												   </div>
											</div>
											<div class="col-xs-3 col-sm-3 col-md-3 ">
												<div class="form-group">
													 <label for="karatage">Gold Karatage</label>
													<select class="form-control"id="karatage"name="karatage">
												     <option>Select</option>
												     <option>14KT</option>
													 <option>18KT</option>
													 <option>22KT</option>
													 <option>24KT</option>
												   </select>
												    </div>
													<div class="form-group">
													 <label for="productstyle">Style:</label>
													<select class="form-control"id="productstyle"name="productstyle">
												     <option>Select</option>
												     <option>Stud</option>
													 <option>Hoop</option>
													 <option>Jhumka</option>
													 <option>Drop</option>
												   </select>
												    </div>
													<div class="form-group">
													 <label for="jewellerytype">Jewellery Type:</label>
													<input type="text" name="jewellerytype" id="jewellerytype"
														class="form-control" 
														placeholder="">
												    </div>
													<div class="form-group">
													 <label for="tagnumber">Tag Number:</label>
													<input type="text" name="tagnumber" id="tagnumber"
														class="form-control" 
														placeholder="">
												    </div>
											</div>
										</div>
								</div>
								<div id="productvenderprice" class="tab-pane fade">
                                           <h3 style="text-align:center">Vender Price</h3>
									<div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3">
													<div class="form-group">
													 <label for="stonepieces">Stone Pieces:</label>
													<input type="text" name="stonepieces" id="stonepieces"
														class="form-control" 
														placeholder="">
												    </div>
												  <div class="form-group">
													 <label for="stoneweight">Stone Weight</label>
												<input type="text" name="stoneweight" id="stoneweight"
														class="form-control" 
														placeholder="">
												    </div>
													<div class="form-group">
													   <label for="stonecostprice">Stone Cost Price:</label>
														<input type="text" name="stonecostprice" id="stonecostprice"
														class="form-control" 
														placeholder="">
												    </div>
													<div class="form-group">
													 <label for="makingcharges">Making Charges:</label>
														<input type="text" name="makingcharges" id="makingcharges"
														class="form-control" 
														placeholder="">
												    </div>
											</div>
											<div class="col-xs-3 col-sm-3 col-md-3 col-xs-offset-2 col-sm-offset-2 col-md-offset-2">
												<div class="form-group">
													 <label for="purity">Purity</label>
													<select class="form-control"id="purity"name="purity">
												     <option>Select</option>
												     <option>14KT</option>
													 <option>18KT</option>
													 <option>22KT</option>
													 <option>24KT</option>
												   </select>
												    </div>
													<div class="form-group">
													 <label for="hmtagprice">HM Tag Price</label>
													<input type="text" name="hmtagprice" id="hmtagprice"
														class="form-control" 
														placeholder="">
												    </div>
													<div class="form-group">
													 <label for="vatprice">Vat Price:</label>
													<input type="text" name="vatprice" id="vatprice"
														class="form-control" 
														placeholder="">
												    </div>
													<div class="form-group">
													 <label for="totalcostprice">Total Cost Price:</label>
													<input type="text" name="totalcostprice" id="totalcostprice"
														class="form-control" 
														placeholder="">
												    </div>
											</div>
										</div>
								</div>

								
									<div id="productimagedetails" class="tab-pane fade">

									<h3 style="text-align:center">Product Image</h3>
									<div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3">
												
												<div class="form-group">
												   <img src="C:\xampplite\htdocs\jewelry\assets\images\image1.jpg" class="img-rounded" alt="Image1" width="100" height="100"> 
												   <img src="C:\xampplite\htdocs\jewelry\assets\images\image1.jpg" class="img-rounded" alt="Image1" width="100" height="100"> 
												   <img src="C:\xampplite\htdocs\jewelry\assets\images\image1.jpg" class="img-rounded" alt="Image1" width="100" height="100"> 
												</div>
												

											</div>
											 <div class="col-xs-3 col-sm-3 col-md-3 col-xs-offset-2 col-sm-offset-2 col-md-offset-2">
												  <div class="form-group">
												     <img src="jewellary.jpg" class="img-rounded" alt="Jewellary Image" width="304" height="236"> 
												  </div>
                                               </div>
										</div>
								</div>
							
					       </div>
				    </div>
			      </div>
			  </div>
	</div>
 </div>

 <div class="col-md-12 container" id="productbulkupload" class="tab-pane fade">
</div>

<div id="venderdetails" class="tab-pane fade">
<div class="panel-body">

									<h3 style="text-align:center">Vender Details</h3>
									  <div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3">
												
												<div class="form-group">
												   <label for="vendername">Vender Name:</label>
													<input type="text" name="vendername" id="vendername"
														class="form-control" 
														placeholder="">
												</div>
												<div class="form-group">
												<label for="address">Address:</label>
													<input type="textarea" name="address" id="address"
														class="form-control" 
														placeholder="">
												</div>
												<div class="form-group">
												<label for="mobilenumber">Mobile Number:</label>
													<input type="text" name="mobile" id="mobilenumber"
														class="form-control" 
														placeholder="">
												</div>
												<div class="form-group">
												<label for="email">Email:</label>
													<input type="text" name="email" id="email"
														class="form-control" 
														placeholder="">
												</div>

											</div>
											 <div class="col-xs-3 col-sm-3 col-md-3 ">
												  
												  <div class="form-group">
												   <label for="organisation">Organisation:</label>
													<input type="text" name="organisation" id="organisation"
														class="form-control" 
														placeholder="">
												</div>
												<div class="form-group">
												   <label for="bankname">Bank Name:</label>
													<input type="text" name="bankname" id="bankname"
														class="form-control" 
														placeholder="">
												</div>
												<div class="form-group">
												   <label for="ifsccode">IFSC code:</label>
													<input type="text" name="ifsccode" id="ifsccode"
														class="form-control" 
														placeholder="">
												  </div>
												<div class="form-group">
												   <label for="accountnumber">Account Number:</label>
													<input type="text" name="accountnumber" id="accountnumber"
														class="form-control" 
														placeholder="">
												</div>
											 </div>
										</div>
								</div>
								</div>
</div>
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
</div>
  </html>