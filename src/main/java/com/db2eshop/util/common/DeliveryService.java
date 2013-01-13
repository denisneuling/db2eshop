package com.db2eshop.util.common;

import java.util.Random;

public class DeliveryService {

	/** Constant <code>random</code> */
	public final static Random random = new Random();
	
	public static String[] deliveryService = {
		"DHL", "Hermes", "DPD", "Deutsche Post", "UPS", "GLS", "LetMeShip"
	};
	
	public static String name() {
		return deliveryService[random.nextInt(deliveryService.length - 1)];
	}
}
