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
                        <li class="active">Contact-Us</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter"><!-- row -->
                
                <div class="col-lg-8 col-md-8"><!-- doc body wrapper -->
                	
                    <div class="col-padded"><!-- inner custom column -->
                    
                    	<div class="row gutter"><!-- row -->
                        
                        	<div class="col-lg-12 col-md-12">
                            
                                <h1 class="page-title">Contact Us</h1>
                                
                                <div class="news-body">
								
								<div class="col-sm-12">
								  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#school_contact_modal">Add School Address Here</button>
								</div>
                                
								<?php
								 error_reporting( ~E_NOTICE );
								 require_once 'dbconfig.php';
								 
								 $stmt = $DB_con->prepare('SELECT id, title, address1, address2, address3, Pin, Tel, Fax, mailid, fblink, twiterlink FROM contact_us');
								 $stmt->execute();
								 
								 if($stmt->rowCount() > 0)
								 {
								  while($row=$stmt->fetch(PDO::FETCH_ASSOC))
								  {
								   extract($row);
								?>
						
								<div itemscope itemtype='http://data-vocabulary.org/Organization'>
									<h2 class="title-median m-contact-subject" itemprop="name"><?php echo $row['title'];  ?></h2>
									<div class="m-contact-address" itemprop="address" itemscope itemtype="http://data-vocabulary.org/Address">
									
									<span class="m-contact-street" itemprop="street-address"><?php echo $row['address1'];  ?></span>
									<span class="m-contact-city-region" itemprop="street-address"><?php echo $row['address2'];  ?></span>
									<span class="m-contact-zip-country" itemprop="street-address"><?php echo $row['address3'];  ?></span>
									<span class="m-contact-zip-country" ><?php echo $row['Pin'];  ?></span>
									</div>
									<div class="m-contact-tel-fax">
										 <span class="m-contact-tel">Tel:
										 <span itemprop="tel"><?php echo $row['Tel'];  ?></span>
										 </span>
										 <span class="m-contact-fax">	
										 <span itemprop="fax"><?php echo $row['Fax']  ?></span>
										 </span>
									</div>
								</div>			
								<div class="social-icons">
								<ul class="list-unstyled list-inline">
								<li><a href="mailto:<?php echo $row['mailid']  ?>" title="Contact us"><i class="fa fa-envelope"></i></a></li>
								<li><a href="<?php echo $row['fblink']  ?>" title="Facebook"><i class="fa fa-facebook"></i></a></li>
								<li><a href="<?php echo $row['twiterlink']  ?>" title="Twitter"><i class="fa fa-twitter"></i></a></li>
								</ul>
								
								<p class="page-header">
									<span>
										<a class="btn btn-danger" href="delete_contactus.php?delete_id=<?php echo $row['id']; ?>" title="click for delete" onclick="return confirm('sure to delete ?')"><span class="glyphicon glyphicon-remove-circle"></span> Delete</a>
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
								
                               </div>
                            
                            </div>
                        
                        </div><!-- row end -->               
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- doc body wrapper end -->
                
                            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- content wrapper end -->
    
	<div id="school_contact_modal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="title-median">School Contact Details</h4>
      </div>
      <div class="modal-body">				
		<form method="post" enctype="multipart/form-data" class="form-horizontal" id="school_contact"  action="add_school_contact.php">
     
			 <table class="table table-responsive">
			 
				<tr>
				 <td><label class="control-label">Title</label></td>
					<td><input class="form-control" type="text" name="school_title" placeholder="" value="<?php echo $school_title; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Address 1</label></td>
					<td><input class="form-control" type="text" name="addres1" placeholder="" value="<?php echo $addres1; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Address 2</label></td>
					<td><input class="form-control" type="text" name="addres2" placeholder="" value="<?php echo $addres2; ?>" /></td>
				</tr>
				<tr>
				 <td><label class="control-label">Address 3</label></td>
					<td><input class="form-control" type="text" name="addres3" placeholder="" value="<?php echo $addres3; ?>" /></td>
				</tr>
				<tr>
				 <td><label class="control-label">Pin</label></td>
					<td><input class="form-control" type="text" name="pin" placeholder="" value="<?php echo $pin; ?>" /></td>
				</tr>
				<tr>
					<td><label class="control-label">Tel</label><input class="form-control" type="text" name="tel" placeholder="" value="<?php echo $tel; ?>" /></td>
					<td><label class="control-label">Fax</label><input class="form-control" type="text" name="fax" placeholder="" value="<?php echo $fax; ?>" /></td>
				</tr>
				<tr>
				 <td><label class="control-label">Mail_ID</label></td>
					<td><input class="form-control" type="text" name="mail" placeholder="" value="<?php echo $mail; ?>" /></td>
				</tr>
				<tr>
				 <td><label class="control-label">Facebook Link</label></td>
					<td><input class="form-control" type="text" name="fb_link" placeholder="" value="<?php echo $fb_link; ?>" /></td>
				</tr>
				<tr>
				 <td><label class="control-label">Twiter Link</label></td>
					<td><input class="form-control" type="text" name="twiter_link" placeholder="" value="<?php echo $twiter_link; ?>" /></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" name="school_contact" class="btn btn-default"> Add About US content </button>
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
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVWryYT9Ok1lnpE1o-BIt5MDa2Gl-IpbE" type="text/javascript"></script>
    
    <!-- Theme -->
    <script src="js/theme.js"></script>
    
  </body>
</html>