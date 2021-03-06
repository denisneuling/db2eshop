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

import java.util.Random;

/**
 * <p>Cities class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Cities {

	/** Constant <code>cities="{ YUMA, REDDING, LAS VEGAS, PHOENIX, TU"{trunked}</code> */
	public static String[] cities = { "YUMA", "REDDING", "LAS VEGAS", "PHOENIX", "TUCSON", "EL PASO", "FRESNO", "RENO", "FLAGSTAFF", "SACRAMENTO", "ALBUQUERQUE", "KEY WEST", "PUEBLO", "MIDLAND-ODESSA", "ROSWELL", "AMARILLO", "ELY", "LOS ANGELES C.O.", "LAKE CHARLES", "LUBBOCK", "NORTH LITTLE ROCK",
			"GRAND JUNCTION", "HONOLULU", "JOHNSTON ISLAND", "ABILENE", "DODGE CITY", "MIAMI", "MILFORD", "WAKE ISLAND", "DENVER", "LANDER", "OKLAHOMA CITY", "SAN DIEGO", "WINNEMUCCA", "CONCORDIA", "KAHULUI", "NORTH PLATTE", "SAN JUAN", "APALACHICOLA", "CHEYENNE", "MACON", "SALT LAKE CITY",
			"SAN FRANCISCO C.O.", "TAMPA", "VALENTINE", "WICHITA", "BOISE", "COLUMBIA", "MEMPHIS", "POCATELLO", "SHREVEPORT", "TUPELO", "CHARLESTON AP", "HURON", "JACKSONVILLE", "RAPID CITY", "RICHMOND", "SHERIDAN", "WILMINGTON", "CHARLOTTE", "GALVESTON", "LITTLE ROCK", "SAVANNAH", "TULSA",
			"CAIRO", "DALLAS-FORT WORTH", "FORT SMITH", "GREAT FALLS", "JACKSON", "LINCOLN", "SIOUX CITY", "TOPEKA", "ATLANTA", "AUSTIN/BERGSTROM", "AUSTIN/CITY", "BILLINGS", "BROWNSVILLE", "CAPE HATTERAS", "CORPUS CHRISTI", "GREENSBORO-WNSTN-SALM", "GREENVILLE-SPARTANBURG AP", "KANSAS CITY",
			"NORFOLK", "OMAHA (NORTH)", "PENSACOLA", "SAN ANTONIO", "SPRINGFIELD", "WILLISTON", "ASHEVILLE", "BISMARCK", "DES MOINES", "EVANSVILLE", "FORT WAYNE", "HELENA", "HOUSTON", "LYNCHBURG", "BIRMINGHAM AP", "BOSTON", "HARRISBURG", "LIHUE", "MAJURO", "MINNEAPOLIS-ST.PAUL", "MONTGOMERY",
			"NEW YORK C.PARK", "PADUCAH KY", "PORT ARTHUR", "PROVIDENCE", "RALEIGH", "SPRINGFIELD", "BALTIMORE", "BIRMINGHAM C.O.", "CHATTANOOGA", "FARGO", "MIDDLETOWN/HARRISBURG AP", "NEW ORLEANS", "PORTLAND", "ST. LOUIS", "ATLANTIC CITY AP", "COLUMBIA", "HARTFORD", "KNOXVILLE", "LOUISVILLE",
			"NASHVILLE", "PEORIA", "PHILADELPHIA", "WASHINGTON NAT'L AP", "INDIANAPOLIS", "MISSOULA", "MOLINE", "YAP", "CHICAGO", "CONCORD", "GREEN BAY", "MADISON", "MILWAUKEE", "SPOKANE", "ALBANY", "ALLENTOWN", "DAYTON", "DETROIT", "BLUE HILL", "DULUTH", "TOLEDO", "AVOCA", "EUREKA", "KOROR",
			"LANSING", "ROCHESTER", "COLUMBUS", "GREATER CINCINNATI AP", "MARQUETTE", "BINGHAMTON", "BURLINGTON", "CLEVELAND", "ALPENA", "BUFFALO", "PORTLAND", "CHUUK", "SAULT STE. MARIE", "SEATTLE SEA-TAC AP", "GRAND RAPIDS", "GUAM", "SYRACUSE", "PITTSBURGH", "SEATTLE C.O.", "NOME", "PAGO PAGO",
			"ANCHORAGE", "HILO", "POHNPEI", "ELKINS", "MT. WASHINGTON", "QUILLAYUTE", "JUNEAU" };
	
	/** Constant <code>random</code> */
	public final static Random random = new Random();
	
	/**
	 * <p>city.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String city() {
		return cities[random.nextInt(cities.length - 1)];
	}

	/**
	 * <p>zipCode.</p>
	 *
	 * @return a int.
	 */
	public static int zipCode(){
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i < 5; i++){
			stringBuffer.append(random.nextInt(9));
		}
		return Integer.parseInt(stringBuffer.toString());
	}
}
