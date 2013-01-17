/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
	
	/**
	 * <p>asString.</p>
	 *
	 * @param date a {@link java.util.Date} object.
	 * @return a {@link java.lang.String} object.
	 */
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
