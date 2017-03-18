<?php
if (!session_id()) session_start();
if (!$_SESSION['logon']){
	header("Location:index.php");
	die();
}
?>


<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ST.MARY's CONVENT SCHOOL</title>
	<link rel="shortcut icon" href="img/site-logo.ico">
    
    <!-- Styles -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,700,800" rel="stylesheet" type="text/css"><!-- Google web fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"><!-- font-awesome -->
    <link href="js/dropdown-menu/dropdown-menu.css" rel="stylesheet" type="text/css"><!-- dropdown-menu -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"><!-- Bootstrap -->
    <link href="js/fancybox/jquery.fancybox.css" rel="stylesheet" type="text/css"><!-- Fancybox -->
    <link href="js/audioplayer/audioplayer.css" rel="stylesheet" type="text/css"><!-- Audioplayer -->
    <link href="style.css" rel="stylesheet" type="text/css"><!-- theme styles -->

  </head>
  
  <body role="document">
  
    <!-- device test, don't remove. javascript needed! -->
    <span class="visible-xs"></span><span class="visible-sm"></span><span class="visible-md"></span><span class="visible-lg"></span>
    <!-- device test end -->
    
    <div id="k-head" class="container"><!-- container + head wrapper -->
    
    	<div class="row"><!-- row -->
        
            <nav class="k-functional-navig"><!-- functional navig -->
        
                <ul class="list-inline pull-right">
                    <li><a href="index.php">LOGOUT</a></li>
                    <li><a href="#">Calendar</a></li>
             
                </ul>
        
            </nav><!-- functional navig end -->
        
        	
            
        </div><!-- row end -->
    
    </div><!-- container + head wrapper end -->
    
    <div id="k-body"><!-- content wrapper -->
    
    	<div class="container"><!-- container -->
        
        	<div class="row"><!-- row -->
            
                         
            	<div class="k-breadcrumbs col-lg-12 clearfix"><!-- breadcrumbs -->
                
                	<ol class="breadcrumb">
                    	<li><a href="admin_page.php">Back</a></li>
                        <li class="active">Slider at Home Page</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter fullwidth"><!-- row -->
                
                <div class="col-lg-12 col-md-12"><!-- doc body wrapper -->
                	
                    <div class="col-padded"><!-- inner custom column -->
                        
						<?php
						
						include 'sql.php';
						$SQL ="SELECT * FROM gallery_details";
						$result = mysql_query($SQL);
						$noofrows = mysql_num_rows($result);
						print("<h1 class='page-title'>ST Mary's School students buzz <span class='label label-info'>$noofrows Slides</span></h1>");
                        
						
						
						?> 
						<div class="row">
								 <div class="col-sm-12">
								  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#slidermodal">Add Sliders</button>
							</div>
						</div>                        
						<div class="news-body">
                            
                            <div class="row gutter k-equal-height"><!-- row -->
                            
                                <?php
								 error_reporting( ~E_NOTICE );
								 require_once 'dbconfig.php';
								 
								 $stmt = $DB_con->prepare('SELECT * FROM slider_details ORDER BY id DESC');
								 $stmt->execute();
								 
								 if($stmt->rowCount() > 0)
								 {
								  while($row=$stmt->fetch(PDO::FETCH_ASSOC))
								  {
								   extract($row);
								?>
						   <div class="col-xs-3">
							<p class="page-header"><?php echo $row['slider_title']; ?></p>
							<p class="page-header"><?php echo $row['slider_content']; ?></p>
							<img src="<?php echo $row['slider_image']; ?>" width="250px" height="250px" />
							<p class="page-header">
							<span>
							
							<a class="btn btn-danger" href="delete_sliders.php?delete_id=<?php echo $row['id']; ?>" title="click for delete" onclick="return confirm('sure to delete ?')"><span class="glyphicon glyphicon-remove-circle"></span> Delete</a>
							</span>
							</p>
						   </div>       
							<?php
								  }
								 }
								 else
								 {
							?>
							<div class="col-xs-12">
								<div class="alert alert-warning">
									<span class="glyphicon glyphicon-info-sign"></span> &nbsp; No Data Found ...
								</div>
							</div>
							<?php
								 }
								 
							?>
                            </div><!-- row end -->
                            
                        </div>
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- doc body wrapper end -->
            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- content wrapper end -->
	
	<div id="slidermodal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="title-median">Slider Details</h4>
      </div>
      <div class="modal-body">				
		<form method="post" enctype="multipart/form-data" class="form-horizontal" id="slider_form"  action="add_sliders.php">
     
			 <table class="table table-bordered table-responsive">
			 
				<tr>
				 <td><label class="control-label">Slider Title</label></td>
					<td><input class="form-control" type="text" name="slidertitle" placeholder="" value="<?php echo $slidertitle; ?>" /></td>
				</tr>
				<tr>
				 <td><label class="control-label">Slider Content</label></td>
					<td><textarea class="form-control" style="min-width: 100%" name="slidercontent" form="slider_form" value="<?php echo $slidercontent; ?>" /></textarea></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Image to Upload</label></td>
					<td><input class="input-group" type="file" name="slider" accept="img/*" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><button type="submit" name="add_slider" class="btn btn-default"> Add Slider to Homepage </button>
					</td>
				</tr>
				
				</table>
				
		</form>
	
      </div>
      <!--div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div-->
    </div>

  </div>
</div> 
	
	
    
 
    <div id="k-subfooter"><!-- subfooter -->
    
    	<div class="container"><!-- container -->
        
        	<div class="row"><!-- row -->
            
            	<div class="col-lg-12">
                
                	<p class="copy-text text-inverse">
                    &copy; 2017 St Mary's Convent Schools. All rights reserved. | Designed By LogicQ SoftSol Pvt. Ltd.
                    </p>
                
                </div>
            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- subfooter end -->

    <!-- jQuery -->
    <script src="jQuery/jquery-2.1.1.min.js"></script>
    <script src="jQuery/jquery-migrate-1.2.1.min.js"></script>
    
    <!-- Bootstrap -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    
    <!-- Drop-down -->
    <script src="js/dropdown-menu/dropdown-menu.js"></script>
    
    <!-- Fancybox -->
	<script src="js/fancybox/jquery.fancybox.pack.js"></script>
    <script src="js/fancybox/jquery.fancybox-media.js"></script><!-- Fancybox media -->
    
    <!-- Responsive videos -->
    <script src="js/jquery.fitvids.js"></script>
    
    <!-- Audio player -->
	<script src="js/audioplayer/audioplayer.min.js"></script>
    
    <!-- Pie charts -->
    <script src="js/jquery.easy-pie-chart.js"></script>
    
    <!-- Google Maps -->
    <script src="https://maps.googleapis.com/maps/api/js?sensor=true"></script>
    
    <!-- Theme -->
    <script src="js/theme.js"></script>
    
  </body>
</html>