package com.db2eshop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

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
	
	public static boolean isIsoFormat(String string){
		if (!string.matches("^[\\d\\-]*$")) {
			return true;
		}
		return false;
	}
}
