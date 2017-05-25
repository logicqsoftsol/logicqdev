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
<link rel="stylesheet" href="assets/css/dropzone.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="assets/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="assets/css/elements.css">
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
		<!-- page specific plugin scripts -->
<script src="assets/js/dropzone.min.js"></script>
<script src="assets/js/app.min.js"></script>
<script src="assets/js/custom.js"></script>
<!-- inline scripts related to this page -->
		<script type="text/javascript">
			jQuery(function($){
			
			try {
			  Dropzone.autoDiscover = false;
			
			  var myDropzone = new Dropzone('#dropzone', {
			    previewTemplate: $('#preview-template').html(),
			    
				thumbnailHeight: 120,
			    thumbnailWidth: 120,
			    maxFilesize: 0.5,
				
				//addRemoveLinks : true,
				//dictRemoveFile: 'Remove',
				
				dictDefaultMessage :
				'<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> Drop files</span> to upload \
				<span class="smaller-80 grey">(or click)</span> <br /> \
				<i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>'
			,
				
			    thumbnail: function(file, dataUrl) {
			      if (file.previewElement) {
			        $(file.previewElement).removeClass("dz-file-preview");
			        var images = $(file.previewElement).find("[data-dz-thumbnail]").each(function() {
						var thumbnailElement = this;
						thumbnailElement.alt = file.name;
						thumbnailElement.src = dataUrl;
					});
			        setTimeout(function() { $(file.previewElement).addClass("dz-image-preview"); }, 1);
			      }
			    }
			
			  });
			
			
			  //simulating upload progress
			  var minSteps = 6,
			      maxSteps = 60,
			      timeBetweenSteps = 100,
			      bytesPerStep = 100000;
			
			  myDropzone.uploadFiles = function(files) {
			    var self = this;
			
			    for (var i = 0; i < files.length; i++) {
			      var file = files[i];
			          totalSteps = Math.round(Math.min(maxSteps, Math.max(minSteps, file.size / bytesPerStep)));
			
			      for (var step = 0; step < totalSteps; step++) {
			        var duration = timeBetweenSteps * (step + 1);
			        setTimeout(function(file, totalSteps, step) {
			          return function() {
			            file.upload = {
			              progress: 100 * (step + 1) / totalSteps,
			              total: file.size,
			              bytesSent: (step + 1) * file.size / totalSteps
			            };
			
			            self.emit('uploadprogress', file, file.upload.progress, file.upload.bytesSent);
			            if (file.upload.progress == 100) {
			              file.status = Dropzone.SUCCESS;
			              self.emit("success", file, 'success', null);
			              self.emit("complete", file);
			              self.processQueue();
			            }
			          };
			        }(file, totalSteps, step), duration);
			      }
			    }
			   }
			
			   
			   //remove dropzone instance when leaving this page in ajax mode
			   $(document).one('ajaxloadstart.page', function(e) {
					try {
						myDropzone.destroy();
					} catch(e) {}
			   });
			
			} catch(e) {
			  alert('Dropzone.js does not support older browsers!');
			}
			
			});
		</script>
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
            <li><a href="#" rel="producttable" class="pull-center"><i class="fa fa-circle-o"></i> Product List </a></li>
            <li><a href="#" rel="productadd" class="pull-center"><i class="fa fa-circle-o"></i> Add Product</a></li>
			<li><a href="#" rel="productbulkupload" class="pull-center"><i class="fa fa-circle-o"></i> Create bulk Product</a></li>
			</ul>
        </li>
		<li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Sales Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
		    <li><a href="#" rel="salesreport" class="pull-center"><i class="fa fa-circle-o"></i>  Sales Reports</a></li>
			<li><a href="#" rel="issuebills" class="pull-center"><i class="fa fa-circle-o"></i>Issue Bill</a></li>
            <li><a href="#" rel="salesandclosingreport" class="pull-center"><i class="fa fa-circle-o"></i> View Sales Closing reports </a></li>
	      </ul>
          </li>
	    <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Supplier Details</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#" rel="supplierlist" class="pull-center"><i class="fa fa-circle-o"></i> Supplier List  </a></li>
            <li><a href="#" rel="supplierproductlist" class="pull-center"><i class="fa fa-circle-o"></i> Supplier Product List</a></li>
			 <li><a href="#" rel="purchasedetails" class="pull-center"><i class="fa fa-circle-o"></i>Purchase Details </a></li>		
            <li><a href="#" rel="recivedetails" class="pull-center"><i class="fa fa-circle-o"></i> Recive Details </a></li>
			<li><a href="#" rel="paymentddetails" class="pull-center"><i class="fa fa-circle-o"></i> Payment Details </a></li>	
			<li><a href="#" rel="pre-orderdetails" class="pull-center"><i class="fa fa-circle-o"></i> Pre-Order Details </a></li>			
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
		  <li><a href="#" rel="stockbalances" class="pull-center"><i class="fa fa-circle-o"></i> Stock Balances</a></li>
          <li><a href="#" rel="stockhistory" class="pull-center"><i class="fa fa-circle-o"></i> Stock History</a></li>
           <li><a href="#" rel="bulkstockupdate" class="pull-center"><i class="fa fa-circle-o"></i> Bulk Stock Update</a></li>		
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
            <li><a href="#" rel="customerlist" class="pull-center"><i class="fa fa-circle-o"></i> CUstomer List </a></li>
			<li><a href="#" rel="recentorderbill" class="pull-center"><i class="fa fa-circle-o"></i>Recent Orders/Bill</a></li>
			<li><a href="#" rel="feedbackreview" class="pull-center"><i class="fa fa-circle-o"></i>Feedback/Review Details</a></li>
			<li><a href="#" rel="paymentdetails" class="pull-center"><i class="fa fa-circle-o"></i>Payment Details</a></li>
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
            <li><a href="#"><i class="fa fa-circle-o"></i>Create User</a></li>
            <li><a href="#"><i class="fa fa-circle-o"></i>Assigne Role</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Setup SMS/Email</a></li>
			<li><a href="#"><i class="fa fa-circle-o"></i>Setup Offer</a></li>
			 <li class="treeview">
          <a href="#">
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
			<li><a href="#"><i class="fa fa-circle-o"></i>Sales and Collection report</a></li>
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
  
  <div  id="producttable" style="display: none">
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
		<th class="pull-center">Product Name</th>
		<th class="pull-center">Jewellery Type</th>
		<th class="pull-center">Degine Type</th>
		<th class="pull-center">Available Quantity</th>
		<th class="pull-center">Inventory Last Update</th>
	</tr>
	
      <tr>
        <td>Necklace</td>
        <td>Gold</td>
		<td>round neck</td>
        <td>2 Pices</td>
		<td>12/04/17</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
		</tr>
      <tr>
         <td>Ring</td>
        <td>Gold</td>
		<td>round neck</td>
        <td>10 pices</td>
		<td>12/04/17</td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
      </tr>
      <tr>
         <td>Bracelet</td>
        <td>silver</td>
		<td>round neck</td>
        <td>25 pices</td>
		<td>18/04/17</td>
        <td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
      </tr>
  </table>
		</div>
	</div>
 </div>
 
 <div  id="productadd" style="display: none">
 	<div class="panel-body">
				
				<div class="row">
				<form id="productadd_submit" action="add_product.php" method="POST">
					<br> <br>
					<div class="panel with-nav-tabs panel-success">
						
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" class="pull-center"
								href="#productbasicdetails">Product Basic Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productpricedetails">Price Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productdescdetails">Description Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productimagedetails">Product Image Details</a></li>
						</ul>
						<div class="panel-body">
						
							<div class="tab-content">
								<div id="productbasicdetails" class="tab-pane fade in active">
								<div class="col-md-12">
                                            <div class="form-group col-md-4">
												<label for="productid">Product Id:</label>
													<input type="text" name="productid" id="productid"
														 class="form-control" 
														placeholder="Product Id" readonly >
											    </div>
											    <div class="form-group col-md-4">
												<label for="barcode">Barcode:</label>
													<input type="text" name="barcode" id="barcode"
														class="form-control" 
														placeholder="Barcode">
												</div>
												 <div class="form-group col-md-4">
													 <label for="brand">Brand Name:</label>
													<input type="text" name="brand" id="brand"
														class="form-control" 
														placeholder="Brand Name">
												 </div>
										</div>		
                                   <div class="col-md-12">										
										<div class="col-md-4">
												<div class="form-group">
												<label for="productcatagory">Product Category :</label>
													<?php 
												// include 'dbconfig.php';
												// $query=$DB_con->query("Select * From category_details");
												// $rowcount=$query->num_rows;
												
												 error_reporting(E_ALL ^ E_DEPRECATED);
												
												require_once 'sql.php' ;
												  $SQL ="SELECT * FROM catagory_details";
												  $result = mysql_query($SQL);
												  $rowcount = mysql_num_rows($result);
												
												?>
												
												<select class="form-control" id="productcatagory" name="productcatagory">
														<option selected="selected">Select Category</option>
														<?php
														if($rowcount>0){

																while($row=mysql_fetch_array($result)){
																	echo '<option value="'.$row['ID'].'">'.$row['DISPLAYNAME'].'</option>';
															}
														}
														else{
																echo '<option value="">Category Not Available</option>';

															}
														?>
														
												    </select>
												</div>
												</div>
												<div class="col-md-4">
												<div class="form-group">
												   <label for="subcatagory">Sub Category :</label>
												   <select class="form-control"id="subcatagory"name="subcatagory">
												     <option selected="selected">Select Sub-Category</option>
												     
												   </select>
												
												  </div>
												  </div>
												  <div class="col-md-4">
												<div class="form-group">
												<label for="productname">Product Name :</label>
													<input type="text" name="productname" id="productname"
														 class="form-control" 
														placeholder="Product Name">
											    </div>
												</div>	
												</div>			
											<div class="col-md-12">												
											<div class="col-md-4">
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
												<div class="col-md-4">
												<div class="form-group">
												  <label for="purchasedate">Purchase Date :</label>
													<input type="date" name="purchasedate" id="purchasedate"
														class="form-control" 
														placeholder="Purchase Date">
												</div>
												</div>
												<div class="col-md-4">
												<div class="form-group">
												   <label for="productsize">Product Size:</label>
													<input type="text" name="productsize" id="productsize"
														class="form-control" 
														placeholder="Product Size">
												</div>
										
											 </div>
											 </div>
								</div>


								<div id="productpricedetails" class="tab-pane fade">

									<h4 style="font-weight:bold">Quantity Details</h4>
									<div class="row">
											<div class="col-md-3 ">
												<div class="form-group">
												   <label for="vendername">Vender Name:</label>
												<?php 	
													$query ="SELECT * FROM vendor_details";
												  $result_vd = mysql_query($query);
												  $rowcount = mysql_num_rows($result_vd);
												  
												 ?>
													
													<select class="form-control" id="vendername" name="vendername" onchange="change_vendorname();">
														<option selected="selected">Select Vendor Name</option>
														<?php
														if($rowcount>0){

																while($row=mysql_fetch_array($result_vd)){
																	echo '<option value="'.$row['ID'].'">'.$row['VENDOR_NAME'].'</option>';
															}
														}
														else{
																echo '<option value="">Vendors Not Available</option>';

															}
														?>
														
												    </select>
												  
												
												  </div>
												  
												  <div class="form-group">
												   <label for="venderid">Vender ID:</label>
													<input type="text" name="venderid" id="venderid"
														class="form-control" 
														value=""readonly >
												  </div>
												  <div class="form-group">
												   <label for="venderprice">Vender Price:</label>
													<input type="text" name="venderprice" id="venderprice"
														class="form-control" 
														placeholder="">
												 </div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
												   <label for="carat">Carat:</label>
												   <select class="form-control"id="carat"name="carat" onchange="change_carat();">
												     <option>Select</option>
												     <option>14KT</option>
													 <option>18KT</option>
													 <option>22KT</option>
													 <option>24KT</option>
												   </select>
												  </div>
												  
												  <div class="form-group">
												   <label for="pureweight">Pure Weight:</label>
													<input type="text" name="pureweight" id="pureweight"
														class="form-control" 
														placeholder="" value=""readonly>
												  </div>
												  
								                 <div class="form-group">
												   <label for="netweight">Net Weight:</label>
													<input type="text" name="netweight" id="netweight"
														class="form-control" 
														placeholder="">
												  </div>
													
												</div>
												<div class="col-md-3">
												<div class="form-group">
												   <label for="meenaweight">Meena Weight:</label>
													<input type="text" name="meenaweight" id="meenaweight"
														class="form-control" 
														placeholder="">
												</div>
												
												  <div class="form-group">
												   <label for="grossweight">Gross Weight:</label>
													<input type="text" name="grossweight" id="grossweight"
														class="form-control" 
														placeholder="">
												</div>
												
												 <div class="form-group">
												   <label for="wastage">Wastage Weight:</label>
													<input type="text" name="wastage" id="wastage"
														class="form-control" 
														placeholder="Wastage">
												  </div>
												</div>
												<div class="col-md-3">
												<div class="form-group">
												   <label for="stone_used">Total Stone Used</label>
													<input type="text" name="stone_used" id="stone_used"
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
												   <label for="stonecolor">Stone Color:</label>
												   <select class="form-control"id="stonecolor"name="stonecolor">
												     <option>Select</option>
												     <option>Yellow</option>
													 <option>White</option>
													 <option>Pink</option>
													 <option>Diamond</option>
												   </select>
												  </div>
												</div>
										</div>
									<h4  style="font-weight:bold">Price Details</h4>
									<div class="row">
											<div class="col-md-3">
												   <div class="form-group">
												   <label for="mrpprice">MRP Price:</label>
													<input type="text" name="mrpprice" id="mrpprice"
														class="form-control" 
														placeholder="">
												 </div>
												<div class="form-group">
												   <label for="stoneprice">Stone Price:</label>
													<input type="text" name="stoneprice" id="stoneprice"
														class="form-control" 
														placeholder="Stone Price">
												 </div>
												  <div class="form-group">
												   <label for="makingcharges">Making Charges:</label>
													<input type="text" name="makingcharges" id="makingcharges"
														class="form-control" 
														placeholder="Making Charges">
												  </div>
												</div>
												<div class="col-md-3">
												  <div class="form-group">
												   <label for="vatprice">VAT Price:</label>
													<input type="text" name="vatprice" id="vatprice"
														class="form-control" 
														placeholder="VAT Price">
												  </div>
												  <div class="form-group">
												   <label for="hmtagprice">HM Tag Price:</label>
													<input type="text" name="hmtagprice" id="hmtagprice"
														class="form-control" 
														placeholder="HM Tag Price">
												 </div>
												  <div class="form-group">
												   <label for="discountprice">Discount Price:</label>
													<input type="text" name="discountprice" id="discountprice"
														class="form-control" 
														placeholder="Discount Price">
												 </div>
											</div>
									</div>
								</div>

								<div id="productdescdetails" class="tab-pane fade">
									<div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3 ">
												<div class="form-group">
													<label for="productstyle">Degine Style:</label>
													<select class="form-control"id="productstyle"name="productstyle">
												     <option>Select</option>
												     <option>Stud</option>
													 <option>Hoop</option>
													 <option>Jhumka</option>
													 <option>Drop</option>
												   </select>
												   </div>
												   
													<div class="form-group">
													 <label for="metalcolor">Avilable Color:</label>
													<select class="form-control"id="metalcolor"name="metalcolor">
														<option>Yellow</option>
														<option>Silver</option>
														<option>Bicolor</option>
												   </select>
												    </div>
													<div class="form-group">
													 <label for="gender">Applicable Geneder</label>
													<select class="form-control"id="gender"name="gender">
												      <option>Select</option>
												      <option>Men</option>
													  <option>Women</option>
													  <option>Kids-Girl</option>
													  <option>Kids-Boys</option>
													  <option>All</option>
												   </select>
												   </div>
											</div>
										<div class="col-md-3 ">
													<div class="form-group">
													 <label for="gender">Description Text</label>
													<textarea class="form-control" id="desctext"name="desctext">
												    </textarea>
												   </div>
												   	<div class="form-group">
													 <label for="gender">Degine Description</label>
													<textarea class="form-control" id="deginedesc"name="deginedesc">
												    </textarea>
												   </div>
												   <div class="form-group">
													 <label for="gender">Technical Description</label>
													<textarea class="form-control" id="technicaldesc"name="technicaldesc">
												    </textarea>
												   </div>
										</div>
										
										</div>
								</div>
	
								
									<div id="productimagedetails" class="tab-pane fade">
									<div>
									<form action="./dummy.html" class="dropzone well" id="dropzone">
										<div class="fallback">
											<input name="file" type="file" multiple="" />
										</div>
									</form>
								</div>
												<div id="preview-template" class="hide">
									<div class="dz-preview dz-file-preview">
										<div class="dz-image">
											<img data-dz-thumbnail="" />
										</div>

										<div class="dz-details">
											<div class="dz-size">
												<span data-dz-size=""></span>
											</div>

											<div class="dz-filename">
												<span data-dz-name=""></span>
											</div>
										</div>

										<div class="dz-progress">
											<span class="dz-upload" data-dz-uploadprogress=""></span>
										</div>

										<div class="dz-error-message">
											<span data-dz-errormessage=""></span>
										</div>

										<div class="dz-success-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-check fa-stack-1x fa-inverse green"></i>
											</span>
										</div>

										<div class="dz-error-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-remove fa-stack-1x fa-inverse red"></i>
											</span>
										</div>
									</div>
								</div><!-- PAGE CONTENT ENDS -->

								</div>
							<div class="modal-footer">
								<button type="submit" id="productadd_submit" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-check-circle" aria-hidden="true"></i>ADD NEW PRODUCT</button>
								<button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>RESET</button>
								</div>
					       </div>
						   </form>
				    </div>
					
			      </div>
				  </form>
			  </div>
	</div>
 </div>
   
 <div  id="productbulkupload" style="display: none">
</div>


  <div  id="salesreport" style="display: none">
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
		<th class="pull-center">Customer name</th>
		<th class="pull-center">Product Type</th>
		<th class="pull-center">Item Name</th>
        <th class="pull-center">Quantity</th>
		<th class="pull-center">Sell Date</th>
		<th class="pull-center">Sell price</th>
		<th class="pull-center">Offer/Discount Price</th>
	</tr>
	
      <tr>
	    <td>Sudhakar Jena</td>
        <td>Gold</td>
        <td>Ring</td>
        <td>2 Pices</td>
		<td>12/04/17</td>
		<td>INR 250000.00</td>
		<td>N/A</td>
		</tr>
        <tr>
	    <td>Sudhakar Jena</td>
        <td>Gold</td>
        <td>Ring</td>
        <td>2 Pices</td>
		<td>12/04/17</td>
		<td>INR 250000.00</td>
		<td>N/A</td>
		</tr>
        <tr>
	    <td>Sudhakar Jena</td>
        <td>Gold</td>
        <td>Ring</td>
        <td>2 Pices</td>
		<td>12/04/17</td>
		<td>INR 250000.00</td>
		<td>N/A</td>
		</tr>
  </table>
		</div>
	</div>
 </div>

   <div  id="issuebills" style="display: none">
 	
	<div class="panel-header">
	  <a data-toggle="modal" class="btn btn-default pull-right" data-target="#createbillmodal"><span class="glyphicons glyphicons-file-plus"></span>Create New Bill</a>
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
	    <th class="pull-center">Bill No.</th>
		<th class="pull-center">Bill Issue Date</th>
		<th class="pull-center">Customer name</th>
		<th class="pull-center">TOtal Amount(INR)</th>
	</tr>
	
      <tr>
	    <td>DD1245</td>
	    <td>Sudhakar Jena</td>
        <td>25000.00</td>
		<td>12/04/17</td>
		<td><a><span class="glyphicon glyphicon-edit"></span>view Details</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
	  </tr>
      <tr>
	    <td>DD1265</td>
	    <td>Sudhakar Jena</td>
        <td>25000.00</td>
		<td>12/04/17</td>
		<td><a><span class="glyphicon glyphicon-edit"></span>view Details</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
	  </tr>
       <tr>
	    <td>DD1266</td>
	    <td>Sudhakar Jena</td>
        <td>25000.00</td>
		<td>12/04/17</td>
		<td><a><span class="glyphicon glyphicon-edit"></span>view Details</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
	  </tr>
  </table>
		</div>
	</div>
 </div>
 
<div id="venderdetails" style="display: none">
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
  
  
  <!-- /product edit modal -->
  <div  id="productaddmodal" class="modal fade" data-backdrop="static" data-keyboard="false" role="dialog">
  <div class="modal-dialog modal-lg">
  
   <div class="modal-content">
   
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Product Details</h4>
      </div>
	  <div class="modal-body">
         	<div class="panel-body">
					<div class="panel with-nav-tabs panel-success">
						
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" class="pull-center"
								href="#productbasicdetails">Product Basic Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productpricedetails">Price Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productdescdetails">Description Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productimagedetails">Product Image Details</a></li>
						</ul>
						<div class="panel-body">
							<div class="tab-content">
								<div id="productbasicdetails" class="tab-pane fade in active">
								<div class="col-md-12">
                                            <div class="form-group col-md-4">
												<label for="productid">Product Id:</label>
													<input type="text" name="productid" id="productid"
														 class="form-control" 
														placeholder="Product Id" readonly>
											    </div>
											    <div class="form-group col-md-4">
												<label for="barcode">Barcode:</label>
													<input type="text" name="barcode" id="barcode"
														class="form-control" 
														placeholder="Barcode">
												</div>
												 <div class="form-group col-md-4">
													 <label for="brand">Brand Name:</label>
													<input type="text" name="brand" id="brand"
														class="form-control" 
														placeholder="Brand Name">
												 </div>
										</div>		
                                   <div class="col-md-12">										
										<div class="col-md-4">
												<div class="form-group">
												<label for="productcatagory">Product Category :</label>
													<select class="form-control" id="productcatagory" name="productcatagory">
														<option>Select</option>
														<option>Earring</option>
														<option>Pedant</option>
                                                       <option>Chain</option>
                                                    </select>
												</div>
												</div>
												<div class="col-md-4">
												<div class="form-group">
												   <label for="subcatagory">Sub Catagory :</label>
												   <select class="form-control"id="subcatagory"name="subcatagory">
												     <option>Select</option>
												     <option>Necklace</option>
													 <option>Bracelet</option>
												   </select>
												  </div>
												  </div>
												  <div class="col-md-4">
												<div class="form-group">
												<label for="productname">Product Name :</label>
													<input type="text" name="productname" id="productname"
														 class="form-control" 
														placeholder="Product Name">
											    </div>
												</div>	
												</div>			
											<div class="col-md-12">												
											<div class="col-md-4">
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
												<div class="col-md-4">
												<div class="form-group">
												  <label for="purchasedate">Purchase Date :</label>
													<input type="date" name="purchasedate" id="purchasedate"
														class="form-control" 
														placeholder="Purchase Date">
												</div>
												</div>
												<div class="col-md-4">
												<div class="form-group">
												   <label for="productsize">Product Size:</label>
													<input type="text" name="productsize" id="productsize"
														class="form-control" 
														placeholder="Product Size">
												</div>
										
											 </div>
											 </div>
								</div>


								<div id="productpricedetails" class="tab-pane fade">

									<h4 style="font-weight:bold">Quantity Details</h4>
									<div class="row">
											<div class="col-md-3 ">
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
											<div class="col-md-3">
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
												   <label for="pureweight">Pure Weight:</label>
													<input type="text" name="pureweight" id="pureweight"
														class="form-control" 
														placeholder=""readonly>
												  </div>
												  
								                 <div class="form-group">
												   <label for="netweight">Net Weight:</label>
													<input type="text" name="netweight" id="netweight"
														class="form-control" 
														placeholder="">
												  </div>
													
												</div>
												<div class="col-md-3">
												<div class="form-group">
												   <label for="meenaweight">Meena Weight:</label>
													<input type="text" name="meenaweight" id="meenaweight"
														class="form-control" 
														placeholder="">
												</div>
												
												  <div class="form-group">
												   <label for="grossweight">Gross Weight:</label>
													<input type="text" name="grossweight" id="grossweight"
														class="form-control" 
														placeholder="">
												</div>
												
												 <div class="form-group">
												   <label for="wastage">Wastage Weight:</label>
													<input type="text" name="wastage" id="wastage"
														class="form-control" 
														placeholder="Wastage">
												  </div>
												</div>
												<div class="col-md-3">
												<div class="form-group">
												   <label for="stoneweight">Total Stone Used</label>
													<input type="text" name="stoneweight" id="stoneweight"
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
												   <label for="stonecolor">Stone Color:</label>
												   <select class="form-control"id="stonecolor"name="stonecolor">
												     <option>Select</option>
												     <option>Yellow</option>
													 <option>White</option>
													 <option>Pink</option>
													 <option>Diamond</option>
												   </select>
												  </div>
												</div>
										</div>
									<h4  style="font-weight:bold">Price Details</h4>
									<div class="row">
											<div class="col-md-3">
												   <div class="form-group">
												   <label for="mrpprice">MRP Price:</label>
													<input type="text" name="mrpprice" id="mrpprice"
														class="form-control" 
														placeholder="">
												 </div>
												<div class="form-group">
												   <label for="stoneprice">Stone Price:</label>
													<input type="text" name="stoneprice" id="stoneprice"
														class="form-control" 
														placeholder="Stone Price">
												 </div>
												  <div class="form-group">
												   <label for="makingcharges">Making Charges:</label>
													<input type="text" name="makingcharges" id="makingcharges"
														class="form-control" 
														placeholder="Making Charges">
												  </div>
												</div>
												<div class="col-md-3">
												  <div class="form-group">
												   <label for="vatprice">VAT Price:</label>
													<input type="text" name="vatprice" id="vatprice"
														class="form-control" 
														placeholder="VAT Price">
												  </div>
												  <div class="form-group">
												   <label for="hmtagprice">HM Tag Price:</label>
													<input type="text" name="hmtagprice" id="hmtagprice"
														class="form-control" 
														placeholder="HM Tag Price">
												 </div>
												  <div class="form-group">
												   <label for="discountprice">Discount Price:</label>
													<input type="text" name="discountprice" id="discountprice"
														class="form-control" 
														placeholder="Discount Price">
												 </div>
											</div>
									</div>
								</div>

								<div id="productdescdetails" class="tab-pane fade">
									<div class="row">
											<div class="col-xs-3 col-sm-3 col-md-3 ">
												<div class="form-group">
													<label for="productstyle">Degine Style:</label>
													<select class="form-control"id="productstyle"name="productstyle">
												     <option>Select</option>
												     <option>Stud</option>
													 <option>Hoop</option>
													 <option>Jhumka</option>
													 <option>Drop</option>
												   </select>
												   </div>
												   
													<div class="form-group">
													 <label for="metalcolor">Avilable Color:</label>
													<select class="form-control"id="metalcolor"name="metalcolor">
														<option>Yellow</option>
														<option>Silver</option>
														<option>Bicolor</option>
												   </select>
												    </div>
													<div class="form-group">
													 <label for="gender">Applicable Geneder</label>
													<select class="form-control"id="gender"name="gender">
												      <option>Select</option>
												      <option>Men</option>
													  <option>Women</option>
													  <option>Kids-Girl</option>
													  <option>Kids-Boys</option>
													  <option>All</option>
												   </select>
												   </div>
											</div>
										<div class="col-md-3 ">
													<div class="form-group">
													 <label for="gender">Description Text</label>
													<textarea class="form-control" id="desctext"name="desctext">
												    </textarea>
												   </div>
												   	<div class="form-group">
													 <label for="gender">Degine Description</label>
													<textarea class="form-control" id="deginedesc"name="deginedesc">
												    </textarea>
												   </div>
												   <div class="form-group">
													 <label for="gender">Technical Description</label>
													<textarea class="form-control" id="technicaldesc"name="technicaldesc">
												    </textarea>
												   </div>
										</div>
										
										</div>
								</div>
	
								
									<div id="productimagedetails" class="tab-pane fade">
									<div>
									<form action="./dummy.html" class="dropzone well" id="dropzone">
										<div class="fallback">
											<input name="file" type="file" multiple="" />
										</div>
									</form>
								</div>
												<div id="preview-template" class="hide">
									<div class="dz-preview dz-file-preview">
										<div class="dz-image">
											<img data-dz-thumbnail="" />
										</div>

										<div class="dz-details">
											<div class="dz-size">
												<span data-dz-size=""></span>
											</div>

											<div class="dz-filename">
												<span data-dz-name=""></span>
											</div>
										</div>

										<div class="dz-progress">
											<span class="dz-upload" data-dz-uploadprogress=""></span>
										</div>

										<div class="dz-error-message">
											<span data-dz-errormessage=""></span>
										</div>

										<div class="dz-success-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-check fa-stack-1x fa-inverse green"></i>
											</span>
										</div>

										<div class="dz-error-mark">
											<span class="fa-stack fa-lg bigger-150">
												<i class="fa fa-circle fa-stack-2x white"></i>

												<i class="fa fa-remove fa-stack-1x fa-inverse red"></i>
											</span>
										</div>
									</div>
								</div><!-- PAGE CONTENT ENDS -->

								</div>
							
					       </div>
				    </div>
			      </div>
				  </div>
				  <div class="modal-footer">
                   	<button type="submit" id="usersearch" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-check-circle" aria-hidden="true"></i>Confirm</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Close</button>
                 </div>
			  </div>
		</div>
	</div>
 </div>
  
</div>
</body>
</div>
<script type="text/javascript">
$('a').on('click', function(){
   var target = $(this).attr('rel');
   $("#"+target).show().siblings("div").hide();
});
</script>
<script type="text/javascript">
	
$(document).ready(function()
{
$('#productcatagory').on('change',function()
{
var id =$(this).val();
if(id)
{
$.ajax
({
type:'POST',
url:'process/get_subcategory.php',
data:'id='+id,
success:function(data)
{

$('#subcatagory').html(data);

}
});
}else
{
$('#subcatagory').html('<option value=””>Select Category First</option>');

}

});

});
</script>
  <script type="text/javascript">
function change_vendorname()
{
	
	var selected_val=$( "#vendername option:selected" ).val();
	//alert(selected_text);
														
	$('#venderid').val(selected_val);
													
}
function change_carat()
{
	var selected_text=$( "#carat option:selected" ).text();
	//alert(selected_text);
	if (selected_text == '14KT')
	{		
	$('#pureweight').val(60);
	}
	else if (selected_text == '18KT')
	{		
	$('#pureweight').val(70);
	}
	else if (selected_text == '22KT')
	{		
	$('#pureweight').val(80);
	}
	else 
	{
	$('#pureweight').val(90);	
	}
}
</script>
	</html>