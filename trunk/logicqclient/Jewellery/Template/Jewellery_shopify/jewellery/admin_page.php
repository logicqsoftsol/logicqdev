<?php
if (!session_id()) session_start();
if (!$_SESSION['logon']){
	header("Location:index.php");
	die();
}
?>
<?php
	include("config.php");
	
	// PROJECT RELATED FUNCTIONS
	function get_menu_tree($parent_id) 
		{
		global $con;
		$menu = "";
		$sqlquery = " SELECT * FROM menu_details where parent_category='" .$parent_id . "' ORDER BY `menu_ID`";
		$res=mysqli_query($con,$sqlquery);
		while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)) 
		{
			   $menu .="<li class='nav-item dropdown' class='dropdown-toggle dropdown-link' data-toggle='dropdown'>
						<a href='".$row['menu_link']."'><span>".$row['menu_name']."</span>
						<i class='fa fa-caret-down'></i>   
						<i class='sub-dropdown1 visible-sm visible-md visible-lg'></i>
						<i class='sub-dropdown visible-sm visible-md visible-lg'></i></a>";
			   // need to add condition for menu check
			   $menu .= "<ul class='dropdown-menu'>".get_menu_tree($row['menu_ID'])."</ul>"; //call  recursively
			   
			   $menu .= "</li>";
	 
		}
		
		return $menu;
		} 

?>
<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->

<!-- Mirrored from cs-utc-jewelry.myshopify.com/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 03 May 2017 19:41:40 GMT -->
<!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=utf-8" /><!-- /Added by HTTrack -->
<head>
  
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <link rel="canonical" href="index.html" />  
  <link href='http://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:400,600,500,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Belleza' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel='stylesheet' type='text/css'>
  
  <meta name="description" content="" />
  

  
  <title>SB Jewellery Online Store</title>
    
    <meta property="og:image" content="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/logoa67f.png?18416184091645500243" />

<link href="../netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
  
<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.cameraa67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />



<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.fancybox-buttonsa67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />


<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.animatea67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />
<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/applicationa67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />
<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/swatcha67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />

<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.owl.carousela67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />
<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.bxslidera67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />

<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/bootstrap.min.3xa67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />

<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.bootstrap.3xa67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />

<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.globala67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />
<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.stylea67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />
<link href="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.media.3xa67f.css?18416184091645500243" rel="stylesheet" type="text/css" media="all" />
  

<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery-1.9.1.mina67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.imagesloaded.mina67f.js?18416184091645500243" type="text/javascript"></script>

<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/bootstrap.min.3xa67f.js?18416184091645500243" type="text/javascript"></script>


<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.easing.1.3a67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.camera.mina67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.mobile.customized.mina67f.js?18416184091645500243" type="text/javascript"></script>




<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cookiesa67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/modernizra67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.optionSelecta67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.customSelecta67f.js?18416184091645500243" type="text/javascript"></script>  
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/applicationa67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.owl.carousel.mina67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.bxslidera67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/skrollr.mina67f.js?18416184091645500243" type="text/javascript"></script>





<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.fancybox-buttonsa67f.js?18416184091645500243" type="text/javascript"></script>


<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.zooma67f.js?18416184091645500243" type="text/javascript"></script>

<script src="../cdn.shopify.com/s/javascripts/currencies.js" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.currencies.mina67f.js?18416184091645500243" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.scripta67f.js?18416184091645500243" type="text/javascript"></script>
  <!-- Facebook Conversion Code for Themes -->
<script>(function() {
  var _fbq = window._fbq || (window._fbq = []);
  if (!_fbq.loaded) {
    var fbds = document.createElement('script');
    fbds.async = true;
    fbds.src = '../connect.facebook.net/en_US/fbds.js';
    var s = document.getElementsByTagName('script')[0];
    s.parentNode.insertBefore(fbds, s);
    _fbq.loaded = true;
  }
})();
window._fbq = window._fbq || [];
window._fbq.push(['track', '6016096938024', {'value':'0.00','currency':'USD'}]);
</script>
<noscript><img height="1" width="1" alt="" style="display:none" src="https://www.facebook.com/tr?ev=6016096938024&amp;cd[value]=0.00&amp;cd[currency]=USD&amp;noscript=1" /></noscript>

  <script type="text/javascript">
//<![CDATA[
      var Shopify = Shopify || {};
      Shopify.shop = "cs-utc-jewelry.myshopify.com";
      Shopify.theme = {"name":"jewelry","id":41982083,"theme_store_id":null,"role":"main"};
      Shopify.theme.handle = 'null';
      Shopify.theme.style = {"id":null,"handle":null};

//]]>
</script><script type="text/javascript">
//<![CDATA[
    (function() {
      function asyncLoad() {
        var urls = ["\/\/productreviews.shopifycdn.com\/assets\/v4\/spr.js?shop=cs-utc-jewelry.myshopify.com"];
        for (var i = 0; i < urls.length; i++) {
          var s = document.createElement('script');
          s.type = 'text/javascript';
          s.async = true;
          s.src = urls[i];
          var x = document.getElementsByTagName('script')[0];
          x.parentNode.insertBefore(s, x);
        }
      };
      if(window.attachEvent) {
        window.attachEvent('onload', asyncLoad);
      } else {
        window.addEventListener('load', asyncLoad, false);
      }
    })();

//]]>
</script><script id="__st">
//<![CDATA[
var __st={"a":9087252,"offset":-14400,"reqid":"8f3f807d-2658-46e1-808d-44d48b2b2373","pageurl":"cs-utc-jewelry.myshopify.com\/","u":"3d20e42782ef","p":"home"};
//]]>
</script><script src="../cdn.shopify.com/s/javascripts/shopify_stats1bce.js?v=6" type="text/javascript" async="async"></script>
<meta id="shopify-digital-wallet" name="shopify-digital-wallet" content="/9087252/digital_wallets/dialog" />

      <script type="text/javascript">
        
      window.ShopifyAnalytics = window.ShopifyAnalytics || {};
      window.ShopifyAnalytics.meta = window.ShopifyAnalytics.meta || {};
      window.ShopifyAnalytics.meta.currency = 'USD';
      var meta = {"page":{"pageType":"home"}};
      for (var attr in meta) {
        window.ShopifyAnalytics.meta[attr] = meta[attr];
      }
    
      </script>

      <script type="text/javascript">
        window.ShopifyAnalytics.merchantGoogleAnalytics = function() {
          
        };
      </script>

      <script type="text/javascript" class="analytics">
        
        

        (function () {
          var customDocumentWrite = function(content) {
            var jquery = null;

            if (window.jQuery) {
              jquery = window.jQuery;
            } else if (window.Checkout && window.Checkout.$) {
              jquery = window.Checkout.$;
            }

            if (jquery) {
              jquery('body').append(content);
            }
          };

          var trekkie = window.ShopifyAnalytics.lib = window.trekkie = window.trekkie || [];
          if (trekkie.integrations) {
            return;
          }
          trekkie.methods = [
            'identify',
            'page',
            'ready',
            'track',
            'trackForm',
            'trackLink'
          ];
          trekkie.factory = function(method) {
            return function() {
              var args = Array.prototype.slice.call(arguments);
              args.unshift(method);
              trekkie.push(args);
              return trekkie;
            };
          };
          for (var i = 0; i < trekkie.methods.length; i++) {
            var key = trekkie.methods[i];
            trekkie[key] = trekkie.factory(key);
          }
          trekkie.load = function(config) {
            trekkie.config = config;
            var script = document.createElement('script');
            script.type = 'text/javascript';
            script.onerror = function(e) {
              (new Image()).src = 'http://v.shopify.com/internal_errors/track?error=trekkie_load';
            };
            script.async = true;
            script.src = '../cdn.shopify.com/s/javascripts/tricorder/trekkie.storefront.mincda3.js?v=2017.03.29.1';
            var first = document.getElementsByTagName('script')[0];
            first.parentNode.insertBefore(script, first);
          };
          trekkie.load(
            {"Trekkie":{"appName":"storefront","development":false,"defaultAttributes":{"shopId":9087252,"isMerchantRequest":null,"themeId":41982083,"themeCityHash":17024357455024228808}},"Performance":{"navigationTimingApiMeasurementsEnabled":true,"navigationTimingApiMeasurementsSampleRate":0.1},"Session Attribution":{}}
          );

          var loaded = false;
          trekkie.ready(function() {
            if (loaded) return;
            loaded = true;

            window.ShopifyAnalytics.lib = window.trekkie;
            

            var originalDocumentWrite = document.write;
            document.write = customDocumentWrite;
            try { window.ShopifyAnalytics.merchantGoogleAnalytics.call(this); } catch(error) {};
            document.write = originalDocumentWrite;

            
        window.ShopifyAnalytics.lib.page(
          null,
          {"pageType":"home"}
        );
      
            
          });

          
      var eventsListenerScript = document.createElement('script');
      eventsListenerScript.async = true;
      eventsListenerScript.src = "../cdn.shopify.com/s/assets/shop_events_listener-9410288c486c406bc38edb97003bb123d375112c2b7e037d65afabae7c905e02.js";
      document.getElementsByTagName('head')[0].appendChild(eventsListenerScript);
    
        })();
      </script>
    


</head>

<body itemscope itemtype="http://schema.org/WebPage" class="templateIndex">
  
  <!-- Header -->
  <header id="top" class="fadeInDown clearfix">
    



<!--top-->
<div class="container">
  <div class="top row">

    <div class="col-md-6 phone-shopping">
      <span>CALL FOR Shopping and Order Related Issue ⁠⁠⁠⁠+91 7507745536 PUNE (MH)</span>
    </div>

    <div class="col-md-18">
      <ul class="text-right">
        <li class="customer-links hidden-xs">
          

<ul id="accounts" class="list-inline">
   
  <li class="login">
    
	<a href="index.php" id="admin_login">LOGOUT</a>
	
  </li>
  
</ul>



        </li>
		
        
        <li class="li-currency">
          <div class="currency_group">
            <div class="currencies-switcher hidden-xs">
              

<div class="currency btn-group uppercase">
  <a class="currency_wrapper dropdown-toggle" data-toggle="dropdown">
    <i class="sub-dropdown1"></i>
    <i class="sub-dropdown"></i>
    
    <span class="heading hidden-xs">GOLD RATE</span>
    <i class="fa fa-caret-down"></i>
  </a>
  <ul class="dropdown-menu">
    
        <div class="gold-box">
        <div class="menu-wrapper" data-columns="1">
          <span class="gold-heading">Todays Metal Rates (per gram)</span>
          <div class="row gold-row">	<div class="col-xs-6">
	                <span class="heading-metal">Metal Type</span>
	                <ul><li>Platinum</li><li>Gold 24 ct (999)</li><li>Gold 24 ct (995)</li><li>Gold 23.5 ct</li><li>Gold 23 ct</li><li>Gold 22 ct</li><li>Gold 18 ct</li><li>Silver Bar</li><li>Silver</li></ul>
	        </div>
	        <div class="col-xs-6">
	                <span class="heading-metal">Metal Rate</span>
	                <ul><li>Rs. 3283</li><li>Rs. 2870</li><li>Rs. 2850</li><li>Rs. 2830</li><li>Rs. 2830</li><li>Rs. 2760</li><li>Rs. 2296</li><li>Rs. 40.3</li><li>Rs. 40.0</li></ul>
	        </div></div>
          <div class="clear">&nbsp;</div>
          <div class="transparent">&nbsp;</div>
        </div>
	</div>
    
    
  </ul>
  
</div>



            </div>
          </div>
        </li>
        
        
        
        
        <li id="widget-social">
          <ul class="list-inline">
            
            <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a></li>
            <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a></li>
            
            
            <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
            
            
            
            
          </ul>
        </li>
        
      </ul>
    </div>

  </div>
</div>
<!--End top-->

<div class="line"></div>

<!-- Navigation -->
<div class="container">
  <div class="top-navigation">

    <ul class="list-inline">
      <li class="top-logo">
        <a id="site-title" href="index.html" title="Jewelry - Shopify theme">
          
          <img class="img-responsive" src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/logoa67f.png?18416184091645500243" alt="Jewelry - Shopify theme" />
          
        </a>
      </li>

      <li class="navigation">
        
<nav class="navbar" role="navigation">
  <div class="clearfix">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle main navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>

    <div class="is-mobile visible-xs">
      <ul class="list-inline">
        <li class="is-mobile-menu">
          <div class="btn-navbar" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar-group">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </span>
          </div>
        </li>

        
        <li class="is-mobile-login">
          <div class="btn-group">
            <div class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-user"></i>
            </div>
            <ul class="customer dropdown-menu">
              
              <li class="logout">
                <a href="account/login.html">Login</a>
              </li>
              <li class="account">
                <a href="account/register.html">Register</a>
              </li>
              
            </ul>
          </div>
        </li>
        
        
        <li class="is-mobile-wl">
          <a href="pages/wish-list.html"><i class="fa fa-heart"></i></a>
        </li>
        
        
        
        

        <li class="is-mobile-cart">
          <a href="cart.html"><i class="fa fa-shopping-cart"></i></a>
        </li>
      </ul>
    </div>

    <div class="collapse navbar-collapse"> 
      <ul class="nav navbar-nav hoverMenuWrapper">
      
		<?php echo get_menu_tree(0);?>
	  
      </ul>       
    </div>
  </div>
</nav>

      </li>

      
         
    </ul>

  </div>
</div>
<!--End Navigation-->


<script>
  function addaffix(scr){
    if($(window).innerWidth() >= 1024){
      if(scr > $('#top').innerHeight()){
        if(!$('#top').hasClass('affix')){
          $('#top').addClass('affix').addClass('animated');
        }
      }
      else{
        if($('#top').hasClass('affix')){
          $('#top').prev().remove();
          $('#top').removeClass('affix').removeClass('animated');
        }
      }
    }
    else $('#top').removeClass('affix');
  }
  $(window).scroll(function() {
    var scrollTop = $(this).scrollTop();
    addaffix(scrollTop);
  });
  $( window ).resize(function() {
    var scrollTop = $(this).scrollTop();
	addaffix(scrollTop);
  });
</script>
 
  </header>
  
  <div id="content-wrapper-parent">
    <div id="content-wrapper">  
      <!-- Content -->
      <div id="content" class="clearfix">        
                
                
      </div>
    </div>
  </div>

  <footer id="footer">      
    <div id="footer-content">
  
  
  
  <div id="widget-newsletter">
    <div class="container">      
      
	  
                     
    </div>
  </div>
  

  <div class="footer-content footer-content-top clearfix">
    <div class="container">
    

    

    
    <div class="footer-link-list col-md-6">
      <div class="group">
        <h5 class="general-title">ADMIN SECTION</h5>
        
        <ul class="list-unstyled list-styled">
          
          <li class="list-unstyled">
            <a href="#">Menu Items</a>
          
          
          <div class="col-padded"><!-- inner custom column -->
                    
                    	<div class="row gutter"><!-- row -->
                        
						<div class="col-sm-12">
								  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#add_modal">Add</button>
						</div>
						
						<div class="col-sm-12">
								  <button  class="btn btn-primary  btnhorizental" data-toggle="modal" data-target="#delete_modeal">Delete</button>
						</div>
						
						</div><!-- row end -->
                    
                    </div> <!-- add div-->
					
		  
		  
             </li>
          
          <li class="list-unstyled">
            <a href="#">Gold Rate</a>
          </li>
          
              
        </ul>
      </div>
    </div>
    
    

  </div>
  </div>
  <div class="footer-content footer-content-bottom clearfix">
    <div class="container">
  

    
    <div class="copyright col-md-12">&copy; 2017 <a href="index.html">Jewelry - Shopify theme</a>. All Rights Reserved.</div> 

    
    
    <div id="widget-payment" class="col-md-12">
      <ul id="payments" class="list-inline animated">

        
        <li class="btooltip tada" data-toggle="tooltip" data-placement="top" title="Visa"><a href="#" class="icons visa"></a></li>
        

        
        <li class="btooltip tada" data-toggle="tooltip" data-placement="top" title="Mastercard"><a href="#" class="icons mastercard"></a></li>
        

        
        <li class="btooltip tada" data-toggle="tooltip" data-placement="top" title="American Express"><a href="#" class="icons amex"></a></li>
        

        
        <li class="btooltip tada" data-toggle="tooltip" data-placement="top" title="Paypal"><a href="#" class="icons paypal"></a></li>
        

        
        <li class="btooltip tada" data-toggle="tooltip" data-placement="top" title="Moneybookers"><a href="#;" class="icons moneybookers"></a></li>
        
      </ul>
    </div>
    
  </div>
  </div>

</div>

    
  </footer>

  
  
  <div class="newsletter-popup" style="display: none;">
    <form action="https://codespot.us5.list-manage.com/subscribe/post?u=ed73bc2d2f8ae97778246702e&amp;id=c63b4d644d" method="post" name="mc-embedded-subscribe-form" target="_blank">

      <h4>-50% Deal</h4>
      
      <p class="tagline">subscribe for newsletter and get the item for 50% off</p>
      
      <div class="group_input">
        <input class="form-control" type="email" name="EMAIL" placeholder="YOUR EMAIL" />
        <button class="btn" type="submit"><i class="fa fa-paper-plane"></i></button>
      </div> 
    </form>
    <div id="popup-hide">
      <input type="checkbox" id="mc-popup-hide" value="1" checked="checked"> <label for="mc-popup-hide">Never show this message again</label>
    </div>
  </div>
  
  	<div id="add_modal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="title-median">New Menu Item </h4>
      </div>
      <div class="modal-body">				
		<center>
			<pre>
			<form method="post" action="add_menu.php">
			<input type="text" placeholder="menu name :" name="menu name" /><br />
			<input type="text" placeholder="menu link :" name="mn_link" /><br />
			<button type="submit" name="add_main_menu">Add main menu</button>
			</form>
			</pre>
			<br />
			<pre>
			<form method="post" action="add_menu.php">
			<select name="parent">
			<option selected="selected">select parent menu</option>
			<?php
			$sqlquery = "SELECT * FROM menu_details WHERE `menu_type` = 'Main_menu'";
			$res=mysqli_query($con,$sqlquery);
			while($row=mysqli_fetch_array($res,MYSQLI_ASSOC))
			//while($row=$res->fetch_array()) 
			{
			 ?>
				<option value="<?php echo $row['menu_ID']; ?>"><?php echo $row['menu_name']; ?></option>
				<?php
			}
			?>
			</select><br />
			<input type="text" placeholder="menu name :" name="sub_menu_name" /><br />
			<input type="text" placeholder="menu link :" name="sub_menu_link" /><br />
			<button type="submit" name="add_sub_menu">Add sub menu</button>
			</form>
			</pre>
			<a href="index.php">back to main page</a>
		</center>
	
      </div>
      <!--div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div-->
    </div>

  </div>
</div> 
  
  
  
  <script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/cs.globala67f.js?18416184091645500243" type="text/javascript"></script>
  
  <script type="text/javascript">
    //<![CDATA[    
    // Including api.jquery.js conditionnally.
    if (typeof Shopify.onCartShippingRatesUpdate === 'undefined') {
      document.write("\u003cscript src=\"\/\/cdn.shopify.com\/s\/assets\/themes_support\/api.jquery-b90ee9a5604bc68b2f4a3af86b4551207834575e264152eac4822d0b60e0c0d5.js\" type=\"text\/javascript\"\u003e\u003c\/script\u003e");
    }    
    //]]>
  </script>   
  <script type="text/javascript">
  Shopify.updateCartInfo = function(cart, cart_summary_id, cart_count_id) {
    if ((typeof cart_summary_id) === 'string') {
      var cart_summary = jQuery(cart_summary_id);
      if (cart_summary.length) {
        // Start from scratch.
        cart_summary.empty();
        // Pull it all out.
        
        jQuery.each(cart, function(key, value) {
          if (key === 'items') {

            
            if (value.length) {
              
			  jQuery('<div class="items control-container"></div>').appendTo(cart_summary);
              var table = jQuery(cart_summary_id + ' div.items');
       
              jQuery.each(value, function(i, item) {
                jQuery('<div class="row items-wrapper"><a class="cart-close" title="Remove" href="javascript:void(0);" onclick="Shopify.removeItem(' + item.variant_id + ')"><i class="fa fa-times"></i></a><div class="col-md-8 cart-left"><a class="cart-image" href="' + item.url + '"><img src="' + Shopify.resizeImage(item.image, 'small') + '" alt="" title=""/></a></div><div class="col-md-16 cart-right"><div class="cart-title"><a href="' + item.url + '">' + item.title + '</a></div><div class="cart-price">' + Shopify.formatMoney(item.price, "<span class='money'>${{amount}}</span>") + '<span class="x"> x </span>' + item.quantity + '</div></div></div>').appendTo(table);
              });
                       
              jQuery('<div class="subtotal"><span>Subtotal:</span><span class="cart-total-right">' + Shopify.formatMoney(cart.total_price, "<span class='money'>${{amount}}</span>") + '</span></div>').appendTo(cart_summary);
              jQuery('<div class="action"><button class="btn" onclick="window.location=\'/checkout\'">CHECKOUT</button><a class="btn btn-1" href="/cart\">View Cart</button></a></div>').appendTo(cart_summary);
              

            }
            else {
              jQuery('<div class="empty text-center"><em>Your shopping cart is empty.. <a href="/collections/all" class="btn">Continue Shopping</a></em></div>').appendTo(cart_summary);
            }
          }
        });
      }
    }
    // Update cart count.
    if ((typeof cart_count_id) === 'string') {
      if (cart.item_count == 0) { 
        jQuery('#' + cart_count_id).html('your cart is empty'); 
      }
      else if (cart.item_count == 1) {
        jQuery('#' + cart_count_id).html('1 item in your cart');
      }
        else {
          jQuery('#' + cart_count_id).html(cart.item_count + ' items in your cart');
        }
    }
    
    /* Update cart info */
    updateCartDesc(cart);
  };
  
  function updateCartDesc(data){
    var $cartLinkText = $('.cart-link .icon:first .number');
           switch(data.item_count){
         case 0:
           $cartLinkText.html('0');
           break;
         case 1:
           $cartLinkText.html('1');
           break;
         default:
           $cartLinkText.html(data.item_count);
           break;
       } 
    var $cartPrice = '<span class="total"> - '+ Shopify.formatMoney(data.total_price, "<span class='money'>${{amount}}</span>") +'</span>';
    
    /* Update currency */
    currenciesCallbackSpecial('#umbrella span.money');
     
  }
  
  Shopify.onCartUpdate = function(cart) {
    Shopify.updateCartInfo(cart, '#cart-info #cart-content', 'shopping-cart');
  };
  
  $(window).load(function() {
    // Let's get the cart and show what's in it in the cart box.	
    Shopify.getCart(function(cart) {
      
      Shopify.updateCartInfo(cart, '#cart-info #cart-content');		
    });
  });
</script>
  <div id="quick-shop-modal" class="modal" role="dialog" aria-hidden="true" tabindex="-1" data-width="800">
  <div class="modal-dialog rotateInDownLeft">
    <div class="modal-content">
      <div class="modal-header">
        <i class="close fa fa-times btooltip" data-toggle="tooltip" data-placement="top" title="Close" data-dismiss="modal" aria-hidden="true"></i>
      </div>
      <div class="modal-body">
        <div class="quick-shop-modal-bg"></div>
        <div class="row">
          
          <div class="col-md-12 product-image">
            <div id="quick-shop-image" class="product-image-wrapper"></div>
          </div>
          
          <div class="col-md-12 product-information">
            
            <h1 id="quick-shop-title"></h1>
            
            <div id="quick-shop-infomation" class="description">
              <div id="quick-shop-description" class="text-left"></div>
            </div>
            
            <div id="quick-shop-container">
              
              <div id="quick-shop-relative" class="relative text-left">
                <ul class="list-unstyled">
                  <li class="control-group vendor">
                    <span class="control-label">Vendor :</span>
                  </li>
                  <li class="control-group type">
                    <span class="control-label">Type :</span>
                  </li>
                </ul>
              </div> 
              
              <form action="https://cs-utc-jewelry.myshopify.com/cart/add" method="post" class="variants" id="quick-shop-product-actions" enctype="multipart/form-data">
                
                <div id="quick-shop-price-container" class="detail-price"></div>

                <div class="quantity-wrapper clearfix">
                  <label class="wrapper-title">Quantity</label>
                  <div class="wrapper">
                    <input type="text" id="qs-quantity" size="5" class="item-quantity" name="quantity" value="1" />
                    <span class="qty-group">
                      <span class="qty-wrapper">
                        <span class="qty-up" title="Increase" data-src="#qs-quantity">
                          <i class="fa fa-plus"></i>
                        </span>
                        
                        <span class="qty-down" title="Decrease" data-src="#qs-quantity">
                          <i class="fa fa-minus"></i>
                        </span>
                      </span>
                    </span>
                  </div>
                </div>
                
                <div id="quick-shop-variants-container" class="variants-wrapper"></div>
                
                <div class="others-bottom">
                  <input id="quick-shop-add" class="btn small add-to-cart" type="submit" name="add" value="Add to Cart" />
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
  
  jQuery(document).ready(function($) {
    
    $('#quick-shop-modal').on('hidden.bs.modal', function () {
      $('.zoomContainer').css('z-index', '1');
      $('#top').removeClass('z-idx');
    })
    
    $('#quick-shop-modal').on( 'shown.bs.modal', function () {
      $('#top').addClass('z-idx');
      $('.modal-dialog').addClass("animated");
      imagesLoaded( '#quick-shop-modal', function() {
        
        updateScrollThumbsQS();
        
        $("#gallery_main_qs").show().owlCarousel({
          navigation : true,
          pagination: false,
          items: 4,
          itemsDesktop : [1199,4],
          itemsDesktopSmall : [979,3],
          itemsTablet: [768,3],
          itemsMobile : [479,2],
          scrollPerPage: true,
          navigationText: ['<span class="btooltip" title="Previous"></span>', '<span class="btooltip" title="Next"></span>']
        });
        
        var delayLoadingQS = '';       
        delayLoadingQS = setInterval(function(){            
          
          quickShopModalBackground.hide();
          $('.zoomContainer').css('z-index', '2000');
          $('#quick-shop-modal .modal-body').resize(); 
          
          clearInterval( delayLoadingQS );            
        }, 500);
      });
      
    });
    
    var quickShopModal = $('#quick-shop-modal');
    var quickShopContainer = $('#quick-shop-container');
    var quickShopImage = $('#quick-shop-image');
    var quickShopTitle = $('#quick-shop-title');
    var quickShopDescription = $('#quick-shop-description');
    var quickShopRelative = $('#quick-shop-relative');
    var quickShopVariantsContainer = $('#quick-shop-variants-container');
    var quickShopPriceContainer = $('#quick-shop-price-container');
    var quickShopAddButton = $('#quick-shop-add');
    var quickShopAddToCartButton = $('#quick-shop-add');
    var quickShopProductActions = $('#quick-shop-product-actions');
    var quickShopModalBackground = $('#quick-shop-modal .quick-shop-modal-bg');
    
    $('body').on(clickEv, '.quick_shop:not(.unavailable)', function(event){
      var quickShopImage = $('#quick-shop-image');
      
      var $this = $(this);
      var product_json = $this.find('.product-json').html();
      
      // Grab product data
      var selectedProduct = JSON.parse(product_json);
      var selectedProductID = selectedProduct.id;
      // Update add button
      quickShopAddButton.data('product-id', selectedProductID);
      
      // Update image
      quickShopImage.empty();
      quickShopImage.html('<a class="main-image"><img class="img-zoom img-responsive image-fly" src="'+ Shopify.resizeImage(selectedProduct.featured_image, "grande")+'" data-zoom-image="'+ selectedProduct.featured_image +'" alt="" /></a>');
      
      var qs_images_size = "";
       if(selectedProduct.images.length < 4) qs_images_size="small-thumbs";
       
       quickShopImage.append('<div id="gallery_main_qs" class="product-image-thumb scroll scroll-mini '+qs_images_size+'"></div>');
        
        var qs_images = selectedProduct.images;
        $.each(qs_images, function(index, value) {
          if(index)
            quickShopImage.find('#gallery_main_qs').append('<a class="image-thumb" href="'+value+'" alt="" data-image="'+ Shopify.resizeImage(value, 'grande') +'" data-zoom-image="'+ Shopify.resizeImage(value, 'original') +'"><img src="'+ Shopify.resizeImage(value, "compact") +'" alt="" /></a>');
          else
            quickShopImage.find('#gallery_main_qs').append('<a class="image-thumb active" href="'+value+'" alt="" data-image="'+ Shopify.resizeImage(value, 'grande') +'" data-zoom-image="'+ Shopify.resizeImage(value, 'original') +'"><img src="'+ Shopify.resizeImage(value, "compact") +'" alt="" /></a>');
        });
        
        // Update title
        quickShopTitle.html('<span href="/products/' + selectedProduct.handle + '">' + selectedProduct.title + '</span>');
        
        // Update description
        var desc = selectedProduct.description.substr(0,370)+"...";
        quickShopDescription.html(desc);
        
        // Update relative
        quickShopRelative.find('a').remove();
        
        quickShopRelative.find('.vendor .control-label').after('<a href="/collections/vendors?q='+selectedProduct.vendor.replace(' ', '+')+'"> '+selectedProduct.vendor+'</a>');
        quickShopRelative.find('.type .control-label').after('<a href="/collections/types?q='+selectedProduct.type.replace(' ', '+')+'"> '+selectedProduct.type+'</a>');
        
        // Generate variants
        var productVariants = selectedProduct.variants;
        var productVariantsCount = productVariants.length;
        
        quickShopPriceContainer.html('');
        quickShopVariantsContainer.html('');
        quickShopAddToCartButton.removeAttr('disabled').fadeTo(200,1);
        
        if (productVariantsCount > 1) {
          
          // Reveal variants container
          quickShopVariantsContainer.show();
          
          // Build variants element
          var quickShopVariantElement = $('<select>',{ 'id': ('#quick-shop-variants-' + selectedProductID) , 'name': 'id'});
          var quickShopVariantOptions = '';
          
          for (var i=0; i < productVariantsCount; i++) {
            quickShopVariantOptions += '<option value="'+ productVariants[i].id +'">'+ productVariants[i].title +'</option>'
          };
          
          // Add variants element to page
          quickShopVariantElement.append(quickShopVariantOptions);
          quickShopVariantsContainer.append(quickShopVariantElement);
          
          // Bind variants to OptionSelect JS
          new Shopify.OptionSelectors(('#quick-shop-variants-' + selectedProductID), { product: selectedProduct, onVariantSelected: selectOptionCallback });
          
          // Add label if only one product option and it isn't 'Title'.
          if (selectedProduct.options.length == 1 && selectedProduct.options[0] != 'Title' ){
            $('#quick-shop-product-actions .selector-wrapper:eq(0)').prepend('<label>'+ selectedProduct.options[0] +'</label>');
          }
          
          // Auto-select first available variant on page load.
          var found_one_in_stock = false;
          for (var i=0; i < selectedProduct.variants.length; i++) {
            
            var variant = selectedProduct.variants[i];
            if(variant.available && found_one_in_stock == false) {
              
              found_one_in_stock = true;
              for (var j=0; j < variant.options.length; j++){
                
                $('.single-option-selector:eq('+ j +')').val(variant.options[j]).trigger('change');
                
              }
            }
          }
          
          $('#quick-shop-variants-container .single-option-selector').customStyle();
          
        } else { // If product only has a single variant
          
          // Hide unnecessary variants container
          quickShopVariantsContainer.hide(); 
          
          // Build variants element
          var quickShopVariantElement = $('<select>',{ 'id': ('#quick-shop-variants-' + selectedProductID) , 'name': 'id'});
          var quickShopVariantOptions = '';
          
          for (var i=0; i < productVariantsCount; i++) {
            quickShopVariantOptions += '<option value="'+ productVariants[i].id +'">'+ productVariants[i].title +'</option>'
          };
          
          // Add variants element to page
          quickShopVariantElement.append(quickShopVariantOptions);
          quickShopVariantsContainer.append(quickShopVariantElement);
          
          
          // Update the add button to include correct variant id
          quickShopAddToCartButton.data('variant-id', productVariants[0].id);
          
          // Determine if product is on sale
          if ( productVariants[0].compare_at_price > 0 && productVariants[0].compare_at_price > productVariants[0].price ) {
            quickShopPriceContainer.html('<del class="price_compare">'+ Shopify.formatMoney(productVariants[0].compare_at_price, "<span class='money'>${{amount}}</span>") + '</del>' + '<span class="price_sale">'+ Shopify.formatMoney(productVariants[0].price, "<span class='money'>${{amount}}</span>") +'</span>');
          } else {
            quickShopPriceContainer.html('<span class="price">'+ Shopify.formatMoney(productVariants[0].price, "<span class='money'>${{amount}}</span>") + '</span>' );
          }
          
        } // END of (productVariantsCount > 1)
        
        
        // Update currency
        currenciesCallbackSpecial('#quick-shop-modal span.money');
         
         
         });
         
         /* selectOptionCallback
      ===================================== */
         var selectOptionCallback = function(variant, selector) {
           
           // selected a valid and in stock variant
           if (variant && (variant.inventory_quantity > 0 || (variant.inventory_quantity <= 0 && variant.inventory_policy == 'continue') ) ) {
             
             quickShopAddToCartButton.data('variant-id', variant.id);
             

             quickShopAddToCartButton.removeAttr('disabled').fadeTo(200,1); 
             
             // determine if variant is on sale
             if ( variant.compare_at_price > 0 && variant.compare_at_price > variant.price ) {
               quickShopPriceContainer.html('</del>' + '<span class="price_sale">'+ Shopify.formatMoney(variant.price, "<span class='money'>${{amount}}</span>") +'</span><span class="dash">/</span><del class="price_compare">'+ Shopify.formatMoney(variant.compare_at_price, "<span class='money'>${{amount}}</span>"));
             } else {
               quickShopPriceContainer.html('<span class="price">'+ Shopify.formatMoney(variant.price, "<span class='money'>${{amount}}</span>") + '</span>' );
             };
             
             // selected an invalid or out of stock variant 
           } else {
             // variant doesn't exist
             quickShopAddToCartButton.attr('disabled', 'disabled').fadeTo(200,0.5);
             var message = variant ? "Sold Out" : "Unavailable";    
             quickShopPriceContainer.html('<span class="unavailable">' + message + '</span>');
             
           }
           
           
           // Update currency
           currenciesCallbackSpecial('#quick-shop-modal span.money');
            
            }
            
           });
</script>
  

<script src="../cdn.shopify.com/s/javascripts/currencies.js" type="text/javascript"></script>
<script src="../cdn.shopify.com/s/files/1/0908/7252/t/2/assets/jquery.currencies.mina67f.js?18416184091645500243" type="text/javascript"></script>

<script type="text/javascript">
  
  jQuery('.currencies li').on(clickEv, function() {
    if(!$(this).hasClass('active')){
      jQuery('.currencies li').removeClass('active');
      var cls = jQuery(this).attr('class');
      jQuery('.' + cls).addClass('active');
      
      var selectedValue = jQuery(this).find('input[type=hidden]').val();
      jQuery('.currencies_src option[value='+selectedValue+']').attr('selected', true);
      jQuery('.currencies_src').change();
      jQuery('.currency').removeClass('open');
    }
  });
  
  var shopCurrency = '',
      defaultCurrency = '',
      cookieCurrency = '';
  currenciesCallback();
  
  function currenciesCallback (){
    
    Currency.format = 'money_format';
     
     
     shopCurrency = 'USD';
      
      /* Sometimes merchants change their shop currency, let's tell our JavaScript file */
      Currency.money_with_currency_format[shopCurrency] = "${{amount}} USD";
     Currency.money_format[shopCurrency] = "${{amount}}";
    
    /* Default currency */
    defaultCurrency = 'USD' || shopCurrency;
    
    /* Cookie currency */
    cookieCurrency = Currency.cookie.read();
    
    /* Fix for customer account pages */
    jQuery('span.money span.money').each(function() {
      jQuery(this).parents('span.money').removeClass('money');
    });
    
    /* Saving the current price */
    jQuery('span.money').each(function() {
      jQuery(this).attr('data-currency-USD', jQuery(this).html());
    });
    
    // If there's no cookie.
    if (cookieCurrency == null) {
      if (shopCurrency !== defaultCurrency) {
        Currency.convertAll(shopCurrency, defaultCurrency);
        jQuery('.currency_code').html(defaultCurrency);
      }
      else {
        Currency.currentCurrency = defaultCurrency;
      }
      Currency.cookie.write(defaultCurrency);
    }
    // If the cookie value does not correspond to any value in the currency dropdown.
    else if (jQuery('[name=currencies]').size() && jQuery('[name=currencies] option[value=' + cookieCurrency + ']').size() === 0) {
      Currency.currentCurrency = shopCurrency;
      Currency.cookie.write(shopCurrency);
    }
      else if (cookieCurrency === shopCurrency) {
        Currency.currentCurrency = shopCurrency;
      }
      else {
        Currency.convertAll(shopCurrency, cookieCurrency);
        
        jQuery('#currencies li').removeClass('active');
        jQuery('#currencies #currency-'+cookieCurrency).addClass('active');
        jQuery('.currency_code').html(cookieCurrency);
      }
    
    jQuery('[name=currencies]').val(Currency.currentCurrency).change(function() {
      var newCurrency = jQuery(this).val();
      Currency.convertAll(Currency.currentCurrency, newCurrency);
      jQuery('.currency_code').html(Currency.currentCurrency);
      jQuery(this).parents('#currency').removeClass('open');
      
      location.reload();
    });
    
    
    $('.currencies li').removeClass('active');
    $('.currencies .currency-' + Currency.cookie.read()).addClass('active');
  }
  
  function currenciesCallbackSpecial(id){
    /* Saving the current price */
    jQuery(id).each(function() {
      jQuery(this).attr('data-currency-USD', jQuery(this).html());
    });
    
    /* Update currency */
    Currency.convertAll(shopCurrency, Currency.cookie.read(), id, 'money_format');
  }
</script>


  
  
  <script>
    jQuery(function() {
      jQuery('.swatch :radio').change(function() {
        var optionIndex = jQuery(this).closest('.swatch').attr('data-option-index');
        var optionValue = jQuery(this).val();
        jQuery(this)
        .closest('form')
        .find('.single-option-selector')
        .eq(optionIndex)
        .val(optionValue)
        .trigger('change');
      }); 
    });
  </script>
  

  <!--Androll-->
<script type="text/javascript">
adroll_adv_id = "HTF7KIWJRBHHXL46WLUDBC";
adroll_pix_id = "IE5CHDRTR5ABXH2P6QXAVM";
(function () {
var oldonload = window.onload;
window.onload = function(){
   __adroll_loaded=true;
   var scr = document.createElement("script");
   var host = (("https:" == document.location.protocol) ? "https://s.adroll.com" : "http://a.adroll.com");
   scr.setAttribute('async', 'true');
   scr.type = "text/javascript";
   scr.src = host + "/j/roundtrip.js";
   ((document.getElementsByTagName('head') || [null])[0] ||
    document.getElementsByTagName('script')[0].parentNode).appendChild(scr);
   if(oldonload){oldonload()}};
}());
</script>

<!-- Google Code -->
<script>

  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){

  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),

  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)

  })(window,document,'script','../www.google-analytics.com/analytics.js','ga');



  ga('create', 'UA-55571446-8', 'auto');

  ga('require', 'displayfeatures');
  
  ga('set', 'dimension1', 'sf_jewelry');
     
  ga('set', 'dimension2', 'jewelry_store');

  ga('send', 'pageview');

</script>
  
</body>

<!-- Mirrored from cs-utc-jewelry.myshopify.com/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 03 May 2017 19:43:33 GMT -->
</html>
