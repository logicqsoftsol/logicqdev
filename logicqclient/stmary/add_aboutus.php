<?php

	error_reporting( ~E_NOTICE ); // avoid notice
	
	require_once 'dbconfig.php';
	
	if(isset($_POST['about_us']))
	{
		$aboutus_title = $_POST['aboutus_title'];
		$para1 = $_POST['para1'];
		$para2 = $_POST['para2'];
		$para3 = $_POST['para3'];
		
		$imgFile = $_FILES['image']['name'];
		$tmp_dir = $_FILES['image']['tmp_name'];
		$imgSize = $_FILES['image']['size'];
		
		
		if(empty($aboutus_title)){
			$errMSG = "Please Enter about_us Title.";
		}
		else if(empty($para1)){
			$errMSG = "Please Enter Para 1.";
		}
		else if(empty($para2)){
			$errMSG = "Please Enter Para 2.";
		}
		else if(empty($para3)){
			$errMSG = "Please Enter Para 3.";
		}
		else if(empty($imgFile)){
			$errMSG = "Please Select Image File.";
		}
		else
		{
			$upload_dir = 'img/'; // upload directory
	
			$imgExt = strtolower(pathinfo($imgFile,PATHINFO_EXTENSION)); // get image extension
		
			// valid image extensions
			$valid_extensions = array('jpeg', 'jpg', 'png', 'gif'); // valid extensions
		
			// rename uploading image
			$imgpic = rand(1000,1000000).".".$imgExt;
			
			$imgurl = 'http://stmaryrnpur.org/'.$upload_dir.$imgpic;
				
			// allow valid image file formats
			if(in_array($imgExt, $valid_extensions)){			
				// Check file size '5MB'
				if($imgSize < 5000000)				{
					move_uploaded_file($tmp_dir,$upload_dir.$imgpic);
				}
				else{
					$errMSG = "Sorry, your file is too large.";
				}
			}
			else{
				$errMSG = "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";		
			}
		}
		
		
		// if no error occured, continue ....
		if(!isset($errMSG))
		{
			$stmt = $DB_con->prepare('INSERT INTO about_us(title,para1,para2,para3,imageurl) VALUES(:title, :para1, :para2, :para3, :imageurl)');
			$stmt->bindParam(':title',$aboutus_title);
			$stmt->bindParam(':para1',$para1);
			$stmt->bindParam(':para2',$para2);
			$stmt->bindParam(':para3',$para3);
			$stmt->bindParam(':imageurl',$imgurl);
					
			if($stmt->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("About Us New Content Successfully Inserted"); location.href="aboutus_admin.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
		}
	}
?>