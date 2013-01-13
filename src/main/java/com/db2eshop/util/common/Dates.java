package com.db2eshop.util.common;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Dates {

	/** Constant <code>random</code> */
	public final static Random random = new Random();
	
	public static Date date(){
	
		Date date = new Date();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(Calendar.YEAR, 0-random.nextInt(50)+18);
		calendar.add(Calendar.MONTH, 0-random.nextInt(12));
		calendar.add(Calendar.DAY_OF_MONTH, 0-random.nextInt(30));
				
		return calendar.getTime();
	}
}
