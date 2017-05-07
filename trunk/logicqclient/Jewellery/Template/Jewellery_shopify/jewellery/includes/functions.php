<?php

$con=mysqli_connect("43.242.215.118:3306","logicqso","qazQAz234#$%","logicqso_jewellery_Ecommerce");
// Check connection
if (mysqli_connect_errno())
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

	// PROJECT RELATED FUNCTIONS
	class PHP_fun 
	{
	function get_menu_tree($parent_id) 
		{
		global $con;
		$menu = "";
		$sqlquery = " SELECT * FROM menu_details where parent_category='" .$parent_id . "' ";
		$res=mysqli_query($con,$sqlquery);
		while($row=mysqli_fetch_array($res,MYSQLI_ASSOC)) 
		{
			   $menu .="<li class='nav-item active'><a href='".$row['menu_link']."'>".$row['menu_name']."</a>";
			   
			   $menu .= "<ul class='nav navbar-nav hoverMenuWrapper'>".get_menu_tree($row['menu_ID'])."</ul>"; //call  recursively
			   
			   $menu .= "</li>";
	 
		}
		
		return $menu;
		} 
	}//class PHP_fun()
?>	