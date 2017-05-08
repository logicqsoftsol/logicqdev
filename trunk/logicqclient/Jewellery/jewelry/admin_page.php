<?php
if (!session_id()) session_start();
if (!$_SESSION['logon_admin']){
	header("Location:index.php");
	die();
}
?>
<?php
	include("admin/config.php");
	
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
 <html lang="en" class="no-js"> 

<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
  <meta name="description" content="" />
  <title>SB Jewellery Online Store</title>
    

  <link href='http://fonts.googleapis.com/css?family=Carrois+Gothic' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Raleway:400,600,500,700' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Belleza' rel='stylesheet' type='text/css'>
  <link href='http://fonts.googleapis.com/css?family=Quicksand:300,400,700' rel='stylesheet' type='text/css'>
<meta property="og:image" content="assets/images/logo.png" />

<link href="netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/jquery.cameraa67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/jquery.fancybox-buttonsa67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/cs.animatea67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/applicationa67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/swatcha67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/jquery.owl.carousela67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/jquery.bxslidera67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/bootstrap.min.3xa67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/cs.bootstrap.3xa67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/cs.globala67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/cs.stylea67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/cs.media.3xa67f.css" rel="stylesheet" type="text/css" media="all" />
<link href="assets/css/27_feb.css" rel='stylesheet' type='text/css' media="all"/>

<script src="assets/js/jquery-1.9.1.mina67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.imagesloaded.mina67f.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.3xa67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.easing.1.3a67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.camera.mina67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.mobile.customized.mina67f.js" type="text/javascript"></script>
<script src="assets/js/cookiesa67f.js" type="text/javascript"></script>
<script src="assets/js/modernizra67f.js" type="text/javascript"></script>
<script src="assets/js/cs.optionSelecta67f.js" type="text/javascript"></script>
<script src="assets/js/cs.customSelecta67f.js" type="text/javascript"></script>  
<script src="assets/js/applicationa67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.owl.carousel.mina67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.bxslidera67f.js" type="text/javascript"></script>
<script src="assets/js/skrollr.mina67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.fancybox-buttonsa67f.js" type="text/javascript"></script>
<script src="assets/js/jquery.zooma67f.js" type="text/javascript"></script>
<script src="assets/js/currencies.js" type="text/javascript"></script>
<script src="assets/js/jquery.currencies.mina67f.js" type="text/javascript"></script>
<script src="assets/js/cs.scripta67f.js" type="text/javascript"></script>

  
</head>

<body >
  
  <!-- Header -->
  <header id="top" class="fadeInDown clearfix">
<!--top-->
<div class="container">
  <div class="top row">

    <div class="col-md-6 phone-shopping">
      <span>PHONE SHOPING (01) 123 456 UJ</span>
    </div>

    <div class="col-md-18">
      <ul class="text-right">
        <li class="customer-links hidden-xs">
          

<ul id="accounts" class="list-inline">
  <li class="my-account">
    <a href="account/login.html">My Account</a>
  </li>
  
  <li class="login">
    
    <span id="loginButton" class="dropdown-toggle" data-toggle="dropdown">
      Login
      <i class="sub-dropdown1"></i>
      <i class="sub-dropdown"></i>
    </span>

    <!-- Customer Account Login -->
    <div id="loginBox" class="dropdown-menu text-left">
      <form method="post" action="#" id="customer_login" accept-charset="UTF-8"><input type="hidden" value="customer_login" name="form_type" /><input type="hidden" name="utf8" value="✓" />

      <div id="bodyBox">
        <ul class="control-container customer-accounts list-unstyled">
          <li class="clearfix">
            <label for="customer_email_box" class="control-label">Email Address <span class="req">*</span></label>
            <input type="email" value="" name="customer[email]" id="customer_email_box" class="form-control" />
          </li>
          
          <li class="clearfix">
            <label for="customer_password_box" class="control-label">Password <span class="req">*</span></label>
            <input type="password" value="" name="customer[password]" id="customer_password_box" class="form-control password" />
          </li>
          
          <li class="clearfix">
            <button class="btn" type="submit">Login</button>
          </li>
          <li class="clearfix">
            <a class="action btn btn-1" href="account/register.html">Create an account</a>
          </li>
        </ul>
      </div>
      </form>

    </div>

    
  </li>
  <li>/</li>
   
  <li class="register">
    <a href="account/register.html" id="customer_register_link">Create an account</a>
  </li>
  
  
   <li class="login">
    
	<a href="login.php" id="admin_login">ADMIN LOGIN</a>
	
  </li>
  
  
</ul>

        </li>
		
        
        
        <li id="widget-social">
          <ul class="list-inline">
            
            <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="Facebook"><i class="fa fa-facebook"></i></a></li>
            <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="Twitter"><i class="fa fa-twitter"></i></a></li>
            
            
            <li><a target="_blank" href="#" class="btooltip swing" data-toggle="tooltip" data-placement="bottom" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
            
            
            
            
          </ul>
        </li>
		
		<li>
			  <a class="view-box" href="#">Gold Rate
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
			  </a>
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
          
          <img class="img-responsive" src="assets/images/logo.png" alt="Jewelry " />
          
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

      
      <li class="top-search hidden-xs">
        <div class="header-search">
            <a href="#">
              <span data-toggle="dropdown">
                <i class="fa fa-search"></i>
                <i class="sub-dropdown1"></i>
                <i class="sub-dropdown"></i>
              </span>
            </a>
            <form id="header-search" class="search-form dropdown-menu" action="#" method="get">
              <input type="hidden" name="type" value="product" />
              <input type="text" name="q" value="" accesskey="4" autocomplete="off" placeholder="Search something..." />
              <button type="submit" class="btn">Search</button>
            </form>
          </div>
      </li>
        

      
      <li class="umbrella hidden-xs">			
        <div id="umbrella" class="list-inline unmargin">
          <div class="cart-link">
            <a href="cart.html" class="dropdown-toggle dropdown-link" data-toggle="dropdown">
              <i class="sub-dropdown1"></i>
              <i class="sub-dropdown"></i>              
              <div class="num-items-in-cart">
                <span class="icon">
                  Cart
                  <span class="number">0</span>
                </span>
              </div>
            </a>

            
            <div id="cart-info" class="dropdown-menu">
              <div id="cart-content">
                <div class="loading">
                  <img src="assets/images/loadera67f.gif" alt="" />
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </li>
      

      
      <li class="mobile-search visible-xs">
        <form id="mobile-search" class="search-form" action="#" method="get">
          <input type="hidden" name="type" value="product" />
          <input type="text" class="" name="q" value="" accesskey="4" autocomplete="off" placeholder="Search something..." />
          
          <button type="submit" class="search-submit" title="search"><i class="fa fa-search"></i></button>
          
        </form>
      </li>
       
    </ul>

  </div>
</div>
<!--End Navigation-->
  </header>
  
  <div id="content-wrapper-parent">
<div id="content-wrapper">       
      
      <!-- Content -->
      <div id="content" class="clearfix">        
                
        <section class="content">
          
              <div id="col-main" class="clearfix">
              
			  <div class="container">
			  
			   
				  <div class="group">
					<h5 class="general-title">ADMIN SECTION</h5>
					
					<ul class="list-unstyled list-styled">
					  
					  <li class="list-unstyled">
						<a href="index.html">ADD</a>
					  </li>
					  
					  <li class="list-unstyled">
						<a href="index.html">UPDATE</a>
					  </li>
					  
					  <li class="list-unstyled">
						<a href="index.html">DELETE</a>
					  </li>
					  
					    
					</ul>
				  </div>
			</div>
			  			  			  
         </div>
       </section>        
      </div>
    </div>
  </div>

  <footer id="footer">      
    <div id="footer-content">
  
  
  
    <div class="footer-content footer-content-top clearfix">
    <div class="container">
    

    

    
    <div class="footer-link-list col-md-6">
      <div class="group">
        <h5 class="general-title">About Us</h5>
        
        <ul class="list-unstyled list-styled">
          
          <li class="list-unstyled">
            <a href="index.html">Store Locations</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Whosesalers</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Map Site</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Contact Us</a>
          </li>
          
        </ul>
      </div>
    </div>
    

    

    
    <div class="footer-link-list col-md-6">
      <div class="group">
        <h5 class="general-title">Information</h5>
        
        <ul class="list-unstyled list-styled">
          
          <li class="list-unstyled">
            <a href="index.html">Help &amp; FAQs</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Advance Search</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Gift Cards</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Shop By Brands</a>
          </li>
          
        </ul>
      </div>
    </div>
    

    

    
    <div class="footer-link-list col-md-6">
      <div class="group">
        <h5 class="general-title">Account</h5>
        
        <ul class="list-unstyled list-styled">
          
          <li class="list-unstyled">
            <a href="index.html">Preferences</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Order History</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Cart Page</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Sign In</a>
          </li>
          
        </ul>
      </div>
    </div>
    

    

    
    <div class="footer-link-list col-md-6">
      <div class="group">
        <h5 class="general-title">Customer</h5>
        
        <ul class="list-unstyled list-styled">
          
          <li class="list-unstyled">
            <a href="search.html">Search Advanced</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Return Policy</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Privacy Policy</a>
          </li>
          
          <li class="list-unstyled">
            <a href="index.html">Help &amp; Contact</a>
          </li>
          
        </ul>
      </div>
    </div>
    

  </div>
  </div>
  <div class="footer-content footer-content-bottom clearfix">
    <div class="container">
  

    
    <div class="copyright col-md-12">&copy; 2017 <a href="index.html">Jewelry </a>. All Rights Reserved.</div> 

    
    
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
			$dbcon = new MySQLi("43.242.215.118","logicqso","qazQAz234#$%","logicqso_jewellery_Ecommerce");
			//$sqlquery = "SELECT * FROM menu_details WHERE `menu_type` = 'Main_menu'";
			//$res=mysqli_query($con,$sqlquery);
			$res=$dbcon->query("SELECT * FROM menu_details WHERE `menu_type` = 'Main_menu'");
			//while($row=mysqli_fetch_array($res,MYSQLI_ASSOC))
			while($row=$res->fetch_array()) 
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
  
  
  
  
  
  
  <script src="assets/js/cs.globala67f.js" type="text/javascript"></script>
  
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
              
              <form action="#" method="post" class="variants" id="quick-shop-product-actions" enctype="multipart/form-data">
                
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
  

  
</body>

<!-- Mirrored from cs-utc-jewelry.myshopify.com/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 03 May 2017 19:43:33 GMT -->
</html>
