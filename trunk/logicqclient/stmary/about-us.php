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
                        <li class="active">About-Us</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter"><!-- row -->
                
                <div class="col-lg-8 col-md-8"><!-- doc body wrapper -->
                	
                    <div class="col-padded"><!-- inner custom column -->
                    
                    	<div class="row gutter"><!-- row -->
                        
                        	<div class="col-lg-12 col-md-12">
                    
                                <figure class="news-featured-image">	
                                    <img src="img/news-1.jpg" alt="Featured image 1" class="img-responsive" />
                                </figure>
                                
                                <h1 class="page-title">About ST Mary's Convent School</h1>
                                
                                <div class="news-body">
                                
                                    <p class="call-out">
                                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. In pretium vulputate scelerisque. Nulla in suscipit risus. Nullam pulvinar augue in risus luctus, sed dapibus ipsum mattis.
                                    </p>
                                
                                    <p>
                                    Duis ornare magna sit amet dui eleifend imperdiet. Aliquam at porta elit. Proin lorem lacus, tempus id diam sit amet, porttitor tempor lectus. Praesent id felis sagittis, suscipit ligula sed, condimentum nisi. In non commodo risus. Praesent fringilla ligula in orci consectetur pulvinar. Nunc facilisis metus pellentesque, vestibulum libero eget, varius elit. Aliquam sed gravida dui, a imperdiet eros. Cras dignissim libero id feugiat pharetra. Nullam ut bibendum est, sed tincidunt massa. 
                                    </p>
                                    
                                </div>
                            
                            </div>
                        
                        </div><!-- row end -->
                        
                        <div class="row gutter k-equal-height"><!-- row -->
                        
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <h6>First Column</h6>
                                <p>
                                Curabitur fringilla, massa sit amet ultricies iaculis, nisi lorem faucibus justo, eu interdum odio nunc eu lorem. Aliquam auctor id augue posuere. Duis ornare magna sit amet dui eleifend imperdiet. Aliquam at porta elit. Proin lorem lacus, tempus id diam sit amet, porttitor tempor lectus.
                                </p>
                            </div>
                            
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <h6>Second Column</h6>
                                <p>
                                Maecenas mollis nisl ut diam condimentum, eu sagittis ante elementum. Nam tempus euismod elit, eu venenatis dolor cursus sed. Praesent id felis sagittis, suscipit ligula sed, condimentum nisi. In non commodo risus. Praesent fringilla ligula in orci consectetur pulvinar.
                                </p>
                            </div>
                        
                        </div><!-- row end -->           
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- doc body wrapper end -->
                
                <div id="k-sidebar" class="col-lg-4 col-md-4"><!-- sidebar wrapper -->
                	
                    <div class="col-padded col-shaded"><!-- inner custom column -->
                    
                        <ul class="list-unstyled clear-margins"><!-- widgets -->
                        
                        	<li class="widget-container widget_nav_menu"><!-- widget -->
                    
                                <h1 class="title-widget">Select</h1>
                                
                                <ul>
                                	<li><a href="#" title="menu item">News Archive</a></li>
                                    <li><a href="#" title="menu item">Tradition of School Events</a></li>
                                    <li><a href="#" title="menu item">Report Asocial Behaviour</a></li>
                                    <li><a href="#" title="menu item">Trends and Tips</a></li>
                                    <li><a href="#" title="menu item">Events Poll</a></li>
                                </ul>
                    
							</li>
                            
                        	<li class="widget-container widget_recent_news"><!-- widgets list -->
                    
                                <h1 class="title-widget">School News</h1>
                                
                                <ul class="list-unstyled">
                                
									<li class="recent-news-wrap news-no-summary">
                                        
                                        <div class="recent-news-content clearfix">
                                            <figure class="recent-news-thumb">
                                                <a href="#" title="Megan Boyle flourishes..."><img src="img/recent-news-thumb-1.jpg" class="attachment-thumbnail wp-post-image" alt="Thumbnail 1" /></a>
                                            </figure>
                                            <div class="recent-news-text">
                                                <div class="recent-news-meta">
                                                    <div class="recent-news-date">Jun 12, 2014</div>
                                                </div>
                                                <h1 class="title-median"><a href="#" title="Megan Boyle flourishes...">Megan Boyle flourishes at Boston University</a></h1>
                                            </div>
                                        </div>
                                    
                                    </li>
                                    
									<li class="recent-news-wrap news-no-summary">

                                        <div class="recent-news-content clearfix">
                                            <figure class="recent-news-thumb">
                                                <a href="#" title="Buntington Alum..."><img src="img/recent-news-thumb-2.jpg" class="attachment-thumbnail wp-post-image" alt="Thumbnail 2" /></a>
                                            </figure>
                                            <div class="recent-news-text">
                                                <div class="recent-news-meta">
                                                    <div class="recent-news-date">Jun 10, 2014</div>
                                                </div>
                                                <h1 class="title-median"><a href="#" title="Buntington Alum...">Buntington Alum Marc Bloom Pens New Book</a></h1>
                                            </div>
                                        </div>
                                    
                                    </li>
                                    
									<li class="recent-news-wrap news-no-summary">

                                        <div class="recent-news-content clearfix">
                                            <figure class="recent-news-thumb">
                                                <a href="#" title="Cody Rotschild Enjoys..."><img src="img/recent-news-thumb-3.jpg" class="attachment-thumbnail wp-post-image" alt="Thumbnail 3" /></a>
                                            </figure>
                                            <div class="recent-news-text">
                                                <div class="recent-news-meta">
                                                    <div class="recent-news-date">Jun 05, 2014</div>
                                                </div>
                                                <h1 class="title-median"><a href="#" title="Cody Rotschild Enjoys...">Cody Rotschild Enjoys Life in Montreal</a></h1>
                                            </div>
                                        </div>
                                    
                                    </li>
                                
                                </ul>
                                
                            </li><!-- widgets list end -->
                            
                            <li class="widget-container widget_sofa_twitter"><!-- widget -->
                            
                            	<ul class="k-twitter-twitts list-unstyled">
                                
                                    <li class="twitter-twitt">
                                    	<p>
                                        <a href="https://twitter.com/DanielleFilson">@MattDeamon</a> Why it always has to be so complicated? Try to get it via this link <a href="http://usap.co/potter">mama.co/hpot</a> Good luck mate!
                                        </p>
                                    </li>
                                
                                </ul>
                                
                                <div class="k-twitter-twitts-footer">
                                	<a href="#" class="k-twitter-twitts-follow" title="Follow!"><i class="fa fa-twitter"></i>&nbsp; Follow us!</a>
                                </div>
                            
                            </li><!-- widget end -->
                            
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