package com.db2eshop.gui;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.persistence.LieferantenDao;

@Component
/**
 * <p>MainFrame class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 5447391288059975630L;

	@Autowired
	private LieferantenDao lieferantenDao;
	
	/**
	 * <p>doSMT.</p>
	 */
	public void doSMT(){
		String addresse = "asdasd";
		String name = "sdsdf"  ; 
		lieferantenDao.findBy("name", "addresse", name , addresse);
	}

	setLayout(new MigLayout("", "[grow]", "[]5[]"));
}
