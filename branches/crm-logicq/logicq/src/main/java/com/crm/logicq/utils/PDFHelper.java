package com.crm.logicq.utils;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceDetails;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

/**
 * 
 * @author 611022675
 *
 */
public class PDFHelper {
	/**
	 * 
	 * @param table
	 * @param header
	 * @param font
	 */
	public static void pdfHeaderWriter(PdfPTable table, String[] header, Font font) {
		if (null != header && header.length > 0) {
			for (String name : header) {
				insertCell(table, name.toUpperCase(), Element.ALIGN_RIGHT, 1, font);
			}
		}

	}

	/**
	 * 
	 * @param table
	 * @param text
	 * @param align
	 * @param colspan
	 * @param font
	 */
	private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
		cell.setHorizontalAlignment(align);
		cell.setColspan(colspan);
		if (text.trim().equalsIgnoreCase("")) {
			cell.setMinimumHeight(10f);
		}
		table.addCell(cell);
	}
/**
 * 
 * @param table
 * @param reportdatalist
 * @param font
 * @param document
 * @param paragraph
 * @throws Exception
 */
	public static void pdfContentWriter(PdfPTable table, List<AttendanceDetails> attendancelist, Font font, Document document,
			Paragraph paragraph) throws Exception {
		if (null != attendancelist && !attendancelist.isEmpty()) {
			for (AttendanceDetails attendance : attendancelist) {
				insertCell(table, String.valueOf(attendance.getFullName()), Element.ALIGN_RIGHT, 1, font);
				insertCell(table, String.valueOf(attendance.getIntime()), Element.ALIGN_RIGHT, 1, font);
				insertCell(table, String.valueOf(attendance.getOuttime()), Element.ALIGN_RIGHT, 1, font);
				insertCell(table, String.valueOf(attendance.getIsPresent()), Element.ALIGN_RIGHT, 1, font);
			}
			paragraph.add(table);
			document.add(paragraph);
			document.close();
		}

	}

}
