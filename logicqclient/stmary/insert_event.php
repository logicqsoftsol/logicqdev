<?php
 error_reporting( ~E_NOTICE ); // avoid notice
 require_once 'sql.php';
 
 if(isset($_POST['btnsave']))
 {
  $news_title = $_POST['news_title'];// News Title
  $news_date = $_POST['news_date'];// News Date
  $description = $_POST['description'];// News Description
  
  $imgFile = $_FILES['news_image']['name'];
  $tmp_dir = $_FILES['news_image']['tmp_name'];
  $imgSize = $_FILES['news_image']['size'];
  
  
  if(empty($news_title)){
   $errMSG = "Please Enter News Title.";
  }
  else if(empty($news_date)){
   $errMSG = "Please Enter Date";
  }
  else if(empty($imgFile)){
   $errMSG = "Please Select Image File.";
  }
  else if(empty($description)){
   $errMSG = "Please Enter Description.";
  }
  else
  {
   $upload_dir = 'news_image/'; // upload directory
 
   $imgExt = strtolower(pathinfo($imgFile,PATHINFO_EXTENSION)); // get image extension
  
   // valid image extensions
   $valid_extensions = array('jpeg', 'jpg', 'png', 'gif'); // valid extensions
  
   // rename uploading image
   $newspic = rand(1000,1000000).".".$imgExt;
    
   // allow valid image file formats
   if(in_array($imgExt, $valid_extensions)){   
    // Check file size '5MB'
    if($imgSize < 5000000)    {
     move_uploaded_file($tmp_dir,$upload_dir.$newspic);
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
	  $image_url = 'http://stmaryrnpur.org/'.$upload_dir.$newspic;
	  $query="INSERT INTO `news` (`title`, `news_date`, `imageurl`, `details`) VALUES ('$news_title','$news_date', '$image_url', '$description')";
	
	
	
	$result = mysql_query($query) or die(mysql_error()); 
	
	
  /*  $stmt = $DB_con->prepare('INSERT INTO news(title,news_date,imageurl,details) VALUES(:ntitle, :ndate, :npic, :ndetails)');
   $stmt->bindParam(':ntitle',$news_title);
   $stmt->bindParam(':ndate',$news_date);
   $stmt->bindParam(':npic',$newspic);
   $stmt->bindParam(':ndetails',$description); */
   
   if($result=='TRUE')
   {
      $successMSG = "new record succesfully inserted ...";
	  echo $successMSG; 
		//header("Location:admin.php"); // redirects image view page after 5 seconds.
		//exit;
   }
   else
   {
    $errMSG = "error while inserting....";
   }
  }
 }
?>