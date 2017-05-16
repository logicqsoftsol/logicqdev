<!DOCTYPE HTML>  
<html>
<head>
<style>
#submenu_mainmenu{
	display:none;
}
</style>

</head>

<body>  


<h2>Add Menu Items</h2>



<p><span class="error">* required field.</span></p>
<form method="post" action="add_menu.php">  
  Main Menu: <input type="text" name="mainmenu_name" value="">
  
  <br><br>
  
  Is Submenu Need: <select name="submenu_select" id="submenu_select" style="margin-right:10px; margin-top:2px;">
    <option selected="selected" value="select"></option>    
    <option value="Yes">Yes</option>
    <option value="No">No</option>
  
</select>

  
  
  <div id="submenu_mainmenu">
  
  Sub Menu Header: <input type="text" name="submenu_headername" value="">
  <br><br>
  Sub Menu: <input type="text" name="submenu_name" value="">
  
  <br><br>
  
  </div>
<br><br>
	
  
  <input type="submit" name="add_main_menu" value="Add Main_Menu">  
</form>

<h3>Add Sub Menu Items</h3>



<p><span class="error">* required field.</span></p>
<form method="post" action="add_menu.php"> 

	<?php include "sql.php" ?>
  Select Main Menu <select name="submenu_select" id="submenu_select" style="margin-right:10px; margin-top:2px;">
    <option selected="selected" value="select"></option>    
    <option value="Yes">Yes</option>
    <option value="No">No</option>
  
</select>
  Sub Menu Header: <input type="text" name="submenu_name" value="">
  
  <br><br>
  
  Sub Menu: <input type="text" name="submenu_name" value="">
  
  <br><br>
  
    
  <input type="submit" name="add_sub_menu" value="Add Sub_Menu">  
</form>

<script type="text/javascript">
var value = document.getElementById("submenu_select");
value.onchange = function(){
	var hidediv = document.getElementById("submenu_mainmenu");
	hidediv.style.display = (this.value == "Yes") ? "block":"none";
}

</script>


</body>
</html>