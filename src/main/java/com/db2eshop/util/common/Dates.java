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
