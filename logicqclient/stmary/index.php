	<?php

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
	
	<!-- link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap-theme.min.css" -->

  </head>
  
  <body role="document">
  
    <!-- device test, don't remove. javascript needed! -->
    <span class="visible-xs"></span><span class="visible-sm"></span><span class="visible-md"></span><span class="visible-lg"></span>
    <!-- device test end -->
    
    <div id="k-head" class="container"><!-- container + head wrapper -->
    
    	<div class="row"><!-- row -->
        
            <nav class="k-functional-navig"><!-- functional navig -->
        
                <ul class="list-inline pull-right">
				
				
                    <li><a href="login.php" class="button">LOGIN</a></li>
                    <li><a href="#" class="button">Calendar</a></li>
				
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
                        
						<?php
							 error_reporting( ~E_NOTICE );
							require_once 'dbconfig.php';
							 
							 $stmt = $DB_con->prepare('SELECT * FROM main_menu');
							 $stmt->execute();
							 
							 if($stmt->rowCount() > 0)
							 {
							  while($row=$stmt->fetch(PDO::FETCH_ASSOC))
							  {
							   extract($row);

								?>

													
								<li><a href="<?php echo $row['m_menu_link']; ?>" title="<?php echo $row['subtitle_menu']; ?>"><?php echo $row['m_menu_name']; ?></a>
								<?php
								$stmt1 = $DB_con->prepare('SELECT * FROM sub_menu WHERE m_menu_id='.$row['m_menu_id']);
								// $res_pro=$dbcon->query("SELECT * FROM sub_menu WHERE m_menu_id=".$row['m_menu_id']);
								
								$stmt1->execute();
								?>
								<ul>				
									<?php  
										if($stmt1->rowCount() > 0)
										{
											while($row1=$stmt1->fetch(PDO::FETCH_ASSOC))
											{
												extract($row1);
										?>
										<li><a href="<?php echo $row1['s_menu_link']; ?>"><?php echo $row1['s_menu_name']; ?></a>
										<?php
										$stmt2 = $DB_con->prepare('SELECT * FROM s_sub_menu WHERE s_menu_id='.$row1['s_menu_id']);
										// $res_pro=$dbcon->query("SELECT * FROM sub_menu WHERE m_menu_id=".$row['m_menu_id']);
										
										$stmt2->execute();
										?>
										<ul>				
										<?php  
										if($stmt2->rowCount() > 0)
										{
											while($row2=$stmt2->fetch(PDO::FETCH_ASSOC))
											{
												extract($row2);
										?>
										<li><a href="<?php echo $row2['ss_menu_link']; ?>"><?php echo $row2['ss_menu_name']; ?></a></li>
										<?php
											}
										}
										?>
										
										</ul>
										</li>
									
										<?php
											}
										}
									?>
								</ul>
								</li>	
								<?php
								}
							}
						?>
						
						
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
                      
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter fullwidth"><!-- row -->
            
                <div class="col-lg-8 clearfix"><!-- featured posts slider -->
                
                    <div id="carousel-featured" class="carousel slide" data-interval="4000" data-ride="carousel"><!-- featured posts slider wrapper; auto-slide -->
                    
                        <ol class="carousel-indicators"><!-- Indicators -->
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                            <li data-target="#carousel-featured" data-slide-to="3"></li>
                            <li data-target="#carousel-featured" data-slide-to="4"></li>
							<li data-target="#carousel-featured" data-slide-to="5"></li>
							<li data-target="#carousel-featured" data-slide-to="6"></li>
							<li data-target="#carousel-featured" data-slide-to="7"></li>
							<li data-target="#carousel-featured" data-slide-to="8"></li>
                        </ol><!-- Indicators end -->
                    
                        <div class="carousel-inner"><!-- Wrapper for slides -->
                        
                            <div class="item active">
                                <img src="img/slide-3.jpg" alt="Image slide 3" />
                                <div class="k-carousel-caption pos-1-3-right scheme-dark">
                                	<div class="caption-content">
                                        <h3 class="caption-title">We have planned, Waiting for use</h3>
                                        <p>
                                        	We must let go of the life we have planned, so as to accept the one that is waiting for us.
                                        </p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="item">
                                <img src="img/slide-2.jpg" alt="Image slide 2" />
                                <div class="k-carousel-caption pos-2-3-left scheme-light">
                                	<div class="caption-content">
                                        <h3 class="caption-title">Preparation for tomorrow</h3>
                                        <p>
                                        	The best preparation for tomorrow is doing your best today.
                                        </p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="item">
                                <img src="img/slide-1.jpg" alt="Image slide 1" />
                                <div class="k-carousel-caption pos-1-3-right scheme-dark">
                                	<div class="caption-content">
                                        <h3 class="caption-title">Best and most beautiful things in World</h3>
                                        <p>
                                        	The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.
                                        </p>
                                       
                                    </div>
                                </div>
                            </div>
                            
                            <div class="item">
                                <img src="img/slide-4.jpg" alt="Image slide 4" />
                                <div class="k-carousel-caption pos-2-3-left scheme-light">
                                	<div class="caption-content">
                                        <h3 class="caption-title">Adjust Life to reach destination</h3>
                                        <p>
                                        	I can't change the direction of the wind, but I can adjust my sails to always reach my destination.
                                        </p>
                                        <p>
                                        	<a href="#" class="btn btn-sm btn-danger" title="Button">READ MORE</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="item">
                                <img src="img/slide-5.jpg" alt="Image slide 5" />
                                <div class="k-carousel-caption pos-1-3-right scheme-dark">
                                	<div class="caption-content">
                                        <h3 class="caption-title">The secret of success</h3>
                                        <p>
                                        	Put your heart, mind, and soul into even your smallest acts. This is the secret of success.
                                        </p>
                                    </div>
                                </div>
                            </div>
							
							<div class="item">
                                <img src="img/slide-6.jpg" alt="Image slide 5" />
                                <div class="k-carousel-caption pos-2-3-left scheme-light">
                                	<div class="caption-content">
                                        <h3 class="caption-title">How happiness work?</h3>
                                        <p>
                                        	Happiness is not something you postpone for the future; it is something you design for the present.
                                        </p>
                                        <p>
                                        	<a href="#" class="btn btn-sm btn-danger" title="Button">READ MORE</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
							
							
							<div class="item">
                                <img src="img/slide-7.jpg" alt="Image slide 5" />
                                <div class="k-carousel-caption pos-1-3-right scheme-dark">
                                	<div class="caption-content">
                                        <h3 class="caption-title">Face vs Shadow</h3>
                                        <p>
                                        	Keep your face always toward the sunshine - and shadows will fall behind you.
                                        </p>
                                    </div>
                                </div>
                            </div>
							
								<div class="item">
                                <img src="img/slide-8.jpg" alt="Image slide 5" />
                                <div class="k-carousel-caption pos-2-3-left scheme-light">
                                	<div class="caption-content">
                                        <h3 class="caption-title">What we think, we become.</h3>
                                        <p>
                                        	What we think, we become.
                                        </p>
                                                                            </div>
                                </div>
                            </div>
							
								<div class="item">
                                <img src="img/slide-9.jpg" alt="Image slide 5" />
                                <div class="k-carousel-caption pos-1-3-right scheme-dark">
                                	<div class="caption-content">
                                        <h3 class="caption-title">Front and Behind of you</h3>
                                        <p>
                                        	What lies behind you and what lies in front of you, pales in comparison to what lies inside of you.
                                        </p>
                                      
                                    </div>
                                </div>
                            </div>
                            
                        </div><!-- Wrapper for slides end -->
                    
                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-featured" data-slide="prev"><i class="fa fa-chevron-left"></i></a>
                        <a class="right carousel-control" href="#carousel-featured" data-slide="next"><i class="fa fa-chevron-right"></i></a>
                        <!-- Controls end -->
                        
                    </div><!-- featured posts slider wrapper end -->
                        
                </div><!-- featured posts slider end -->
				
				<div class="col-lg-4 clearfix">
			
				<div>
                    
                                
                                
                                <ul>
                                	
									<h1 class="title-widget"><b>Our Principal Says</b></h1>
									
									<p>	Welcome to our school website. </p>

<p>WE CARE is our school motto and very much underpins everything we do at Gate Pa. We pride ourselves on our unique spirit and the culture of sharing and caring. Please free to call in or make an appointment so I can show you around our school facilities. </p>
                                    
                                </ul>
					</div>
				</div>
                
            </div><!-- row end -->
            
            <div class="row no-gutter"><!-- row -->
                
                <div class="col-lg-4 col-md-4"><!-- upcoming events wrapper -->
                	
                    <div class="col-padded col-shaded" 	><!-- inner custom column -->
                    
                    	<ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_up_events"><!-- widgets list -->
                    
                                <h1 class="title-widget">Upcoming Events</h1>
                                
                                <ul class="list-unstyled">
								
								<marquee scrollamount="3" onmouseover="stop();"  onmouseout="start();" direction="up" >
								                       
                                    <?php
include 'sql.php';

<<<<<<< .mine$SQL ="SELECT * FROM events ORDER BY event_date DESC LIMIT 0, 3";;
=======$SQL ="SELECT * FROM events ORDER BY event_date LIMIT 0 , 2";;
>>>>>>> .theirs$result = mysql_query($SQL);
while ($db_field = mysql_fetch_assoc($result)) {
	$eventname = $db_field['eventname'];
	$eventdate = $db_field['event_date'];
	$description = $db_field['description'];
	$eventid = $db_field['id'];
	print("<li class='up-event-wrap'>");
	print("<h1 class='title-median'><a href='#'>$eventname</a></h1>");
	print("<div class='up-event-meta clearfix'>");
	print("<div class='up-event-date'>$eventdate</div>");
	print("</div>");
	print("<p> $description</p>");
	print("</li>");
}
mysql_close($db_handle);
?>
<<<<<<< .mine 
</marquee>
 
 <a href="events.php">View More</a>		 
=======                                 
         <a href="events.php">View More</a>
                                
>>>>>>> .theirs                                </ul>
                            
                            </li><!-- widgets list end -->
                        
                        </ul><!-- widgets end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- upcoming events wrapper end -->
                
                <div class="col-lg-4 col-md-4"><!-- recent news wrapper -->
                	
                    <div class="col-padded"><!-- inner custom column -->
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_recent_news"><!-- widgets list -->
                    
                                <h1 class="title-widget">Latest News</h1>
                                
                                <ul class="list-unstyled">
								
								<marquee scrollamount="3" onmouseover="stop();"  onmouseout="start();" direction="up" >
                                
						<?php
include 'sql.php';

$SQL ="SELECT * FROM news ORDER BY news_date LIMIT 0 , 2";;
$result = mysql_query($SQL);
while ($db_field = mysql_fetch_assoc($result)) {
	$title = $db_field['title'];
	$newsdate = $db_field['news_date'];
	$details = $db_field['details'];
	$imageurl = $db_field['imageurl'];
	$id = $db_field['id'];
	print("<li class='recent-news-wrap'>");
	print("<h1 class='title-median'><a href='#'>$title</a></h1>");
	print("<div class='recent-news-meta'>");
	print("<div class='recent-news-date'></div>$newsdate");
	print("</div>");
	print(" <div class='recent-news-content clearfix'>");
	print(" <figure class='recent-news-thumb'>");
	print(" <a href='#'><img src='$imageurl' class='attachment-thumbnail wp-post-image' alt='Thumbnail 3' /></a>");
	print(" </figure>");
	print("  <div class='recent-news-text'>");
	print("<p> $details</p>");
	print("</div>");
	print("</div>");
	print("</li>");
}
mysql_close($db_handle);
?>	
<<<<<<< .mine</marquee>
<a href="news.php">View More</a>
=======
<a href="news.php">View More</a>
>>>>>>> .theirs                                </ul>
                                
                            </li><!-- widgets list end -->
                        
                        </ul><!-- widgets end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- recent news wrapper end -->
                
                <div class="col-lg-4 col-md-4"><!-- misc wrapper -->
                	
                    <div class="col-padded col-shaded"><!-- inner custom column -->
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        	<li class="widget-container widget_course_search"><!-- widget -->
                            
                            	<h1 class="title-titan">Announcements</h1>
                                
						        
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
    
                            </li><!-- widget end -->
                            
                            <li class="widget-container widget_text"><!-- widget -->
                            
                            	<a href="https://www.facebook.com/pages/S-T-Mary-convent-School-Raghunath-Pur-Baripada/480859435290908" class="custom-button cb-green" title="How to apply?">
                                	<i class="custom-button-icon fa fa-facebook"></i>
                                    <span class="custom-button-wrap">
                                    	<span class="custom-button-title">JOIN US ON Facebook</span>
                                        <span class="custom-button-tagline">S T Mary convent School Raghunathpur Baripada</span>
                                    </span>
                                    <em></em>
                                </a>
                                
                            	<a href="http://wikimapia.org/31704924/St-Mary-High-School" class="custom-button cb-gray" title="Campus tour">
                                	<i class="custom-button-icon fa fa-globe"></i>
                                    <span class="custom-button-wrap">
                                    	<span class="custom-button-title">Communicate to US @WIKIMAPIA</span>
                                        <span class="custom-button-tagline">St. Mary High School (Baripada(ବାରିପଦା)) </span>
                                    </span>
                                    <em></em>
                                </a>
                                
                            	<a href="https://swachhbharat.mygov.in/mass-pledge/st-marys-convent-school" class="custom-button cb-yellow" title="Prospectus">
                                	<i class="custom-button-icon fa fa-leaf"></i>
                                    <span class="custom-button-wrap">
                                    	<span class="custom-button-title">We at Swachh Bharat #MyCleanIndia</span>
                                        <span class="custom-button-tagline">Mass pledge taking ceremony at St. Mary’s Convent ...</span>
                                    </span>
                                    <em></em>
                                </a>
                            
                            </li><!-- widget end -->
                            
                            <!--li class="widget-container widget_sofa_twitter"><!-- widget -->
                            
                            	<!--ul class="k-twitter-twitts list-unstyled">
                                
                                    <li class="twitter-twitt">
                                    	<p>
                                        <a href="https://twitter.com/DanielleFilson">@MattDeamon</a> Why it always has to be so complicated? Try to get it via this link <a href="http://usap.co/potter">mama.co/hpot</a> Good luck mate!
                                        </p>
                                    </li>
                                
                                </ul>
                                
                                <div class="k-twitter-twitts-footer">
                                	<a href="#" class="k-twitter-twitts-follow" title="Follow!"><i class="fa fa-twitter"></i>&nbsp; Follow us!</a>
                                </div>
                            
                            </li--><!-- widget end -->
                            
                        </ul><!-- widgets end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- misc wrapper end -->
            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- content wrapper end -->
    
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
                                
								<button type="submit" class="btn btn-default"><a href="http://sms.sudhanshulenka.com/" title="Send SMS">SEND SMS</button>
                                        
							</li>
                            
                        </ul> 
                        
                    </div>
				
				</div>
                
                </div><!-- widgets column right end -->
            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- footer end -->
    
    <div id="k-subfooter"><!-- subfooter -->
    
    	<div class="container"><!-- container -->
        
        	<div class="row"><!-- row -->
            
            	<div class="col-lg-12">
                
                	<p>
                    &copy; 2017 St Mary's Convent Schools. All rights reserved. | Designed By LogicQ SoftSol Pvt. Ltd.
                    </p>
                
                </div>
            
            </div><!-- row end -->
        
        </div><!-- container end -->
    
    </div><!-- subfooter end -->

    <!-- jQuery -->
    <script src="jQuery/jquery-2.1.1.min.js"></script>
    <script src="jQuery/jquery-migrate-1.2.1.min.js"></script>
	
	<!-- script type="text/javascript">
	jQuery.noConflict();
    jQuery(document).ready(function (){ 
        jQuery("#marquee_list").marquee({ 
   			  
		// enable the plugin
		enable : true,  //plug-in is enabled
		
		// scroll direction
		// 'vertical' or 'horizontal'
		direction: 'vertical',

		// children items
		itemSelecter : 'li',
		// animation delay
		delay: 30,

		// animation speed
		speed: 1,
		 
		// animation timing
		timing: 1,

		// mouse hover to stop the scroller
		mouse: true
	  
		  });
	});
	</script -->
    
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
	
	<!-- News Therme >
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery.marquee.js" type="text/javascript"></script -->
    
  </body>
</html>