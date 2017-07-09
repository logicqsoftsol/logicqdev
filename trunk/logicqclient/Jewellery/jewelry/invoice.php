<?php

error_reporting(E_ALL ^ E_DEPRECATED);
require('fpdf/fpdf.php');

$purchaseid = $_GET['purchaseid'];
$sellerid = $_GET['sellerid'];

$invoiceno = $_GET['invoice'];

$pdf = new FPDF('P', 'mm', 'A4');
//Adding Page
$pdf->AddPage();
// Set Font for page
$pdf->SetFont('Courier', 'B',14);

//Cell Function with (width, height, text, border (0 no or 1 border), endline (0 continue or 1 new), align(L, R, C))
$pdf->Cell(120, 5,'LOGO',0,0);
$pdf->Cell(70, 5,'INVOICE',0,1);

$pdf->Cell(120, 5,'M/S DD Jewellery Pvt. Ltd.',0,0);
$pdf->Cell(70, 5,'',0,1);

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
#$pdf->Cell(25, 5,'PurchID #',0,0);
#$pdf->Cell(45, 5,$purchaseid,0,1);

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

$pdf->SetFont('Courier', 'B',10);

$pdf->Cell(10, 5,'Sl. No',0,0,'C');
$pdf->Cell(20, 5,'Code',0,0,'C');
$pdf->Cell(45, 5,'Item(s)',0,0);
$pdf->Cell(20, 5,'Purity',0,0,'C');
$pdf->Cell(15, 5,'Weight',0,0,'C');
$pdf->Cell(25, 5,'Metal Price',0,0,'C');
$pdf->Cell(25, 5,'Making/Gm',0,0,'C');
$pdf->Cell(30, 5,'Amount',0,1,'R');

$pdf->SetFont('Courier', '',10);

$pdf->Cell(10, 5,'1',0,0,'C');
$pdf->Cell(20, 5,'1801',0,0,'C');
$pdf->Cell(45, 5,'C. F. Tops',0,0);
$pdf->Cell(20, 5,'916KDM',0,0,'C');
$pdf->Cell(15, 5,'4.8gm',0,0,'C');
$pdf->Cell(25, 5,'2000',0,0,'C');
$pdf->Cell(25, 5,'100',0,0,'C');
$pdf->Cell(30, 5,'13,440',0,1,'R');

$pdf->Cell(10, 5,'2',0,0,'C');
$pdf->Cell(20, 5,'1602',0,0,'C');
$pdf->Cell(45, 5,'C. Rings',0,0);
$pdf->Cell(20, 5,'916KDM',0,0,'C');
$pdf->Cell(15, 5,'2.5gm',0,0,'C');
$pdf->Cell(25, 5,'2000',0,0,'C');
$pdf->Cell(25, 5,'200',0,0,'C');
$pdf->Cell(30, 5,'11,270',0,1,'R');

$pdf->Cell(120, 10,'',0,1);

$pdf->SetFont('Courier', 'B',10);
define('RUPEE',chr(8234));
$pdf->Cell(25, 5,'',0,0);
$pdf->Cell(25, 5,'',0,0,'C');
$pdf->Cell(75, 5,'',0,0,'C');
$pdf->Cell(35, 5,'Total Amount',0,0);
$pdf->Cell(30, 5,'24,710.00',0,1,'R');

$pdf->SetFont('Courier', 'B',10);
$pdf->Cell(25, 5,'Paid By Cash',0,0);

$pdf->SetFont('Courier', '',10);
$pdf->SetFont('Courier', '',10);
$pdf->Cell(25, 5,'16,000.00',0,0,'C');
$pdf->Cell(75, 5,'',0,0,'C');
$pdf->Cell(35, 5,'Discount Amount',0,0);
$pdf->Cell(30, 5,'0.00',0,1,'R');

$pdf->Cell(25, 5,'',0,0);
$pdf->Cell(25, 5,'',0,0,'C');
$pdf->Cell(75, 5,'',0,0,'C');
$pdf->Cell(35, 5,'VAT(14.5%)',0,0);
$pdf->Cell(30, 5,'3,583.00',0,1,'R');

$pdf->SetFont('Courier', 'B',10);
$pdf->Cell(25, 5,'',0,0);
$pdf->Cell(25, 5,'',0,0,'C');
$pdf->Cell(75, 5,'',0,0,'C');
$pdf->Cell(35, 5,'Net Total',0,0);
$pdf->Cell(30, 5,'28,293.00',0,1,'R');

$pdf->Cell(20, 10,'Remarks',0,0);
$pdf->SetFont('Courier', '',10);
$pdf->Cell(50, 10,'You are connecting with Us',0,1);



ob_end_clean();
$pdf->Output();

?>