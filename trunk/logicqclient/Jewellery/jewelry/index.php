<?php
	include("admin/dbconfig.php");
	
	// PROJECT RELATED FUNCTIONS
	function get_menu_tree($parent_id) 
		{
		global $con;
		$menu = "";
		$sqlquery = " SELECT * FROM menu_details where parent_category='" .$parent_id . "' ORDER BY `menu_ID`";
		$res=mysqli_query($db_found,$sqlquery);
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
<div class="home-slider-wrapper clearfix">
 <div class="camera_wrap" id="home-slider">
   <div data-src="assets/images/slide-image-1.jpg">
        
        <div class="camera_caption camera_title_1 fadeIn">
          <a href="collections/bracelets.html" style="color:#010101;">Live the moment</a>
        </div>
        

        
        <div class="camera_caption camera_caption_1 fadeIn" style="color:#010101;">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
        </div>
        
        
        
        <div class="camera_caption camera_image-caption_1 moveFromLeft">
          <img src="assets/images/slide-image-caption-1a67f.png" alt="image_caption" />
        </div>
        
        
        

        
        <div class="camera_cta_1">
          <a href="collections/bracelets.html" class="btn">See Collection</a>
        </div>
        

      </div>

      <div src="assets/images/slide-image-2a67f.jpg">
        
        <div class="camera_caption camera_title_2 moveFromLeft">
          <a href="collections/sample-collection-with-left-slidebar.html" style="color:#666666;">Love’s embrace</a>
        </div>
        

        
        
        
        <div class="camera_caption camera_image-caption_2 moveFromLeft">
          <img src="assets/images/slide-image-caption-2a67f.png" alt="image_caption" />
        </div>
        
        
        

        
        <div class="camera_cta_2">
          <a href="collections/sample-collection-with-left-slidebar.html" class="btn">See Collection</a>
        </div>
        

      </div>
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      <div data-src="assets/images/slide-image-3a67f.jpg">
        

        
        <div class="camera_caption camera_caption_3 fadeFromRight" style="color:#010101;">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et <br/>dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip <br/> ex ea commodo consequat. Duis aute irure dolor in reprehenderitvoluptatem.
        </div>
        
        
        
        <div class="camera_caption camera_image-caption_3 moveFromLeft">
          <img src="assets/images/slide-image-caption-3a67f.png" alt="image_caption" />
        </div>
        
        
        

        
        <div class="camera_cta_3">
          <a href="collections/sample-collection-with-right-slidebar.html" class="btn">See Collection</a>
        </div>
        

      </div>
      
      
      
      
      
      
      
      
    </div>
    
    
  </div>
  
        
      
      <!-- Content -->
      <div id="content" class="clearfix">        
                
        <section class="content">
          
              
              <div id="col-main" class="clearfix">

  
  


  
  
<div class="home-popular-collections">
  <div class="container">
    <div class="group_home_collections row">
      <div class="col-md-24">

        <div class="home_collections">
          <h6 class="general-title">Popular Collections</h6>
          <div class="home_collections_wrapper">
            <div id="home_collections">

              
              <div class="home_collections_item">
                <div class="home_collections_item_inner">
                  <div class="collection-details">
                    
                    <a href="collections/bracelets.html" title="Browse our Bracelets">
                      
                      <img src="assets/images/3_largef441.png" alt="Bracelets" />
                      
                    </a>
                  </div>
                  <div class="hover-overlay">
                    <span class="col-name"><a href="collections/bracelets.html">Bracelets</a></span>
                    <div class="collection-action">
                      <a href="collections/bracelets.html">See the Collection</a>
                    </div>
                  </div>
                </div>
              </div>
              

              
              <div class="home_collections_item">
                <div class="home_collections_item_inner">
                <div class="collection-details">
                  
                  <a href="collections/earrings.html" title="Browse our Earrings">
                    
                    <img src="assets/images/2_largea971.png" alt="Earrings" />
                    
                  </a>
                </div>
                <div class="hover-overlay">
                  <span class="col-name"><a href="collections/earrings.html">Earrings</a></span>
                  <div class="collection-action">
                    <a href="collections/earrings.html">See the Collection</a>
                  </div>
                </div>
                </div>
              </div>
              

              
              <div class="home_collections_item">
                <div class="home_collections_item_inner">
                <div class="collection-details">
                  
                  <a href="collections/necklaces.html" title="Browse our Necklaces">
                    
                    <img src="assets/images/1_79ec3305-7c83-4daa-804c-fac19b2d1b7b_large04b2.png" alt="Necklaces" />
                    
                  </a>
                </div>
                <div class="hover-overlay">
                  <span class="col-name"><a href="collections/necklaces.html">Necklaces</a></span>
                  <div class="collection-action">
                    <a href="collections/necklaces.html">See the Collection</a>
                  </div>
                </div>
                </div>
              </div>
              

              

              
              <div class="home_collections_item">
                <div class="home_collections_item_inner">
                <div class="collection-details">
                  
                  <a href="collections/rings.html" title="Browse our Rings">
                    
                    <img src="assets/images/4_large6125.png" alt="Rings" />
                    
                  </a>                  
                </div>
                <div class="hover-overlay">
                  <span class="col-name"><a href="collections/rings.html">Rings</a></span>
                  <div class="collection-action">
                    <a href="collections/rings.html">See the Collection</a>
                  </div>
                </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
  

  
  
  <div class="home-newproduct">
    <div class="container">
      <div class="group_home_products row">
        <div class="col-md-24">

          <div class="home_products">
            <h6 class="general-title">New Products</h6>
            <div class="home_products_wrapper">
              <div id="home_products">
                
                

                
                <div class="element no_full_width col-md-8 col-sm-8 not-animated" data-animate="fadeInUp" data-delay="0">
                    <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/curabitur-cursus-dignis.html" class="container_item">

        <img src="assets/images/products/1_grande2245.jpg?v=1435560927" class="img-responsive" alt="Curabitur cursus dignis" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/curabitur-cursus-dignis.html">Curabitur cursus dignis</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293238211"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        <span class="price_sale"><span class='money'>$259.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>

      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              <option selected="selected" value="3947651075">black / small</option>
              <option value="3947651139">red / small</option>
              <option value="3947651203">blue / small</option>
              <option value="3947651267">purple / small</option>
              <option value="3947651331">green / small</option>
              <option value="3947651395">white / small</option>
              <option value="3947651459">black / medium</option>
              <option value="3947651523">red / medium</option>
              <option value="3947651587">blue / medium</option>
			  <option value="3947651651">purple / medium</option>
              <option value="3947651715">green / medium</option>
              <option value="3947651779">white / medium</option>
			  <option value="3947651907">red / large</option>
              <option value="3947651971">blue / large</option>
              <option value="3947652035">purple / large</option>
			  <option value="3947652099">green / large</option>
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/curabitur-cursus-dignis.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293238211,"title":"Curabitur cursus dignis","handle":"curabitur-cursus-dignis","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:34-04:00","vendor":"Vendor 1","type":"Sweaters Wear","tags":["$100 - $200","Above $200","Best Seller","Black","Green","L","M","Red","S","Sale Off","Under $100","White","XL"],"price":25900,"price_min":25900,"price_max":29900,"available":true,"price_varies":true,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947651075,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149251,"product_id":1293238211,"position":1,"created_at":"2015-06-29T02:55:27-04:00","updated_at":"2015-06-29T02:55:27-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","variant_ids":[3947651075,3947651459]},"available":true,"name":"Curabitur cursus dignis - black \/ small","public_title":"black \/ small","options":["black","small"],"price":25900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651139,"title":"red \/ small","option1":"red","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149443,"product_id":1293238211,"position":2,"created_at":"2015-06-29T02:55:28-04:00","updated_at":"2015-06-29T02:55:28-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","variant_ids":[3947651139,3947651523,3947651907]},"available":true,"name":"Curabitur cursus dignis - red \/ small","public_title":"red \/ small","options":["red","small"],"price":26000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651203,"title":"blue \/ small","option1":"blue","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150083,"product_id":1293238211,"position":3,"created_at":"2015-06-29T02:55:30-04:00","updated_at":"2015-06-29T02:55:30-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","variant_ids":[3947651203,3947651587,3947651971]},"available":true,"name":"Curabitur cursus dignis - blue \/ small","public_title":"blue \/ small","options":["blue","small"],"price":26900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651267,"title":"purple \/ small","option1":"purple","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150339,"product_id":1293238211,"position":4,"created_at":"2015-06-29T02:55:31-04:00","updated_at":"2015-06-29T02:55:31-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","variant_ids":[3947651267,3947651651,3947652035]},"available":true,"name":"Curabitur cursus dignis - purple \/ small","public_title":"purple \/ small","options":["purple","small"],"price":27900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651331,"title":"green \/ small","option1":"green","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150915,"product_id":1293238211,"position":5,"created_at":"2015-06-29T02:55:32-04:00","updated_at":"2015-06-29T02:55:32-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","variant_ids":[3947651331,3947651715,3947652099]},"available":true,"name":"Curabitur cursus dignis - green \/ small","public_title":"green \/ small","options":["green","small"],"price":28900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651395,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792151107,"product_id":1293238211,"position":6,"created_at":"2015-06-29T02:55:33-04:00","updated_at":"2015-06-29T02:55:33-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6.jpg?v=1435560933","variant_ids":[3947651395,3947651779]},"available":true,"name":"Curabitur cursus dignis - white \/ small","public_title":"white \/ small","options":["white","small"],"price":29900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651459,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149251,"product_id":1293238211,"position":1,"created_at":"2015-06-29T02:55:27-04:00","updated_at":"2015-06-29T02:55:27-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","variant_ids":[3947651075,3947651459]},"available":true,"name":"Curabitur cursus dignis - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":27000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651523,"title":"red \/ medium","option1":"red","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149443,"product_id":1293238211,"position":2,"created_at":"2015-06-29T02:55:28-04:00","updated_at":"2015-06-29T02:55:28-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","variant_ids":[3947651139,3947651523,3947651907]},"available":true,"name":"Curabitur cursus dignis - red \/ medium","public_title":"red \/ medium","options":["red","medium"],"price":28000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651587,"title":"blue \/ medium","option1":"blue","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150083,"product_id":1293238211,"position":3,"created_at":"2015-06-29T02:55:30-04:00","updated_at":"2015-06-29T02:55:30-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","variant_ids":[3947651203,3947651587,3947651971]},"available":true,"name":"Curabitur cursus dignis - blue \/ medium","public_title":"blue \/ medium","options":["blue","medium"],"price":27000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651651,"title":"purple \/ medium","option1":"purple","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150339,"product_id":1293238211,"position":4,"created_at":"2015-06-29T02:55:31-04:00","updated_at":"2015-06-29T02:55:31-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","variant_ids":[3947651267,3947651651,3947652035]},"available":true,"name":"Curabitur cursus dignis - purple \/ medium","public_title":"purple \/ medium","options":["purple","medium"],"price":25900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651715,"title":"green \/ medium","option1":"green","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150915,"product_id":1293238211,"position":5,"created_at":"2015-06-29T02:55:32-04:00","updated_at":"2015-06-29T02:55:32-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","variant_ids":[3947651331,3947651715,3947652099]},"available":true,"name":"Curabitur cursus dignis - green \/ medium","public_title":"green \/ medium","options":["green","medium"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651779,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792151107,"product_id":1293238211,"position":6,"created_at":"2015-06-29T02:55:33-04:00","updated_at":"2015-06-29T02:55:33-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6.jpg?v=1435560933","variant_ids":[3947651395,3947651779]},"available":true,"name":"Curabitur cursus dignis - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651907,"title":"red \/ large","option1":"red","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149443,"product_id":1293238211,"position":2,"created_at":"2015-06-29T02:55:28-04:00","updated_at":"2015-06-29T02:55:28-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","variant_ids":[3947651139,3947651523,3947651907]},"available":true,"name":"Curabitur cursus dignis - red \/ large","public_title":"red \/ large","options":["red","large"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651971,"title":"blue \/ large","option1":"blue","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150083,"product_id":1293238211,"position":3,"created_at":"2015-06-29T02:55:30-04:00","updated_at":"2015-06-29T02:55:30-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","variant_ids":[3947651203,3947651587,3947651971]},"available":true,"name":"Curabitur cursus dignis - blue \/ large","public_title":"blue \/ large","options":["blue","large"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947652035,"title":"purple \/ large","option1":"purple","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150339,"product_id":1293238211,"position":4,"created_at":"2015-06-29T02:55:31-04:00","updated_at":"2015-06-29T02:55:31-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","variant_ids":[3947651267,3947651651,3947652035]},"available":true,"name":"Curabitur cursus dignis - purple \/ large","public_title":"purple \/ large","options":["purple","large"],"price":28900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947652099,"title":"green \/ large","option1":"green","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150915,"product_id":1293238211,"position":5,"created_at":"2015-06-29T02:55:32-04:00","updated_at":"2015-06-29T02:55:32-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","variant_ids":[3947651331,3947651715,3947652099]},"available":true,"name":"Curabitur cursus dignis - green \/ large","public_title":"green \/ large","options":["green","large"],"price":25900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6.jpg?v=1435560933"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

                </div>
                
                <div class="element no_full_width col-md-8 col-sm-8 not-animated" data-animate="fadeInUp" data-delay="1">
                    <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/curabitur-cursus-dignis-1.html" class="container_item">

        <img src="assets/images/products/2_119a31f2-2054-4483-93a3-841310e6bdfb_grande2b1c.jpg?v=1435561310" class="img-responsive" alt="Curabitur cursus dignis" />

        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/curabitur-cursus-dignis-1.html">Curabitur cursus dignis</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293239619"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        
        <span class="price">
          
          <span class='money'>$200.00</span>
          
        </span>
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              
              
              
              
              
              <option selected="selected" value="5141875779">Default Title</option>
              
              
              
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="add-to-cart" type="submit" name="add"><i class="fa fa-shopping-cart"></i><span class="list-mode">Add to Cart</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="curabitur-cursus-dignis-1" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <span class="product-json hide">{"id":1293239619,"title":"Curabitur cursus dignis","handle":"curabitur-cursus-dignis-1","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:38-04:00","vendor":"Vendor 2","type":"Hoodies Wear","tags":["Best Seller","Red","S","Sale Off","Under $100"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":null,"compare_at_price_min":0,"compare_at_price_max":0,"compare_at_price_varies":false,"variants":[{"id":5141875779,"title":"Default Title","option1":"Default Title","option2":null,"option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Curabitur cursus dignis","public_title":null,"options":["Default Title"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":9,"inventory_management":null,"inventory_policy":"deny","barcode":""}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2_119a31f2-2054-4483-93a3-841310e6bdfb.jpg?v=1435561310","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3_5e173faf-876b-4e2f-8e49-597207470817.jpg?v=1435561311","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_5d375b4c-f42f-4a86-aa2f-ff4e0ead303f.jpg?v=1435561312"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2_119a31f2-2054-4483-93a3-841310e6bdfb.jpg?v=1435561310","options":["Title"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span>
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

                </div>
                
                <div class="element no_full_width col-md-8 col-sm-8 not-animated" data-animate="fadeInUp" data-delay="2">
                    <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/donec-aliquam-ante-non.html" class="container_item">

        <img src="assets/images/products/6_03a522d6-f36a-4f59-a815-bbade4d87a6e_grandec150.jpg?v=1435897857" class="img-responsive" alt="Donec aliquam ante non" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/donec-aliquam-ante-non.html">Donec aliquam ante non</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293236931"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        

        
        
        
        
        
        
        
        <span class="price_sale"><span class='money'>$250.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>

        
        
        
        
        
        

        
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              <option value="3947648771">black / small</option>
              <option selected="selected" value="3947648835">white / small</option>
              <option value="3947648899">black / medium</option>
              <option value="3947648963">white / medium</option>
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/donec-aliquam-ante-non.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="donec-aliquam-ante-non" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293236931,"title":"Donec aliquam ante non","handle":"donec-aliquam-ante-non","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:30-04:00","vendor":"Vendor 3","type":"Dressing","tags":["$100 - $200","Best Seller","Green","M"],"price":25000,"price_min":25000,"price_max":26000,"available":true,"price_varies":true,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947648771,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Donec aliquam ante non - black \/ small","public_title":"black \/ small","options":["black","small"],"price":25000,"weight":0,"compare_at_price":null,"inventory_quantity":0,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947648835,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792290499,"product_id":1293236931,"position":2,"created_at":"2015-06-29T03:02:41-04:00","updated_at":"2015-07-03T00:30:57-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_b760c006-b403-4035-ba94-b19cb0ff8214.jpg?v=1435897857","variant_ids":[3947648835,3947648963]},"available":true,"name":"Donec aliquam ante non - white \/ small","public_title":"white \/ small","options":["white","small"],"price":25000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947648899,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Donec aliquam ante non - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":26000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947648963,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792290499,"product_id":1293236931,"position":2,"created_at":"2015-06-29T03:02:41-04:00","updated_at":"2015-07-03T00:30:57-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_b760c006-b403-4035-ba94-b19cb0ff8214.jpg?v=1435897857","variant_ids":[3947648835,3947648963]},"available":true,"name":"Donec aliquam ante non - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":26000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_03a522d6-f36a-4f59-a815-bbade4d87a6e.jpg?v=1435897857","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_b760c006-b403-4035-ba94-b19cb0ff8214.jpg?v=1435897857"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_03a522d6-f36a-4f59-a815-bbade4d87a6e.jpg?v=1435897857","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
      </div>
    </li>
  </ul> 

                </div>
                
                <div class="element no_full_width col-md-8 col-sm-8 not-animated" data-animate="fadeInUp" data-delay="3">
                    <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/donec-condime-fermentum.html" class="container_item">

        <img src="assets/images/products/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9_grande02fe.jpg?v=1435561424" class="img-responsive" alt="Donec condime fermentum" />

        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/donec-condime-fermentum.html">Donec condime fermentum</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293235843"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        
        <span class="price">
           
          <span class='money'>$200.00</span>
          
        </span>
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
             <option selected="selected" value="3947646083">black / small</option>
				<option value="3947646147">red / small</option>
                <option value="3947646211">white / small</option>
                <option value="3947646275">blue / small</option>
                <option value="3947646339">black / medium</option>
                <option value="3947646403">red / medium</option>
                <option value="3947646467">blue / medium</option>
				<option value="3947646531">white / medium</option>
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/donec-condime-fermentum.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
           
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="donec-condime-fermentum" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293235843,"title":"Donec condime fermentum","handle":"donec-condime-fermentum","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:27-04:00","vendor":"Vendor 4","type":"Sweaters Wear","tags":["Above $200","Black","L","Sale Off"],"price":20000,"price_min":20000,"price_max":25000,"available":true,"price_varies":true,"compare_at_price":null,"compare_at_price_min":0,"compare_at_price_max":0,"compare_at_price_varies":false,"variants":[{"id":3947646083,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313411,"product_id":1293235843,"position":1,"created_at":"2015-06-29T03:03:44-04:00","updated_at":"2015-06-29T03:03:44-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","variant_ids":[3947646083,3947646339]},"available":true,"name":"Donec condime fermentum - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646147,"title":"red \/ small","option1":"red","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313539,"product_id":1293235843,"position":2,"created_at":"2015-06-29T03:03:45-04:00","updated_at":"2015-06-29T03:03:45-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5_9c4bb547-32eb-42ea-bed5-2f1fc3832c2e.jpg?v=1435561425","variant_ids":[3947646147,3947646403]},"available":true,"name":"Donec condime fermentum - red \/ small","public_title":"red \/ small","options":["red","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646211,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313987,"product_id":1293235843,"position":3,"created_at":"2015-06-29T03:03:46-04:00","updated_at":"2015-06-29T03:03:46-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_2b8df768-6599-4e41-ae4c-2d6afd2b1d95.jpg?v=1435561426","variant_ids":[3947646211,3947646531]},"available":true,"name":"Donec condime fermentum - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646275,"title":"blue \/ small","option1":"blue","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792314179,"product_id":1293235843,"position":4,"created_at":"2015-06-29T03:03:47-04:00","updated_at":"2015-06-29T03:03:47-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/7.jpg?v=1435561427","variant_ids":[3947646275,3947646467]},"available":true,"name":"Donec condime fermentum - blue \/ small","public_title":"blue \/ small","options":["blue","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646339,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313411,"product_id":1293235843,"position":1,"created_at":"2015-06-29T03:03:44-04:00","updated_at":"2015-06-29T03:03:44-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","variant_ids":[3947646083,3947646339]},"available":true,"name":"Donec condime fermentum - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":25000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646403,"title":"red \/ medium","option1":"red","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313539,"product_id":1293235843,"position":2,"created_at":"2015-06-29T03:03:45-04:00","updated_at":"2015-06-29T03:03:45-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5_9c4bb547-32eb-42ea-bed5-2f1fc3832c2e.jpg?v=1435561425","variant_ids":[3947646147,3947646403]},"available":true,"name":"Donec condime fermentum - red \/ medium","public_title":"red \/ medium","options":["red","medium"],"price":25000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646467,"title":"blue \/ medium","option1":"blue","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792314179,"product_id":1293235843,"position":4,"created_at":"2015-06-29T03:03:47-04:00","updated_at":"2015-06-29T03:03:47-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/7.jpg?v=1435561427","variant_ids":[3947646275,3947646467]},"available":true,"name":"Donec condime fermentum - blue \/ medium","public_title":"blue \/ medium","options":["blue","medium"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646531,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313987,"product_id":1293235843,"position":3,"created_at":"2015-06-29T03:03:46-04:00","updated_at":"2015-06-29T03:03:46-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_2b8df768-6599-4e41-ae4c-2d6afd2b1d95.jpg?v=1435561426","variant_ids":[3947646211,3947646531]},"available":true,"name":"Donec condime fermentum - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5_9c4bb547-32eb-42ea-bed5-2f1fc3832c2e.jpg?v=1435561425","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_2b8df768-6599-4e41-ae4c-2d6afd2b1d95.jpg?v=1435561426","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/7.jpg?v=1435561427"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

                </div>
                
                <div class="element no_full_width col-md-8 col-sm-8 not-animated" data-animate="fadeInUp" data-delay="4">
                    <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/maximus-quam-posuere-1.html" class="container_item">

        <img src="assets/images/products/10_16854be2-a731-4970-984e-7f6e483d2405_grandedd3a.jpg" class="img-responsive" alt="Maximus quam posuere" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/maximus-quam-posuere-1.html">Maximus quam posuere</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293227907"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        <span class="price_sale"><span class='money'>$200.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>
 </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
             <option selected="selected" value="3947629763">black / small</option>
             <option value="3947629827">white / small</option>
             <option value="3947629891">black / medium</option>
             <option value="3947629955">white / medium</option> 
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/maximus-quam-posuere-1.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="maximus-quam-posuere-1" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293227907,"title":"Maximus quam posuere","handle":"maximus-quam-posuere-1","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:05-04:00","created_at":"2015-06-29T00:22:06-04:00","vendor":"Vendor 3","type":"Sweaters Wear","tags":["Best Seller","Sale Off"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947629763,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566019,"product_id":1293227907,"position":1,"created_at":"2015-06-29T03:11:53-04:00","updated_at":"2015-06-29T03:11:53-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","variant_ids":[3947629763,3947629891]},"available":true,"name":"Maximus quam posuere - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947629827,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566339,"product_id":1293227907,"position":2,"created_at":"2015-06-29T03:11:54-04:00","updated_at":"2015-06-29T03:11:54-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_11ac0177-cd42-4bfc-b610-df79b9a60afb.jpg?v=1435561914","variant_ids":[3947629827,3947629955]},"available":true,"name":"Maximus quam posuere - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947629891,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566019,"product_id":1293227907,"position":1,"created_at":"2015-06-29T03:11:53-04:00","updated_at":"2015-06-29T03:11:53-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","variant_ids":[3947629763,3947629891]},"available":true,"name":"Maximus quam posuere - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947629955,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566339,"product_id":1293227907,"position":2,"created_at":"2015-06-29T03:11:54-04:00","updated_at":"2015-06-29T03:11:54-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_11ac0177-cd42-4bfc-b610-df79b9a60afb.jpg?v=1435561914","variant_ids":[3947629827,3947629955]},"available":true,"name":"Maximus quam posuere - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_11ac0177-cd42-4bfc-b610-df79b9a60afb.jpg?v=1435561914"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

                </div>
                
                <div class="element no_full_width col-md-8 col-sm-8 not-animated" data-animate="fadeInUp" data-delay="5">
                    <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/product-full-width.html" class="container_item">

        <img src="assets/images/products/11_68ab6d0f-109c-429b-a903-4cbf60257806_grande6ce0.jpg?v=1435561981" class="img-responsive" alt="Product full width" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/product-full-width.html">Product full width</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293240771"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        <span class="price_sale"><span class='money'>$200.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              <option selected="selected" value="3947656579">black / small</option>
              
              
              
              <option value="3947656643">white / small</option>
              
              
              
              <option value="3947656707">black / medium</option>
              
              
              
              <option value="3947656771">white / medium</option>
              
              
              
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/product-full-width.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="product-full-width" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293240771,"title":"Product full width","handle":"product-full-width","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:41-04:00","vendor":"Vendor 3","type":"Sweaters Wear","tags":["Best Seller","Black","Gray","Sale Off","Under $100","XL"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947656579,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623043,"product_id":1293240771,"position":1,"created_at":"2015-06-29T03:13:01-04:00","updated_at":"2015-06-29T03:13:01-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","variant_ids":[3947656579,3947656707]},"available":true,"name":"Product full width - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947656643,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623491,"product_id":1293240771,"position":2,"created_at":"2015-06-29T03:13:02-04:00","updated_at":"2015-06-29T03:13:02-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_5fd43d5b-08ec-4a13-b388-7f7a55a92ed0.jpg?v=1435561982","variant_ids":[3947656643,3947656771]},"available":true,"name":"Product full width - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947656707,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623043,"product_id":1293240771,"position":1,"created_at":"2015-06-29T03:13:01-04:00","updated_at":"2015-06-29T03:13:01-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","variant_ids":[3947656579,3947656707]},"available":true,"name":"Product full width - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947656771,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623491,"product_id":1293240771,"position":2,"created_at":"2015-06-29T03:13:02-04:00","updated_at":"2015-06-29T03:13:02-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_5fd43d5b-08ec-4a13-b388-7f7a55a92ed0.jpg?v=1435561982","variant_ids":[3947656643,3947656771]},"available":true,"name":"Product full width - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_5fd43d5b-08ec-4a13-b388-7f7a55a92ed0.jpg?v=1435561982"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

                </div>
                
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>

 
  <div class="home-feature">
  <div class="container">
    <div class="group_featured_products row">
      <div class="col-md-24">
        <div class="home_fp">
          <h6 class="general-title">Featured Products</h6>
          <div class="home_fp_wrapper">
            <div id="home_fp">
              
              

              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="0">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/curabitur-cursus-dignis.html" class="container_item">

        <img src="assets/images/products/1_grande2245.jpg" class="img-responsive" alt="Curabitur cursus dignis" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/curabitur-cursus-dignis.html">Curabitur cursus dignis</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293238211"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        <span class="price_sale"><span class='money'>$259.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              
              <option selected="selected" value="3947651075">black / small</option>
              <option value="3947651139">red / small</option>
              <option value="3947651203">blue / small</option>
              <option value="3947651267">purple / small</option>
              <option value="3947651331">green / small</option>
              <option value="3947651395">white / small</option>
              <option value="3947651459">black / medium</option>
              <option value="3947651523">red / medium</option>
              <option value="3947651587">blue / medium</option>
              <option value="3947651651">purple / medium</option>
              <option value="3947651715">green / medium</option>
              <option value="3947651779">white / medium</option>
              <option value="3947651907">red / large</option>
              <option value="3947651971">blue / large</option>
              <option value="3947652035">purple / large</option>
              <option value="3947652099">green / large</option>
           </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/curabitur-cursus-dignis.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="curabitur-cursus-dignis" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293238211,"title":"Curabitur cursus dignis","handle":"curabitur-cursus-dignis","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:34-04:00","vendor":"Vendor 1","type":"Sweaters Wear","tags":["$100 - $200","Above $200","Best Seller","Black","Green","L","M","Red","S","Sale Off","Under $100","White","XL"],"price":25900,"price_min":25900,"price_max":29900,"available":true,"price_varies":true,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947651075,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149251,"product_id":1293238211,"position":1,"created_at":"2015-06-29T02:55:27-04:00","updated_at":"2015-06-29T02:55:27-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","variant_ids":[3947651075,3947651459]},"available":true,"name":"Curabitur cursus dignis - black \/ small","public_title":"black \/ small","options":["black","small"],"price":25900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651139,"title":"red \/ small","option1":"red","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149443,"product_id":1293238211,"position":2,"created_at":"2015-06-29T02:55:28-04:00","updated_at":"2015-06-29T02:55:28-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","variant_ids":[3947651139,3947651523,3947651907]},"available":true,"name":"Curabitur cursus dignis - red \/ small","public_title":"red \/ small","options":["red","small"],"price":26000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651203,"title":"blue \/ small","option1":"blue","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150083,"product_id":1293238211,"position":3,"created_at":"2015-06-29T02:55:30-04:00","updated_at":"2015-06-29T02:55:30-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","variant_ids":[3947651203,3947651587,3947651971]},"available":true,"name":"Curabitur cursus dignis - blue \/ small","public_title":"blue \/ small","options":["blue","small"],"price":26900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651267,"title":"purple \/ small","option1":"purple","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150339,"product_id":1293238211,"position":4,"created_at":"2015-06-29T02:55:31-04:00","updated_at":"2015-06-29T02:55:31-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","variant_ids":[3947651267,3947651651,3947652035]},"available":true,"name":"Curabitur cursus dignis - purple \/ small","public_title":"purple \/ small","options":["purple","small"],"price":27900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651331,"title":"green \/ small","option1":"green","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150915,"product_id":1293238211,"position":5,"created_at":"2015-06-29T02:55:32-04:00","updated_at":"2015-06-29T02:55:32-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","variant_ids":[3947651331,3947651715,3947652099]},"available":true,"name":"Curabitur cursus dignis - green \/ small","public_title":"green \/ small","options":["green","small"],"price":28900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651395,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792151107,"product_id":1293238211,"position":6,"created_at":"2015-06-29T02:55:33-04:00","updated_at":"2015-06-29T02:55:33-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6.jpg?v=1435560933","variant_ids":[3947651395,3947651779]},"available":true,"name":"Curabitur cursus dignis - white \/ small","public_title":"white \/ small","options":["white","small"],"price":29900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651459,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149251,"product_id":1293238211,"position":1,"created_at":"2015-06-29T02:55:27-04:00","updated_at":"2015-06-29T02:55:27-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","variant_ids":[3947651075,3947651459]},"available":true,"name":"Curabitur cursus dignis - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":27000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651523,"title":"red \/ medium","option1":"red","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149443,"product_id":1293238211,"position":2,"created_at":"2015-06-29T02:55:28-04:00","updated_at":"2015-06-29T02:55:28-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","variant_ids":[3947651139,3947651523,3947651907]},"available":true,"name":"Curabitur cursus dignis - red \/ medium","public_title":"red \/ medium","options":["red","medium"],"price":28000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651587,"title":"blue \/ medium","option1":"blue","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150083,"product_id":1293238211,"position":3,"created_at":"2015-06-29T02:55:30-04:00","updated_at":"2015-06-29T02:55:30-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","variant_ids":[3947651203,3947651587,3947651971]},"available":true,"name":"Curabitur cursus dignis - blue \/ medium","public_title":"blue \/ medium","options":["blue","medium"],"price":27000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651651,"title":"purple \/ medium","option1":"purple","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150339,"product_id":1293238211,"position":4,"created_at":"2015-06-29T02:55:31-04:00","updated_at":"2015-06-29T02:55:31-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","variant_ids":[3947651267,3947651651,3947652035]},"available":true,"name":"Curabitur cursus dignis - purple \/ medium","public_title":"purple \/ medium","options":["purple","medium"],"price":25900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651715,"title":"green \/ medium","option1":"green","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150915,"product_id":1293238211,"position":5,"created_at":"2015-06-29T02:55:32-04:00","updated_at":"2015-06-29T02:55:32-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","variant_ids":[3947651331,3947651715,3947652099]},"available":true,"name":"Curabitur cursus dignis - green \/ medium","public_title":"green \/ medium","options":["green","medium"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651779,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792151107,"product_id":1293238211,"position":6,"created_at":"2015-06-29T02:55:33-04:00","updated_at":"2015-06-29T02:55:33-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6.jpg?v=1435560933","variant_ids":[3947651395,3947651779]},"available":true,"name":"Curabitur cursus dignis - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651907,"title":"red \/ large","option1":"red","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792149443,"product_id":1293238211,"position":2,"created_at":"2015-06-29T02:55:28-04:00","updated_at":"2015-06-29T02:55:28-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","variant_ids":[3947651139,3947651523,3947651907]},"available":true,"name":"Curabitur cursus dignis - red \/ large","public_title":"red \/ large","options":["red","large"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947651971,"title":"blue \/ large","option1":"blue","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150083,"product_id":1293238211,"position":3,"created_at":"2015-06-29T02:55:30-04:00","updated_at":"2015-06-29T02:55:30-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","variant_ids":[3947651203,3947651587,3947651971]},"available":true,"name":"Curabitur cursus dignis - blue \/ large","public_title":"blue \/ large","options":["blue","large"],"price":25900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947652035,"title":"purple \/ large","option1":"purple","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150339,"product_id":1293238211,"position":4,"created_at":"2015-06-29T02:55:31-04:00","updated_at":"2015-06-29T02:55:31-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","variant_ids":[3947651267,3947651651,3947652035]},"available":true,"name":"Curabitur cursus dignis - purple \/ large","public_title":"purple \/ large","options":["purple","large"],"price":28900,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947652099,"title":"green \/ large","option1":"green","option2":"large","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792150915,"product_id":1293238211,"position":5,"created_at":"2015-06-29T02:55:32-04:00","updated_at":"2015-06-29T02:55:32-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","variant_ids":[3947651331,3947651715,3947652099]},"available":true,"name":"Curabitur cursus dignis - green \/ large","public_title":"green \/ large","options":["green","large"],"price":25900,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2.jpg?v=1435560928","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3.jpg?v=1435560930","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4.jpg?v=1435560931","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5.jpg?v=1435560932","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6.jpg?v=1435560933"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1.jpg?v=1435560927","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
      </div>
    </li>
  </ul> 

              </div>
              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="200">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/curabitur-cursus-dignis-1.html" class="container_item">

        <img src="assets/images/products/2_119a31f2-2054-4483-93a3-841310e6bdfb_grande2b1c.jpg?v=1435561310" class="img-responsive" alt="Curabitur cursus dignis" />

        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/curabitur-cursus-dignis-1.html">Curabitur cursus dignis</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293239619"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        
        <span class="price">
          
          <span class='money'>$200.00</span>
          
        </span>
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              <option selected="selected" value="5141875779">Default Title</option>
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="add-to-cart" type="submit" name="add"><i class="fa fa-shopping-cart"></i><span class="list-mode">Add to Cart</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="curabitur-cursus-dignis-1" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293239619,"title":"Curabitur cursus dignis","handle":"curabitur-cursus-dignis-1","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:38-04:00","vendor":"Vendor 2","type":"Hoodies Wear","tags":["Best Seller","Red","S","Sale Off","Under $100"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":null,"compare_at_price_min":0,"compare_at_price_max":0,"compare_at_price_varies":false,"variants":[{"id":5141875779,"title":"Default Title","option1":"Default Title","option2":null,"option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Curabitur cursus dignis","public_title":null,"options":["Default Title"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":9,"inventory_management":null,"inventory_policy":"deny","barcode":""}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2_119a31f2-2054-4483-93a3-841310e6bdfb.jpg?v=1435561310","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/3_5e173faf-876b-4e2f-8e49-597207470817.jpg?v=1435561311","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_5d375b4c-f42f-4a86-aa2f-ff4e0ead303f.jpg?v=1435561312"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/2_119a31f2-2054-4483-93a3-841310e6bdfb.jpg?v=1435561310","options":["Title"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

              </div>
              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="400">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/donec-aliquam-ante-non.html" class="container_item">

        <img src="assets/images/products/6_03a522d6-f36a-4f59-a815-bbade4d87a6e_grandec150.jpg" class="img-responsive" alt="Donec aliquam ante non" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/donec-aliquam-ante-non.html">Donec aliquam ante non</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293236931"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        

        
        
        
        
        
        
        
        <span class="price_sale"><span class='money'>$250.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>

        
        
        
        
        
        

        
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              <option value="3947648771">black / small</option>
              <option selected="selected" value="3947648835">white / small</option> 
              <option value="3947648899">black / medium</option>
              <option value="3947648963">white / medium</option>
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/donec-aliquam-ante-non.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="donec-aliquam-ante-non" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293236931,"title":"Donec aliquam ante non","handle":"donec-aliquam-ante-non","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:30-04:00","vendor":"Vendor 3","type":"Dressing","tags":["$100 - $200","Best Seller","Green","M"],"price":25000,"price_min":25000,"price_max":26000,"available":true,"price_varies":true,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947648771,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Donec aliquam ante non - black \/ small","public_title":"black \/ small","options":["black","small"],"price":25000,"weight":0,"compare_at_price":null,"inventory_quantity":0,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947648835,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792290499,"product_id":1293236931,"position":2,"created_at":"2015-06-29T03:02:41-04:00","updated_at":"2015-07-03T00:30:57-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_b760c006-b403-4035-ba94-b19cb0ff8214.jpg?v=1435897857","variant_ids":[3947648835,3947648963]},"available":true,"name":"Donec aliquam ante non - white \/ small","public_title":"white \/ small","options":["white","small"],"price":25000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947648899,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Donec aliquam ante non - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":26000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947648963,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792290499,"product_id":1293236931,"position":2,"created_at":"2015-06-29T03:02:41-04:00","updated_at":"2015-07-03T00:30:57-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_b760c006-b403-4035-ba94-b19cb0ff8214.jpg?v=1435897857","variant_ids":[3947648835,3947648963]},"available":true,"name":"Donec aliquam ante non - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":26000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_03a522d6-f36a-4f59-a815-bbade4d87a6e.jpg?v=1435897857","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_b760c006-b403-4035-ba94-b19cb0ff8214.jpg?v=1435897857"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_03a522d6-f36a-4f59-a815-bbade4d87a6e.jpg?v=1435897857","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

              </div>
              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="600">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/donec-condime-fermentum.html" class="container_item">

        <img src="assets/images/products/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9_grande02fe.jpg?v=1435561424" class="img-responsive" alt="Donec condime fermentum" />

        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/donec-condime-fermentum.html">Donec condime fermentum</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293235843"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        
        <span class="price">
           
          <span class='money'>$200.00</span>
          
        </span>
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              
              
              
              
              
              <option selected="selected" value="3947646083">black / small</option>
              
              
              
              <option value="3947646147">red / small</option>
              
              
              
              <option value="3947646211">white / small</option>
              
              
              
              <option value="3947646275">blue / small</option>
              
              
              
              <option value="3947646339">black / medium</option>
              
              
              
              <option value="3947646403">red / medium</option>
              
              
              
              <option value="3947646467">blue / medium</option>
              
              
              
              <option value="3947646531">white / medium</option>
              
              
              
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/donec-condime-fermentum.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="donec-condime-fermentum" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <span class="product-json hide">{"id":1293235843,"title":"Donec condime fermentum","handle":"donec-condime-fermentum","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:27-04:00","vendor":"Vendor 4","type":"Sweaters Wear","tags":["Above $200","Black","L","Sale Off"],"price":20000,"price_min":20000,"price_max":25000,"available":true,"price_varies":true,"compare_at_price":null,"compare_at_price_min":0,"compare_at_price_max":0,"compare_at_price_varies":false,"variants":[{"id":3947646083,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313411,"product_id":1293235843,"position":1,"created_at":"2015-06-29T03:03:44-04:00","updated_at":"2015-06-29T03:03:44-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","variant_ids":[3947646083,3947646339]},"available":true,"name":"Donec condime fermentum - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646147,"title":"red \/ small","option1":"red","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313539,"product_id":1293235843,"position":2,"created_at":"2015-06-29T03:03:45-04:00","updated_at":"2015-06-29T03:03:45-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5_9c4bb547-32eb-42ea-bed5-2f1fc3832c2e.jpg?v=1435561425","variant_ids":[3947646147,3947646403]},"available":true,"name":"Donec condime fermentum - red \/ small","public_title":"red \/ small","options":["red","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646211,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313987,"product_id":1293235843,"position":3,"created_at":"2015-06-29T03:03:46-04:00","updated_at":"2015-06-29T03:03:46-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_2b8df768-6599-4e41-ae4c-2d6afd2b1d95.jpg?v=1435561426","variant_ids":[3947646211,3947646531]},"available":true,"name":"Donec condime fermentum - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646275,"title":"blue \/ small","option1":"blue","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792314179,"product_id":1293235843,"position":4,"created_at":"2015-06-29T03:03:47-04:00","updated_at":"2015-06-29T03:03:47-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/7.jpg?v=1435561427","variant_ids":[3947646275,3947646467]},"available":true,"name":"Donec condime fermentum - blue \/ small","public_title":"blue \/ small","options":["blue","small"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646339,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313411,"product_id":1293235843,"position":1,"created_at":"2015-06-29T03:03:44-04:00","updated_at":"2015-06-29T03:03:44-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","variant_ids":[3947646083,3947646339]},"available":true,"name":"Donec condime fermentum - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":25000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646403,"title":"red \/ medium","option1":"red","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313539,"product_id":1293235843,"position":2,"created_at":"2015-06-29T03:03:45-04:00","updated_at":"2015-06-29T03:03:45-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5_9c4bb547-32eb-42ea-bed5-2f1fc3832c2e.jpg?v=1435561425","variant_ids":[3947646147,3947646403]},"available":true,"name":"Donec condime fermentum - red \/ medium","public_title":"red \/ medium","options":["red","medium"],"price":25000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646467,"title":"blue \/ medium","option1":"blue","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792314179,"product_id":1293235843,"position":4,"created_at":"2015-06-29T03:03:47-04:00","updated_at":"2015-06-29T03:03:47-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/7.jpg?v=1435561427","variant_ids":[3947646275,3947646467]},"available":true,"name":"Donec condime fermentum - blue \/ medium","public_title":"blue \/ medium","options":["blue","medium"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947646531,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792313987,"product_id":1293235843,"position":3,"created_at":"2015-06-29T03:03:46-04:00","updated_at":"2015-06-29T03:03:46-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_2b8df768-6599-4e41-ae4c-2d6afd2b1d95.jpg?v=1435561426","variant_ids":[3947646211,3947646531]},"available":true,"name":"Donec condime fermentum - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":null,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/5_9c4bb547-32eb-42ea-bed5-2f1fc3832c2e.jpg?v=1435561425","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/6_2b8df768-6599-4e41-ae4c-2d6afd2b1d95.jpg?v=1435561426","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/7.jpg?v=1435561427"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/4_0fe2529b-f7ae-4ed5-a8ff-4fae623757f9.jpg?v=1435561424","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span>
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

              </div>
              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="800">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/maximus-quam-posuere-1.html" class="container_item">

        <img src="assets/images/products/10_16854be2-a731-4970-984e-7f6e483d2405_grandedd3a.jpg?v=1435561913" class="img-responsive" alt="Maximus quam posuere" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/maximus-quam-posuere-1.html">Maximus quam posuere</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293227907"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        

        
        
        
        
        
        <span class="price_sale"><span class='money'>$200.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>

        
        
        
        
        
        
        
        

        
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              

              
              
              
              
              
              

              

              
              
              <option selected="selected" value="3947629763">black / small</option>
              
              
              
              <option value="3947629827">white / small</option>
              
              
              
              <option value="3947629891">black / medium</option>
              
              
              
              <option value="3947629955">white / medium</option>
              
              
              
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/maximus-quam-posuere-1.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="maximus-quam-posuere-1" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293227907,"title":"Maximus quam posuere","handle":"maximus-quam-posuere-1","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:05-04:00","created_at":"2015-06-29T00:22:06-04:00","vendor":"Vendor 3","type":"Sweaters Wear","tags":["Best Seller","Sale Off"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947629763,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566019,"product_id":1293227907,"position":1,"created_at":"2015-06-29T03:11:53-04:00","updated_at":"2015-06-29T03:11:53-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","variant_ids":[3947629763,3947629891]},"available":true,"name":"Maximus quam posuere - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947629827,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566339,"product_id":1293227907,"position":2,"created_at":"2015-06-29T03:11:54-04:00","updated_at":"2015-06-29T03:11:54-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_11ac0177-cd42-4bfc-b610-df79b9a60afb.jpg?v=1435561914","variant_ids":[3947629827,3947629955]},"available":true,"name":"Maximus quam posuere - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947629891,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566019,"product_id":1293227907,"position":1,"created_at":"2015-06-29T03:11:53-04:00","updated_at":"2015-06-29T03:11:53-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","variant_ids":[3947629763,3947629891]},"available":true,"name":"Maximus quam posuere - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947629955,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":null,"requires_shipping":true,"taxable":true,"featured_image":{"id":2792566339,"product_id":1293227907,"position":2,"created_at":"2015-06-29T03:11:54-04:00","updated_at":"2015-06-29T03:11:54-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_11ac0177-cd42-4bfc-b610-df79b9a60afb.jpg?v=1435561914","variant_ids":[3947629827,3947629955]},"available":true,"name":"Maximus quam posuere - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_11ac0177-cd42-4bfc-b610-df79b9a60afb.jpg?v=1435561914"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/10_16854be2-a731-4970-984e-7f6e483d2405.jpg?v=1435561913","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

              </div>
              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="1000">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/product-full-width.html" class="container_item">

        <img src="assets/images/products/11_68ab6d0f-109c-429b-a903-4cbf60257806_grande6ce0.jpg?v=1435561981" class="img-responsive" alt="Product full width" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/product-full-width.html">Product full width</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293240771"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        

        
        
        
        
        
        <span class="price_sale"><span class='money'>$200.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>

        
        
        
        
        
        
        
        

        
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              

              
              
              
              
              
              

              

              
              
              <option selected="selected" value="3947656579">black / small</option>
              
              
              
              <option value="3947656643">white / small</option>
              
              
              
              <option value="3947656707">black / medium</option>
              
              
              
              <option value="3947656771">white / medium</option>
              
              
              
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/product-full-width.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="product-full-width" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293240771,"title":"Product full width","handle":"product-full-width","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:41-04:00","vendor":"Vendor 3","type":"Sweaters Wear","tags":["Best Seller","Black","Gray","Sale Off","Under $100","XL"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947656579,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623043,"product_id":1293240771,"position":1,"created_at":"2015-06-29T03:13:01-04:00","updated_at":"2015-06-29T03:13:01-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","variant_ids":[3947656579,3947656707]},"available":true,"name":"Product full width - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947656643,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623491,"product_id":1293240771,"position":2,"created_at":"2015-06-29T03:13:02-04:00","updated_at":"2015-06-29T03:13:02-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_5fd43d5b-08ec-4a13-b388-7f7a55a92ed0.jpg?v=1435561982","variant_ids":[3947656643,3947656771]},"available":true,"name":"Product full width - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947656707,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623043,"product_id":1293240771,"position":1,"created_at":"2015-06-29T03:13:01-04:00","updated_at":"2015-06-29T03:13:01-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","variant_ids":[3947656579,3947656707]},"available":true,"name":"Product full width - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947656771,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792623491,"product_id":1293240771,"position":2,"created_at":"2015-06-29T03:13:02-04:00","updated_at":"2015-06-29T03:13:02-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_5fd43d5b-08ec-4a13-b388-7f7a55a92ed0.jpg?v=1435561982","variant_ids":[3947656643,3947656771]},"available":true,"name":"Product full width - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_5fd43d5b-08ec-4a13-b388-7f7a55a92ed0.jpg?v=1435561982"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/11_68ab6d0f-109c-429b-a903-4cbf60257806.jpg?v=1435561981","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

              </div>
              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="1200">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/product-with-left-slidebar.html" class="container_item">

        <img src="assets/images/products/9_29fe62cc-0d0f-4cbc-b09a-6d6a8d7c2431_grandeebbe.jpg?v=1435833580" class="img-responsive" alt="Product with left sidebar" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/product-with-left-slidebar.html">Product with left sidebar</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293241795"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        

        
        
        
        
        
        <span class="price_sale"><span class='money'>$200.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>

        
        
        
        
        
        
        
        

        
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              

              
              
              
              
              
              

              

              
              
              <option selected="selected" value="3947658499">black / small</option>
              
              
              
              <option value="3947658563">white / small</option>
              
              
              
              <option value="3947658627">black / medium</option>
              
              
              
              <option value="3947658691">white / medium</option>
              
              
              
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/product-with-left-slidebar.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="product-with-left-slidebar" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <!--span class="product-json hide">{"id":1293241795,"title":"Product with left sidebar","handle":"product-with-left-slidebar","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:43-04:00","vendor":"Vendor 3","type":"Sweaters Wear","tags":["$100 - $200","Best Seller","Green","M","Red","S","Sale Off","Under $100"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947658499,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792669315,"product_id":1293241795,"position":2,"created_at":"2015-06-29T03:14:00-04:00","updated_at":"2015-07-02T06:39:40-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_fd5d3707-e135-43bc-bfa9-abe5f518c260.jpg?v=1435833580","variant_ids":[3947658499,3947658627]},"available":true,"name":"Product with left sidebar - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":0,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947658563,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Product with left sidebar - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947658627,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792669315,"product_id":1293241795,"position":2,"created_at":"2015-06-29T03:14:00-04:00","updated_at":"2015-07-02T06:39:40-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_fd5d3707-e135-43bc-bfa9-abe5f518c260.jpg?v=1435833580","variant_ids":[3947658499,3947658627]},"available":true,"name":"Product with left sidebar - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947658691,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":null,"available":true,"name":"Product with left sidebar - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/9_29fe62cc-0d0f-4cbc-b09a-6d6a8d7c2431.jpg?v=1435833580","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/12_fd5d3707-e135-43bc-bfa9-abe5f518c260.jpg?v=1435833580"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/9_29fe62cc-0d0f-4cbc-b09a-6d6a8d7c2431.jpg?v=1435833580","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span-->
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

              </div>
              
              <div class="element no_full_width not-animated" data-animate="fadeInUp" data-delay="1400">
                  <ul class="row-container list-unstyled clearfix">
    <li class="row-left">
      <a href="products/product-with-right-slidebar.html" class="container_item">

        <img src="assets/images/products/13_728a8813-99ca-43bd-80fe-a5cbae33a10e_grandeae57.jpg?v=1435562121" class="img-responsive" alt="Product with right sidebar" />

        
        <span class="sale_banner">
          
          <span class="sale_text">Sale</span>
          
        </span>
        
      </a>

      <div class="hbw">
        <span class="hoverBorderWrapper"></span>
      </div>

    </li>

    <li class="row-right parent-fly animMix">
	  <div class="product-content-left">
        <a class="title-5" href="products/product-with-right-slidebar.html">Product with right sidebar</a>
        
          <span class="shopify-product-reviews-badge" data-id="1293242371"></span>
        
      </div>
      <div class="product-content-right">
      <div class="product-price">
        
        

        
        
        
        
        
        <span class="price_sale"><span class='money'>$200.00</span></span>
        <del class="price_compare"> <span class='money'>$300.00</span></del>

        
        
        
        
        
        
        
        

        
          
         
      </div>
      </div>
      <div class="list-mode-description">
        Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum. Temporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed...
      </div>
      <div class="hover-appear">
        <form action="#" method="post">
          
          <div class="hide clearfix"> 
            <select name="id" >
              

              
              
              
              
              
              

              

              
              
              <option selected="selected" value="3947659459">black / small</option>
              
              
              
              <option value="3947659523">white / small</option>
              
              
              
              <option value="3947659587">black / medium</option>
              
              
              
              <option value="3947659651">white / medium</option>
              
              
              
            </select>
          </div>
          
          <div class="effect-ajax-cart">
            
            <input type="hidden" name="quantity" value="1" />
            
            <button class="select-option" type="button" onclick="window.location='products/product-with-right-slidebar.html';"><i class="fa fa-th-list" title="Select Options"></i><span class="list-mode">Select Option</span></button>
            
            
          </div>        
        </form>
       
        
        <div class="product-ajax-qs hidden-xs hidden-sm">
            <div data-handle="product-with-right-slidebar" data-target="#quick-shop-modal" class="quick_shop" data-toggle="modal">
              <i class="fa fa-eye" title="Quick view"></i><span class="list-mode">Quick View</span>
              <span class="product-json hide">{"id":1293242371,"title":"Product with right sidebar","handle":"product-with-right-slidebar","description":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e","published_at":"2015-06-29T00:22:00-04:00","created_at":"2015-06-29T00:22:45-04:00","vendor":"Vendor 3","type":"Sweaters Wear","tags":["$100 - $200","Best Seller","Black","L","Sale Off","White"],"price":20000,"price_min":20000,"price_max":20000,"available":true,"price_varies":false,"compare_at_price":30000,"compare_at_price_min":30000,"compare_at_price_max":30000,"compare_at_price_varies":false,"variants":[{"id":3947659459,"title":"black \/ small","option1":"black","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792714307,"product_id":1293242371,"position":1,"created_at":"2015-06-29T03:15:00-04:00","updated_at":"2015-06-29T03:15:21-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/13_728a8813-99ca-43bd-80fe-a5cbae33a10e.jpg?v=1435562121","variant_ids":[3947659459,3947659587]},"available":true,"name":"Product with right sidebar - black \/ small","public_title":"black \/ small","options":["black","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":0,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947659523,"title":"white \/ small","option1":"white","option2":"small","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792713411,"product_id":1293242371,"position":2,"created_at":"2015-06-29T03:14:59-04:00","updated_at":"2015-06-29T03:15:21-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1_adca515b-a9f4-4ba8-b511-e8bbf8c05c65.jpg?v=1435562121","variant_ids":[3947659523,3947659651]},"available":true,"name":"Product with right sidebar - white \/ small","public_title":"white \/ small","options":["white","small"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947659587,"title":"black \/ medium","option1":"black","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792714307,"product_id":1293242371,"position":1,"created_at":"2015-06-29T03:15:00-04:00","updated_at":"2015-06-29T03:15:21-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/13_728a8813-99ca-43bd-80fe-a5cbae33a10e.jpg?v=1435562121","variant_ids":[3947659459,3947659587]},"available":true,"name":"Product with right sidebar - black \/ medium","public_title":"black \/ medium","options":["black","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null},{"id":3947659651,"title":"white \/ medium","option1":"white","option2":"medium","option3":null,"sku":"","requires_shipping":true,"taxable":true,"featured_image":{"id":2792713411,"product_id":1293242371,"position":2,"created_at":"2015-06-29T03:14:59-04:00","updated_at":"2015-06-29T03:15:21-04:00","src":"https:\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1_adca515b-a9f4-4ba8-b511-e8bbf8c05c65.jpg?v=1435562121","variant_ids":[3947659523,3947659651]},"available":true,"name":"Product with right sidebar - white \/ medium","public_title":"white \/ medium","options":["white","medium"],"price":20000,"weight":0,"compare_at_price":30000,"inventory_quantity":1,"inventory_management":null,"inventory_policy":"deny","barcode":null}],"images":["\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/13_728a8813-99ca-43bd-80fe-a5cbae33a10e.jpg?v=1435562121","\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/1_adca515b-a9f4-4ba8-b511-e8bbf8c05c65.jpg?v=1435562121"],"featured_image":"\/\/cdn.shopify.com\/s\/files\/1\/0908\/7252\/products\/13_728a8813-99ca-43bd-80fe-a5cbae33a10e.jpg?v=1435562121","options":["Color","Size"],"content":"\u003cp\u003eNam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis amet voluptas assumenda est, omnis dolor repellendus quis nostrum.\u003c\/p\u003e\n\u003cp\u003eTemporibus autem quibusdam et aut officiis debitis aut rerum dolorem necessitatibus saepe eveniet ut et neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, ut aliquid ex ea commodi consequatur.\u003c\/p\u003e"}</span>
            </div>
        </div>

        
          <a class="wish-list" href="account/login.html" title="wish list"><i class="fa fa-heart"></i><span class="list-mode">Add to Wishlist</span></a>
          
        
      </div>
    </li>
  </ul> 

              </div>
              
            </div>
          </div>
        </div>

      </div>
    </div>
  </div>
  </div>
  

  
  
  <div class="home-partners">
  <div class="container">
    <div class="partners-logo row">

      <div class="col-md-24">
        <div id="partners-container" class="clearfix">
          <h6 class="general-title">Popular Brands</h6>
          <div id="partners" class="clearfix">
            
            

            
            
            
            

            <div class="logo not-animated text-center" data-animate="bounceIn" data-delay="150">
              <a class="animated" href="collections/vendors323e.html?q=Vendor%201">
                <img class="pulse" src="assets/images/partners_logo_1a67f.png" alt="" />
              </a>
            </div>

            

            
            

            
            
            
            

            <div class="logo not-animated text-center" data-animate="bounceIn" data-delay="300">
              <a class="animated" href="collections/vendorsc606.html?q=Vendor%202">
                <img class="pulse" src="assets/images/partners_logo_2a67f.png" alt="" />
              </a>
            </div>

            <div class="logo not-animated text-center" data-animate="bounceIn" data-delay="450">
              <a class="animated" href="collections/vendors97a5.html?q=Vendor%203">
                <img class="pulse" src="assets/images/partners_logo_2a67f.png" alt="" />
              </a>
            </div>
            

            <div class="logo not-animated text-center" data-animate="bounceIn" data-delay="600">
              <a class="animated" href="collections/vendorsdc04.html?q=Vendor%204">
                <img class="pulse" src="assets/images/partners_logo_2a67f.png" alt="" />
              </a>
            </div>

            <div class="logo not-animated text-center" data-animate="bounceIn" data-delay="750">
              <a class="animated" href="collections/vendors323e.html?q=Vendor%201">
                <img class="pulse" src="assets/images/partners_logo_2a67f.png" alt="" />
              </a>
            </div>

            <div class="logo not-animated text-center" data-animate="bounceIn" data-delay="900">
              <a class="animated" href="collections/vendorsc606.html?q=Vendor%202">
                <img class="pulse" src="assets/images/partners_logo_2a67f.png" alt="" />
              </a>
            </div>

            <div class="logo not-animated text-center" data-animate="bounceIn" data-delay="1050">
              <a class="animated" href="collections/vendors97a5.html?q=Vendor%203">
                <img class="pulse" src="assets/images/partners_logo_2a67f.png" alt="" />
              </a>
            </div>
         </div>

        </div>
      </div>
      <div class="clearfix"></div>

    </div>
  </div>
  </div>
  

</div>
              
              

        </section>        
      </div>
    </div>
  </div>

  <footer id="footer">      
    <div id="footer-content">
  <h6 class="general-title contact-footer-title">Newsletter</h6>
  
  
  <div id="widget-newsletter">
    <div class="container">      
      
      <div class="newsletter col-md-24">
        <form action="#" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" target="_blank">
          <span class="news-desc">We promise only send the good things</span>
          <div class="group_input">
            <input class="form-control" type="email" placeholder="Your Email Address" name="Email" id="email-input" />
            <div class="unpadding-top"><button class="btn btn-1" type="submit"><i class="fa fa-paper-plane"></i></button></div>
          </div>              
        </form>
      </div>
                
    </div>
  </div>
  

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
