package com.db2eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Import class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Import extends AbstractModel<Import> {
	private static final long serialVersionUID = ;


	private Long id;


	private int count;
	
	
	private int date;

	
	public Import() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getDate() {
		return count;
	}

	public void setDate(int date) {
		this.date = date;
	}
}
