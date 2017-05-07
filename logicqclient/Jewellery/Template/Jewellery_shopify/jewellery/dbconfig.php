<?php 
									$DB_HOST = '43.242.215.118';
									$DB_USER = 'logicqso';
									$DB_PASS = 'qazQAz234#$%';
									$DB_NAME = 'logicqso_jewellery_Ecommerce';
									 
									 try{
									  $DB_con = new PDO("mysql:host={$DB_HOST};dbname={$DB_NAME}",$DB_USER,$DB_PASS);
									  $DB_con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
									 }
									 catch(PDOException $e){
									  echo $e->getMessage();
									 }
									 
?>
