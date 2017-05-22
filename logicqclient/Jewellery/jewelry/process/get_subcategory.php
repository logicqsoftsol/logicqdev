<?php
include('../dbconfig.php');
if($_POST['id'])
{
 $id=$_POST['id'];
  
 $stmt = $DB_con->prepare("SELECT * FROM sub_catagory WHERE CATAGORY_ID=:id");
 $stmt->execute(array(':id' => $id));
 ?>
 <option selected="selected">Select Sub-Category</option>
 <?php
 while($row=$stmt->fetch(PDO::FETCH_ASSOC))
 {
  ?>
        <option value="<?php echo $row['ID']; ?>"><?php echo $row['DISPLAY_NAME']; ?></option>
        <?php
 }
}
if($_POST['vid'])
{
 $id=$_POST['vid'];
  
 $stmt = $DB_con->prepare("SELECT * FROM vendor_details WHERE ID=:id");
 $stmt->execute(array(':id' => $id));
 ?>
  <?php
 while($row=$stmt->fetch(PDO::FETCH_ASSOC))
 {
  ?>
        <input type="text" name="vendername" id="vendername" class="form-control" placeholder="" value="<?php echo $row['DISPLAY_NAME']; ?>" readonly>
        <?php
 }
}
?>