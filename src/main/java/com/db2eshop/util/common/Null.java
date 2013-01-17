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
