package com.db2eshop.launcher;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import com.db2eshop.governance.spring.ApplicationContextLoader;

/**
 * <p>Launcher class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Launcher {

	@SuppressWarnings("unused")
	private static ApplicationContextLoader applicationContextLoader = ApplicationContextLoader.getInstance();
	
	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args){
		LocaleContextHolder.setLocale(Locale.US);
	}
}
