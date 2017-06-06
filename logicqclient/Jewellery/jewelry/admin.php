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
<link href="assets/css/cs.stylea67f.css" rel="stylesheet" type="text/css" media="all" />
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
            <li><a href="#" rel="salesclosingreport" class="pull-center"><i class="fa fa-circle-o"></i> View Sales Closing reports </a></li>
	      </ul>
          </li>
	    <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Supplier</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#" rel="supplierlist" class="pull-center"><i class="fa fa-circle-o"></i> Supplier List  </a></li>
            <li><a href="#" rel="supplierproductlist" class="pull-center"><i class="fa fa-circle-o"></i> Supplier Product catalogue</a></li>
		</ul>
        </li>
	   <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Payment/purchase</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#" rel="purchasedetails" class="pull-center"><i class="fa fa-circle-o"></i>Order Details</a></li>		
            <li><a href="#" rel="recivedDetails" class="pull-center"><i class="fa fa-circle-o"></i>Process Order</a></li>
			<li><a href="#" rel="paymentddetails" class="pull-center"><i class="fa fa-circle-o"></i>Process Payment</a></li>
			<li><a href="#" rel="invoicedetails" class="pull-center"><i class="fa fa-circle-o"></i>Order Invoice Details</a></li>
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
            <li><a href="#" rel="customerlist" class="pull-center"><i class="fa fa-circle-o"></i> Customer List </a></li>
			<li><a href="#" rel="customerwizard" class="pull-center"><i class="fa fa-circle-o"></i> Customer Wizard </a></li>
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

 <li class="umbrella hidden-xs">			
        <div id="umbrella" class="list-inline unmargin">
          <div class="cart-link">
            <a class="btn btn-default" data-toggle="modal" data-target="#checkoutmodal">              
              <div class="num-items-in-cart">
                <span class="icon">
                 Purchase Cart
                  <span class="number">1</span>
                </span>
              </div>
            </a>
          </div>
        </div>
      </li>

	  
	   <a href="#" rel="pre-order">
                       <div class="col-lg-3 col-md-3">
                                 <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p class="counter">300</p>
                                        <span class="info-box-title">Total product</span>
                                    </div>
                                </div>
                            </div>
                        </div>
						</a>
						<a href="#" rel="inprogress-order">
						<div class="col-lg-3 col-md-3">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p class="counter">10</p>
                                        <span class="info-box-title">Recent Product</span>
                                    </div>
                                </div>
                            </div>
                        </div>
					</a>
					 <a href="#" rel="processed-order">		
				      <div class="col-lg-3 col-md-3">
                        <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p class="counter">10</p>
                                        <span class="info-box-title">Top 10 Product Degine</span>
                                    </div>
                                </div>
                            </div>
                       </div>
					 </a>
	  <div class="col-md-12">
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
		<th class="pull-center">Material Type</th>
		<th class="pull-center">Degine Category</th>
		<th class="pull-center">Item Code</th>
		<th class="pull-center">Rating</th>
		<th class="pull-center">Comment</th>
	</tr>
	
      <tr>
        <td>Necklace</td>
        <td>Gold</td>
		<td>round neck</td>
		<td>DD12345</td>
		<td>*****</td>
		<td>good degine</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Modify</a></td>
		<td><a data-toggle="modal" data-target="#vendorListmodal"><span class="glyphicon glyphicon-edit"></span>PlaceOrder</a></td>
		</tr>
       <tr>
        <td>Necklace</td>
        <td>Gold</td>
		<td>round neck</td>
		<td>DD12346</td>
		<td>*****</td>
		<td>good degine</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Modify</a></td>
		<td><a data-toggle="modal" data-target="#vendorListmodal"><span class="glyphicon glyphicon-edit"></span>PlaceOrder</a></td>
	</tr>
     <tr>
        <td>Necklace</td>
        <td>Gold</td>
		<td>round neck</td>
		<td>DD12346</td>
		<td>*****</td>
		<td>good degine</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Modify</a></td>
		<td><a data-toggle="modal" data-target="#vendorListmodal"><span class="glyphicon glyphicon-edit"></span>PlaceOrder</a></td>
	</tr>
  </table>
		</div>
	</div>
 </div></div>
 
<div  id="productadd" style="display: none">
 	<div class="panel-body">
				<div class="row">
					<br> <br>
					<div class="panel with-nav-tabs panel-success">
						
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" class="pull-center"
								href="#productbasicdetails">Product Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productimagedetails">Images</a></li>
						</ul>
						<div class="panel-body">
							<div class="tab-content">
								<div id="productbasicdetails" class="tab-pane fade in active">
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
													 <label for="gender">Description Text</label>
													<textarea class="form-control" id="desctext"name="desctext">
												    </textarea>
												   </div>
										</div>
										<div class="col-md-4">
												   	<div class="form-group">
													 <label for="gender">Degine Description</label>
													<textarea class="form-control" id="deginedesc"name="deginedesc">
												    </textarea>
												   </div>
										</div>
										<div class="col-md-4">
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
 
<div  id="salesclosingreport" style="display: none">
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
	    <th class="pull-center">Transaction Type</th>
		<th class="pull-center">Bill No.</th>
		<th class="pull-center">Bill Amount(INR)</th>
		<th class="pull-center">Recived Amount(INR)</th>
		<th class="pull-center">Due Amount(INR)</th>
		<th class="pull-center">Due Amount Reasone</th>
	</tr>
	
      <tr>
	    <td>CASH</td>
	    <td>DD165</td>
        <td>25000.00</td>
		<td>2000.00</td>
		<td>23000.00</td>
		<td>Advanced Payment</td>
	  </tr>
       <tr>
	    <td>CASH</td>
	    <td>DD165</td>
        <td>25000.00</td>
		<td>2000.00</td>
		<td>23000.00</td>
		<td>Advanced Payment</td>
	  </tr>
       <tr>
	    <td>CASH</td>
	    <td>DD165</td>
        <td>25000.00</td>
		<td>2000.00</td>
		<td>23000.00</td>
		<td>Advanced Payment</td>
	  </tr>
  </table>
		</div>
	</div>	
	<div class="panel-footer">
	   <div class="col-md-9 col-lg-9 table-responsive"> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Total Bill Count</td>
                        <td>3</td>
                      </tr>
                      <tr>
                        <td>Total Billed Amount(INR)</td>
                        <td>75000.00</td>
                      </tr>
                      <tr>
                        <td>Total Recived Amount(INR)</td>
                        <td>6000.00</td>
                      </tr>
                        <tr>
                        <td>Total Due Amount(INR)</td>
                        <td>6000.00</td>
                      </tr>
                      <tr>
                        <td>Sale Report date</td>
                        <td>2017-MAY-10</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
	</div>
	</div>
		
<div  id="supplierlist" style="display: none">
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
	    <th class="pull-center">Id</th>
		<th class="pull-center">Name</th>
		<th class="pull-center">Address</th>
		<th class="pull-center">Contact Number</th>
		<th class="pull-center">Contact Person</th>
	</tr>
	
      <tr>
        <td>DS1233</td>
        <td>Radha Mohan Charu</td>
		<td>kuch bi kuch bi</td>
        <td>7057014118</td>
		<td>Radha Mohan Charu</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
		</tr>
        <tr>
        <td>DS1233</td>
        <td>Radha Mohan Charu</td>
		<td>kuch bi kuch bi</td>
        <td>7057014118</td>
		<td>Radha Mohan Charu</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
		</tr>
       <tr>
        <td>DS1233</td>
        <td>Radha Mohan Charu</td>
		<td>kuch bi kuch bi</td>
        <td>7057014118</td>
		<td>Radha Mohan Charu</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Edit</a></td>
		<td><a><span class="glyphicon glyphicon-edit"></span>Delete</a></td>
		</tr>
  </table>
		</div>
	</div>
 </div>
 
<div  id="supplierproductlist" style="display: none">
   
      <li class="umbrella hidden-xs">			
        <div id="umbrella" class="list-inline unmargin">
          <div class="cart-link">
            <a class="btn btn-default" data-toggle="modal" data-target="#checkoutmodal">              
              <div class="num-items-in-cart">
                <span class="icon">
                 Purchase Cart
                  <span class="number">1</span>
                </span>
              </div>
            </a>
          </div>
        </div>
      </li>
	  <br></br>
	  <a class="btn btn-default pull-right" data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Add Catelogue</a>
	  
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
	    <th class="pull-center">Catelogue Id</th>
		<th class="pull-center">Catelogue Name</th>
		<th class="pull-center">Vendor Id</th>
		<th class="pull-center">Item Category</th>
		<th class="pull-center">Item Sub-Category</th>
		<th class="pull-center">Product ID</th>
		<th class="pull-center">Item Degine Type</th>
	</tr>
	
      <tr>
        <td>DS1233</td>
		<td>ASSSDASA</td>
        <td>Radha Mohan Charu</td>
		<td>GOld</td>
        <td>Bracelates</td>
		<td>PR12345</td>
		<td>Chain</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>view Details</a></td>
		<td><a data-toggle="modal" data-target="#quantitymodal"><span class="glyphicon glyphicon-edit"></span>Place Order</a></td>
		</tr>
       <tr>
        <td>DS1233</td>
		<td>ASSSDASA</td>
        <td>Radha Mohan Charu</td>
		<td>GOld</td>
        <td>Bracelates</td>
		<td>PR12346</td>
		<td>Bold Chain</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>view Details</a></td>
		<td><a data-toggle="modal" data-target="#quantitymodal"><span class="glyphicon glyphicon-edit"></span>Place Order</a></td>
	  </tr>
       <tr>
        <td>DS1233</td>
		<td>ASSSDASA</td>
        <td>Radha Mohan Charu</td>
		<td>GOld</td>
        <td>Bracelates</td>
		<td>PR12347</td>
		<td>Plain</td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>view Details</a></td>
		<td><a data-toggle="modal" data-target="#quantitymodal"><span class="glyphicon glyphicon-edit"></span>Place Order</a></td>
	   </tr>
  </table>
		</div>
	</div>
 </div>
		
<div  id="purchasedetails" style="display: none">
                      <a href="#" rel="pre-order">
                       <div class="col-lg-3 col-md-3">
                                 <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p class="counter">3</p>
                                        <span class="info-box-title">Yet to review</span>
                                    </div>
                                </div>
                            </div>
                        </div>
						</a>
						<a href="#" rel="inprogress-order">
						<div class="col-lg-3 col-md-3">
                            <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p class="counter">10</p>
                                        <span class="info-box-title">Order In Progress</span>
                                    </div>
                                </div>
                            </div>
                        </div>
					</a>
				     <a href="#" rel="processed-order">		
				      <div class="col-lg-3 col-md-3">
                        <div class="panel info-box panel-white">
                                <div class="panel-body">
                                    <div class="info-box-stats">
                                        <p class="counter">12</p>
                                        <span class="info-box-title">Processed</span>
                                    </div>
                                </div>
                            </div>
                       </div>
					  </a>
<div id="pre-order"	style="display: none">			  
	<div class="col-md-12">
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
	    <th class="pull-center">Purchase Id</th>
		<th class="pull-center">Purchase Date</th>
		<th class="pull-center">Supplier Id</th>
		<th class="pull-center">Supplier Name</th>
		<th class="pull-center">Excepted Delivery Date</th>
		<th class="pull-center">Status</th>
		<th class="pull-center">Comment</th>
		
		
	</tr>
	
      <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>review</td>
		<td>Yet to review</td>
		</tr>
	 <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>review</td>
		<td>Yet to review</td>
	</tr>
      <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>review</td>
		<td>Yet to review</td>
	</tr>
  </table>
		</div>
	</div>
  </div>
 </div>
 
 <div id="inprogress-order"	style="display: none">			  
	<div class="col-md-12">
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
	    <th class="pull-center">Purchase Id</th>
		<th class="pull-center">Purchase Date</th>
		<th class="pull-center">Supplier Id</th>
		<th class="pull-center">Supplier Name</th>
		<th class="pull-center">Excepted Delivery Date</th>
		<th class="pull-center">Invoice Id</th>
		<th class="pull-center">Status</th>
		<th class="pull-center">Comment</th>
	</tr>
	
      <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>DD/INV/004</td>
		<td>inprogress</td>
		<td>Place order by syx</td>
		</tr>
	 <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>DD/INV/004</td>
		<td>inprogress</td>
		<td>Place order by syx</td>
		</tr>
      <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>DD/INV/004</td>
		<td>inprogress</td>
		<td>Place order by syx</td>
	</tr>
  </table>
		</div>
	</div>
  </div>
 </div>
 
 <div id="processed-order"	style="display: none">			  
	<div class="col-md-12">
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
	    <th class="pull-center">Purchase Id</th>
		<th class="pull-center">Purchase Date</th>
		<th class="pull-center">Supplier Id</th>
		<th class="pull-center">Supplier Name</th>
		<th class="pull-center">Excepted Delivery Date</th>
		<th class="pull-center">Invoice Id</th>
		<th class="pull-center">Payment Recipt No.</th>
		<th class="pull-center">Payment status</th>
		<th class="pull-center">Status</th>
		<th class="pull-center">Comment</th>
	</tr>
	
      <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>DD/INV/004</td>
		<td>DD/PAY/123</td>
		<td>Pending</td>
		<td>processed</td>
		<td>Place order by syx</td>
	 </tr>
	 <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>DD/INV/004</td>
		<td>DD/PAY/123</td>
		<td>Pending</td>
		<td>processed</td>
		<td>Place order by syx</td>
	 </tr>
       <tr>
        <td>DD_PUARCHE_01</td>
        <td>30-May-2017</td>
		<td>DDASADF</td>
        <td>Rakesh Mheta</td>
		<td>02-June-2017</td>
		<td>DD/INV/004</td>
		<td>DD/PAY/123</td>
		<td>Pending</td>
		<td>processed</td>
		<td>Place order by syx</td>
	 </tr>
  </table>
		</div>
	</div>
  </div>
 </div>
  
 </div>
	
<div  id="recivedDetails" style="display: none">
	<div class="panel-header">
        <a class="btn btn-default pull-right" data-toggle="modal" data-target="#processreciveModal"><span class="glyphicon glyphicon-edit"></span>Process Purchase</a>
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
	    <th class="pull-center">Recived Id</th>
		<th class="pull-center">Purche Id</th>
		<th class="pull-center">Purche Date</th>
		<th class="pull-center">Quantity</th>
		<th class="pull-center">Total Weight</th>
		<th class="pull-center">Recived Date</th>
		<th class="pull-center">Recive By</th>
		<th class="pull-center">Payment By</th>
		<th class="pull-center">Payment Status</th>
		<th class="pull-center">Comments</th>
	</tr>
      <tr>
        <td>DDREC_123</td>
        <td>DD_PUARCHE_02</td>
		<td>30-May-2017</td>
        <td>10</td>
		<td>100 mg</td>
		<td>30-May-2017</td>
		<td>Satyajit </td>
		<td>Glod</td>
		<td>due</td>
		<td>Need to lear rest amount by gold</td>
		<td><a data-toggle="modal" data-target="#orderrecivemodal"><span class="glyphicon glyphicon-edit"></span>View/Modify</a></td>
	  </tr>
      <tr>
        <td>DDREC_124</td>
        <td>DD_PUARCHE_02</td>
		<td>30-May-2017</td>
        <td>10</td>
		<td>100 mg</td>
		<td>30-May-2017</td>
		<td>Satyajit </td>
		<td>Glod</td>
		<td>due</td>
		<td>Need to lear rest amount by gold</td>
		<td><a data-toggle="modal" data-target="#orderrecivemodal"><span class="glyphicon glyphicon-edit"></span>View/Modify</a></td>
	  </tr>
      <tr>
        <td>DDREC_125</td>
        <td>DD_PUARCHE_02</td>
		<td>30-May-2017</td>
        <td>10</td>
		<td>100 mg</td>
		<td>30-May-2017</td>
		<td>Satyajit </td>
		<td>Glod</td>
		<td>due</td>
		<td>Need to lear rest amount by gold</td>
		<td><a data-toggle="modal" data-target="#orderrecivemodal"><span class="glyphicon glyphicon-edit"></span>View/Modify</a></td>
	  </tr>
  </table>
		</div>
	</div>
 </div>	
		
<div  id="stockbalances" style="display: none">
	<div class="panel-header">
 <a class="btn btn-default pull-right" data-toggle="modal" data-target="#stockupdateModal"><span class="glyphicon glyphicon-edit"></span>Update</a>
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
	    <th class="pull-center">Item Id</th>
		<th class="pull-center">Item Name</th>
		<th class="pull-center">Item Avilable Quantity</th>
		<th class="pull-center">Item Sell Quantity</th>
		<th class="pull-center">Item Total Quantity</th>
		<th class="pull-center">Item Unit Type</th>
		<th class="pull-center">Last Order Date</th>
		<th class="pull-center">Current Stock Status </th>
	</tr>
	
      <tr>
        <td>DPCED123</td>
        <td>Bracelates</td>
		<td>10</td>
        <td>5</td>
		<td>15</td>
		<td>pices</td>
		<td>2017-09-07 </td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Close</a></td>
		<td>Normal</td>
		</tr>
        <tr>
        <td>DPCED123</td>
        <td>Bracelates</td>
		<td>4</td>
        <td>11</td>
		<td>15</td>
		<td>pices</td>
		<td>2017-09-07 </td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Close</a></td>
		<td>Major</td>
		</tr>
        <tr>
        <td>DPCED123</td>
        <td>Bracelates</td>
		<td>1</td>
        <td>14</td>
		<td>15</td>
		<td>pices</td>
		<td>2017-09-07 </td>
		<td><a data-toggle="modal" data-target="#productaddmodal"><span class="glyphicon glyphicon-edit"></span>Close</a></td>
		<td>critical</td>
		</tr>
  </table>
		</div>
	</div>
</div>	
	
<div  id="stockhistory" style="display: none">
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
	    <th class="pull-center">Item Id</th>
		<th class="pull-center">Item Name</th>
		<th class="pull-center"><a>Order Id</a></th>
		<th class="pull-center"><a>Supplier Id</a></th>
		<th class="pull-center">Supplier Name</th>
		<th class="pull-center">Last Stock Update</th>
		<th class="pull-center">Stock Update By</th>
	</tr>
	
      <tr>
        <td><a data-toggle="modal" data-target="#productdetailmodal">DPCED123</a></td>
        <td>Bracelates</td>
		<td><a data-toggle="modal" data-target="#orderdetailsmodal">DD123234</a></td>
        <td><a data-toggle="modal" data-target="#suppliermodal">ASDSDDSE</a></td>
		<td>Sudhakar jena</td>
		<td>2017-09-07 </td>
		<td>Admin</td>
		</tr>
            <tr>
        <td><a data-toggle="modal" data-target="#productdetailmodal">DPCED123</a></td>
        <td>Bracelates</td>
		<td><a data-toggle="modal" data-target="#orderdetailsmodal">DD123234</a></td>
        <td><a data-toggle="modal" data-target="#suppliermodal">ASDSDDSE</a></td>
		<td>Sudhakar jena</td>
		<td>2017-09-07 </td>
		<td>Admin</td>
		</tr>
      <tr>
        <td><a data-toggle="modal" data-target="#productdetailmodal">DPCED123</a></td>
        <td>Bracelates</td>
		<td><a data-toggle="modal" data-target="#orderdetailsmodal">DD123234</a></td>
        <td><a data-toggle="modal" data-target="#suppliermodal">ASDSDDSE</a></td>
		<td>Sudhakar jena</td>
		<td>2017-09-07 </td>
		<td>Admin</td>
		</tr>
  </table>
		</div>
</div>
</div>

<div  id="customerlist" style="display: none">
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
	    <th class="pull-center">Customer Name</th>
		<th class="pull-center">Type</th>
		<th class="pull-center">Mobile Number</th>
		<th class="pull-center">Last Transaction Date</th>
	    <th class="pull-center">Billed Amount</th>
		<th class="pull-center">Current Status</th>
	</tr>
	
      <tr>
	    <td>Sudhakar Jena</td>
		<td>Individual</td>
	    <td>91-7057014118</td>
        <td>2017-May-10</td>
		<td>25000.00</td>
		<td>Over Due</td>
	  </tr>
       <tr>
	    <td>Sudhakar Jena</td>
		<td>Individual</td>
	    <td>91-7057014118</td>
        <td>2017-May-10</td>
		<td>25000.00</td>
		<td>Over Due</td>
	  </tr>
       <tr>
	    <td>Sudhakar Jena</td>
		<td>Individual</td>
	    <td>91-7057014118</td>
        <td>2017-May-10</td>
		<td>25000.00</td>
		<td>Over Due</td>
	  </tr>
   </table>
 </div>
 </div> </div>
 
<div id="customerwizard" style="display: none">
        <div class="wizard">
            <div class="wizard-inner">
                <div class="connecting-line"></div>
                <ul class="nav nav-tabs" role="tablist">

                    <li role="presentation" class="active">
                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="customer details">
                            <span class="round-tab">
                                <i class="fa fa-user-plus" aria-hidden="true"></i>
                            </span>
                        </a>
                    </li>

                    <li role="presentation" class="disabled">
                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Address Details">
                            <span class="round-tab">
                               <i class="fa fa-address-book" aria-hidden="true"></i>
                            </span>
                        </a>
                    </li>
					   <li role="presentation" class="disabled">
                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Purchase Details">
                            <span class="round-tab">
                                <i class="fa fa-file" aria-hidden="true"></i>
                            </span>
                        </a>
                    </li>
                    <li role="presentation" class="disabled">
                        <a href="#step4" data-toggle="tab" aria-controls="step4" role="tab" title="Payment Details">
                            <span class="round-tab">
                                <i class="fa fa-money" aria-hidden="true"></i>
                            </span>
                        </a>
                    </li>
                   <li role="presentation" class="disabled">
                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Complete">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-ok"></i>
                            </span>
                        </a>
                    </li>
                </ul>
            </div>

            <form role="form">
                <div class="tab-content">
                    <div class="tab-pane active" role="tabpanel" id="step1">
                                <div class="col-sm-12 form-group">
														<div class="col-sm-2">
													<select class="form-control" id="productcatagory" name="productcatagory">
														<option>Select</option>
														<option>Mr.</option>
														<option>Mrs.</option>
                                                        <option>Miss</option>
                                                    </select>	
														</div>

														<div class="col-sm-4">
															<div class="inputer">
																<div class="input-wrapper">
																	<input type="text" class="form-control" placeholder="First Name *" name="fname">
																</div>
															</div>
														</div>

														<div class="col-sm-6">
															<div class="inputer">
																<div class="input-wrapper">
																	<input type="text" class="form-control" placeholder="Family Name/Last Name *" name="faname">
																</div>
															</div>
														</div>
												</div><!--.col-->
														<div class="col-sm-12 form-group">
														<div class="col-sm-6">
															<div class="inputer">
																<div class="input-wrapper">
																	<input type="text" name="birthday" class="form-control bootstrap-daterangepicker-basic" value="" placeholder="Date Of Birth*" />
																</div>
															</div>
														</div>	

														<div class="col-sm-5 padding-right-zero">
															<div class="inputer">
																<div class="input-wrapper">
																	<input type="email" class="form-control" name="email1" placeholder="Email Id*">
																</div>
															</div>
														</div>
												</div>
							<div class="col-sm-12 form-group">
														<div class="col-sm-6">
													<select class="form-control" id="productcatagory" name="productcatagory">
														<option>Select</option>
														<option>Male</option>
														<option>Female</option>
                                                    </select>
														</div>	
														<div class="col-sm-1 padding-right-zero phone">
													<select class="form-control" id="productcatagory" name="productcatagory">
														<option>Select</option>
														<option>+91</option>
														<option>+89</option>
                                                    </select>
														</div>	
														<div class="col-sm-4 padding-right-zero">
															<div class="inputer">
																<div class="input-wrapper">
																	<input type="text" class="form-control" name="phoneno" placeholder="Phone Number*">
																</div>
															</div>
														</div>
														<div class="col-sm-1 text-right" id="abc1">
															<a class="btn btn-red btn-xs btn-ripple" id="reg_no_ver3" onClick="if($('#reg_no_ver3')[0].className == 'btn btn-red btn-xs btn-ripple'){$('#phonedefaultModal').modal();}"><i class="fa fa-check-square-o"></i></a>



															<div class="modal scale fade" id="phonedefaultModal" tabindex="-1" role="dialog" aria-hidden="true">
																<div class="modal-dialog">
																	<div class="modal-content">
																		<div class="modal-header bg-main-color">
																			<div class="col-sm-12">
																				<h4 class="modal-title">Phone Verification</h4>
																			</div><!--.col-->
																			<div class="clearfix"></div>
																		</div>
																		<div class="modal-body">

																			<div id="pane-login" class="panel-body active">
																				<div class="form-group">
																					<div class="inputer">
																						<div class="input-wrapper">
																							<input type="text" class="form-control" placeholder="Enter OTP">
																						</div>
																					</div>
																				</div><!--.form-group-->
																				<div class="form-buttons clearfix">
																					<button class="btn btn-success btn-xs pull-right" onClick="$('#phonedefaultModal').modal('hide');" type="button">Submit</button>
																					
																					<button class="btn btn-success btn-xs pull-right" style="margin-right: 10px;" onClick="$('#phonedefaultModal').modal('hide');" type="button">Re Send OTP</button>
																				</div><!--.form-buttons-->
																			</div><!--#login.panel-body-->
																		</div>
																	</div><!--.modal-content-->
																</div><!--.modal-dialog-->
															</div><!--.modal-->
														</div>
												</div>														
                      
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-primary next-step">Save and continue</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step2">
                        			<div class="col-sm-12 form-group">
												<div class="col-sm-8">
													<div class="col-sm-12 padding-zero">
														<div class="inputer">
															<div class="input-wrapper">
																<textarea class="form-control" rows="1" placeholder="Address Line1"></textarea>
															</div>
														</div>
														<div class="inputer">
															<div class="input-wrapper">
																<textarea class="form-control" rows="1" placeholder="Address Line2"></textarea>
															</div>
														</div>
													</div>
													<div class="col-sm-6 padding-left-zero">
														<div class="inputer">
															<div class="input-wrapper">
																<input type="text" class="form-control" placeholder="City" name="city">
															</div>
														</div>
													</div>
													<div class="col-sm-6 padding-right-zero">
														<select class="form-control" id="productcatagory" name="productcatagory">
														<option>Select</option>
														<option>GOA</option>
														<option>DELHI</option>
                                                    </select>
													</div>
													<div class="clearfix"></div>
													<div class="col-sm-6 padding-left-zero">
														<div id="basic" data-input-name="country" data-width="100%"></div>
													</div>
													<div class="col-sm-6 padding-right-zero">
														<div class="inputer">
															<div class="input-wrapper">
																<input type="text" class="form-control" placeholder="Pin Code" name="pin_code">
															</div>
														</div>
													</div>	
												</div>
												<div class="col-sm-4">
														<div class="col-sm-6 padding-right-zero">
														<div class="inputer">
															<div class="input-wrapper">
																<textarea type="text" class="form-control" placeholder="Shipping Address Details" name="pin_code"></textarea>
															</div>
														</div>
													</div>
												</div>
											</div>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Previous</button></li>
                            <li><button type="button" class="btn btn-primary next-step">Save and continue</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step3">
                       
	<div class="panel-body">
	<div class="col-md-8">
		<div class="table-responsive">
			<table class="table table-bordered table-fixed table-hover">
    <tr class ="success">
	    <th class="pull-center">Item Type</th>
	    <th class="pull-center">Item Name</th>
		<th class="pull-center">Item Code</th>
		<th class="pull-center">Item Wegiht</th>
		<th class="pull-center">Quantity</th>
		<th class="pull-center">Amount</th>
	    <th class="pull-center">Discount</th>
	</tr>

      <tr>
	    <td>Gold</td>
	    <td>Jhumuka</td>
        <td>DP123445</td>
		<td>100gm</td>
		<td>2</td>
		<td>23000.00</td>
		<td>N/A</td>
	  </tr>
  </table>
  </div>
  </div>
  <div class="col-md-4">
  <table class="table table-bordered table-fixed table-hover">
  	<tr class ="success">
	<th class="pull-center">Makeing Charges</th>
	<th class="pull-center">Carret</th>
	</tr>
	 <tr>
	  <td>400.00</td>
	  <td>24</td>
	 </tr>
  </table>
  </div>
	</div>	
	<div class="panel-footer">
	   <div class="col-md-9 col-lg-9 table-responsive"> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Total Billed Amount(INR)</td>
                        <td>75000.00</td>
                      </tr>
                      <tr>
                        <td>Total Recived Amount(INR)</td>
                        <td>6000.00</td>
                      </tr>
                        <tr>
                        <td>Total Due Amount(INR)</td>
                        <td>6000.00</td>
                      </tr>
                      <tr>
                        <td>Due Reasone</td>
                        <td>sadadsad</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
	</div>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Previous</button></li>
                            <li><button type="button" class="btn btn-default next-step">Skip</button></li>
                            <li><button type="button" class="btn btn-primary btn-info-full next-step">Save and continue</button></li>
                        </ul>
                    </div>
					  <div class="tab-pane" role="tabpanel" id="step4">
            <div class="panel-body">
					<div class="panel with-nav-tabs panel-success">
						
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" class="pull-center"
								href="#cardPayment">Card</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#netbanking">NetBanking</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#walletpayment">Wallet</a></li>
						    <li><a data-toggle="tab" class="pull-center"
								href="#otherpayment">Other</a></li>
						</ul>
						<div class="panel-body">
							<div class="tab-content">
								<div id="cardPayment" class="tab-pane fade in active">
								    <div class="col-sm-8">
													<div class="col-sm-12 padding-zero">
													<div class="col-sm-6">
														<div class="inputer">
															<div class="input-wrapper">
																	<input type="text" class="form-control" placeholder="NAME ON CARD" name="nameoncard" required>
															</div>
														</div>
													</div>	
													<div class="col-sm-5">
														<div class="inputer">
															<div class="input-wrapper">
																	<input type="text" class="form-control" placeholder="CARD NUMBER" name="cardnumber" required>
															</div>
														</div>
									                </div>
													  </div>
												<div class="col-sm-12 padding-zero">
												<div class="col-sm-8">
															<div class="input-wrapper">
														   <h5>EXPIRATION</h5>
														   <div class="col-sm-3">
																	<input type="number" class="form-control"  value="6" min="1" />	
															</div>
															<div class="col-sm-4">
																	<input type="number" class="form-control"   value="1988" min="1" />	
													      </div>
													  </div>
													 </div>
													 	<div class="col-sm-4">
													<div class="inputer">
															<div class="input-wrapper">										
														<input type="text" class="form-control" placeholder="CVV NUMBER" name="cvvnumber" max=4 min=3 requried>
													</div>
													</div>
													</div>
									              </div>
													
												</div>	
								
								</div>
								<div id="netbanking" class="tab-pane fade">
					            		<div class="swit">								
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>Andhra Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Allahabad Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Bank of Baroda</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Canara Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IDBI Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Icici Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Overseas Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Punjab National Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>South Indian Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>State Bank Of India</label> </div></div>		
												</div>
												<div class="swit">								
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>City Union Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>HDFC Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>IndusInd Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Syndicate Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Deutsche Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Corporation Bank</label> </div></div>
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>UCO Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Indian Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Federal Bank</label> </div></div>	
													<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>ING Vysya Bank</label> </div></div>	
												</div>
									
								</div>

								<div id="walletpayment" class="tab-pane fade">
											<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>PayTM</label> </div></div>
											<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>PayPal</label> </div></div>

								</div>
								<div id="otherpayment" class="tab-pane fade">
											<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio" checked=""><i></i>Cash</label> </div></div>
											<div class="check_box"> <div class="radio"> <label><input type="radio" name="radio"><i></i>Chqueu</label> </div></div>

								</div>
								
								</div><!-- PAGE CONTENT ENDS -->
								</div>
							
					       </div>
	               </div>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Previous</button></li>
                            <li><button type="button" class="btn btn-default next-step">Skip</button></li>
                            <li><button type="button" class="btn btn-primary btn-info-full next-step">Save and continue</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="complete">
                             
                         <object data="data/yesbankpay.pdf" type="application/pdf" class="form-control" style="width:900px; height:400px;">
							<a href="data/yesbankpay.pdf">yesbankpay.pdf</a>
						</object>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </form>
        </div>
</div><!--.display-animation-->
 
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

<div id="checkoutdetails" style="display: none">
 <div class="panel-body">
<table class="table table-bordered table-fixed table-hover">
			 <tr class ="success">
	    <th class="pull-center">Catelogue Id</th>
		 <th class="pull-center">Catelogue Name</th>
		 <th class="pull-center">Product Id</th>
		 <th class="pull-center">Item Name</th>
		 <th class="pull-center">Item For</th>
		 <th class="pull-center">Size</th>
		 <th class="pull-center">Carat</th>
		 <th class="pull-center">Net Weight</th>
		 <th class="pull-center">Stone Used</th>
		 <th class="pull-center">Stone Color</th>
		 <th class="pull-center">Quantity</th>
		 
	  </tr>
	
      <tr>
        <td>DS1233</td>
		 <td>ASsdsdsdsald</td>
		 <td>Bracletes</td>
		<td>PROD_1234</td>
        <td>Men</td>
		<td><input type="text" class="form-control" value="27-24"></td>
		<td><input type="text" class="form-control" value="24"></td>
		<td><input type="text" class="form-control" value="10-25"></td>
		<td><input type="text" class="form-control" value="Y"></td>
		<td><input type="text" class="form-control" value="Any"></td>
		<td><input type="text" class="form-control" value="10">10</input></td>
	 </tr>
	   <tr>
        <td>DS1234</td>
		 <td>ASsdsdsdsa</td>
		 <td>Bracletes</td>
		<td>PROD_1235</td>
        <td>Women</td>
		<td><input type="text" class="form-control">25-22</input></td>
		<td><input type="text" class="form-control">24</input></td>
		<td><input type="text" class="form-control">10-25</input></td>
		<td><input type="text" class="form-control">Y</input></td>
		<td><input type="text" class="form-control">Rose/Red/Yellow</input></td>
		<td><input type="text" class="form-control">10</input></td>
	 </tr>
   </table>
<table class="table table-bordered table-fixed table-hover">
			 <tr class ="success">
	    <th class="pull-center">Catelogue Id</th>
		 <th class="pull-center">Catelogue Name</th>
		 <th class="pull-center">Product Id</th>
		 <th class="pull-center">Item Name</th>
		 <th class="pull-center">Item For</th>
		 <th class="pull-center">Size</th>
		 <th class="pull-center">Carat</th>
		 <th class="pull-center">Net Weight</th>
		 <th class="pull-center">Stone Used</th>
		 <th class="pull-center">Stone Color</th>
		 <th class="pull-center">Quantity</th>
		 
	  </tr>
	
      <tr>
        <td>DS1233</td>
		 <td>ASsdsdsdsald</td>
		 <td>Bracletes</td>
		<td>PROD_1234</td>
        <td>Men</td>
		<td><input type="text" class="form-control" value="27-24"></td>
		<td><input type="text" class="form-control" value="24"></td>
		<td><input type="text" class="form-control" value="10-25"></td>
		<td><input type="text" class="form-control" value="Y"></td>
		<td><input type="text" class="form-control" value="Any"></td>
		<td><input type="text" class="form-control" value="10">10</input></td>
	 </tr>
	   <tr>
        <td>DS1234</td>
		 <td>ASsdsdsdsa</td>
		 <td>Bracletes</td>
		<td>PROD_1235</td>
        <td>Women</td>
		<td><input type="text" class="form-control">25-22</input></td>
		<td><input type="text" class="form-control">24</input></td>
		<td><input type="text" class="form-control">10-25</input></td>
		<td><input type="text" class="form-control">Y</input></td>
		<td><input type="text" class="form-control">Rose/Red/Yellow</input></td>
		<td><input type="text" class="form-control">10</input></td>
	 </tr>
   </table>
 
</div>
</div>

<div id="recivedproductdetails" style="display: none">
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
	    <th class="pull-center">Catelogue Id</th>
		<th class="pull-center">Item Code</th>
		<th class="pull-center">Product Id</th>
		<th class="pull-center">Purity</th>
		<th class="pull-center">Pure Weight</th>
		<th class="pull-center">Net Weight</th>
		<th class="pull-center">Meena Weight</th>
		<th class="pull-center">Wastage Weight</th>
		<th class="pull-center">Gross Weight</th>
		<th class="pull-center">Total Stone Used</th>
		<th class="pull-center">Total Stone Weight</th>
		<th class="pull-center">Stone Color</th>
		<th class="pull-center">Stone Price</th>
		<th class="pull-center">Making Charges</th>
		<th class="pull-center">HM Tag Price</th>
		<th class="pull-center">MRP Buy Price</th>
	</tr>
      <tr>
        <td>DS1234</td>
		<td>DS_RING_1234</td>
        <td>22</td>
		<td>10 mg</td>
        <td>12 mg</td>
		<td>1 mg</td>
		<td>30-May-2017</td>
		<td>Satyajit </td>
		<td>Glod</td>
		<td>due</td>
		<td>Need to lear rest amount by gold</td>
		<td></td>
	  </tr>
      <tr>
        <td>DDREC_124</td>
        <td>DD_PUARCHE_02</td>
		<td>30-May-2017</td>
        <td>10</td>
		<td>100 mg</td>
		<td>30-May-2017</td>
		<td>Satyajit </td>
		<td>Glod</td>
		<td>due</td>
		<td>Need to lear rest amount by gold</td>
		<td><a data-toggle="modal" data-target="#orderrecivemodal"><span class="glyphicon glyphicon-edit"></span>View/Modify</a></td>
	  </tr>
      <tr>
        <td>DDREC_125</td>
        <td>DD_PUARCHE_02</td>
		<td>30-May-2017</td>
        <td>10</td>
		<td>100 mg</td>
		<td>30-May-2017</td>
		<td>Satyajit </td>
		<td>Glod</td>
		<td>due</td>
		<td>Need to lear rest amount by gold</td>
		<td><a data-toggle="modal" data-target="#orderrecivemodal"><span class="glyphicon glyphicon-edit"></span>View/Modify</a></td>
	  </tr>
  </table>
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
					<div class="panel with-nav-tabs panel-success">
						<ul class="nav nav-tabs">
							<li class="active"><a data-toggle="tab" class="pull-center"
								href="#productbasicdetails">Product Details</a></li>
							<li><a data-toggle="tab" class="pull-center"
								href="#productimagedetails">Images</a></li>
						</ul>
						<div class="panel-body">
							<div class="tab-content">
								<div id="productbasicdetails" class="tab-pane fade in active">
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
													 <label for="gender">Description Text</label>
													<textarea class="form-control" id="desctext"name="desctext">
												    </textarea>
												   </div>
										</div>
										<div class="col-md-4">
												   	<div class="form-group">
													 <label for="gender">Degine Description</label>
													<textarea class="form-control" id="deginedesc"name="deginedesc">
												    </textarea>
												   </div>
										</div>
										<div class="col-md-4">
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
								</div>
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
 
 <div id="stockupdateModal" class="modal fade" data-backdrop="static" data-keyboard="false" role="dialog">
   <div class="modal-dialog modal-md">
  
   <div class="modal-content">
   
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Product Details</h4>
      </div>
	  <div class="modal-body">
         	<div class="panel-body">
				<div class="form-group">
				        <label for="bankname">Purchase Recived ID</label>
						<input type="text" name="productrecciveid" id="productrecciveid" class="form-control" placeholder="Product Recive ID">
				</div>
					<button type="submit" id="usersearch" class="btn btn-default"  data-dismiss="modal">Processed</button>
			</div>
			
			  <div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Close</button>
                 </div>
	   </div>
	   </div>
  </div>
</div>

<div id="processreciveModal" class="modal fade" data-backdrop="static" data-keyboard="false" role="dialog">
   <div class="modal-dialog modal-md">
  
   <div class="modal-content">
   
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Recive Details</h4>
      </div>
	  <div class="modal-body">
         	<div class="panel-body">
				<div class="form-group">
				        <label for="bankname">Purchase ID</label>
						<input type="text" name="purchaseid" id="purchaseid" class="form-control" placeholder="Purchaseid Id">
				</div>
					<button type="submit" id="processpurchase" class="btn btn-default"  data-dismiss="modal">Process</button>
			</div>
			
			  <div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Close</button>
                 </div>
	   </div>
	   </div>
  </div>
</div>

<div id="quantitymodal" class="modal fade" data-backdrop="static" data-keyboard="false" role="dialog">
   <div class="modal-dialog modal-md">
  
   <div class="modal-content">
   
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Quantity Details</h4>
      </div>
	  <div class="modal-body">
         	<div class="panel-body">
			
							<div class="table-responsive">
						  <table class="table table-bordered table-fixed table-hover">
							<tr class ="success">
								<th class="pull-center">Supplier Name</th>
								<th class="pull-center">Supplier ID</th>
								<th class="pull-center">Catalogue Id</th>
								<th class="pull-center">Category</th>
								<th class="pull-center">Sub Category</th>
								<th class="pull-center">Matrial Type</th>
								<th class="pull-center">Carret</th>
								<th class="pull-center">Size</th>
								<th class="pull-center">Weight</th>
							</tr>
							<tr>
								<td>RadhaMohan Jewellry</td>
								<td>DD1234567</td>
								<td>DDCAT6785</td>
								<td>Ring</td>
								<td>Chain Ring</td>
								<td>Gold</td>
								<td>22</td>
								<td>10-20</td>
								<td>10gm</td>
							</tr>
						</table>
						</div>
						
						<label for="bankname">Quantity in Pices</label>
						<input type="text" name="pquantity" id="pquantity" class="form-control" placeholder="Purchase Quantity">
				
			</div>
			
			  <div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Add to Cart</button>
                <button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Close</button>
				</div>
	   </div>
	   </div>
  </div>
</div>

<div id="checkoutmodal" class="modal fade" data-backdrop="static" data-keyboard="false" role="dialog">
   <div class="modal-dialog modal-md">
  
   <div class="modal-content">
   
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Puarche Details</h4>
      </div>
	  <div class="modal-body">
         	<div class="panel-body">
	<table class="table table-bordered table-fixed table-hover">
			 <tr class ="success">
	    <th class="pull-center">Catelogue Id</th>
		 <th class="pull-center">Catelogue Name</th>
		 <th class="pull-center">Item Category</th>
		 <th class="pull-center">Item Sub-Category</th>
		 <th class="pull-center">Item Degine Type</th>
		 <th class="pull-center">Quantity</th>
	  </tr>
	
      <tr>
        <td>DS1233</td>
		 <td>ASsdsdsdsald</td>
		<td>GOld</td>
        <td>Bracelates</td>
		<td>Chain</td>
		<td>10</td>
	 </tr>
   </table>
			</div>
			  <div class="modal-footer">
			   <button id="checkoutbutton" type="button" class="btn btn-default"><i class="fa fa-times-circle" aria-hidden="true"></i>Check Out</button>
                <button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Continu Shopping</button>
				</div>
	   </div>
	   </div>
  </div>
</div>

<div id="productpurchasemodal" class="modal fade" data-backdrop="static" data-keyboard="false" role="dialog">
   <div class="modal-dialog modal-md">
  
   <div class="modal-content">
   
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Puarche Details</h4>
      </div>
	  <div class="modal-body">
         	<div class="panel-body">
	<table class="table table-bordered table-fixed table-hover">
			 <tr class ="success">
	    <th class="pull-center">Catelogue Id</th>
		 <th class="pull-center">Catelogue Name</th>
		 <th class="pull-center">Product Id</th>
		 <th class="pull-center">Item Name</th>
		 <th class="pull-center">Item For</th>
		 <th class="pull-center">Size</th>
		 <th class="pull-center">Carat</th>
		 <th class="pull-center">Net Weight</th>
		 <th class="pull-center">Stone Used</th>
		 <th class="pull-center">Stone Color</th>
		 <th class="pull-center">Quantity</th>
		 
	  </tr>
	
      <tr>
        <td>DS1233</td>
		 <td>ASsdsdsdsald</td>
		 <td>Bracletes</td>
		<td>PROD_1234</td>
        <td>Men</td>
		<td><input type="text" class="form-control" value="27-24"></td>
		<td><input type="text" class="form-control" value="24"></td>
		<td><input type="text" class="form-control" value="10-25"></td>
		<td><input type="text" class="form-control" value="Y"></td>
		<td><input type="text" class="form-control" value="Any"></td>
		<td><input type="text" class="form-control" value="10">10</input></td>
	 </tr>
	   <tr>
        <td>DS1234</td>
		 <td>ASsdsdsdsa</td>
		 <td>Bracletes</td>
		<td>PROD_1235</td>
        <td>Women</td>
		<td><input type="text" class="form-control">25-22</input></td>
		<td><input type="text" class="form-control">24</input></td>
		<td><input type="text" class="form-control">10-25</input></td>
		<td><input type="text" class="form-control">Y</input></td>
		<td><input type="text" class="form-control">Rose/Red/Yellow</input></td>
		<td><input type="text" class="form-control">10</input></td>
	 </tr>
   </table>
			</div>
			  <div class="modal-footer">
			   <button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Update</button>
								<button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>Close</button>
				</div>
	   </div>
	   </div>
  </div>
</div>

<div id="vendorListmodal" class="modal fade" data-backdrop="static" data-keyboard="false" role="dialog">
   <div class="modal-dialog modal-md">
  
   <div class="modal-content">
   
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Vendor Details</h4>
      </div>
	  <div class="modal-body">
         	<div class="panel-body">
			<div class="col-md-4">
<input list="vendors" class="form-control" placeholder="Vendor Details">
<datalist id="vendors">
  <option value="ABC sad">
  <option value="PQR sad">
  <option value="DFV asd">
</datalist>
</div>
<div class="col-md-4">
<input  class="form-control" placeholder="Quantity">
</div>
<div class="col-md-6">
<p>Name : Sudhanshu <p>
<p>Address : syad,rpet,aaasda,pin-756019<p>
<p>Email : asd@gmail.com<p>
<p>Mobile Number : +91-705014119 <p>
<p>Shop Number : +91-705014119 <p>
</div>
			</div>
			  <div class="modal-footer">
			   <button id="checkoutbutton" type="button" class="btn btn-default"><i class="fa fa-times-circle" aria-hidden="true"></i>save</button>
                <button type="button" class="btn btn-default"
								data-dismiss="modal"><i class="fa fa-times-circle" aria-hidden="true"></i>close</button>
				</div>
	   </div>
	   </div>
  </div>
</div>

</body>
<script type="text/javascript">
$('#checkoutbutton').on('click', function(){
  $('#checkoutmodal').modal('hide');
  $('#supplierproductlist').hide();
  $('#purchasedetails').show();
});

$('a').on('click', function(){
   var target = $(this).attr('rel');
   $("#"+target).show().siblings("div").hide();
});


$(document).ready(function () {
    //Initialize tooltips
    $('.nav-tabs > li a[title]').tooltip();
    
    //Wizard
    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {

        var $target = $(e.target);
    
        if ($target.parent().hasClass('disabled')) {
            return false;
        }
    });

    $(".next-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        $active.next().removeClass('disabled');
        nextTab($active);

    });
    $(".prev-step").click(function (e) {

        var $active = $('.wizard .nav-tabs li.active');
        prevTab($active);

    });
});

function nextTab(elem) {
    $(elem).next().find('a[data-toggle="tab"]').click();
}
function prevTab(elem) {
    $(elem).prev().find('a[data-toggle="tab"]').click();
}
</script>
  </html>