package com.db2eshop.util;

/**
 * <p>StringUtil class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class StringUtil {

	/**
	 * <p>nominilize.</p>
	 *
	 * @param word a {@link java.lang.String} object.
	 * @return a {@link java.lang.String} object.
	 */
	public static String nominilize(String word){
		if(word == null){
			return "";
		}
		if(word.isEmpty() || word.length()==1){
			return word;
		}
		String rest = word.substring(1);
		return word.substring(0, 1).toUpperCase()+rest;
	}
}
