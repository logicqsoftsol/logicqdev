<?php
	
	$con=mysqli_connect("43.242.215.118:3306","logicqso","qazQAz234#$%","logicqso_jewellery_Ecommerce");
// Check connection

echo "sucess";
if (mysqli_connect_errno())
{
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

?>