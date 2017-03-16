<?php

//including the database connection file
include("sql.php");
 
//getting id of the data from url
$id = $_GET['id'];
 
//deleting the row from table
$result = mysql_query("DELETE FROM news WHERE id=$id");

if($result)
   {
    echo '<script language="javascript">';
    echo 'alert("News Successfully deleted"); location.href="admin.php"';
    echo '</script>';
   }
   else
   {
    echo 'error while deleting....';
   }

?>