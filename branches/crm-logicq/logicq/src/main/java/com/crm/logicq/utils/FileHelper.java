package com.crm.logicq.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.joda.time.chrono.AssembledChronology.Fields;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

/**
 * @author 611022163
 */
public class FileHelper {

	/**
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	public static CellProcessor[] getProcessors(String[] fields, Class claz) throws Exception {

		final CellProcessor[] processors = new CellProcessor[fields.length];
		for (int row = 0; row < fields.length; row++) {
			Field fetchfield = claz.getDeclaredField(fields[row]);
			if (fetchfield.getType().isAssignableFrom(String.class)) {
				//processors[row] = new NotNull();
			} else {
				processors[row] = new Optional();
			}
		}
		return processors;
	}

	/**
	 * @param filename
	 * @param reportlist
	 * @return
	 * @throws Exception
	 */
	public static InputStream createTXT(String filename, List<?> reportlist) throws Exception {

		return new ByteArrayInputStream(reportlist.toString().getBytes("UTF8"));
	}

	/**
	 * @param filterparams
	 * @return
	 */
	public static String[] getHeaderList(Class claz) {

		String[] header = null;
		Field[] fileds = claz.getDeclaredFields();
		
		//int arraysize = filterparams.size();
		header = new String[fileds.length];
		for (int i = 0; i < fileds.length; i++) {
			boolean checkFlag = true;
			if (fileds[i].getName().equals("presentcount")) {
				checkFlag = false;
			} else if (fileds[i].getName().equals("absentcount")) {
				checkFlag = false;
			}
			if (checkFlag) {
				header[i] = fileds[i].getName().toUpperCase();
			}
		}
		return header;
	}

	/**
	 * @param filterparams
	 * @return
	 */
	public static String[] getFieldList(Class claz) {

		String[] header = null;
		Field[] fileds = claz.getDeclaredFields();
		// int arraysize = filterparams.size();
		header = new String[fileds.length];
		for (int i = 0; i < fileds.length; i++) {
			if ( !(fileds[i].getName().equals("presentcount")) ||! (fileds[i].getName().equals("absentcount"))) {
				header[i] = fileds[i].getName();
			}
		}
		return header;
	}
}
