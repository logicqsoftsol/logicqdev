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
        
        	<!--div class="col-lg-12">
        
        		<div id="k-site-logo" class="pull-left"> // Site Logo
                
                    <h1 class="k-logo">
                        <a href="index.php" title="Home Page">
                            <img src="img/site-logo.png" alt="Site Logo" class="img-responsive" />
                        </a>
                    </h1>
                    
                    <a id="mobile-nav-switch" href="#drop-down-left"><span class="alter-menu-icon"></span></a> // alternative menu button 
            
            	</div>  // site logo end 
				
            	<nav id="k-menu" class="k-main-navig"> // main navig 
        
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
        
            	</nav> // main navig end
            
            </div-->
            
        </div><!-- row end -->
    
    </div><!-- container + head wrapper end -->
    
    <div id="k-body"><!-- content wrapper -->
    
    	<div class="container"><!-- container -->
        
        	<div class="row"><!-- row -->
            
                         
            	<div class="k-breadcrumbs col-lg-12 clearfix"><!-- breadcrumbs -->
                
                	<ol class="breadcrumb">
                    	<li><a href="admin_page	.php">Back</a></li>
                        <li class="active">ADMIN</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
     
            <div class="row no-gutter"><!-- row -->
                 
                <div class="col-lg-12 col-md-12"><!-- upcoming events wrapper -->
                	 <div class="row">
   					 <div class="col-sm-12 text-center">
       		  		  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#newsmodal">Add News</button>
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
while ($db_field = mysql_fetch_array($result)) {
	$title = $db_field['title'];
	$newsdate = $db_field['news_date'];
	$details = $db_field['details'];
	$imageurl = $db_field['imageurl'];
	
	print("<div class='col-md-5 col-lg-5 table-responsive '>");
	print("<h1 class='title-median'>$title</h1>");
	//print("<a href='edit.php?id=$id>Edit</a>");
	print("<div class='up-event-meta clearfix'>");
	print("<div class='up-event-date'></div>$newsdate");
	print("</div>");
	print(" <div class='recent-news-content clearfix'>");
	print(" <figure class='recent-news-thumb'>");
	print(" <a href='#'><img src='$imageurl' class='attachment-thumbnail wp-post-image' alt='Thumbnail 3' /></a>");
	print(" </figure>");
	print("  <div class='recent-news-text'>");
	print("<a href=\"editnews.php?id=$db_field[id]\">Edit</a> | <a href=\"deletenews.php?id=$db_field[id]\" onClick=\"return confirm('Are you sure you want to delete?')\">Delete</a>");
	print("<p> $details</p>");
	print("</div>");
	print("</div>");
	print("</div>");
	print("<br>");
	
	// print("<div id='test' class='modal fade' role='dialog'><div class='modal-dialog modal-lg'><div class='modal-content'><div class='modal-header'>
	
       // <h4 class='title-median'>$db_field[id]</h4>
      //</div>
      // <div class='modal-body'></div>
	  //</div></div></div>");
      	  

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
	print("<a href=\"editevents.php?id=$db_field[id]\">Edit</a> | <a href=\"deleteevents.php?id=$db_field[id]\" onClick=\"return confirm('Are you sure you want to delete?')\">Delete</a>");
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

		<form method="post" enctype="multipart/form-data" class="form-horizontal" id="event_form" action="insertevent.php">
     
			 <table class="table table-bordered table-responsive">
			 
				<tr>
				 <td><label class="control-label">Event Title</label></td>
					<td><input class="form-control" type="text" name="event_title" placeholder="Enter News Title" value="<?php echo $event_title; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Date</label></td>
					<td><input class="form-control" type="date" name="event_date" placeholder="" value="<?php echo $event_date; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Event Description</label></td>
						<td>
						<textarea rows="4" cols="50" name="event_desc" form="event_form" value="<?php echo $event_desc; ?>"></textarea>
  						</td>
					</tr>	
				
				<tr>
					<td colspan="2"><button type="submit" name="eventsave" class="btn btn-default">
					<span class="glyphicon glyphicon-save"></span> &nbsp; save
					</button>
					</td>
				</tr>
				
				</table>
				
		</form >    
	  
      </div>
      <!--div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div-->
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
		<form method="post" enctype="multipart/form-data" class="form-horizontal" id="news_form"  action="insert.php">
     
			 <table class="table table-bordered table-responsive">
			 
				<tr>
				 <td><label class="control-label">News Title</label></td>
					<td><input class="form-control" type="text" name="news_title" placeholder="Enter News Title" value="<?php echo $news_title; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Date</label></td>
					<td><input class="form-control" type="date" name="news_date" placeholder="" value="<?php echo $news_date; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Image to Upload</label></td>
					<td><input class="input-group" type="file" name="news_image" accept="img/*" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">News Description</label></td>
						<td>
						<textarea rows="4" cols="50" name="description" form="news_form" value="<?php echo $description; ?>"></textarea>
  						</td>
					</tr>	
				
				<tr>
					<td colspan="2"><button type="submit" name="btnsave" class="btn btn-default">
					<span class="glyphicon glyphicon-save"></span> &nbsp; save
					</button>
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
<div id="delete_newsmodal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="title-median">News Details</h4>
      </div>
      <div class="modal-body">				
		<!--form method="post" enctype="multipart/form-data" class="form-horizontal" id="news_form" >
     
			 <table class="table table-bordered table-responsive">
			 
				<tr>
				 <td><label class="control-label">News Title</label></td>
					<td><input class="form-control" type="text" name="news_title" placeholder="Enter News Title" value="<?php echo $news_title; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Date</label></td>
					<td><input class="form-control" type="date" name="news_date" placeholder="" value="<?php echo $news_date; ?>" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">Image to Upload</label></td>
					<td><input class="input-group" type="file" name="news_image" accept="img/*" /></td>
				</tr>
				
				<tr>
				 <td><label class="control-label">News Title</label></td>
						<td>
						<textarea rows="4" cols="50" name="description" form="news_form" value="<?php echo $description; ?>">Enter Description Here....</textarea>
  						</td>
					</tr>	
				
				<tr>
					<td colspan="2"><button type="submit" name="btnsave" class="btn btn-default">
					<span class="glyphicon glyphicon-save"></span> &nbsp; save
					</button>
					</td>
				</tr>
				
				</table>
				
		</form-->
	
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
    
    <!-- Theme -->
    <script src="js/theme.js"></script>
    <script type="text/javascript">

</script>
  </body>
</html>