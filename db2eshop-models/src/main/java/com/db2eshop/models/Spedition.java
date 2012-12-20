package com.db2eshop.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Spedition class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Spedition extends AbstractModel<Spedition> implements Serializable {
	private static final long serialVersionUID = 5226154843133542099L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String telefonNummer;

	/**
	 * <p>
	 * Constructor for Spedition.
	 * </p>
	 */
	public Spedition() {
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
	 * Getter for the field <code>telefonNummer</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTelefonNummer() {
		return telefonNummer;
	}

	/**
	 * <p>
	 * Setter for the field <code>telefonNummer</code>.
	 * </p>
	 *
	 * @param telefonNummer
	 *            a {@link java.lang.String} object.
	 */
	public void setTelefonNummer(String telefonNummer) {
		this.telefonNummer = telefonNummer;
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

}
