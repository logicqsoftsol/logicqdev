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
				header("Location: admin.php");
				die();
		}
	}
	$msg = "Check username and/or password.";
	mysql_close($db_handle);
}
?>


<html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>STMarry Public Schools</title>
    
    <!-- Styles -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,700,800" rel="stylesheet" type="text/css"><!-- Google web fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"><!-- font-awesome -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"><!-- Bootstrap -->

    <link href="style.css" rel="stylesheet" type="text/css"><!-- theme styles -->
    <link href="css/login.css" rel="stylesheet" type="text/css"><!-- theme styles -->
  </head>
<body link="#0066FF" vlink="#6633CC" bgcolor="#FFFFCC" background="images/image001.jpg" style='margin:0'>
<div class="login-page">
  <div class="form">
    <form name='login_form' method='post' action='login.php' class="login-form">
      <input name = 'uname' type = 'text' value = '' placeholder="User Name">
      <input name = 'pword' type="password" placeholder="Password"/>
      <button name = 'login' type = 'submit' value = 'Login'>Login</button>
    </form>
  </div>
</div>
</body>
</html>