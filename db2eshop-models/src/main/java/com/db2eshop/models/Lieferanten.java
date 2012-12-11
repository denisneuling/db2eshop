package com.db2eshop.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Lieferanten class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 *
 */
public class Lieferanten extends AbstractModel<Lieferanten> implements Serializable {
	private static final long serialVersionUID = -1171168614829706963L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String telefon;

	/**
	 * <p>
	 * Constructor for Lieferanten.
	 * </p>
	 */
	public Lieferanten() {
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

	/**
	 * <p>
	 * Getter for the field <code>telefon</code>.
	 * </p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	public String getTelefon() {
		return telefon;
	}

	/**
	 * <p>
	 * Setter for the field <code>telefon</code>.
	 * </p>
	 * 
	 * @param telefon
	 *            a {@link java.lang.String} object.
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
