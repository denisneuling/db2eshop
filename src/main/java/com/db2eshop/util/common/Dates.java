package com.db2eshop.util.common;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * <p>Dates class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Dates {

	/** Constant <code>random</code> */
	public final static Random random = new Random();
	
	/**
	 * <p>date.</p>
	 *
	 * @return a {@link java.util.Date} object.
	 */
	public static Date date(){
	
		Date date = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int year = random.nextInt(50)+18;
		int month = random.nextInt(12);
		int day = random.nextInt(30);
		
		calendar.add(Calendar.YEAR, 0-(year<0?-year:year));
		calendar.add(Calendar.MONTH, 0-(month<0?-month:month));
		calendar.add(Calendar.DAY_OF_MONTH, 0-(day<0?-day:day));
				
		return calendar.getTime();
	}
}
