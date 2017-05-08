<?php
session_start();
session_destroy();
$user = "";
$pass = "";
$msg = "";

if ($_SERVER['REQUEST_METHOD'] == 'POST'){
	include 'sql.php';

	$user = $_POST['uname'];
	$pass = $_POST['pword'];
		
	//unwanted HTML (scripting attacks)
	$user = htmlspecialchars($user);
	$pass = htmlspecialchars($pass);
	
	$SQL = "SELECT * FROM login";
	$result = mysql_query($SQL);
	while ($db_field = mysql_fetch_assoc($result)) {
		$a = $db_field['username'];
		$b = $db_field['password'];
		if(($user == $a) AND ($pass == $b)){
			if (!session_id())
				session_start();
				$_SESSION['logon'] = true;
				header("Location: admin_page.php");
				die();
		}
	}
	$msg = "Check username and/or password.";
	mysql_close($db_handle);
}
?>
<!DOCTYPE HTML>
<html>
<head>
<title>ADMIN Login</title>
<meta charset="UTF-8" />
<meta name="Designer" content="PremiumPixels.com">
<meta name="Author" content="$hekh@r d-Ziner, CSSJUNTION.com">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/structure.css">
</head>

<body>
<form name='login_form' method='post' action='login.php' class="box login">
      <input name = 'uname' type = 'text' value = '' placeholder="User Name">
      <input name = 'pword' type="password" placeholder="Password"/>
      <button name = 'login' type = 'submit' value = 'Login' class="btnLogin" >Login</button>
</form>

<footer id="main">
  
</footer>
</body>
</html>
