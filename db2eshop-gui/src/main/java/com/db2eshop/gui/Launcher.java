package com.db2eshop.gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

import com.db2eshop.governance.spring.ApplicationContextLoader;
import com.db2eshop.governance.spring.ApplicationContextObserver;

public class Launcher extends JFrame implements Observer {
	private static final long serialVersionUID = 5812168694593003688L;

	private final Logger log = Logger.getLogger(this.getClass());

	private ApplicationContextObserver applicationContextObserver = ApplicationContextObserver.getInstance();

	private ApplicationContextLoader applicationContextLoader = ApplicationContextLoader.getInstance();

	public Launcher() {
	}

	public static void main(String[] args) {
		Launcher launcher = new Launcher();
		launcher.start();
	}

	private void start() {
		if (!applicationContextObserver.isRefreshed()) {
			applicationContextObserver.addObserver(this);
		} else {
			buildMainFrame();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		buildMainFrame();
	}

	private void buildMainFrame() {
		log.info("Building GUI");

		this.dispose();

		MainFrame mainFrame = applicationContextLoader.getApplicationContext().getBean(com.db2eshop.gui.MainFrame.class);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
