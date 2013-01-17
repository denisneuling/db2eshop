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
