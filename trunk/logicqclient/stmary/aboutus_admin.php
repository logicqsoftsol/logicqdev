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
                        <li class="active">About-Us</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter"><!-- row -->
                
                <div class="col-lg-8 col-md-8"><!-- doc body wrapper -->
                	
                    <div class="col-padded"><!-- inner custom column -->
                    
                    	<div class="row gutter"><!-- row -->
                        
						<div class="col-sm-12">
								  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#aboutus_modal">Add New About US Here</button>
						</div>
						
						<?php
								 error_reporting( ~E_NOTICE );
								 require_once 'dbconfig.php';
								 
								 $stmt = $DB_con->prepare('SELECT id, title, para1, para2, para3, imageurl FROM about_us ORDER BY id DESC');
								 $stmt->execute();
								 
								 if($stmt->rowCount() > 0)
								 {
								  while($row=$stmt->fetch(PDO::FETCH_ASSOC))
								  {
								   extract($row);
								?>
						   <div class="col-lg-12 col-md-12">
							<img src="<?php echo $row['imageurl']; ?>" width="250px" height="250px" />
							<h1 class='page-title'><a href='#'><?php echo $row['title']; ?></a></h1>
							<div class="news-body">
							<p><?php echo $row['para1']; ?></p>
							<p><?php echo $row['para2']; ?></p>
							<p><?php echo $row['para3']; ?></p>
							</div>
							<p>
							<span>
							
							<a class="btn btn-danger" href="deleteaboutus.php?delete_id=<?php echo $row['id']; ?>" title="click for delete" onclick="return confirm('sure to delete ?')"><span class="glyphicon glyphicon-remove-circle"></span> Delete</a>
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
                        
                                  
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- doc body wrapper end -->
                
                <div id="k-sidebar" class="col-lg-4 col-md-4"><!-- sidebar wrapper -->
                	
                    <div class="col-padded col-shaded"><!-- inner custom column -->
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_nav_menu"><!-- widget -->
                    
                                <h1 class="title-widget">Useful Links</h1>
                                
                                <ul>
                                	
										<?php
										include 'sql.php';

										$SQL ="SELECT * FROM announcements";;
										$result = mysql_query($SQL);
										while ($db_field = mysql_fetch_assoc($result)) {
											$ann_title = $db_field['title'];
											$ann_details = $db_field['details'];
											$ann_fileurl = $db_field['fileurl'];
											$ann_id = $db_field['id'];
											print("<p>»");
											print("<a href=$ann_fileurl>$ann_title</a>");
											print("</p>");
										}
										mysql_close($db_handle);
										?>
                                    
                                </ul>
                    
							</li>
                            
                        	<li class="widget-container widget_recent_news"><!-- widgets list -->
                    
                                <h1 class="title-widget">School News</h1>
                                
                                <ul class="list-unstyled">
                                
									<?php
include 'sql.php';

$SQL ="SELECT * FROM news";;
$result = mysql_query($SQL);
while ($db_field = mysql_fetch_assoc($result)) {
	$title = $db_field['title'];
	$newsdate = $db_field['news_date'];
	$details = $db_field['details'];
	$imageurl = $db_field['imageurl'];
	$id = $db_field['id'];
	print("<li class='recent-news-wrap news-no-summary'>");
	print("<div class='recent-news-content clearfix'>");
	print(" <figure class='recent-news-thumb'>");
	print(" <a href='#'><img src='$imageurl' class='attachment-thumbnail wp-post-image' alt='Thumbnail' /></a>");
	print(" </figure>");
	print("<div class='recent-news-text'>");
	print("<div class='recent-news-meta'>");
	print("<div class='recent-news-date'>$newsdate</div>");
	print("</div>");
	print(" <div class='news-summary'>");
	print("<h1 class='title-median'>$title</h1>");
	print("</div>");
	print("</div>");
	print("</li>");
	
}
mysql_close($db_handle);
?>
                                
                                </ul>
                                
                            </li><!-- widgets list end -->
                            
                            
                            
                        </ul><!-- widgets end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- sidebar wrapper end -->
            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- content wrapper end -->
	
	
	<div id="aboutus_modal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="title-median">About US Details</h4>
      </div>
      <div class="modal-body">				
		<form method="post" enctype="multipart/form-data" class="form-horizontal" id="about_us"  action="add_aboutus.php">
     
			 <table class="table table-bordered table-responsive">
			 
				<tr>
				 <td><label class="control-label">Title</label></td>
					<td><input class="form-control" type="text" name="aboutus_title" placeholder="" value="<?php echo $aboutus_title; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">First Paragraph</label></td>
					<td><textarea class="form-control" style="min-width: 100%" name="para1" form="about_us" value="<?php echo $para1; ?>" /></textarea></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Second Paragraph</label></td>
					<td><textarea class="form-control" style="min-width: 100%" name="para2" form="about_us" value="<?php echo $para2; ?>" /></textarea></td>
				</tr>
				<tr>
				 <td><label class="control-label">Third Paragraph</label></td>
					<td><textarea class="form-control" style="min-width: 100%" name="para3" form="about_us" value="<?php echo $para3; ?>" /></textarea></td>
				</tr>
				<tr>
				 <td><label class="control-label">Image to Upload</label></td>
					<td><input class="input-group" type="file" name="image" accept="img/*" /></td>
				</tr>
				
				<tr>
					<td colspan="2"><button type="submit" name="about_us" class="btn btn-default"> Add About US content </button>
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
    
 <div id="k-footer"><!-- footer -->
    
    	<div class="container"><!-- container -->
        
        	<div class="row no-gutter"><!-- row -->
            
            	<div class="col-lg-4 col-md-4"><!-- widgets column left -->
            
                    <div class="col-padded col-naked">
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_nav_menu"><!-- widgets list -->
                    
                                <h1 class="title-widget">Useful links</h1>
                                
                                <ul>
                                	
										<?php
										include 'sql.php';

										$SQL ="SELECT * FROM announcements";;
										$result = mysql_query($SQL);
										while ($db_field = mysql_fetch_assoc($result)) {
											$ann_title = $db_field['title'];
											$ann_details = $db_field['details'];
											$ann_fileurl = $db_field['fileurl'];
											$ann_id = $db_field['id'];
											print("<p>»");
											print("<a href=$ann_fileurl>$ann_title</a>");
											print("</p>");
										}
										mysql_close($db_handle);
										?>
                                    
                                </ul>	
							</li>
                            
                        </ul>
                         
                    </div>
                    
                </div><!-- widgets column left end -->
                
                <div class="col-lg-4 col-md-4"><!-- widgets column center -->
                
                    <div class="col-padded col-naked">
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_recent_news"><!-- widgets list -->
                    
                                <h1 class="title-widget">Contact</h1>
                                
                                <?php
										include 'sql.php';

										$SQL ="SELECT * FROM contact_us";;
										$result = mysql_query($SQL);
										while ($db_field = mysql_fetch_assoc($result)) {
											$abus_title = $db_field['title'];
											$abus_address1 = $db_field['address1'];
											$abus_address2 = $db_field['address2'];
											$abus_address3 = $db_field['address3'];
											$abus_pin = $db_field['Pin'];
											$abus_tel = $db_field['Tel'];
											$abus_fax = $db_field['Fax'];
											$abus_mailid = $db_field['mailid'];
											$abus_fblink = $db_field['fblink'];
											$abus_twiterlink = $db_field['twiterlink'];
											
											print("<div itemscope itemtype='http://data-vocabulary.org/Organization'>");
											print("<h2 class='title-median m-contact-subject' itemprop='name'>$abus_title</h2>");
											print("<div class='m-contact-address' itemprop='address' itemscope itemtype='http://data-vocabulary.org/Address'>");
											print("<span class='m-contact-street' itemprop='street-address'>$abus_address1</span>");
											print("<span class='m-contact-city-region' itemprop='locality region'>$abus_address2</span>");
											print("<span class='m-contact-zip-country' itemprop='postal-code country-name'>$abus_address3</span>");
											print("<span class='m-contact-zip-country'>$abus_pin</span>");
											print("</div>");
											print("<div class='m-contact-tel-fax'>");
											print("<span class='m-contact-tel'>Tel: <span itemprop='tel'>+91-$abus_tel</span></span>");
											print("<span class='m-contact-fax'>Fax: <span itemprop='fax'>+91-$abus_fax</span></span>");
											print("</div>");
											print("<div class='social-icons'>");
											print("<ul class='list-unstyled list-inline'>");
											print("<li><a href='mailto:$abus_mailid' title='Contact us'><i class='fa fa-envelope'></i></a></li>");
											print("<li><a href='$abus_fblink' title='Facebook'><i class='fa fa-facebook'></i></a></li>");
											print("</ul>");
											print("</div>");
																				
											
										}
										mysql_close($db_handle);
										?>
                    
                    
							</li>
                            
                        </ul>
                        
                    </div>
                    
                </div><!-- widgets column center end -->
                
                <div class="col-lg-4 col-md-4"><!-- widgets column right -->
                
                    <div class="col-padded col-naked">
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_sofa_flickr"><!-- widgets list -->
                    
                                <h1 class="title-widget">Send SMS</h1>
                                
								<button type="submit" class="btn btn-default"><a href="http://sms.sudhanshulenka.com/" title="Send SMS">SEND SMS</button></span>
                                <span class="help-block">Click Here to Send SMS</span>
                                            
							</li>
                            
                        </ul> 
                        
                    </div>
                
                </div><!-- widgets column right end -->
            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- footer end -->
    
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
	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVWryYT9Ok1lnpE1o-BIt5MDa2Gl-IpbE&callback=initMap" type="text/javascript"></script>
    
    <!-- Theme -->
    <script src="js/theme.js"></script>
    
  </body>
</html>	