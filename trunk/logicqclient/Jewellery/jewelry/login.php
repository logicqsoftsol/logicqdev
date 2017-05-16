<?php
session_start();
session_destroy();
$user = "";
$pass = "";
$msg = "";

if ($_SERVER['REQUEST_METHOD'] == 'POST'){
	include 'ChromePhp.php';
	include 'sql.php';

	$user = $_POST['username'];
	$pass = $_POST['password'];
		
	//unwanted HTML (scripting attacks)
	$user = htmlspecialchars($user);
	$pass = htmlspecialchars($pass);
	
	$SQL = "SELECT count(*) as usercount FROM login where username = '$user' and password = '$pass' ";
	$result = mysql_query($SQL);
	while ($db_field = mysql_fetch_assoc($result)) {
		$a = $db_field['usercount'];
		if($a==1){
			if (!session_id())
				session_start();
				$_SESSION['logon'] = true;
				header("Location: admin.html");
				die();
		}
	}
	$msg = "Check username and/or password.";
	mysql_close($db_handle);
}
?>