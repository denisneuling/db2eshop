package com.db2eshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Supplier class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Supplier extends AbstractModel<Supplier> implements Serializable {
	private static final long serialVersionUID = -6602792748963845414L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private String telephone;

	/**
	 * <p>
	 * Constructor for Supplier.
	 * </p>
	 */
	public Supplier() {
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
	 * Getter for the field <code>telephone</code>.
	 * </p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * <p>
	 * Setter for the field <code>telephone</code>.
	 * </p>
	 *
	 * @param telephone
	 *            a {@link java.lang.String} object.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", telephone=" + telephone + "]";
	}
}
