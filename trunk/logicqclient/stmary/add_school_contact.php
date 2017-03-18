<?php

	error_reporting( ~E_NOTICE ); // avoid notice
	
	require_once 'dbconfig.php';
	
	if(isset($_POST['school_contact']))
	{
		$school_title = $_POST['school_title'];
		$addres1 = $_POST['addres1'];
		$addres2 = $_POST['addres2'];
		$addres3 = $_POST['addres3'];
		$pin = $_POST['pin'];
		$tel = $_POST['tel'];
		$fax = $_POST['fax'];
		$mail = $_POST['mail'];
		$fb_link = $_POST['fb_link'];
		$twiter_link = $_POST['twiter_link'];
				
		if(empty($school_title)){
			echo $errMSG = "Please Enter School Name.";
		}
		else if(empty($addres1)){
			echo $errMSG = "Please Enter Address 1.";
		}
		else if(empty($addres2)){
			echo $errMSG = "Please Enter Address 2.";
		}
		else if(empty($addres3)){
			echo $errMSG = "Please Enter Address 3.";
		}
		else if(empty($fax)){
			echo $errMSG = "Please Enter Fax Number.";
		}
		else if(empty($pin)){
			echo $errMSG = "Please Enter Pin";
		}
		else if(empty($tel)){
			echo $errMSG = "Please Enter Telephone.";
		}
		else if(empty($mail)){
			echo $errMSG = "Please Enter Mail ID.";
		}
		else if(empty($fb_link)){
			echo $errMSG = "Please Enter Facebook Link.";
		}
		else if(empty($twiter_link)){
			echo $errMSG = "Please Enter Twitter Link.";
		}
					
		
		// if no error occured, continue ....
		if(!isset($errMSG))
		{
			$stmt = $DB_con->prepare('INSERT INTO contact_us(title, address1, address2, address3, Pin, Tel, Fax, mailid, fblink, twiterlink) VALUES(:title, :addres1, :addres2, :addres3, :Pin, :Tel, :Fax, :mail, :fb_link, :twiter_link)');
			$stmt->bindParam(':title',$school_title);
			$stmt->bindParam(':addres1',$addres1);
			$stmt->bindParam(':addres2',$addres2);
			$stmt->bindParam(':addres3',$addres3);
			$stmt->bindParam(':Pin',$pin);
			$stmt->bindParam(':Tel',$tel);
			$stmt->bindParam(':Fax',$fax);
			$stmt->bindParam(':mail',$mail);
			$stmt->bindParam(':fb_link',$fb_link);
			$stmt->bindParam(':twiter_link',$twiter_link);
			
					
			if($stmt->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("Contact Us New Content Successfully Inserted"); location.href="sch_add_admin.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
		}
	}
?>