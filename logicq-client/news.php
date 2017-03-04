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
                        <li class="active">News</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter"><!-- row -->
                
                <div class="col-lg-8 col-md-8"><!-- doc body wrapper -->
                	
                    <div class="col-padded"><!-- inner custom column -->
                    
                    	<div class="row gutter"><!-- row -->
                        
                        	<div class="col-lg-12 col-md-12">
                    
                            	<h1 class="page-title">News</h1><!-- category title -->
                            
                                <div 	class="category-description"><!-- category description -->
                                    <p>
                                    Read More News to challenge the Career.
                                    </p>
                                </div>
                            
                            </div>
                        
                        </div><!-- row end -->
                        
                        <div class="row gutter k-equal-height"><!-- row -->
                        
                            <div class="news-mini-wrap col-lg-6 col-md-6"><!-- news mini-wrap -->
                            
                                <figure class="news-featured-image">	
                                    <img src="img/news-1.jpg" alt="Featured image 1" class="img-responsive" />
                                </figure>
                                
                                <div class="page-title-meta">
                                    <h1 class="page-title"><a href="#" title="Cody Rotschild enjoys...">First News</a></h1>
                                    <div class="news-meta">
                                        <span class="news-meta-date">Jun 12, 2016</span>
                                        <span class="news-meta-category"><a href="news.php" title="News">News</a></span>
                                        <span class="news-meta-comments"><a href="#" title="3 comments">3 comments</a></span>
                                    </div>
                                </div>
                                
                                <div class="news-summary">
                                    <p>
                                    First News Content... <a href="" title="Read more" class="moretag">More</a>
                                    </p>
                                </div>
                            
                            </div><!-- news mini-wrap end -->
                            
                            <div class="news-mini-wrap col-lg-6 col-md-6"><!-- news mini-wrap -->
                            
                                <figure class="news-featured-image">
                                	<img src="img/news-2.jpg" alt="Featured image 2" class="img-responsive" />
                                </figure>
                                
                                <div class="page-title-meta">
                                    <h1 class="page-title"><a href="#" title="Megan Boyle flourishes...">Second News</a></h1>
                                    <div class="news-meta">
                                        <span class="news-meta-date">Jun 10, 2016</span>
                                        <span class="news-meta-category"><a href="news.php" title="News">News</a></span>
                                        <span class="news-meta-comments"><a href="#" title="12 comments">12 comments</a></span>
                                    </div>
                                </div>
                                
                                <div class="news-summary">
                                    <p>
                                    Second News Content... <a href="" title="Read more" class="moretag">More</a>
                                    </p>
                                </div>
                            
                            </div><!-- news mini-wrap end -->
                            
							 <div class="news-mini-wrap col-lg-6 col-md-6"><!-- news mini-wrap -->
                            
                                <figure class="news-featured-image">
                                	<img src="img/news-3.jpg" alt="Featured image 2" class="img-responsive" />
                                </figure>
                                
                                <div class="page-title-meta">
                                    <h1 class="page-title"><a href="#" title="Megan Boyle flourishes...">Third News</a></h1>
                                    <div class="news-meta">
                                        <span class="news-meta-date">Jun 10, 2016</span>
                                        <span class="news-meta-category"><a href="news.php" title="News">News</a></span>
                                        <span class="news-meta-comments"><a href="#" title="12 comments">12 comments</a></span>
                                    </div>
                                </div>
                                
                                <div class="news-summary">
                                    <p>
                                    Third News Content... <a href="" title="Read more" class="moretag">More</a>
                                    </p>
                                </div>
                            
                            </div><!-- news mini-wrap end -->
							
							 <div class="news-mini-wrap col-lg-6 col-md-6"><!-- news mini-wrap -->
                            
                                <figure class="news-featured-image">
                                	<img src="img/news-4.jpg" alt="Featured image 2" class="img-responsive" />
                                </figure>
                                
                                <div class="page-title-meta">
                                    <h1 class="page-title"><a href="#" title="Megan Boyle flourishes...">Forth News</a></h1>
                                    <div class="news-meta">
                                        <span class="news-meta-date">Jun 10, 2016</span>
                                        <span class="news-meta-category"><a href="news.php" title="News">News</a></span>
                                        <span class="news-meta-comments"><a href="#" title="12 comments">12 comments</a></span>
                                    </div>
                                </div>
                                
                                <div class="news-summary">
                                    <p>
                                    Forth News Content... <a href="" title="Read more" class="moretag">More</a>
                                    </p>
                                </div>
                            
                            </div><!-- news mini-wrap end -->
							
							 <div class="news-mini-wrap col-lg-6 col-md-6"><!-- news mini-wrap -->
                            
                                <figure class="news-featured-image">
                                	<img src="img/news-5.jpg" alt="Featured image 2" class="img-responsive" />
                                </figure>
                                
                                <div class="page-title-meta">
                                    <h1 class="page-title"><a href="#" title="Megan Boyle flourishes...">Fifth News</a></h1>
                                    <div class="news-meta">
                                        <span class="news-meta-date">Jun 10, 2016</span>
                                        <span class="news-meta-category"><a href="news.php" title="News">News</a></span>
                                        <span class="news-meta-comments"><a href="#" title="12 comments">12 comments</a></span>
                                    </div>
                                </div>
                                
                                <div class="news-summary">
                                    <p>
                                    Fifth News Content... <a href="" title="Read more" class="moretag">More</a>
                                    </p>
                                </div>
                            
                            </div><!-- news mini-wrap end -->
							
                        
                        </div><!-- row end -->
                        
                        
                        <div class="row gutter"><!-- row -->
                        
                        	<div class="col-lg-12">
                        
                                <ul class="pagination pull-right"><!-- pagination -->
                                    <li class="disabled"><a href="#">Prev</a></li>
                                    <li class="active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">Next</a></li>
                                </ul><!-- pagination end -->
                            
                            </div>
                            
                        </div><!-- row end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- doc body wrapper end -->
                
                <div id="k-sidebar" class="col-lg-4 col-md-4"><!-- sidebar wrapper -->
                	
                    <div class="col-padded col-shaded"><!-- inner custom column -->
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
							<li class="widget-container widget_nav_menu"><!-- widgets list -->
                    
                                <h1 class="title-widget">Useful links</h1>
                                
                                <ul>
                                	<li><a href="#" title="menu item">Annual Exam Schedule</a></li>
                                    <li><a href="#" title="menu item">Next Year Time Table</a></li>
                                    
                                </ul>
                    
							</li>
                            
                        	<li class="widget-container widget_up_events"><!-- widget -->
                    
                                <h1 class="title-widget">Upcoming Events</h1>
                                
                                <ul class="list-unstyled">
                                
										<li class="up-event-wrap">
                                
                                        <h1 class="title-median"><a href="#" title="Annual Function">Annual Function</a></h1>
                                        
                                        <div class="up-event-meta clearfix">
                                            <div class="up-event-date">Apr 25, 2017</div><div class="up-event-time">10:00 - 04:00</div>
                                        </div>
                                        
                                        <p>
                                        Annual Function with Sports Activity... <a href="#" class="moretag" title="read more">MORE</a> 
                                        </p>
                                    
                                    </li>
                                    
                                    <li class="up-event-wrap">
                                
                                        <h1 class="title-median"><a href="#" title="Summer Vacation">Summer Vacation</a></h1>
                                        
                                        <div class="up-event-meta clearfix">
                                            <div class="up-event-date">May 01, 2017 to Jun 03, 2017</div><div class="up-event-time"></div>
                                        </div>
                                        
                                        <p>
                                        Summer Vacation... <a href="#" class="moretag" title="read more">MORE</a> 
                                        </p>
                                    
                                    </li>
                                    
                                    <!--li class="up-event-wrap">
                                
                                        <h1 class="title-median"><a href="#" title="School talents gathering">Campus "Open Doors"</a></h1>
                                        
                                        <div class="up-event-meta clearfix">
                                            <div class="up-event-date">Sep 04, 2015</div><div class="up-event-date">Sep 11, 2015</div>
                                        </div>
                                        
                                        <p>
                                        Donec fringilla lacinia laoreet. Vestibulum ultrices blandit tempor. Aenean magna elit, varius eget quam a, posuere... <a href="#" class="moretag" title="read more">MORE</a> 
                                        </p>
                                    
                                    </li-->
                                
                                
                            
                        	<li class="widget-container widget_newsletter"><!-- widget -->
                            
                            	<h1 class="title-titan">School Newsletter</h1>
                                
                                <form role="search" method="get" class="newsletter-form" action="#">
                                    <div class="input-group">
                                        <input type="text" placeholder="Your e-mail address" autocomplete="off" class="form-control newsletter-form-input" name="email" />
                                        <span class="input-group-btn"><button type="submit" class="btn btn-default">GO!</button></span>
                                    </div>
                                    <span class="help-block">* Enter your e-mail address to subscribe.</span>
                                </form>
                            
                            </li>
                            
                            <li class="widget-container widget_text"><!-- widget -->
                            
                            	<a href="#" class="custom-button cb-red" title="How to apply?">
                                	<i class="custom-button-icon fa fa-empire"></i>
                                    <span class="custom-button-wrap">
                                    	<span class="custom-button-title">Donate Now</span>
                                        <span class="custom-button-tagline">Become a corporate sponsor of our schools!</span>
                                    </span>
                                    <em></em>
                                </a>
                            
                            </li>
                            
                        </ul><!-- widgets end -->
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- sidebar wrapper end -->
            
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
                        
                        	<!-- <li class="widget-container widget_sofa_flickr"><!-- widgets list -->
                    
                                <!-- <h1 class="title-widget">Flickr Stream</h1>
                                
                                <ul class="k-flickr-photos list-unstyled">
                                	<li><a href="#" title="Flickr photo"><img src="img/flickr-1.jpg" alt="Photo 1" /></a></li>
                                    <li><a href="#" title="Flickr photo"><img src="img/flickr-2.jpg" alt="Photo 2" /></a></li>
                                    <li><a href="#" title="Flickr photo"><img src="img/flickr-3.jpg" alt="Photo 3" /></a></li>
                                    <li><a href="#" title="Flickr photo"><img src="img/flickr-4.jpg" alt="Photo 4" /></a></li>
                                    <li><a href="#" title="Flickr photo"><img src="img/flickr-5.jpg" alt="Photo 5" /></a></li>
                                    <li><a href="#" title="Flickr photo"><img src="img/flickr-6.jpg" alt="Photo 6" /></a></li>
                                    <li><a href="#" title="Flickr photo"><img src="img/flickr-7.jpg" alt="Photo 7" /></a></li>
                                    <li><a href="#" title="Flickr photo"><img src="img/flickr-8.jpg" alt="Photo 8" /></a></li>
                                </ul>
                    
							</li> -->
                            
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