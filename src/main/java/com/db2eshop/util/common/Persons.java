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
 * <p>Persons class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Persons {

	/** Constant <code>SPACE=" "</code> */
	public static final String SPACE = " ";

	/** Constant <code>preNames="{ Aaron, Adrian, Aileen, Alexander, Ale"{trunked}</code> */
	public static String[] preNames = { "Aaron", "Adrian", "Aileen", "Alexander", "Alexandra", "Ali", "Alina", "Amelie", "Amely", "Andre", "Andreas", "Angelina", "Ann", "Anna", "Annika", "Anthony", "Anton", "Antonia", "Antonio", "Ayleen", "Aylin", "Ben", "Benedikt", "Benjamin", "Bennet", "Can",
			"Carl", "Carlotta", "Carolin", "Carolina", "Caroline", "Catrin", "Celine", "Chantal", "Charlotte", "Chayenne", "Cheyenne", "Chiara", "Christian", "Christin", "Christina", "Christine", "Clara", "Claudia", "Constantin", "Damian", "Daniel", "David", "Dominic", "Dominik", "Eileen",
			"Elaine", "Elena", "Elia", "Elias", "Elisa", "Elisabeth", "Elise", "Emelie", "Emely", "Emil", "Emilia", "Emilie", "Emily", "Emma", "Eric", "Erik", "Fabian", "Fabienne", "Felix", "Finlay", "Finley", "Finn", "Finnley", "Fiona", "Florian", "Frank", "Franz", "Franziska", "Frederik",
			"Friedrich", "Fynn", "Gabriel", "Georg", "Grace", "Hanna", "Hannah", "Helena", "Helene", "Hendrik", "Henri", "Henry", "Ida", "Isabel", "Isabell", "Isabella", "Isabelle", "Jacob", "Jakob", "James", "Jan", "Jana", "Jane", "Jasmin", "Jason", "Jennifer", "Jessica", "Joel", "Joeline",
			"Johann", "Johanna", "Johannes", "Joleen", "Jolie", "Joline", "Jona", "Jonas", "Jonathan", "Joschua", "Josef", "Josefine", "Joseph", "Josephine", "Joshua", "Joy", "Juli", "Julia", "Julian", "Julie", "Julius", "Karl", "Karlotta", "Karolina", "Karoline", "Katharina", "Kathrin", "Katrin",
			"Kevin", "Kiara", "Kim", "Klara", "Konstantin", "Kristian", "Kristin", "Kristina", "Kristine", "Lara", "Laura", "Lea", "Leah", "Leander", "Lee", "Lena", "Lennard", "Lennart", "Lennox", "Leon", "Leonard", "Leoni", "Leonie", "Leticia", "Letizia", "Levi", "Levin", "Liam", "Lilli", "Lilly",
			"Lina", "Linn", "Linus", "Lisa", "Loreen", "Lotta", "Lotte", "Lou", "Louis", "Louisa", "Louise", "Luca", "Lucas", "Lucia", "Luis", "Luisa", "Luise", "Luka", "Lukas", "Luna", "Lyn", "Lynn", "Magdalena", "Maja", "Malin", "Manuel", "Mara", "Marah", "Marc", "Marcel", "Marco", "Marcus",
			"Maria", "Marie", "Mario", "Mark", "Markus", "Marleen", "Marlen", "Marlene", "Marta", "Martha", "Martin", "Martina", "Mateo", "Matheo", "Mathilda", "Matilda", "Matteo", "Matthias", "Matthis", "Mattis", "Maurice", "Max", "Maxim", "Maximilian", "Maya", "Melanie", "Melina", "Mia",
			"Michael", "Michelle", "Milena", "Moritz", "Nadine", "Nele", "Niclas", "Nicole", "Niklas", "Nina", "Noah", "Noel", "Nur", "Ole", "Oliver", "Oscar", "Oskar", "Pascal", "Patrick", "Paul", "Paulina", "Pauline", "Peter", "Philipp", "Pia", "Rafael", "Raphael", "Rene", "Richard", "Robert",
			"Robin", "Rosa", "Rose", "Sabrina", "Samira", "Samuel", "Sandra", "Sara", "Sarah", "Sebastian", "Selina", "Simon", "Sina", "Sofia", "Sofie", "Sophia", "Sophie", "Stefan", "Stefanie", "Stephan", "Su", "Sue", "Summer", "Svenja", "Tanja", "Tayler", "Teresa", "Theresa", "Thomas", "Tim",
			"Timo", "Tobias", "Tomas", "Tyler", "Valentin", "Valentina", "Vanessa", "Victoria", "Viktoria", "Vincent", "Wilhelm", "Yasmin", "Zoe" };

	/** Constant <code>surNames="{ Watson, Walker, Whitworth, Carrie, Bo"{trunked}</code> */
	public static String[] surNames = { "Watson", "Walker", "Whitworth", "Carrie", "Boileau", "Marnontov", "Newman", "Peacock", "Loomis", "Amundson", "Telfar", "Dobson", "Mawley", "Hebden", "Belton", "Hadley", "Tyack", "Sheram", "Lackie", "Mercer", "Berriman", "Starling", "Wife", "Emerson",
			"Broadbent", "Decew", "Tibbets", "Trudelle", "Lockwood", "Sayer", "Peck", "Marquet", "Rainer", "O'dell", "Porcher", "Sims", "Penn", "Dexter", "Gwenn", "Le francois", "Scot", "Hardcastle", "Hartwell", "Beauclerk", "Wittelsbach", "Sketcher", "Brockbank", "Grand", "Rajah", "Vansickle",
			"Taylard", "Gordon", "Wood", "Buckb", "Prior", "Galcano", "Eccles", "Spicer", "Master", "Clarke", "Redfearn", "Burdick", "Whipp", "Hounan", "Pearson", "Penfold", "Burkhalter", "Herrington", "Lee", "Greenbank", "Baynes", "Clifford", "Crosthwaith", "Howes", "Danby", "Coulborn",
			"Edmundson", "Gaines", "Manners", "Askham", "Dowthwaite", "Horsburg", "Haining", "Dickerson", "Collins", "Powley", "Lecky", "Audane", "Fawlkes", "Patton", "Rumney", "Hill", "Newham", "De blaquiere", "Bycraft", "Goodyear", "Smith", "Goehrke", "Mackie", "Threlkeld", "Punch", "Grayston",
			"Wardup", "Mcbeath" };

	/** Constant <code>random</code> */
	public final static Random random = new Random();

	/**
	 * <p>name.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String name() {
		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(preNames[random.nextInt(preNames.length - 1)]);
		stringBuffer.append(SPACE);
		stringBuffer.append(surNames[random.nextInt(surNames.length - 1)]);

		return stringBuffer.toString();
	}

	/**
	 * <p>preName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String preName() {
		return preNames[random.nextInt(preNames.length - 1)];
	}

	/**
	 * <p>surName.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String surName() {
		return surNames[random.nextInt(surNames.length - 1)];
	}
}
