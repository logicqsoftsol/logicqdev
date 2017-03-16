<?php
 error_reporting( ~E_NOTICE ); // avoid notice
 require_once 'sql.php';
 
 if(isset($_POST['eventsave']))
 {
  $event_title = $_POST['event_title'];// Event Title
  $event_date = $_POST['event_date'];// events Date
  $event_desc = $_POST['event_desc'];// events Description
  
	  if(empty($event_title)){
	   $errMSG = "Please Enter events Title.";
	  }
	  else if(empty($event_date)){
	   $errMSG = "Please Enter Date";
	  }
	  else if(empty($event_desc)){
	   $errMSG = "Please Enter Description.";
	  }
  
  // if no error occured, continue ....
		if(!isset($errMSG))
		{
			  
			$query="INSERT INTO `events` (`eventname`, `event_date`, `description`) VALUES ('$event_title', '$event_date', '$event_desc')";
			//echo $query;
			
			$result = mysql_query($query) or die(mysql_error()); 
			
			
			if($result)
			   {
				echo '<script language="javascript">';
				echo 'alert("New Event Successfully Inserted"); location.href="admin.php"';
				echo '</script>';
			   }
			else
			   {
				echo 'error while inserting....';
			   }
		}
 }
 else 
 {
		$errmsg="Not entering into ";
		echo $errmsg; 
	 
 }
?>