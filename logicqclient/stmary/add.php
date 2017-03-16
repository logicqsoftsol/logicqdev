<?php
 function renderForm($title, $date, $desc, $error)
 {
?>
 <?php 
 if ($error != '')
 {
 echo '<div style="padding:4px; border:1px solid red; color:red;">'.$error.'</div>';
 }
 ?> 
<form action="" method="post">
  <div class="form-group">
    <label for="news-title">News Title</label>
    <input id="news-title" class="form-control" type="text" name="news-title" placeholder="Leader" value="<?php echo $news-title; ?>" />
  </div>
    <div class="form-group">
    <label for="news_date">Date</label>
    <input id="news_date" class="form-control" type="date" name="news_date" placeholder="" value="<?php echo $news_date; ?>" />
  </div>
  <div class="form-group">
    <label class="form-group">Image Upload for News</label>
	<input id="news_date" class="input-group" type="file" name="news_date" accept="image/*" />
  </div>
  <div class="form-group">
    <label for="news_desc">Notes</label>
    <input id="news_desc" class="form-control" type="text" name="news_desc" placeholder="Description" value="<?php echo $news_desc; ?>" />
  </div>
  <button type="submit" class="btn btn-default" value="Submit" name="submit">Submit</button>
</form>
<?php 
}

 include 'sql.php';

 if (isset($_POST['submit']))
 { 

 $title = mysql_real_escape_string(htmlspecialchars($_POST['news-title']));
 $date = mysql_real_escape_string(htmlspecialchars($_POST['news_date']));
 $desc = mysql_real_escape_string(htmlspecialchars($_POST['news_desc']));
 
 echo $title;
 echo $date;
 echo $desc;

 if ($title == '' || $date == '' || $desc == '')
 {
 $error = '<center>ERROR: Please fill in all required fields!</center>';

 @renderForm($title, $date, $desc, $error);
 }
 else
 {
	$query="INSERT INTO `news` (`title`, `news_date`, `details`) VALUES ('$title','$date', '$desc')";
	
	echo $query;
	
	mysql_query($query) or die(mysql_error()); 

 }
 }
 else

 {
 @renderForm('','','');
 }?>