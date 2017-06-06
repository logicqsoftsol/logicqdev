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

$pdf->Cell(100, 5,'Billing to',0,0);
$pdf->Cell(90, 5,'Shipping to',0,1);

$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(95, 5,'S S Lenka',0,0);
$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(80, 5,'S S Lenka',0,1);

$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(95, 5,'Balesore, Odisha - 751201',0,0);
$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(80, 5,'Balesore, Odisha - 751201',0,1);

$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(95, 5,'+91-7057014118',0,0);
$pdf->Cell(5, 5,'',0,0);
$pdf->Cell(80, 5,'+91-7057014118',0,1);

$pdf->Cell(190, 10,'',0,1);

$pdf->SetFont('Courier', 'B',12);

$pdf->Cell(35, 5,'Product Code',1,0,'C');
$pdf->Cell(85, 5,'Description',1,0,'C');
$pdf->Cell(25, 5,'Weight(s)',1,0);
$pdf->Cell(45, 5,'Amount',1,1,'C');

$pdf->SetFont('Courier', '',12);

$pdf->Cell(35, 5,'125486',1,0,'C');
$pdf->Cell(85, 5,'Silver Plate',1,0,'C');
$pdf->Cell(25, 5,'10',1,0,'C');
$pdf->Cell(45, 5,'3,350.00',1,1,'R');

$pdf->Cell(35, 5,'928856',1,0,'C');
$pdf->Cell(85, 5,'Silver Ring',1,0,'C');
$pdf->Cell(25, 5,'20',1,0,'C');
$pdf->Cell(45, 5,'4,850.00',1,1,'R');

$pdf->Cell(35, 5,'785246',1,0,'C');
$pdf->Cell(85, 5,'Diamond Ring',1,0,'C');
$pdf->Cell(25, 5,'22',1,0,'C');
$pdf->Cell(45, 5,'5,050.00',1,1,'R');

define('RUPEE',chr(8377));
$pdf->Cell(30, 5,'',0,0);
$pdf->Cell(90, 5,'',0,0,'C');
$pdf->Cell(25, 5,'Subtotal',0,0);
$pdf->Cell(5, 5,RUPEE,1,0);
$pdf->Cell(40, 5,'13,200.00',1,1,'R');

$pdf->Cell(30, 5,'',0,0);
$pdf->Cell(90, 5,'',0,0,'C');
$pdf->Cell(25, 5,'Taxable',0,0);
$pdf->Cell(5, 5,RUPEE,1,0);
$pdf->Cell(40, 5,'-',1,1,'R');

$pdf->Cell(30, 5,'',0,0);
$pdf->Cell(90, 5,'',0,0,'C');
$pdf->Cell(25, 5,'VAT',0,0);
$pdf->Cell(5, 5,RUPEE,1,0);
$pdf->Cell(40, 5,'14%',1,1,'R');

$pdf->Cell(30, 5,'',0,0);
$pdf->Cell(90, 5,'',0,0,'C');
$pdf->Cell(25, 5,'Total',0,0);
$pdf->Cell(5, 5,RUPEE,1,0);
$pdf->Cell(40, 5,'15,050.00',1,1,'R');




ob_end_clean();
$pdf->Output();

?>