package com.db2eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>ArtikelArt class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 *
 */
public class ArtikelArt extends AbstractModel<ArtikelArt> {
	private static final long serialVersionUID = -9004421460842418357L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	/**
	 * <p>
	 * Constructor for ArtikelArt.
	 * </p>
	 */
	public ArtikelArt() {
	}

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <p>
	 * Getter for the field <code>name</code>.
	 * </p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>
	 * Setter for the field <code>name</code>.
	 * </p>
	 * 
	 * @param name
	 *            a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}
}
