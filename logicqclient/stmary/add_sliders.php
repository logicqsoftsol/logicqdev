<?php

	error_reporting( ~E_NOTICE ); // avoid notice
	
	require_once 'dbconfig.php';
	
	if(isset($_POST['add_slider']))
	{
		$slider_title = $_POST['slidertitle'];
		$slider_content = $_POST['slidercontent'];
		
		$imgFile = $_FILES['slider']['name'];
		$tmp_dir = $_FILES['slider']['tmp_name'];
		$imgSize = $_FILES['slider']['size'];
		
		
		if(empty($slider_title)){
			$errMSG = "Please Enter Slider Title.";
		}
		if(empty($slider_content)){
			$errMSG = "Please Enter Slider Content.";
		}
		else if(empty($imgFile)){
			$errMSG = "Please Select Image File.";
		}
		else
		{
			$upload_dir = 'img/slider/'; // upload directory
	
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
			$stmt = $DB_con->prepare('INSERT INTO slider_details(slider_title,slider_content,slider_image) VALUES(:slider_title, :slider_content, :slider_image)');
			$stmt->bindParam(':slider_title',$slider_title);
			$stmt->bindParam(':slider_content',$slider_content);
			$stmt->bindParam(':slider_image',$imgurl);
					
			if($stmt->execute())
			{
				echo '<script language="javascript">';
				echo 'alert("New Image Successfully Inserted"); location.href="slider_admin.php"';
				echo '</script>';
			}
			else
			{
				echo 'error while inserting....';
			}
		}
	}
?>