<?php
session_start();
session_destroy();
?>

<!DOCTYPE html>
<html lang="en">
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ST.MARY's CONVENT SCHOOL</title>
    
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
                    <li><a href="login.php">LOGIN</a></li>
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
                      
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter fullwidth"><!-- row -->
            
                <div class="col-lg-12 clearfix"><!-- featured posts slider -->
                
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
                
            </div><!-- row end -->
            
            <div class="row no-gutter"><!-- row -->
                
                <div class="col-lg-4 col-md-4"><!-- upcoming events wrapper -->
                	
                    <div class="col-padded col-shaded"><!-- inner custom column -->
                    
                    	<ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_up_events"><!-- widgets list -->
                    
                                <h1 class="title-widget">Upcoming Events</h1>
                                
                                <ul class="list-unstyled">
                                
                                    <?php
include 'sql.php';

$SQL ="SELECT * FROM events";;
$result = mysql_query($SQL);
while ($db_field = mysql_fetch_assoc($result)) {
	$eventname = $db_field['eventname'];
	$eventdate = $db_field['event_date'];
	$description = $db_field['description'];
	$eventid = $db_field['id'];
	print("<li class='up-event-wrap'>");
	print("<h1 class='title-median'><a href='#'>$eventname</a></h1>");
	print("<div class='up-event-meta clearfix'>");
	print("<div class='up-event-date'></div>$eventdate");
	print("</div>");
	print("<p> $description</p>");
	print("</li>");
}
mysql_close($db_handle);
?>
                                    
                          
                                
                                </ul>
                            
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
                                </ul>
                                
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
                                	<li><a href="#" title="menu item">Annual Exam Schedule</a></li>
                                    <li><a href="#" title="menu item">Next Year Time Table</a></li>
                                    
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
                                
                                <div itemscope itemtype="http://data-vocabulary.org/Organization"> 
                                
                                	<h2 class="title-median m-contact-subject" itemprop="name">ST Mary's Convent School</h2>
									
                                
                                	<div class="m-contact-address" itemprop="address" itemscope itemtype="http://data-vocabulary.org/Address">
                                		<span class="m-contact-street" itemprop="street-address">Laxmiposi Road, Baripada Municipal Market</span>
                                		<span class="m-contact-city-region"><span class="m-contact-city" itemprop="locality">Baripada</span>, <span class="m-contact-region" itemprop="region">ODISHA</span></span>
                                		<span class="m-contact-zip-country"><span class="m-contact-zip" itemprop="postal-code">757001</span> <span class="m-contact-country" itemprop="country-name">INDIA</span></span>
                                	</div>
                                     
                                	<div class="m-contact-tel-fax">
                                    	<span class="m-contact-tel">Tel: <span itemprop="tel">+(91)-6792-255290</span></span>
                                    	<span class="m-contact-fax">Fax: <span itemprop="fax">+(91)-6792-255290</span></span>
                                    </div>
                                    
                                </div>
                                
                                <div class="social-icons">
                                
                                	<ul class="list-unstyled list-inline">
                                    
                                    	<li><a href="mailto:info@stmaryrnpur.org" title="Contact us"><i class="fa fa-envelope"></i></a></li>
                                        
                                        <li><a href="https://www.facebook.com/pages/S-T-Mary-convent-School-Raghunath-Pur-Baripada/480859435290908" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                                    
                                    </ul>
                                
                                </div>
                    
							</li>
                            
                        </ul>
                        
                    </div>
                    
                </div><!-- widgets column center end -->
                
                <div class="col-lg-4 col-md-4"><!-- widgets column right -->
                
                    <div class="col-padded col-naked">
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	
                            
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
                    &copy; 2017 ST Mary's Convent School. All rights reserved.
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