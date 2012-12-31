package com.db2eshop.gui.component;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class DashBoard extends Container implements InitializingBean {
	private static final long serialVersionUID = 6816890195017278060L;

	public DashBoard() {
		setLayout(new MigLayout("", "[grow]", "[]5[]"));
		add(new JLabel("KNr"), "");
		add(new JTextField(5), "wrap");
		add(new JLabel("Vorname"), "");
		add(new JTextField(10), "");
		add(new JLabel("Nachname"), "");
		add(new JTextField(10), "wrap");
		add(new JLabel("Strasse"), "");
		add(new JTextField(17), "");
		add(new JLabel("HNr"), "");
		add(new JTextField(3), "wrap");
		add(new JLabel("PLZ"), "");
		add(new JTextField(5), "");
		add(new JLabel("Ort"), "");
		add(new JTextField(15), "wrap");

		add(new JButton("Exit"), "center");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.repaint();
		this.setVisible(true);
	}

}
