<?php

/*
$user_name = "fees0_4320930";
$password = "fergus";
$database = "fees0_4320930_bui";
$server = "sql212.0fees.net";
$db_handle = mysql_connect($server, $user_name, $password);
$db_found = mysql_select_db($database, $db_handle);
*/

$user_name = "root";
$password = "";
$database = "jewelry";
$server = "127.0.0.1:3306";
$db_handle = mysql_connect($server, $user_name, $password);
$db_found = mysql_select_db($database, $db_handle);	


if (!$db_found) {
	die("DATABASE not found!");
}

?>