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
package com.db2eshop.log;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

import com.db2eshop.log.color.Colors;

/**
 * <p>ConsoleAppender class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ConsoleAppender extends org.apache.log4j.ConsoleAppender implements Appender, OptionHandler {

	protected Map<Level, String> colors = new HashMap<Level, String>();

	/**
	 * <p>Constructor for ConsoleAppender.</p>
	 */
	public ConsoleAppender() {
		colors.put(Level.ALL, Colors.RESET);
		colors.put(Level.TRACE, Colors.RESET);
		colors.put(Level.DEBUG, Colors.WHITEF);
		colors.put(Level.INFO, Colors.RESET);
		colors.put(Level.WARN, Colors.BLUEF);
		colors.put(Level.ERROR, Colors.REDF);
		colors.put(Level.FATAL, Colors.MAGENTAF);
		colors.put(Level.OFF, Colors.CYANF);
	}

	/** {@inheritDoc} */
	protected void subAppend(LoggingEvent event) {

		String formatted = this.layout.format(event);
		String colored = inquireColor(formatted, event);

		this.qw.write(colored);

		if (layout.ignoresThrowable()) {
			String[] s = event.getThrowableStrRep();
			if (s != null) {
				int len = s.length;
				for (int i = 0; i < len; i++) {
					this.qw.write(inquireColor(s[i], event));
					this.qw.write(Layout.LINE_SEP);
				}
			}
		}

		if (shouldFlush(event)) {
			this.qw.flush();
		}
	}

	/**
	 * <p>inquireColor.</p>
	 *
	 * @param message a {@link java.lang.String} object.
	 * @param event a {@link org.apache.log4j.spi.LoggingEvent} object.
	 * @return a {@link java.lang.String} object.
	 */
	protected String inquireColor(String message, LoggingEvent event){
		Level currentLevel = event.getLevel();
		String format = colors.get(currentLevel);

		if(format == null)
			return message;

		return Colors.colored(message, format);
	}
}
