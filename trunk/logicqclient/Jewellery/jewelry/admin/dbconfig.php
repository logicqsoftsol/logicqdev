<?php 
									/* $DB_HOST = '43.242.215.118';
									$DB_USER = 'logicqso';
									$DB_PASS = 'qazQAz234#$%';
									$DB_NAME = 'logicqso_jewellery_Ecommerce';
									 
									 try{
									  $DB_con = new PDO("mysql:host={$DB_HOST};dbname={$DB_NAME}",$DB_USER,$DB_PASS);
									  $DB_con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
									 }
									 catch(PDOException $e){
									  echo $e->getMessage();
									 } */
									 
									 // $dbcon = new MySQLi("43.242.215.118","logicqso","qazQAz234#$%","logicqso_jewellery_Ecommerce");
									 
									 $dbcon = new MySQLi("127.0.0.1","root","","jewellery", "3306");
									 
									 if ($dbcon->connect_error) {
										die('Error : ('. $dbcon->connect_errno .') '. $dbcon->connect_error);
									}
									 
?>
