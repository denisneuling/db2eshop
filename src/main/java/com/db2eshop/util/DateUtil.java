package com.db2eshop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>DateUtil class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class DateUtil {

	/**
	 * <p>asDate.</p>
	 *
	 * @param string a {@link java.lang.String} object.
	 * @return a {@link java.util.Date} object.
	 */
	public static Date asDate(String string){
		try{
			if(isIsoFormat(string)){
				throw new RuntimeException("Date does not fit into ISO date format.");
			}
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = simpleDateFormat.parse(string);
		    return date;
		}
		catch(ParseException parseException){
			throw new RuntimeException(parseException);
		}
	}
	
	public static String asString(Date date){
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 return simpleDateFormat.format(date);
	}
	
	/**
	 * <p>isIsoFormat.</p>
	 *
	 * @param string a {@link java.lang.String} object.
	 * @return a boolean.
	 */
	public static boolean isIsoFormat(String string){
		if (!string.matches("^[\\d\\-]*$")) {
			return true;
		}
		return false;
	}
}
