package common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

	/**
	 * 
	 * Convert String to Date
	 * 
	 * @param dateStr
	 * @param dateFormat
	 * @return Date
	 */
	public static Date cvStringToDate(String dateStr, String dateFormat) {
		Date outputDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		try {
			outputDate = simpleDateFormat.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Lỗi khi chuyển String to Date");
		}
		return outputDate;
	}
	
	/**
	 * Conver date to string
	 * @param inputDate
	 * @param dateFormat
	 * @return String
	 */
	public static String cvDatoToString(Date inputDate, String dateFormat) {
		String outputDate = "";
		if(outputDate != null) {
			SimpleDateFormat dateFormatOutput = new SimpleDateFormat(dateFormat);
			outputDate = dateFormatOutput.format(inputDate);
		}
		return outputDate;
	}
}
