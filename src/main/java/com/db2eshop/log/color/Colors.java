package com.db2eshop.log.color;

/**
 * <p>Colors class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Colors {

	/** Constant <code>REDB="\033[1;41m"</code> */
	public static final String REDB = "\033[1;41m";
	/** Constant <code>REDF="\033[31m"</code> */
	public static final String REDF = "\033[31m";
	/** Constant <code>GREENB="\033[1;42m"</code> */
	public static final String GREENB = "\033[1;42m";
	/** Constant <code>GREENF="\033[1;32m"</code> */
	public static final String GREENF = "\033[1;32m";
	/** Constant <code>YELLOWB="\033[1;43m"</code> */
	public static final String YELLOWB = "\033[1;43m";
	/** Constant <code>YELLOWF="\033[1;33m"</code> */
	public static final String YELLOWF = "\033[1;33m";
	/** Constant <code>BLUEB="\033[1;44m"</code> */
	public static final String BLUEB = "\033[1;44m";
	/** Constant <code>BLUEF="\033[1;34m"</code> */
	public static final String BLUEF = "\033[1;34m";
	/** Constant <code>MAGENTAB="\033[1;45m"</code> */
	public static final String MAGENTAB = "\033[1;45m";
	/** Constant <code>MAGENTAF="\033[1;35m"</code> */
	public static final String MAGENTAF = "\033[1;35m";
	/** Constant <code>CYANB="\033[1;46m"</code> */
	public static final String CYANB = "\033[1;46m";
	/** Constant <code>CYANF="\033[1;36m"</code> */
	public static final String CYANF = "\033[1;36m";
	/** Constant <code>WHITEB="\033[1;47m"</code> */
	public static final String WHITEB = "\033[1;47m";
	/** Constant <code>WHITEF="\033[1;37m"</code> */
	public static final String WHITEF = "\033[1;37m";
	/** Constant <code>RESET="\033[0m"</code> */
	public static final String RESET = "\033[0m";

	/**
	 * <p>colored.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param color a {@link java.lang.String} object.
	 * @return a {@link java.lang.String} object.
	 */
	public static String colored(String message, String color) {
		if (color == null) {
			return message;
		}
		return String.format("%s%s%s%s", RESET, color, (message == null ? "" : message), RESET);
	}
}
