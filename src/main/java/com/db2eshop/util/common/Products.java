package com.db2eshop.util.common;

import java.util.Random;

/**
 * <p>Products class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Products {

	/** Constant <code>SPACE=" "</code> */
	public static final String SPACE = " ";
	
	/** Constant <code>random</code> */
	public final static Random random = new Random();
	
	/** Constant <code>products="{ Knockwurst, Smorgasbord, Coffee, Donu"{trunked}</code> */
	public static String[] products = { "Knockwurst", "Smorgasbord", "Coffee", "Donuts", "Cherry Pie", "Jelly Donuts", "Asparagus", "Extra Decaf", "Gum", "Two eggs over hard, ", "bacon super crispy, almost burned, cremated",
			"Grapefruit juice, just as long as those grapefruits are freshly squeezed", "Coconut", "Beer", "Tuna fish, whole wheat", "Coffee with fish", "Fruit punch", "Soft drinks", "Sparkling cider", "Baguettes with brie and butter", "Huckleberry pie", "Double scotch on the rocks (two of them)",
			"Coffee with creme and sugar", "Black coffee (black as midnight on a moonless night)", "Fish", "Short stack of griddle cakes, slightly heated,", "butter,", "slice of ham", "Local mushrooms", "Huckleberry pie, heated, ice cream on the side", "Weenie roast", "Ice cube", "Diet lasagna",
			"Eggnog", "Peanuts", "Chicken feed drug transaction", "Turkey sandwich with mayo", "Leg of lamb (crush some garlic; fresh mint)", "A couple of bottles", "Cherry coke", "Fries", "Tea", "Sugar cookies", "Cake", "$1000 poker chip from One-Eyed Jacks", "Sauce (Champagne)", "Dom Parignon",
			"Milk", "Meatloaf", "Cocaine", "Bon Bons", "Ice cream (Butter Pecan)", "A cherry", "Trout", "Milk and cookies", "Bottled water", "Roadside stew", "Whiskey", "Hot milk", "Pitch gum", "Hospital food", "Pheasant", "Soup", "Chocolate peanut butter pie", "Heinz 57 Ketchup", "Mustard",
			"Ginger beer", "Creamed Corn", "Grapefruit with cherry", "Chicken with rice", "One smoked cheese pig", "Marshmallows", "Bear claw", "Pickled icemen", "Vegetable (Leo?)", "Bobby Briggs (?)", "Lemonade", "Saltines with apple butter", "Beans", "(Family night at) The Pancake Plantation",
			"English caramel", "Chamomile tea", "Rabbit chili", "Cheeseburger, medium; a coke and some fries", "Irish (?)", "Diet soda", "Black Yukon sucker punch", "Saki (?)", "Cold milk", "Oatmeal", "Two chocolate shakes (extra whipped creme on one)", "Real potatoes", "Dog biscuit",
			"Salmon (fresh, firm)", "Omelet (white veal sausage, morel mushrooms)", "Peanuts", "Ham", "Carrots", "Potato salad", "Deviled eggs", "Carrot sticks and celery sticks", "Chicken", "Corn on the cob", "Waldorf salad", "Popcorn", "Three berry pie", "Jello", "Roast", "Nectar of the gods",
			"Small box of chocolate bunnies", "Scrambled eggs", "Venison steaks", "Sparkling wine", "Gruel", "Apples", "Lollipop", "Red wine", "Peas (pass the peas again)", "Red herring", "Fried eggs", "Mound of sweet breads, saut�ed with chestnuts and Canadian bacon",
			"Big biscuits smothered in gravy", "Anchovies", "Bicarbonate soda", "Sausage patties (not sausage links)", "Pig head with grapes and a green apple in its mouth", "Roasted pine weasel", "Rare steak", "Chicken pot pie", "Turkey sandwich, whole wheat, lettuce, dollop of mayonnaise",
			"Garmonbozia", "Turkey dog", "Muffin", "High school sandwich", "Reiner Ale" };
	
	/**
	 * <p>product.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String product() {
		return products[random.nextInt(products.length - 1)];
	}
}
