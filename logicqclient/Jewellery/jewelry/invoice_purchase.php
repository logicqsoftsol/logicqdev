<?php

error_reporting(E_ALL ^ E_DEPRECATED);
require('fpdf/fpdf.php');

$purchaseid = $_GET['purchaseid'];
$sellerid = $_GET['sellerid'];

$invoiceno='DD/NOV17/1002';

$pdf = new FPDF('P', 'mm', 'A4');
//Adding Page
$pdf->AddPage();
// Set Font for page
$pdf->SetFont('Courier', 'B',14);

//Cell Function with (width, height, text, border (0 no or 1 border), endline (0 continue or 1 new), align(L, R, C))
$pdf->Cell(120, 5,'M/S DD Jewellery Pvt. Ltd.',0,0);
$pdf->Cell(70, 5,'INVOICE',0,1);

$pdf->SetFont('Courier', '',12);

$pdf->Cell(120, 5,'Bavadhan',0,0);
$pdf->Cell(80, 5,'',0,1);

$pdf->Cell(120, 5,'Pune, MH-411021',0,0);
$pdf->Cell(25, 5,'Date',0,0);
$pdf->Cell(45, 5,'07/06/2017',0,1);

$pdf->Cell(120, 5,'Contact [+91-8087089087]',0,0);
$pdf->Cell(25, 5,'Invoice #',0,0);
$pdf->Cell(45, 5,$invoiceno,0,1);

$pdf->Cell(120, 5,'Fax [+91-20-12548765]',0,0);
$pdf->Cell(25, 5,'PurchID #',0,0);
$pdf->Cell(45, 5,$purchaseid,0,1);

$pdf->Cell(190, 10,'',0,1);

$pdf->Cell(100, 5,'Vendor Details',0,1);


$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(95, 5,'RENUKA JEWELLERY',0,1);


$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(95, 5,'Pune, MH-411033',0,1);


$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(95, 5,'+91-8078982052',0,0);


$pdf->Cell(190, 10,'',0,1);

$pdf->SetFont('Courier', 'B',10);

$pdf->Cell(30, 5,'Pur. ID',0,0,'C');
$pdf->Cell(30, 5,'Seller ID',0,0,'C');
$pdf->Cell(45, 5,'Item Dec.',0,0);
$pdf->Cell(25, 5,'Prod. ID',0,0,'C');
$pdf->Cell(25, 5,'Design Type',0,0,'C');
$pdf->Cell(25, 5,'Cateloue ID',0,1,'C');


$pdf->SetFont('Courier', '',10);

$pdf->Cell(30, 5,'1',0,0,'C');
$pdf->Cell(30, 5,'1801',0,0,'C');
$pdf->Cell(45, 5,'C. F. Tops',0,0);
$pdf->Cell(25, 5,'916KDM',0,0,'C');
$pdf->Cell(25, 5,'4.8gm',0,0,'C');
$pdf->Cell(25, 5,'2',0,1,'C');


$pdf->Cell(30, 5,'2',0,0,'C');
$pdf->Cell(30, 5,'1602',0,0,'C');
$pdf->Cell(45, 5,'C. Rings',0,0);
$pdf->Cell(25, 5,'916KDM',0,0,'C');
$pdf->Cell(25, 5,'2.5gm',0,0,'C');
$pdf->Cell(25, 5,'3',0,0,'C');


$pdf->Cell(120, 10,'',0,1);

$pdf->SetFont('Courier', 'B',10);
define('RUPEE',chr(8234));
$pdf->Cell(25, 5,'',0,0);
$pdf->Cell(25, 5,'',0,0,'C');
$pdf->Cell(75, 5,'',0,0,'C');
$pdf->Cell(35, 5,'Estimated Price',0,0);
$pdf->SetFont('Courier', '',10);
$pdf->Cell(30, 5,'50,000.00',0,1,'R');






ob_end_clean();
$pdf->Output();

?>