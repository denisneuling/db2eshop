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
package com.db2eshop.gui.splash;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * <p>
 * BootSplash class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@SuppressWarnings("rawtypes")
public class BootSplash implements ApplicationListener, BeanPostProcessor {
	private SplashScreen splashScreen;

	private static BootSplash INSTANCE;

	/**
	 * <p>
	 * getInstance.
	 * </p>
	 *
	 * @return a {@link com.db2eshop.gui.splash.BootSplash} object.
	 */
	public static BootSplash getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BootSplash();
		}
		return INSTANCE;
	}

	private BootSplash() {
		splashScreen = new SplashScreen();
	}

	/**
	 * <p>
	 * Getter for the field <code>splashScreen</code>.
	 * </p>
	 *
	 * @return a {@link com.db2eshop.gui.splash.SplashScreen} object.
	 */
	public static SplashScreen getSplashScreen() {
		return getInstance().splashScreen;
	}

	/** {@inheritDoc} */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		splashScreen.setMessage("Initialized " + bean.getClass().getSimpleName());

		// ugly hack
		// to dispose the splashscreen even if the context is loading the config
		// processor not fast enough
		if ("AnnotationBeanConfigurerAspect".equals(bean.getClass().getSimpleName())) {
			splashScreen.dispose();
		}
		return bean;
	}

	/** {@inheritDoc} */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		splashScreen.setMessage("Initializing " + bean.getClass().getSimpleName());
		return bean;
	}

	/** {@inheritDoc} */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			splashScreen.dispose();
		}
	}

	private class SplashScreen extends JWindow {
		private static final long serialVersionUID = 3888409743043286932L;
		private JLabel head;
		private JLabel label;

		/**
		 * <p>
		 * Constructor for SplashScreen.
		 * </p>
		 */
		public SplashScreen() {
			JPanel content = new JPanel();
			content.setLayout(new MigLayout("fill"));

			head = new JLabel("<html><body><h2>Projektarbeit HTW Berlin DB2</h2><br>Denis Neuling (denisneuling@gmail.com)<br>Dennis Wieding (e-dennis@gmx.net)<br>Mateusz Wozniak (asro@live.de)</body></html>");
			head.setMinimumSize(new Dimension(60, 20));
			head.setBackground(new Color(0, 0, 0, 0));
			head.setFont(new Font(head.getFont().getName(), Font.BOLD, 9));
			head.setHorizontalAlignment(SwingConstants.CENTER);
			content.add(head, "grow,push,wrap");

			label = new JLabel("                                                                                                                        ");
			label.setMinimumSize(new Dimension(60, 20));
			label.setBackground(new Color(0, 0, 0, 0));
			label.setFont(new Font(label.getFont().getName(), Font.BOLD, 9));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.firePropertyChange("opaque", false, true);
			content.add(label, "grow,push");
			this.setLayout(new MigLayout("fill"));
			this.add(content, "grow,push");
			pack();

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int w = this.getSize().width;
			int h = this.getSize().height;
			int x = (screenSize.width - w) / 2;
			int y = (screenSize.height - h) / 2;

			this.setLocation(x, y);
			setVisible(true);
		}

		/**
		 * <p>
		 * setMessage.
		 * </p>
		 * 
		 * @param message
		 *            a {@link java.lang.String} object.
		 */
		public void setMessage(String message) {
			label.setText("<html><body><i>" + message + "</i></body></html>");
		}
	}
}
