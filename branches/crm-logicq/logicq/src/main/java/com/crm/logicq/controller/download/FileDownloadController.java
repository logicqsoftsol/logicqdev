package com.crm.logicq.controller.download;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.service.attendance.IAttendanceService;
import com.crm.logicq.utils.ReportHelper;
import com.crm.logicq.vo.download.DownloadCriteria;

@RestController
@RequestMapping("/api/admin/report")
public class FileDownloadController {
	
	private static final String CSV = "CSV";
	private static final String PDF = "PDF";
	private static final String XLS = "XLS";
	
	private static final Logger logger = LoggerFactory.getLogger(FileDownloadController.class);
	
	@Autowired
	IAttendanceService attendanceservice;
	
	@RequestMapping(value = "/downloadAttendanceReport/{reporttype}/{reportfor}/{fromdate}/{todate}/{applicableto}/{uniqueid}/{classname}/{section}/{exportfor}/{exporttype}")
	public void getAllReports(
	        @PathVariable String reporttype, @PathVariable String reportfor,@PathVariable Date fromdate,@PathVariable Date todate,
	        @PathVariable String applicableto,@PathVariable String uniqueid,
	        @PathVariable String classname,@PathVariable String section,
	        @PathVariable String exportfor,@PathVariable String exporttype, HttpServletRequest request, HttpServletResponse response
			) {
		DownloadCriteria reportdownloadcriteria = new DownloadCriteria();

		
		/*reportdownloadcriteria.setReporttype(reporttype);
		reportdownloadcriteria.setApplicableto(applicableto);
		reportdownloadcriteria.setUniqueid(uniqueid);
		reportdownloadcriteria.setExportfor(exportfor);
		reportdownloadcriteria.setExporttype(exporttype);*/
		
		AttendanceCriteria atttaendancecriteria=new AttendanceCriteria();
		atttaendancecriteria.setApplicablefor(applicableto.toUpperCase());
		
		atttaendancecriteria.setReporttype(reporttype);
		atttaendancecriteria.setReportFor(reportfor);
		atttaendancecriteria.setFromdate(fromdate);
		atttaendancecriteria.setTodate(todate);
		
		//atttaendancecriteria.setApplicableto(applicableto);
		atttaendancecriteria.setClassName(classname);
		atttaendancecriteria.setSectionName(section);
		atttaendancecriteria.setCardno(uniqueid);
		
		
			try {
				List<AttendanceDetails> attendancedetails=attendanceservice.getAttendanceAsTabular(atttaendancecriteria);
				if (CSV.equalsIgnoreCase(exporttype)) {
					createCSVFile(response, attendancedetails,atttaendancecriteria);
				}
				if (PDF.equalsIgnoreCase(exporttype)) {
					createPDFFile(response, attendancedetails);
				}
			
				if (XLS.equalsIgnoreCase(reporttype)) {
					createXLSFile(response, attendancedetails);
				}
			} catch (Exception exp) {
				logger.error(" Unable perform operation : " + exp.getMessage(), exp);
			}

	

	}
	/**
	 * This method will create csv file
	 * 
	 * @param response
	 * @throws Exception
	 */
	private void createCSVFile(HttpServletResponse response, List<AttendanceDetails> attendancedetails,AttendanceCriteria atttaendancecriteria) throws Exception {
		ICsvBeanWriter csvWriter = null;
		try {
			String csvFileName = "report_data.csv";
			response.setContentType("text/csv");
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", csvFileName);
			response.setHeader(headerKey, headerValue);
			csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			ReportHelper.createCSV(csvWriter, attendancedetails,atttaendancecriteria);
		} finally {
			if (null != csvWriter) {
				csvWriter.flush();
				csvWriter.close();
			}
		}
	}
	

	/**
	 * This method will be create pdf
	 * 
	 * @param response
	 * @throws Exception
	 */
	private void createPDFFile(HttpServletResponse response, List<AttendanceDetails> attendancedetails) throws Exception {

		String pdffilename = "report_data.pdf";
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = String.format("filename=\"%s\"", pdffilename);
		response.setHeader(headerKey, headerValue);
		ByteArrayOutputStream bytearray = ReportHelper.createPDF(attendancedetails);
		response.getWriter().write(bytearray.toString("UTF-8"));
		// ServletOutputStream sos = response.getOutputStream();
		// response.setContentLength(bytearray.size());
		// bytearray.writeTo(sos);
		bytearray.flush();
		bytearray.close();
		// sos.flush();
		// sos.close();
		response.getWriter().flush();
		response.getWriter().close();

	}
	
	/**
	 * 
	 * @param response
	 * @param reportdatalist
	 * @throws Exception
	 */
	private void createXLSFile(HttpServletResponse response,List<AttendanceDetails> attendancedetails) throws Exception {
		
		HSSFWorkbook workBook=ReportHelper.createExcel(response,attendancedetails);
		//response.getOutputStream().write(workBook.getBytes());
		workBook.write(response.getOutputStream()); 
		
	}

}
