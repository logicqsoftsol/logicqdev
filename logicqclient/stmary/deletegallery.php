<?php

error_reporting( ~E_NOTICE );
require_once 'dbconfig.php';


if(isset($_GET['delete_id']))
 {
  // select image from db to delete
  $stmt_select = $DB_con->prepare('SELECT photourl FROM gallery_details WHERE id =:uid');
  $stmt_select->execute(array(':uid'=>$_GET['delete_id']));
  $imgRow=$stmt_select->fetch(PDO::FETCH_ASSOC);
  $photourl = $imgRow['photourl'];
  $url = substr($photourl, 23);
  echo $url;
  unlink($url);
  
  // it will delete an actual record from db
  $stmt_delete = $DB_con->prepare('DELETE FROM gallery_details WHERE id =:uid');
  $stmt_delete->bindParam(':uid',$_GET['delete_id']);
  $stmt_delete->execute();
  
  if($stmt_delete->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("Selected Image Removed Sucessfully"); location.href="gallery_admin.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while deleting....';
			}
   }
 ?>