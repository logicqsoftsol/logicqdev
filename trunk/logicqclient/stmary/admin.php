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
        
        	<div class="col-lg-12">
        
        		<div id="k-site-logo" class="pull-left"><!-- site logo -->
                
                    <h1 class="k-logo">
                        <a href="index.php" title="Home Page">
                            <img src="img/site-logo.png" alt="Site Logo" class="img-responsive" />
                        </a>
                    </h1>
                    
                    <a id="mobile-nav-switch" href="#drop-down-left"><span class="alter-menu-icon"></span></a><!-- alternative menu button -->
            
            	</div><!-- site logo end -->

            	<nav id="k-menu" class="k-main-navig"><!-- main navig -->
        
                    <ul id="drop-down-left" class="k-dropdown-menu">
                        <li>
                            <a href="news.php" title="Our School News">News</a>
                        </li>
                        <li>
                            <a href="events.php" title="Upcoming Events">Events</a>
                        </li>
                        <li>
                            <a href="#" class="Pages Collection" title="Moments of Life">Gallery</a>
                            <ul class="sub-menu">
                                
                               <li><a href="#">Summer Holiday Trip</a></li>
                                <li><a href="#">Winter Holiday Trip</a></li>
                               
                                <li>
                                    <a href="#">Annual Function</a>	
                                    <ul class="sub-menu">
                                        <li><a href="gallery.php">2014-15</a></li>
                                        <li>
                                            <a href="gallery_page_3_3.php">2015-16</a>
                                         
                                        </li>
                                        <li><a href="#">2016-17</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
						<li>
                            <a href="#" title="Available Course">Course</a>
                        </li>
                        <li>
                            <a href="about-us.php" title="See More about our school">About Us</a>
                            <ul class="sub-menu">
                                <li><a href="#">Our Vision</a></li>
                                <li><a href="#">Achievements</a></li>
                           
                            </ul>
                        </li>
                        <li>
                            <a href="contact-us.php" title="School Contacts">Contact Us</a>
                        </li>
                    </ul>
        
            	</nav><!-- main navig end -->
            
            </div>
            
        </div><!-- row end -->
    
    </div><!-- container + head wrapper end -->
    
    <div id="k-body"><!-- content wrapper -->
    
    	<div class="container"><!-- container -->
        
        	<div class="row"><!-- row -->
            
                         
            	<div class="k-breadcrumbs col-lg-12 clearfix"><!-- breadcrumbs -->
                
                	<ol class="breadcrumb">
                    	<li><a href="index.php">Home</a></li>
                        <li class="active">ADMIN</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
     
            <div class="row no-gutter"><!-- row -->
                 
                <div class="col-lg-12 col-md-12"><!-- upcoming events wrapper -->
                	 <div class="row">
   					 <div class="col-sm-12 text-center">
       		  		  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#newsmodal">Add News</button>
        			  <button  class="btn btn-danger  btnhorizental" data-toggle="modal" data-target="#newsmodal">Edit News</button>
         			  <button class="btn btn-danger  btnhorizental" data-toggle="modal" data-target="#newsmodal">Delete News</button>
    			 </div>
				</div>
                    <div class="col-padded col-shaded"><!-- inner custom column -->
                    
                    	<ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_up_events"><!-- widgets list -->
                                <div class="panel panel-info">
                                 <ul class="pagination pull-right">
   										 <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                         <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                  </ul>
								<div class="panel-heading">
								    <h1 class="title-widget">School News</h1>
								</div>
								  <div class="panel-body">
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
	print("<div class='col-md-5 col-lg-5 table-responsive '>");
	print("<h1 class='title-median'><a href='#'>$title</a></h1>");
	print("<div class='up-event-meta clearfix'>");
	print("<div class='up-event-date'></div>$newsdate");
	print("</div>");
	print(" <div class='recent-news-content clearfix'>");
	print(" <figure class='recent-news-thumb'>");
	print(" <a href='#'><img src='$imageurl' class='attachment-thumbnail wp-post-image' alt='Thumbnail 3' /></a>");
	print(" </figure>");
	print("  <div class='recent-news-text'>");
	print("<p> $details</p>");
	print("</div>");
	print("</div>");
	print("</div>");
}
mysql_close($db_handle);
?>
								  </div>
								</div>
                            
                            </li><!-- widgets list end -->
                        
                        </ul><!-- widgets end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- upcoming events wrapper end -->
                
                <div class="col-lg-12 col-md-12"><!-- recent news wrapper -->
                		 <div class="row">
   					 <div class="col-sm-12 text-center">
       		  		  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#eventsmodal">Add Event</button>
        			  <button  class="btn btn-danger  btnhorizental" data-toggle="modal" data-target="#eventsmodal">Edit Event</button>
         			  <button class="btn btn-danger  btnhorizental" data-toggle="modal" data-target="#eventsmodal">Delete Event</button>
    			 </div>
				</div>
                    <div class="col-padded"><!-- inner custom column -->
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_recent_news"><!-- widgets list -->
                        	<div class="panel panel-info">
                                  <ul class="pagination pull-right">
   										 <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                                         <li class="page-item"><a class="page-link" href="#">Next</a></li>
                                  </ul>
								<div class="panel-heading">
								    <h1 class="title-widget">Upcoming Events</h1>
								</div>
								  <div class="panel-body">
													<?php
include 'sql.php';

$SQL ="SELECT * FROM events";;
$result = mysql_query($SQL);
while ($db_field = mysql_fetch_assoc($result)) {
	$eventname = $db_field['eventname'];
	$eventdate = $db_field['event_date'];
	$description = $db_field['description'];
	$eventid = $db_field['id'];
	print("<div class='col-md-5 col-lg-5 table-responsive '>");
	print("<h1 class='title-median'><a href='#'>$eventname</a></h1>");
	print("<div class='up-event-meta clearfix'>");
	print("<div class='up-event-date'></div>$eventdate");
	print("</div>");
	print("<p> $description</p>");
	print("</div>");
}
mysql_close($db_handle);
?>
	
                                </div>                    	
  								
                                	</div>
                            </li><!-- widgets list end -->
                        
                        </ul><!-- widgets end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- recent news wrapper end -->
                
    
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- content wrapper end -->
    
    
 <div id="eventsmodal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="title-median">Events Details</h4>
      </div>
      <div class="modal-body">
      <div class="col-md-5">
      <input name='operationtype'  class="form-control"  type="text" placeholder="For Events" readonly>
	</div>					
	<div class="col-md-6">	
	   <?php
       include 'sql.php';
       $SQL = "SELECT eventname,id FROM events ";
       $result = mysql_query($SQL);
	  print("<input type='text' class='form-control' list='eventnamelist' placeholder='Select Details'>");
	   print("<datalist id='eventnamelist'>");
	while ($db_field = mysql_fetch_assoc($result)) {
		$ev_name = $db_field['eventname'];
		$ev_id = $db_field['id'];
		print("<option value='$ev_name'>'$ev_id'</option>");
	}
	print("</datalist>");
	mysql_close($db_handle);
	?>     
	</div>	   	                  
								Title : <input name = 'title' type = 'text' value = '' placeholder="Enter  Title">
								Date : <input name = 'date' type = 'text' value = '' placeholder="Enter  Date">
								Details: <textarea rows="5" cols="80" name = 'detail'  value = '' placeholder="Enter  Details"></textarea>
						
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> 

 <div id="newsmodal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="title-median">News Details</h4>
      </div>
      <div class="modal-body">				
	<div class="col-md-5">	
	   <?php
       include 'sql.php';
       $SQL = "SELECT title,id FROM news ";
       $result = mysql_query($SQL);
	  print("<select name='newlist' class='form-control' id='newlist' onchange='fetchNewsDetails(this.value);'>");
	while ($db_field = mysql_fetch_assoc($result)) {
		$ev_name = $db_field['title'];
		$ev_id = $db_field['id'];
		print("<option value=$ev_id>$ev_name</option>");
	}
	print("</select>");
	mysql_close($db_handle);
	?>  
	</div>	   	                  
						
								Date : <input name = "newsdate" id="newsdate" type = "text"  placeholder="Enter  Date">
								Details: <textarea rows="5" id="newsdetails" cols="80" name = 'newsdetails'   placeholder="Enter  Details"></textarea>
						
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
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
    
    <!-- Theme -->
    <script src="js/theme.js"></script>
    <script type="text/javascript">
function fetchNewsDetails(id){
	
}
</script>
  </body>
</html>