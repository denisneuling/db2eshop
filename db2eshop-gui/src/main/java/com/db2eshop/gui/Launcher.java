package com.db2eshop.gui;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import com.db2eshop.governance.spring.ApplicationContextLoader;
import com.db2eshop.governance.spring.ApplicationContextObserver;
import com.db2eshop.governance.spring.event.ContextEvent;

public class Launcher implements Observer {

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
		if (arg1 instanceof ContextEvent) {
			if (((ContextEvent) arg1).getState().equals(ContextEvent.State.FINISHED)) {
				buildMainFrame();
			} else {
				((ContextEvent) arg1).getMessage();
			}
		}
	}

	private void buildMainFrame() {
		log.info("Building GUI");

		MainFrame mainFrame = applicationContextLoader.getApplicationContext().getBean(com.db2eshop.gui.MainFrame.class);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
