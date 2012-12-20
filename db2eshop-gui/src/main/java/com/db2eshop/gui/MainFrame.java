package com.db2eshop.gui;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.persistence.LieferantenDao;

@Component
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 5447391288059975630L;

	@Autowired
	private LieferantenDao lieferantenDao;
	
	public void doSMT(){
		String addresse = "asdasd";
		String name = "sdsdf"  ; 
		lieferantenDao.findBy("name", "addresse", name , addresse);
	}

}
