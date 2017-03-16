<?php

	error_reporting( ~E_NOTICE ); // avoid notice
	
	require_once 'dbconfig.php';
	
	if(isset($_POST['addphoto']))
	{
		$photo_title = $_POST['photo_title'];
		
		
		$imgFile = $_FILES['photo']['name'];
		$tmp_dir = $_FILES['photo']['tmp_name'];
		$imgSize = $_FILES['photo']['size'];
		
		
		if(empty($photo_title)){
			$errMSG = "Please Enter Image Title.";
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
			$stmt = $DB_con->prepare('INSERT INTO gallery_details(title,photourl) VALUES(:title, :imgpic)');
			$stmt->bindParam(':title',$photo_title);
			$stmt->bindParam(':imgpic',$imgurl);
					
			if($stmt->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("New Image Successfully Inserted"); location.href="gallery_admin.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
		}
	}
?>