package com.db2eshop.util.common;

/**
 * <p>Null class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Null {

	private final static String REPRESENTATION = " - ";
	private Null(){
	}
	
	/**
	 * <p>getInstance.</p>
	 *
	 * @return a {@link com.db2eshop.util.common.Null} object.
	 */
	public static Null getInstance(){
		return new Null();
	}
	
	/**
	 * <p>asObject.</p>
	 *
	 * @return a {@link java.lang.Object} object.
	 */
	public static Object asObject(){
		return null;
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString(){
		return REPRESENTATION;
	}
}
