package com.crm.logicq.utils;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.StringUtils;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.ICsvBeanWriter;

import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.service.user.impl.AttendanceConversion;
import com.crm.logicq.vo.attendance.AttendanceVO;
import com.crm.logicq.vo.download.AttendanceReportCriteria;
import com.crm.logicq.vo.template.OfficeSetupTemplateVO;

public class ReportHelper {
	
	
	/**
	 * This method will crate report for CSV
	 * @param csvbeanwriter
	 * @param reportdatalist
	 * @throws Exception
	 */
	public static void createCSV(ICsvBeanWriter csvbeanwriter, List<AttendanceDetails> attendancelist,AttendanceReportCriteria atttaendancecriteria) throws Exception {
		if (!attendancelist.isEmpty()) {
			String[] csvHeader = FileHelper.getHeaderList(AttendanceVO.class);
			String[] fieldlist = FileHelper.getFieldList(AttendanceVO.class);
			final CellProcessor[] processors = FileHelper.getProcessors(fieldlist,AttendanceVO.class);
			AttendanceAggregationResult aggregation =new AttendanceAggregationResult();
			List<AttendanceVO> attendacevolist=AttendanceConversion.convertEntityToVOWithAttendanceAggregation(attendancelist,aggregation);
			 formCSVHeader(csvbeanwriter, atttaendancecriteria, csvHeader,aggregation);
			
			for (AttendanceVO attendance : attendacevolist) {
				csvbeanwriter.write(attendance, csvHeader, processors);
			}
		}
	}

	private static void formCSVHeader(ICsvBeanWriter csvbeanwriter, AttendanceReportCriteria atttaendancecriteria, String[] csvHeader,AttendanceAggregationResult aggregation) throws Exception {
		OfficeSetupTemplateVO officesetup = new OfficeSetupTemplateVO();
		// Map<String, String>
		// officesetupmap=FileHelper.convertPojoToMap(officesetup);
		// Map<String, String>
		// attendancemap=FileHelper.convertPojoToMap(atttaendancecriteria);
		csvbeanwriter.writeHeader("", "####", "Attendance Report","####");
		//
		// for (Map.Entry<String, String> office : officesetupmap.entrySet()) {
		// csvbeanwriter.writeHeader(office.getKey(),office.getValue());
		// }
		csvbeanwriter.writeHeader(" School Name ", officesetup.getEntityname().toUpperCase());
		
		csvbeanwriter.writeHeader("School Addresses ", officesetup.getEntityaddresses(), ""," Contact Details ",officesetup.getContactdetails() );
		csvbeanwriter.writeHeader(" Website ", officesetup.getWebaddress().toUpperCase(),""," Email ", officesetup.getEntityemail());
		csvbeanwriter.writeHeader("");
		csvbeanwriter.writeHeader("","","", " Total Present ",String.valueOf(aggregation.getPresentcount()));
		csvbeanwriter.writeHeader( "","",""," Total Absent ",String.valueOf(aggregation.getAbsentcount()));
		csvbeanwriter.writeHeader("");
		csvbeanwriter.writeHeader("","####","Attendance Search Criteria","####");
		csvbeanwriter.writeHeader("Report For ", atttaendancecriteria.getApplicableto(), "", "From Date",
				DateUtils.convertDateToString(atttaendancecriteria.getFromdate()));
		csvbeanwriter.writeHeader("Report Name", atttaendancecriteria.getReportname(), "", "To Date",
				DateUtils.convertDateToString(atttaendancecriteria.getTodate()));
		if (!StringUtils.isEmpty(atttaendancecriteria.getClassname())) {
			csvbeanwriter.writeHeader("Class Name ", atttaendancecriteria.getClassname());
		}
		if (!StringUtils.isEmpty(atttaendancecriteria.getSectionname())) {
			csvbeanwriter.writeHeader("Section Name ", atttaendancecriteria.getSectionname());
		}
		if (!StringUtils.isEmpty(atttaendancecriteria.getCardnumber())) {
			csvbeanwriter.writeHeader("Card Number ", atttaendancecriteria.getCardnumber());
		}
		if (!StringUtils.isEmpty(atttaendancecriteria.getMobilenumber())) {
			csvbeanwriter.writeHeader("Mobile Number ", atttaendancecriteria.getMobilenumber());
		}
		csvbeanwriter.writeHeader("");
		csvbeanwriter.writeHeader(csvHeader);
	}

	/**
	 * This method will create PDF
	 * @param reportDataList
	 * @return
	 * @throws Exception
	 */
	public static ByteArrayOutputStream createPDF(List<AttendanceDetails> attendancelist) throws Exception {
		return ReportPDFWriter.getInstance().createPDFContent("report", attendancelist);
	}

/**
 * Thsi method wiil create xls file 
 * @param workBook
 * @param excelSheet
 * @throws Exception
 */
	public static HSSFWorkbook createExcel(HttpServletResponse response,List<AttendanceDetails> attendancelist) throws Exception {
		
		response.setContentType("application/vnd.ms-excel");
	    response.setHeader("Expires", "0");
	    response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
	    response.setHeader("Pragma", "public");
	    response.setHeader("Content-Disposition", "attachment; filename=ReportsData.xls");
	    
		HSSFWorkbook workBook = new HSSFWorkbook();
		HSSFSheet excelSheet = workBook.createSheet("report_excel");
		HSSFRow excelHeader = excelSheet.createRow(0);
		String[] xlsHeaders = FileHelper.getHeaderList(AttendanceDetails.class);
		String[] xlsFields =FileHelper.getFieldList(AttendanceDetails.class);
		for (int i = 0; i < xlsHeaders.length; i++) {
			excelHeader.createCell(i).setCellValue(xlsHeaders[i]);
		}

		for (int row = 1; row < attendancelist.size(); row++) {
			HSSFRow excelRow = excelSheet.createRow(row);
			for (int record = 0; record < xlsHeaders.length; record++) {
				Field field = AttendanceDetails.class.getDeclaredField(xlsFields[record]);
				field.setAccessible(Boolean.TRUE);
				Object value = field.get(attendancelist.get(row));
				excelRow.createCell(record).setCellValue(String.valueOf(value));
			}
		}
		
		return workBook;
	}

}
