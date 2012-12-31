package com.db2eshop.gui;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/**
 * <p>MainFrame class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 5447391288059975630L;
	
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
	  
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  pack();
	  setLocationRelativeTo(null);
	  setVisible(true);
}
