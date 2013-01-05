package com.db2eshop.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Import class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Import extends AbstractModel<Import> implements Serializable {
	private static final long serialVersionUID = -8663449394006905708L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private int count;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Import() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
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

	public void setDate(Date date) {
		this.date = date;
	}
}