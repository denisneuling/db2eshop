package com.db2eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Artikel class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 *
 */
public class Artikel extends AbstractModel<Artikel> {
	private static final long serialVersionUID = 6709110157288379399L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private int anzahl;

	@Column
	private String beschreibung;

	/**
	 * <p>
	 * Constructor for Artikel.
	 * </p>
	 */
	public Artikel() {
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
	 * Getter for the field <code>anzahl</code>.
	 * </p>
	 * 
	 * @return a int.
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * <p>
	 * Setter for the field <code>anzahl</code>.
	 * </p>
	 * 
	 * @param anzahl
	 *            a int.
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	/**
	 * <p>
	 * Getter for the field <code>beschreibung</code>.
	 * </p>
	 * 
	 * @return a {@link java.lang.String} object.
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * <p>
	 * Setter for the field <code>beschreibung</code>.
	 * </p>
	 * 
	 * @param beschreibung
	 *            a {@link java.lang.String} object.
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
}
