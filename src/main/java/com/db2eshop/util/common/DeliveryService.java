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
