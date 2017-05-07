<?php

	error_reporting( ~E_NOTICE ); // avoid notice
	
	require_once 'dbconfig.php';

if(isset($_POST['add_main_menu']))
{
 $menu_name = $_POST['menu_name'];
 $menu_link = $_POST['menu_link'];
 $sql=$con->query("INSERT INTO menu_details(menu_name,menu_link,parent_category) VALUES('$menu_name','$menu_link',0)");
 
			if($sql->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("New Main Menu Successfully Inserted"); location.href="admin_page.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
 
 
}
if(isset($_POST['add_sub_menu']))
{
 $parent = $_POST['parent'];
 $submenu_name = $_POST['sub_menu_name'];
 $s_menu_link = $_POST['sub_menu_link'];
 
 $stmt = $con->prepare('INSERT INTO menu_details(parent_category,menu_name,menu_link) VALUES(:parent_category, :menu_name, :menu_link)');
 $stmt->bindParam(':parent_category',$parent);
 $stmt->bindParam(':menu_name',$submenu_name);
 $stmt->bindParam(':menu_link',$s_menu_link);
			
 //$sql=$con->query("INSERT INTO menu_details(parent_category,menu_name,menu_link) VALUES('$parent','$submenu_name','$s_menu_link')");
 
			if($stmt->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("New Main Menu Successfully Inserted"); location.href="admin_page.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
 
}

?>