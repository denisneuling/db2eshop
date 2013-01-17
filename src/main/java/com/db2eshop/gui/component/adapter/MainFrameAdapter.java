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
package com.db2eshop.gui.component.adapter;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.db2eshop.gui.MainFrame;

/**
 * <p>MainFrameAdapter class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class MainFrameAdapter extends ComponentAdapter {

	private MainFrame mainFrame;

	/**
	 * <p>Constructor for MainFrameAdapter.</p>
	 *
	 * @param mainFrame a {@link com.db2eshop.gui.MainFrame} object.
	 */
	public MainFrameAdapter(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/** {@inheritDoc} */
	@Override
	public void componentResized(ComponentEvent e) {
		mainFrame.repaint();
	}
}
