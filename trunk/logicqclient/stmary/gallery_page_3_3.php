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
                        <li class="active">Gallery-2015-16</li>
                    </ol>
                    
                </div><!-- breadcrumbs end -->
                
            </div><!-- row end -->
            
            <div class="row no-gutter fullwidth"><!-- row -->
                
                <div class="col-lg-12 col-md-12"><!-- doc body wrapper -->
                	
                    <div class="col-padded"><!-- inner custom column -->
                        
                        <h1 class="page-title">ST Mary's School students buzz <span class="label label-info">8 photos</span></h1>
                        
                        <div class="news-body">
                            
                            <div class="row gutter k-equal-height"><!-- row -->
                            
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-1.jpg" title="Image 1" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-1.jpg" alt="Image 1" /></a>
                                    </figure>
                                    <div class="gallery-photo-description">
                                    	Lorem ipsum dolor sit amet
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-2.jpg" title="Image 2" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-2.jpg" alt="Image 2" /></a>
                                   	</figure>
                                    <div class="gallery-photo-description">
                                    	Nunc aliquam erat id nulla ultrices varius
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-3.jpg" title="Image 3" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-3.jpg" alt="Image 3" /></a>
                                    </figure>
                                    <div class="gallery-photo-description">
                                    	Duis vehicula nec eros vel vehicula
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-4.jpg" title="Image 4" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-4.jpg" alt="Image 4" /></a>
                                    </figure>
                                    <div class="gallery-photo-description">
                                    	Suspendisse sagittis
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-6.jpg" title="Image 5" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-6.jpg" alt="Image 5" /></a>
                                    </figure>
                                    <div class="gallery-photo-description">
                                    	Orci quis venenatis sodales, eros est ultrices quam
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-5.jpg" title="Image 6" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-5.jpg" alt="Image 6" /></a>
                                    </figure>
                                    <div class="gallery-photo-description">
                                    	Sit amet ultrices diam velit vel leo
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-7.jpg" title="Image 7" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-7.jpg" alt="Image 7" /></a>
                                    </figure>
                                    <div class="gallery-photo-description">
                                    	Phasellus congue ornare odio rhoncus varius
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-4 col-sm-12">
                                	<figure class="gallery-photo-thumb">
                                    	<a href="img/slide-8.jpg" title="Image 8" data-fancybox-group="gallery-bssb" class="fancybox"><img src="img/slide-8.jpg" alt="Image 8" /></a>
                                    </figure>
                                    <div class="gallery-photo-description">
                                    	Cras luctus laoreet leo quis porttitor
                                    </div>
                                </div>
                            
                            </div><!-- row end -->
                            
                        </div>
                    
                    </div><!-- inner custom column end -->
                    
                </div><!-- doc body wrapper end -->
            
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
                            
                        </ul><!-- widgets end -->
                         
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
    
    <!-- Theme -->
    <script src="js/theme.js"></script>
    
  </body>
</html>