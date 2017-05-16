<?php

error_reporting( ~E_NOTICE ); 

require_once 'dbconfig.php';

if(isset($_POST['add_main_menu']))
{
 $name = $_POST['mainmenu_name'];
 //echo $name;
 $displayname = strtoupper($name);
 $name_shrink = preg_replace('/\s+/', '', $name);
 $menu_link = $name_shrink.".html";
 //echo $menu_link;
 $submenuchk = $_POST['submenu_select'];
 
	if(empty($name)){
			$errMSG = "Please Enter Main Menu.";
	}
	else if(empty($menu_link)){
		$errMSG = "Please Enter Menu link.";
	}
	else if(empty($submenuchk)){
		$errMSG = "Please select proper option for Sub Menu";
	}
	else
	{
 
 if ($submenuchk == 'Yes')
 {
	$submenu_header_name = $_POST['submenu_headername'];
	$smenu_header_displayname = strtoupper($submenu_header_name);
	$submenu_name = $_POST['submenu_name'];
	$smenu_displayname = strtoupper($submenu_name);
	$sname_shrink = preg_replace('/\s+/', '', $submenu_name);
	$submenu_link = "products/".$sname_shrink.".html";
	//$submenu_link = $_POST['submenu_link'];
	 
	$submenulist=1;
	$type='mainmenu';
	 
	 if(!isset($errMSG))
	{
	 $select1=$DB_con->query('SELECT * FROM menu_details');
	 $menuid=$select1->rowCount();

	 $select2=$DB_con->query('SELECT * FROM sub_menu_header');
	 $submenuheaderid=$select2->rowCount();

	 $select3=$DB_con->query('SELECT * FROM sub_menu_details');
	 $submenuid=$select3->rowCount();

	
 
	$sql_menu=$DB_con->query("INSERT INTO menu_details(id, name, type, displayname, submenulist, linkurl) 
	VALUES($menuid, '$name', '$type', '$displayname', $submenulist, '$menu_link')");
    
	$sql_submenu_header=$DB_con->query("INSERT INTO sub_menu_header(id, name, displayname, menu_id, menu_name) 
	VALUES($submenuheaderid, '$submenu_header_name', '$smenu_header_displayname', $menuid, '$name')");
	
	$sql_submenu=$DB_con->query("INSERT INTO sub_menu_details(id, name, displayname, menu_id, menu_name, sub_menu_header_id, linkurl) 
	VALUES('$submenuid', '$submenu_name', '$smenu_displayname', '$menuid', '$name', '$submenuheaderid', '$submenu_link')");
			
			if($sql_menu && $sql_submenu_header && $sql_submenu)
			{
				echo '<script language="javascript">';
				echo 'alert("New Main Menu adn its Sub Menu Successfully Inserted"); location.href="add_menu_submenu.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
	}
	 
 }
 else {
	 $submenulist=0;
	 $type='mainmenu';
	 
	 $select=$DB_con->prepare('SELECT * FROM menu_details');
	 $select->execute();
	 $count=$select->rowCount();
	 
	//echo $getcount;
 
 $sql=$DB_con->prepare("INSERT INTO menu_details(id, name, type, displayname, submenulist, linkurl) VALUES($count, '$name', '$type', '$displayname', $submenulist, '$menu_link')");
 
 if($sql->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("New Main Menu Successfully Inserted"); location.href="addmenu_page.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
 }

}
  
}
if(isset($_POST['add_sub_menu']))
{
 $mainmenu_id = $_POST['mainmenu_select'];
 $s_menu_header = $_POST['submenu_headername'];
 $s_menu_name = $_POST['submenu_name'];
 
 $smenu_header_dname = strtoupper($s_menu_header);
 $smenu_dname = strtoupper($s_menu_name);
 $sname_shrink = preg_replace('/\s+/', '', $s_menu_name);
 $submenu_link = "products/".$sname_shrink.".html";
 
 
	 $select2=$DB_con->query('SELECT * FROM sub_menu_header');
	 $submenuheaderid=$select2->rowCount();

	 $select3=$DB_con->query('SELECT * FROM sub_menu_details');
	 $submenuid=$select3->rowCount();
	 
	 $menu_name=$DB_con->query("SELECT name from menu_details where id = ".$mainmenu_id."");
	 //echo $menu_name;
 
    $sql_submenu_header=$DB_con->query("INSERT INTO sub_menu_header(id, name, displayname, menu_id, menu_name) 
	VALUES($submenuheaderid, '$s_menu_header', '$smenu_header_dname', $mainmenu_id, '$menu_name')");
	
	$sql_submenu=$DB_con->query("INSERT INTO sub_menu_details(id, name, displayname, menu_id, menu_name, sub_menu_header_id, linkurl) 
	VALUES('$submenuid', '$s_menu_name', '$smenu_dname', '$mainmenu_id', '$menu_name', '$submenuheaderid', '$submenu_link')");
 
    //$stmt = $dbcon->query("INSERT INTO sub_menu_details() VALUES('$parent', '$submenu_name', '$s_menu_link')");
	
 //$sql=$con->query("INSERT INTO menu_details(parent_category,menu_name,menu_link) VALUES('$parent','$submenu_name','$s_menu_link')");
 
			if($sql_submenu_header && $sql_submenu)
			{
				$sql_submenu_header->free();
				$sql_submenu->free();
				echo '<script language="javascript">';
				echo 'alert("New Sub Menu with its Headers Successfully Inserted"); location.href="add_menu_submenu.php"';
				echo '</script>';
				
			}
			else
			{
				echo 'error while inserting....';
			}
 
}

?>
