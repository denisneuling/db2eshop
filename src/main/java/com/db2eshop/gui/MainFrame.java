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
package com.db2eshop.gui;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.db2eshop.gui.component.DashBoard;
import com.db2eshop.gui.component.adapter.MainFrameAdapter;
import com.db2eshop.gui.menu.MenuPanel;

/**
 * <p>
 * MainFrame class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class MainFrame extends JFrame implements WindowListener, InitializingBean {
	private static final long serialVersionUID = 5447391288059975630L;
	protected Logger log = Logger.getLogger(this.getClass());

	@Value("${application.name}")
	private String title;

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private MenuPanel menuPanel;

	@Autowired
	private DashBoard dashBoard;

	/**
	 * <p>
	 * Constructor for MainFrame.
	 * </p>
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(800, 600));
		addWindowListener(this);

		addComponentListener(new MainFrameAdapter(this));
	}

	/**
	 * <p>
	 * die.
	 * </p>
	 */
	public void die() {
		try {
			log.info("Closing applicationContext.");
			((ClassPathXmlApplicationContext) applicationContext).close();
			log.info("Destroying applicationContext.");
			((ClassPathXmlApplicationContext) applicationContext).destroy();
		} catch (Exception castError) {
			log.fatal(String.format("Destroying applicationContext failed. Reason: %s", castError.getMessage()), castError);
		} finally {
			// hard kill
			log.info("Died.");
			System.exit(0);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		setTitle(title);
		setJMenuBar(menuPanel);

		MigLayout layout = new MigLayout("fill");

		this.getContentPane().setLayout(layout);
		this.getContentPane().add(dashBoard, "grow, push");

		this.pack();
		this.setVisible(true);
	}

	/** {@inheritDoc} */
	@Override
	public void windowActivated(WindowEvent e) {
		log.debug("Window activated");
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosed(WindowEvent e) {
		log.debug("Window closed");

		die();
	}

	/** {@inheritDoc} */
	@Override
	public void windowClosing(WindowEvent e) {
		log.debug("Window closing");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeactivated(WindowEvent e) {
		log.debug("Window deactivated");
	}

	/** {@inheritDoc} */
	@Override
	public void windowDeiconified(WindowEvent e) {
		log.debug("Window deiconified");
	}

	/** {@inheritDoc} */
	@Override
	public void windowIconified(WindowEvent e) {
		log.debug("Window iconified");
	}

	/** {@inheritDoc} */
	@Override
	public void windowOpened(WindowEvent e) {
		log.debug("Window opened");
	}
}
