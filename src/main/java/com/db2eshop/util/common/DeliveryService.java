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
 * <p>DeliveryService class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class DeliveryService {

	/** Constant <code>random</code> */
	public final static Random random = new Random();
	
	/** Constant <code>deliveryService="{DHL, Hermes, DPD, Deutsche Post, UPS, "{trunked}</code> */
	public static String[] deliveryService = {
		"DHL", "Hermes", "DPD", "Deutsche Post", "UPS", "GLS", "LetMeShip"
	};
	
	/**
	 * <p>name.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String name() {
		return deliveryService[random.nextInt(deliveryService.length - 1)];
	}
}
