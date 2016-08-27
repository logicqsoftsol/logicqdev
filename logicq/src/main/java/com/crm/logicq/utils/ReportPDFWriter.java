package com.crm.logicq.utils;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.crm.logicq.model.attendance.AttendanceDetails;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * 
 * @author 611022163
 *
 */
public class ReportPDFWriter {



	private static ReportPDFWriter instance;

	private ReportPDFWriter() {

	}

	public static ReportPDFWriter getInstance() {
		if (null == instance) {
			synchronized (ReportPDFWriter.class) {
				if (null == instance) {
					instance = new ReportPDFWriter();
				}
			}
		}
		return instance;
	}

	/**
	 * 
	 * @param filename
	 * @param reportlist
	 * @throws Exception
	 */
	public ByteArrayOutputStream createPDFContent(String filename, List<AttendanceDetails> attendancelist) throws Exception {

		ByteArrayOutputStream pdfoutStream = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter.getInstance(document, pdfoutStream);
		document.open();
		Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD, new BaseColor(0, 0, 0));
		Font bf12 = new Font(FontFamily.TIMES_ROMAN, 4);
		document.setPageSize(PageSize.A4);
		Paragraph paragraph = new Paragraph(" Attendance Details Report ");
		String[] header = FileHelper.getHeaderList(AttendanceDetails.class);
		PdfPTable table = new PdfPTable(header.length);
		PDFHelper.pdfHeaderWriter(table, header, bf12);
		PDFHelper.pdfContentWriter(table, attendancelist, bf12, document, paragraph);
		return pdfoutStream;
	}

}
