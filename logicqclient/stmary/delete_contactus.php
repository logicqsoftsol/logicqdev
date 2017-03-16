<?php

error_reporting( ~E_NOTICE );
require_once 'dbconfig.php';


if(isset($_GET['delete_id']))
 {
 
  // it will delete an actual record from db
  $stmt_delete = $DB_con->prepare('DELETE FROM contact_us WHERE id =:uid');
  $stmt_delete->bindParam(':uid',$_GET['delete_id']);
  $stmt_delete->execute();
  
  if($stmt_delete->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("Contact Us Content Removed Sucessfully"); location.href="aboutus_admin.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while deleting....';
			}
   }
 ?>