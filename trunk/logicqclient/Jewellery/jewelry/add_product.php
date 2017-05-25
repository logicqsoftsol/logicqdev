<?php

error_reporting( ~E_NOTICE ); 

require_once 'dbconfig.php';

if(isset($_POST['productadd_submit']))
{
	
alert("inside");
 
 $barcode=$_POST['barcode'];
 $brand=$_POST['brand'];
 $productcatagory=$_POST['productcatagory'];
 $subcatagory=$_POST['subcatagory'];
 $productname=$_POST['productname'];
 $productmatterialtype=$_POST['productmatterialtype'];
 $purchasedate=$_POST['purchasedate'];
 $productsize=$_POST['productsize'];
 $vendername=$_POST['vendername'];
 $venderid=$_POST['venderid'];
 $venderprice=$_POST['venderprice'];
  $carat=$_POST['carat'];
   $pureweight=$_POST['pureweight'];
    $netweight=$_POST['netweight'];
	 $meenaweight=$_POST['meenaweight'];
  $grossweight=$_POST['grossweight'];
  $wastage=$_POST['wastage'];
  $stone_used=$_POST['stone_used'];
  $stoneweight=$_POST['stoneweight'];
  $stonecolor=$_POST['stonecolor'];
  $mrpprice=$_POST['mrpprice'];
  $stoneprice=$_POST['stoneprice'];
  $makingcharges=$_POST['makingcharges'];
  $vatprice=$_POST['vatprice'];
  $hmtagprice=$_POST['hmtagprice'];
  $discountprice=$_POST['discountprice'];
  $productstyle=$_POST['productstyle'];
  $metalcolor=$_POST['metalcolor'];
  $gender=$_POST['gender'];
  $desctext=$_POST['desctext'];
  $deginedesc=$_POST['deginedesc'];
  $technicaldesc=$_POST['technicaldesc'];
  $prod_q_type = "number(s)";
  $prod_unit_type = "gram(s)";
  
  
    // Unique Product ID
	$today = date('Ymd');
	$rand = strtoupper(substr(uniqid(sha1(time())),0,4));
	$prd_id = $today.$rand;
 alert($barcode, $brand, $productname);
 
 // Insert data into product description
 $sql_prod_desc=$DB_con->query("INSERT INTO prod_desc_details(PRODUCT_ID, DESC_TEXT, DEGN_STYLE, AVAL_COLOR, APPLICABLE_GENDER, DESIGN_DESC, TECHNICAL_SPEC) VALUES($prd_id, '$desctext', '$productstyle', '$metalcolor', '$gender', '$hmtagprice', '$deginedesc', '$technicaldesc')");
 
  // Insert data into price details
 $sql_price_details=$DB_con->query("INSERT INTO price_details(PRODUCT_ID, SELL_PRICE, VENDOR_PRICE, MRP_PRICE, HM_TAG_PRICE, MAKING_PRICE) VALUES($prd_id, '$desctext', '$productstyle', '$metalcolor', '$gender', '$hmtagprice', '$deginedesc', '$technicaldesc')");
 
  // Insert data into quantity details
 $sql_quantity_details=$DB_con->query("INSERT INTO quantity_details(PRODUCT_ID, PRODUCT_QUANTITY_TYPE, PRODUCT_UNIT_TYPE, NET_WT, GROSS_WT, MEENA_WT, WASTAGE, PURE_WT) VALUES($prd_id, '$prod_q_type', '$prod_unit_type', '$netweight', '$grossweight', '$meenaweight', '$wastage', '$pureweight')");
 
 //Get Quantity ID from Quantity Table
 $sql_get_qid=$DB_con->query("SELECT ID from quantity_details where PRODUCT_ID=$prd_id");
 
 $sql_get_pr_id=$DB_con->query("SELECT ID from price_details where PRODUCT_ID=$prd_id");
 
 $sql_get_doc_id=$DB_con->query("SELECT ID from prod_document_details where PRODUCT_ID=$prd_id");
 
 
 
 $sql_stone_details=$DB_con->query("INSERT INTO stone_details(QUANTITY_ID, STONE_WT, STONE_COLOR, STONE_PCS, STONE_PRICE) VALUES($sql_get_qid, '$desctext', '$stoneweight', '$stonecolor', '$stone_used', '$stoneprice')");
 
 $sql_stone_details=$DB_con->query("INSERT INTO product_details(ID, NAME, CATAGORY_ID, SUB_CATAGORY_ID, BARCODE, VENDOR_ID, COLOR, SIZE, PRICE_ID, QUANTITY_ID, DOCUMENT_ID, DESCRIPTION_ID) VALUES($prd_id, '$productname', '$productcatagory', '$subcatagory', '$barcode', '$venderid', '$productmatterialtype', '$productsize', '$sql_get_pr_id', '$sql_get_qid', '$sql_get_doc_id')");
 
 
 
  
 
 if($sql_stone_details && $sql_stone_details && $sql_quantity_details && $sql_price_details && $sql_prod_desc)
	{
		echo '<script language="javascript">';
		echo 'alert("New Product is Added Sucessfully with Ref ID $prd_id"); location.href="admin.php"';
		echo '</script>';
	}
	else
	{
		echo 'error while inserting....';
	}

}

?>
