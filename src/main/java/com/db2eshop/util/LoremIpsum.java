package com.db2eshop.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * <p>LoremIpsum class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class LoremIpsum {

	/** Constant <code>SPACE=" "</code> */
	public static final String SPACE = " ";
	/** Constant <code>DOT="."</code> */
	public static final String DOT = ".";

	/** Constant <code>wordList="{ Lorem, ipsum, dolor, sit, amet, conse"{trunked}</code> */
	public static final String[] wordList = { "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et",
			"accusam", "et", "justo", "do", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam",
			"nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata",
			"sanctus", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua",
			"At", "vero", "eos", "et", "accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Duis", "autem", "vel", "eum", "iriure", "dolor", "in", "hendrerit",
			"in", "vulputate", "velit", "esse", "molestie", "consequat", "vel", "illum", "dolore", "eu", "feugiat", "nulla", "facilisis", "at", "vero", "eros", "et", "accumsan", "et", "iusto", "odio", "dignissim", "qui", "blandit", "praesent", "luptatum", "zzril", "delenit", "augue", "duis",
			"dolore", "te", "feugait", "nulla", "facilisi", "Lorem", "ipsum", "dolor", "sit", "amet", "consectetuer", "adipiscing", "elit", "sed", "diam", "nonummy", "nibh", "euismod", "tincidunt", "ut", "laoreet", "dolore", "magna", "aliquam", "erat", "volutpat", "Ut", "wisi", "enim", "ad",
			"minim", "veniam", "quis", "nostrud", "exerci", "tation", "ullamcorper", "suscipit", "lobortis", "nisl", "ut", "aliquip", "ex", "ea", "commodo", "consequat", "Duis", "autem", "vel", "eum", "iriure", "dolor", "in", "hendrerit", "in", "vulputate", "velit", "esse", "molestie", "consequat",
			"vel", "illum", "dolore", "eu", "feugiat", "nulla", "facilisis", "at", "vero", "eros", "et", "accumsan", "et", "iusto", "odio", "dignissim", "qui", "blandit", "praesent", "luptatum", "zzril", "delenit", "augue", "duis", "dolore", "te", "feugait", "nulla", "facilisi", "Nam", "liber",
			"tempor", "cum", "soluta", "nobis", "eleifend", "option", "congue", "nihil", "imperdiet", "doming", "id", "quod", "mazim", "placerat", "facer", "possim", "assum", "Lorem", "ipsum", "dolor", "sit", "amet", "consectetuer", "adipiscing", "elit", "sed", "diam", "nonummy", "nibh", "euismod",
			"tincidunt", "ut", "laoreet", "dolore", "magna", "aliquam", "erat", "volutpat", "Ut", "wisi", "enim", "ad", "minim", "veniam", "quis", "nostrud", "exerci", "tation", "ullamcorper", "suscipit", "lobortis", "nisl", "ut", "aliquip", "ex", "ea", "commodo", "consequat", "Duis", "autem",
			"vel", "eum", "iriure", "dolor", "in", "hendrerit", "in", "vulputate", "velit", "esse", "molestie", "consequat", "vel", "illum", "dolore", "eu", "feugiat", "nulla", "facilisis", "At", "vero", "eos", "et", "accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita",
			"kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna",
			"aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Lorem", "ipsum",
			"dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "At", "accusam", "aliquyam", "diam", "diam", "dolore", "dolores", "duo", "eirmod", "eos", "erat", "et", "nonumy", "sed", "tempor", "et", "et", "invidunt", "justo", "labore", "Stet", "clita", "ea", "et", "gubergren", "kasd",
			"magna", "no", "rebum", "sanctus", "sea", "sed", "takimata", "ut", "vero", "voluptua", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore",
			"et", "dolore", "magna", "aliquyam", "erat", "Consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et", "justo", "duo",
			"dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor",
			"invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem",
			"ipsum", "dolor", "sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et",
			"accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut",
			"labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem", "ipsum", "dolor",
			"sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr", "sed", "diam", "nonumy", "eirmod", "tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et",
			"justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est", "Lorem", "ipsum", "dolor", "sit", "amet", "Lorem", "ipsum", "dolor", "sit", "amet", "consetetur", "sadipscing", "elitr,", "sed", "diam", "nonumy", "eirmod",
			"tempor", "invidunt", "ut", "labore", "et", "dolore", "magna", "aliquyam", "erat", "sed", "diam", "voluptua", "At", "vero", "eos", "et", "accusam", "et", "justo", "duo", "dolores", "et", "ea", "rebum", "Stet", "clita", "kasd", "gubergren", "no", "sea", "takimata", "sanctus", "est",
			"Lorem", "ipsum", "dolor", "sit", "amet", "Duis", "autem", "vel", "eum", "iriure", "dolor", "in", "hendrerit", "in", "vulputate", "velit", "esse", "molestie", "consequat", "vel", "illum", "dolore", "eu", "feugiat", "nulla", "facilisis", "at", "vero", "eros", "et", "accumsan", "et",
			"iusto", "odio", "dignissim", "qui", "blandit", "praesent", "luptatum", "zzril", "delenit", "augue", "duis", "dolore", "te", "feugait", "nulla", "facilisi", "Lorem", "ipsum", "dolor", "sit", "amet", "consectetuer", "adipiscing", "elit", "sed", "diam", "nonummy", "nibh", "euismod",
			"tincidunt", "ut", "laoreet", "dolore", "magna", "aliquam", "erat", "volutpat", "Ut", "wisi", "enim", "ad", "minim", "veniam", "quis", "nostrud", "exerci", "tation", "ullamcorper", "suscipit", "lobortis", "nisl", "ut", "aliquip", "ex", "ea", "commodo", "consequat", "Duis", "autem",
			"vel", "eum", "iriure", "dolor", "in", "hendrerit", "in", "vulputate", "velit", "esse", "molestie", "consequat", "vel", "illum", "dolore", "eu", "feugiat", "nulla", "facilisis", "at", "vero", "eros", "et", "accumsan", "et", "iusto", "odio", "dignissim", "qui", "blandit", "praesent",
			"luptatum", "zzril", "delenit", "augue", "duis", "dolore", "te", "feugait", "nulla", "facilisi", "Nam", "liber", "tempor", "cum", "soluta", "nobis", "eleifend", "option", "congue", "nihil", "imperdiet", "doming", "id", "quod", "mazim", "placerat", "facer", "possim", "assum", "Lorem",
			"ipsum", "dolor", "sit", "amet", "consectetuer", "adipiscing", "elit", "sed", "diam", "nonummy", "nibh", "euismod", "tincidunt", "ut", "laoreet", "dolore", "magna", "aliquam", "erat", "volutpat", "Ut", "wisi", "enim", "ad", "minim", "veniam", "quis", "nostrud", "exerci", "tation",
			"ullamcorper", "suscipit", "lobortis", "nisl", "ut", "aliquip", "ex", "ea", "commodo" };

	/** Constant <code>random</code> */
	public final static Random random = new Random();

	/**
	 * <p>word.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String word() {
		return wordList[random.nextInt(wordList.length)];
	}

	/**
	 * <p>phrase.</p>
	 *
	 * @param words a int.
	 * @return a {@link java.lang.String} object.
	 */
	public static String phrase(int words) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < words; i++) {
			buffer.append(word());
			if (i != words - 1) {
				buffer.append(SPACE);
			}
		}
		buffer.append(DOT);
		return buffer.toString();
	}

	/**
	 * <p>phrase.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String phrase() {
		return phrase(random.nextInt(wordList.length));
	}

	/**
	 * <p>secureRandomString.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public static String secureRandomString() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}

}
